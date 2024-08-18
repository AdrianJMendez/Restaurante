<?php
namespace App\Http\Controllers;

use Illuminate\Http\Request;
use App\Services\InventarioService;

class InventarioController extends Controller
{
    protected $inventarioService;

    public function __construct(InventarioService $inventarioService)
    {
        $this->inventarioService = $inventarioService;
    }

    public function index()
    {
        $productos = $this->inventarioService->obtenerTodos();
        return view('inventario', compact('productos'));
    }

    public function buscar(Request $request)
    {
        $productos = $this->inventarioService->buscarPorNombre($request->input('nombre'));
        return view('inventario', compact('productos'));
    }

    public function ordenar()
    {
        $this->inventarioService->ordenarInventario();
        return redirect()->route('inventario.index')->with('success', 'Inventario ordenado exitosamente.');
    }
}
