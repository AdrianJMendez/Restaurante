<?php

namespace App\Http\Controllers;
use Illuminate\Http\Request;

class usuarioController extends Controller
{
    

    public function redirectUser(Request $request){
         // Validar que el campo de permisos exista en la solicitud
    $request->validate([
        'permisos' => 'required|in:admin,gerente,cajero',
    ]);

    // Obtener el valor de los permisos desde el request
    $permisos = $request->input('permisos');

    // Redirigir según el valor de los permisos
    switch ($permisos) {
        case 'admin':
            return view('mainAdmin');
        case 'gerente':
            return view('mainGerente');
        case 'cajero':
            return view('mainCajero');
    }
    }

    
}