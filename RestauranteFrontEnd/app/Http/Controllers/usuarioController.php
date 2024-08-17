<?php

namespace App\Http\Controllers;

use Illuminate\Http\Request;
use GuzzleHttp\Client;

class UsuarioController extends Controller
{
    public function index()
    {
        $client = new Client();
        $response = $client->request('GET', 'http://localhost:8091/api/restaurante/usuario/todos');

        $usuarios = json_decode($response->getBody()->getContents(), true);

        return view('users', compact('usuarios'));
    }

    public function crear(Request $request)
    {
        $client = new Client();
        $response = $client->post('http://localhost:8091/api/restaurante/usuario/crear', [
            'json' => [
                'user' => $request->input('user'),
                'contrasena' => $request->input('contrasena'),
                'categoriapermiso' => $request->input('categoriaPermiso')
            ]
        ]);

        if ($response->getStatusCode() == 200) {
            return redirect()->route('usuarios.index')->with('success', 'Usuario creado exitosamente.');
        } else {
            return redirect()->route('usuarios.index')->with('error', 'Error al crear el usuario.');
        }
    }

    public function eliminar($id)
    {
        $client = new Client();
        $response = $client->delete("http://localhost:8091/api/restaurante/usuario/borrar/id/{$id}");

        if ($response->getStatusCode() == 200) {
            return redirect()->route('usuarios.index')->with('success', 'Usuario eliminado exitosamente.');
        } else {
            return redirect()->route('usuarios.index')->with('error', 'Error al eliminar el usuario.');
        }
    }
}


