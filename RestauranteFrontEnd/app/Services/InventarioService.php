<?php
namespace App\Services;

use App\Models\Producto;

class InventarioService
{
    public function obtenerTodos()
    {
        return Producto::all();
    }

    public function buscarPorNombre($nombre)
    {
        return Producto::where('nombre', 'like', '%' . $nombre . '%')->get();
    }

    public function ordenarInventario()
    {
        Http::post('http://api.ejemplo.com/ordenar-inventario');
    }
}
