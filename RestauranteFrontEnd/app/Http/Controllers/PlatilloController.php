<?php

// app/Http/Controllers/PlatilloController.php
namespace App\Http\Controllers;

use Illuminate\Http\Request;
use GuzzleHttp\Client;


class PlatilloController extends Controller
{

    public function __construct()
    {
        $this->client = new Client(); // Inicializa el cliente Guzzle
    }

    // Método para mostrar todos los platillos
    public function index()
    {
        $client = new Client();
        $response = $client->request('GET', 'http://localhost:8091/api/restaurante/platillo/todos');

        $platillos = json_decode($response->getBody()->getContents(), true);

        return view('platillos', compact('platillos'));
    }

    // Método para mostrar el formulario de creación de platillo
    public function create()
    {
        $client = new Client();
        $response = $client->request('GET', 'http://localhost:8091/api/restaurante/inventario/todos');

        $ingredientes = json_decode($response->getBody()->getContents(), true);

        return view('agregarPlatillos', compact('ingredientes'));
    }
    
    

    // Método para almacenar un nuevo platillo
    public function crear(Request $request)
    {
        // Recibir los datos del formulario
        $nombre = $request->input('nombre');
        $precio = $request->input('precio');
        $ingredientes = $request->input('ingredientes'); // Array de IDs de ingredientes
        $cantidades = $request->input('cantidades'); // Array de cantidades para cada ingrediente
    
        // Construir el array de inventarios
        $inventarios = [];
        foreach ($ingredientes as $index => $inventarioId) {
            $inventarios[] = [
                'inventario' => [
                    'inventarioId' => $inventarioId,
                ],
                'cantidad' => $cantidades[$index],
            ];
        }
    
        // Enviar los datos al backend usando Guzzle
        $response = $this->client->post('http://localhost:8091/api/restaurante/platillo/crear', [
            'json' => [
                'nombre' => $nombre,
                'precio' => $precio,
                'inventarios' => $inventarios,
            ],
        ]);
    
        // Maneja la respuesta del backend
        if ($response->getStatusCode() == 200) {
            // Redirige a la vista con la lista actualizada de platillos
            return redirect()->route('platos.index')->with('success', 'Platillo agregado exitosamente.');
        } else {
            return back()->withErrors(['error' => 'Error al crear el platillo']);
        }
    }
    

    // Método para eliminar un platillo
    public function eliminar($platilloId)
        {
            try {
                // Envía la solicitud al backend para eliminar el cliente
                $response = $this->client->delete("http://localhost:8091/api/restaurante/platillo/borrar/id/{$platilloId}");

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
