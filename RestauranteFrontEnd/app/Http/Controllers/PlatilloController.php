<?php

// app/Http/Controllers/PlatilloController.php
namespace App\Http\Controllers;

use Illuminate\Http\Request;
use App\Services\PlatilloService;

class PlatilloController extends Controller
{
    protected $platilloService;

    public function __construct(PlatilloService $platilloService)
    {
        $this->platilloService = $platilloService;
    }

    // Método para mostrar todos los platillos
    public function index()
    {
        $platillos = $this->platilloService->obtenerTodos();
        return view('platillos', compact('platillos'));
    }

    // Método para mostrar el formulario de creación de platillo
    public function create()
    {
        return view('agregarPlatillo');
    }

    // Método para almacenar un nuevo platillo
    public function store(Request $request)
    {
        $data = $request->validate([
            'nombre' => 'required|string|max:255',
            'precio' => 'required|numeric',
            'ingredientes' => 'required|string',
        ]);

        $this->platilloService->crearPlatillo($data);

        return redirect()->route('platillos.index')->with('success', 'Platillo agregado exitosamente.');
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
