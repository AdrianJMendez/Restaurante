<?php

// app/Services/PlatilloService.php
namespace App\Services;

use App\Models\Platillo;

class PlatilloService
{
    public function obtenerTodos()
    {
        return Platillo::all();
    }

    public function obtenerPorId($id)
    {
        return Platillo::findOrFail($id);
    }

    public function crearPlatillo($data)
    {
        return Platillo::create($data);
    }

    public function actualizarPlatillo($id, $data)
    {
        $platillo = Platillo::findOrFail($id);
        $platillo->update($data);
        return $platillo;
    }

    public function eliminarPlatillo($id)
    {
        $platillo = Platillo::findOrFail($id);
        $platillo->delete();
        return $platillo;
    }
}
