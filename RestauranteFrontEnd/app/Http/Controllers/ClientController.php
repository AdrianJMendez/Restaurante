<?php
namespace App\Http\Controllers;

use Illuminate\Http\Request;
use GuzzleHttp\Client;

class ClientController extends Controller
{

    private $client;

    public function __construct()
    {
        $this->client = new Client();
    }



    public function index()
    {
        // Crear una instancia de Guzzle HTTP Client
        $client = new Client();

        try {
            // Enviar la solicitud al backend de Spring Boot
            $response = $client->get("http://localhost:8091/api/restaurante/cliente/todos");

            // Decodificar la respuesta JSON
            $clientes = json_decode($response->getBody(), true);

            // Pasar los datos a la vista
            return view('clients', [
                'clientes' => $clientes,
            ]);

        } catch (\Exception $e) {
            // Manejar errores de la solicitud
            return back()->withErrors(['error' => 'Hubo un problema al conectarse al servidor o al procesar la respuesta']);
        }
    }

    

    public function crearCliente(Request $request)
    {
        // Valida los datos del formulario
        $validatedData = $request->validate([
            'identificacion' => 'required|string',
            'nombre' => 'required|string',
            'apellido' => 'required|string',
        ]);

        // Envía los datos al backend usando Guzzle
        $response = $this->client->post('http://localhost:8091/api/restaurante/cliente/crear', [
            'json' => [
                'identificacion' => $validatedData['identificacion'],
                'nombre' => $validatedData['nombre'],
                'apellido' => $validatedData['apellido'],
            ],
        ]);

        // Maneja la respuesta del backend
        if ($response->getStatusCode() == 200) {
            // Redirige a la vista con la lista actualizada de clientes
            return redirect()->route('clientes.index');

        } else {
            return back()->withErrors(['error' => 'Error al crear cliente']);
        }
    }

    public function eliminar($identificacion)
        {
            try {
                // Envía la solicitud al backend para eliminar el cliente
                $response = $this->client->delete("http://localhost:8091/api/restaurante/cliente/borrar/dni/{$identificacion}");

                if ($response->getStatusCode() == 200) {
                    return redirect()->route('clients.index')->with('success', 'Cliente eliminado correctamente');
                } else {
                    return back()->withErrors(['error' => 'Error al eliminar cliente']);
                }
            } catch (\Exception $e) {
                return back()->withErrors(['error' => 'Hubo un problema al conectarse al servidor o al procesar la respuesta']);
            }
        }

    


}
