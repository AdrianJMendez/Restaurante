<?php
namespace App\Http\Controllers;

use Illuminate\Http\Request;
use GuzzleHttp\Client;

class LoginController extends Controller
{
    public function login(Request $request)
{
    // Validar los datos del formulario
    $validatedData = $request->validate([
        'identificacion' => 'required|integer',
        'contrasena' => 'required|string',
    ]);

    // Crear una instancia de Guzzle HTTP Client
    $client = new Client();

    try {
        // Enviar la solicitud al backend de Spring Boot
        $response = $client->get("http://localhost:8091/api/restaurante/usuario/unos/{$validatedData['identificacion']}");

        // Decodificar la respuesta JSON
        $usuario = json_decode($response->getBody(), true);

        // Extraer el nombre del usuario y el nombre del permiso
        $nombreUsuario = $usuario['user']; // Ajusta la clave según la estructura de tu respuesta
        $nombrePermiso = $usuario['categoriaPermiso']['nombre']; // Ajusta la clave según la estructura de tu respuesta
        $usuarioid = $usuario['usuarioid'];

        // Pasar los datos a la vista
        // Determinar la vista a retornar
        $vista = '';

        switch ($nombrePermiso) {
            case 'Gerente':
                $vista = 'mainGerente';
                break;
            case 'Cajero':
                $vista = 'mainCajero';
                break;
            case 'Administrador':
                $vista = 'mainAdministrador';
                break;
            default:
                return back()->withErrors(['error' => 'Permiso no reconocido']);
        }




        return view($vista, [
            'nombreUsuario' => $nombreUsuario,
            'nombrePermiso' => $nombrePermiso,
            'usuarioid'=> $usuarioid,
        ]);

    } catch (\Exception $e) {
        // Manejar errores de la solicitud
        return back()->withErrors(['error' => 'Hubo un problema al conectarse al servidor o al procesar la respuesta']);
    }
}


}