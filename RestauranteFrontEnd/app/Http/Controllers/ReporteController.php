<?php

namespace App\Http\Controllers;

use Illuminate\Http\Request;
use GuzzleHttp\Client;
use App\Http\Controllers\OrdenesController;
use App\Http\Controllers\FacturaController;


class ReporteController extends Controller
{
    public function index(Request $request)
    {
        $ordenesController = new OrdenesController();
        $facturasController = new FacturaController();
        $client = new Client();
        

        // Llamar al método index para sacar las cantidades
        $ordenes = $ordenesController->index()->getData()['ordenes'];
        $facturas = $facturasController->showFacturaH()->getData()['facturas'];
        $response = $client->request('GET', 'http://localhost:8091/api/factura/obtener/todos');
        $facturas = json_decode($response->getBody()->getContents(), true);
         

        // Contar los IDs
        $ordenesInventario = count($ordenes);
        $ordenesFacturadas = count($facturas);


     // Sumar los valores de la variable 'total'
     $ventasTotales = array_sum(array_column($facturas, 'total'));

        $gananciasTotales = $ventasTotales * .25;

        return view('reportes', compact('ordenesInventario', 'ordenesFacturadas', 'ventasTotales', 'gananciasTotales'));
    }

    
}
