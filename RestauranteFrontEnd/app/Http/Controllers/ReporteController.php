<?php

namespace App\Http\Controllers;

use Illuminate\Http\Request;
use GuzzleHttp\Client;
use App\Http\Controllers\OrdenesController;


class ReporteController extends Controller
{
    public function index(Request $request)
    {
        $ordenesController = new OrdenesController();
        
        // Llamar al método index para sacar las ordenes
        $ordenes = $ordenesController->index()->getData()['ordenes'];

        // Contar los IDs
        $ordenesInventario = count($ordenes);
        $ordenesFacturadas = 'Valor de ordenes facturadas';
        $ventasTotales = 'Valor de ventas totales';
        $gananciasTotales = 'Valor de ganancias totales';

        return view('reportes', compact('ordenesInventario', 'ordenesFacturadas', 'ventasTotales', 'gananciasTotales'));
    }

    
}
