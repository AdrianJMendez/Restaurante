<?php
namespace App\Http\Controllers;

use Illuminate\Http\Request;
use GuzzleHttp\Client;
use Illuminate\Support\Facades\Validator;

class FacturaController extends Controller
{

    private $client;

    public function __construct()
    {
        $this->client = new Client();
    }


    public function showFactura()
    {


        return view('factureAdmin');

    }

    
    public function FactureNew()
    {   
        $client = new Client();
        $response = $client->request('GET', 'http://localhost:8091/api/restaurante/platillo/todos');

        $platillos = json_decode($response->getBody()->getContents(), true);

        return view('newFacture', compact('platillos'));
    }



    public function showFacturaH()
    {
        // Crear una instancia de Guzzle HTTP Client
        $client = new Client();

        try {
            // Enviar la solicitud al backend de Spring Boot
            $response = $client->get("http://localhost:8091/api/factura/obtener/todos");

            // Decodificar la respuesta JSON
            $facturas = json_decode($response->getBody(), true);

            // Pasar los datos a la vista
            return view('HistorialFactura', [
                'facturas' => $facturas,
            ]);

        } catch (\Exception $e) {
            // Manejar errores de la solicitud
            return back()->withErrors(['error' => 'Hubo un problema al conectarse al servidor o al procesar la respuesta']);
        }
    }

    

    public function crear(Request $request)
{
    // Validar los datos del formulario
    $validator = Validator::make($request->all(), [
        'usuarioid' => 'required|integer',
        'identificacion' => 'required|integer',
        'platillos' => 'required|array',
        'platillos.*' => 'integer',
        'cantidad.*' => 'required|integer',  // Asegúrate de que la cantidad sea un array
        'fecha' => 'required|date',
        'metodoDePago' => 'required|string'
    ]);

    if ($validator->fails()) {
        return redirect()->route('facture.new')->withErrors($validator)->withInput();
    }

    $client = new Client();

    try {
        // Construcción del array de platillos con sus cantidades
        $platillos = array_map(function($platilloId, $index) use ($request) {
            return [
                'platillo' => [
                    'platilloId' => $platilloId
                ],
                'cantidad' => $request->input('cantidad')[$index] // Accede a la cantidad correspondiente
            ];
        }, $request->input('platillos'), array_keys($request->input('platillos')));

        // Envío de la solicitud POST a la API
        $response = $client->post('http://localhost:8091/api/factura/crear', [
            'json' => [
                'usuario' => [
                    'usuarioid' => $request->input('usuarioid')
                ],
                'cliente' => [
                    'clienteid' => $request->input('identificacion')
                ],
                'oferta' => null, // Ignorando oferta
                'platillos' => $platillos, // Array de platillos con cantidades
                'fecha' => $request->input('fecha'),
                'metodoDePago' => $request->input('metodoDePago')
            ]
        ]);

        return redirect()->route('factura')->with('success', 'Factura creada exitosamente.');

    } catch (\GuzzleHttp\Exception\RequestException $e) {
        return redirect()->route('facture.new')->withErrors(['error' => 'Hubo un problema al crear la factura: ' . $e->getMessage()]);
    } catch (\Exception $e) {
        return redirect()->route('facture.new')->withErrors(['error' => 'Hubo un problema al crear la factura.']);
    }
}


     // Método para eliminar una factura
     public function eliminar($facturaId)
        {
            try {
                // Envía la solicitud al backend para eliminar el cliente
                $response = $this->client->delete("http://localhost:8091/api/factura/borrar/id/{$facturaId}");

                if ($response->getStatusCode() == 200) {
                    return redirect()->route('factura.h')->with('success', 'Cliente eliminado correctamente');
                } else {
                    return back()->withErrors(['error' => 'Error al eliminar cliente']);
                }
            } catch (\Exception $e) {
                return back()->withErrors(['error' => 'Hubo un problema al conectarse al servidor o al procesar la respuesta']);
            }
        }
    


}



