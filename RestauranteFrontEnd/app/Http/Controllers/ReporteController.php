<?php

namespace App\Http\Controllers;

use Illuminate\Http\Request;
use GuzzleHttp\Client;
use App\Http\Controllers\OrdenesController;


class ReporteController extends Controller
{
    public function index(Request $request)
    {
        $id = $request->input();
        $ordenesInventario = 'valor';
        $ordenesFacturadas = 'Valor de ordenes facturadas';
        $ventasTotales = 'Valor de ventas totales';
        $gananciasTotales = 'Valor de ganancias totales';

        return view('reportes', compact('ordenesInventario', 'ordenesFacturadas', 'ventasTotales', 'gananciasTotales'));
    }

    
}
