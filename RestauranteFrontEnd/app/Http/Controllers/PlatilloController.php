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
       

        // Envía los datos al backend usando Guzzle
        $response = $this->client->post('http://localhost:8091/api/restaurante/platillo/crear', [
            'json' => [
                'nombre' => $request->input('nombre'),
                'precio' => $request->input('precio'),
            ],
        ]);

        // Maneja la respuesta del backend
        if ($response->getStatusCode() == 200) {
            // Redirige a la vista con la lista actualizada de platillos
            return redirect()->route('platillos.index')->with('success', 'Platillo agregado exitosamente.');
        } else {
            return back()->withErrors(['error' => 'Error al crear el platillo']);
        }
    }

    // Método para mostrar el formulario de edición de un platillo
    public function edit($id)
    {
        $platillo = $this->platilloService->obtenerPorId($id);
        return view('editarPlatillo', compact('platillo'));
    }

    // Método para actualizar un platillo existente
    public function update(Request $request, $id)
    {
        $data = $request->validate([
            'nombre' => 'required|string|max:60',
            'precio' => 'required|numeric',
            'ingredientes' => 'required|string',
        ]);

        $this->platilloService->actualizarPlatillo($id, $data);

        return redirect()->route('platillos.index')->with('success', 'Platillo actualizado exitosamente.');
    }

    // Método para eliminar un platillo
    public function destroy($id)
    {
        $this->platilloService->eliminarPlatillo($id);
        return redirect()->route('platillos.index')->with('success', 'Platillo eliminado exitosamente.');
    }
}
