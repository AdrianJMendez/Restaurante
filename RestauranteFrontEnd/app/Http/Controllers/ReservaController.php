<?php

namespace App\Http\Controllers;

use Illuminate\Http\Request;
use Illuminate\Support\Facades\Http;
use GuzzleHttp\reserva;

class ReservaController extends Controller
{
    public function index()
    {
        $response = Http::get('http://localhost:8091/api/reserva');
        $mesas = $response->json();
        return view('reservas', compact('mesas'));
    }

    public function create(Request $request)
    {
        $cliente = $request->input('cliente');
        // Lógica para crear una nueva reserva
        $response = Http::post('http://localhost:8091/api/reserva/crear', [
            'cliente' => $cliente,
            // Otros datos necesarios para la reserva 
        ]);

        return redirect('/reservas');
    }

    public function showCreateForm()
    {
        return view('agregarReserva');
    }
}
