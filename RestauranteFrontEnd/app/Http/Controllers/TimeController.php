<?php

namespace App\Http\Controllers;

use Illuminate\Http\Request;
use GuzzleHttp\Client;

class TimeController extends Controller
{
    public function showTime()
    {
        $client = new Client();
        $response = $client->request('GET', 'http://worldtimeapi.org/api/timezone/America/Tegucigalpa');
        $data = json_decode($response->getBody()->getContents(), true);

        // Extrae la hora
        $datetime = $data['datetime'];
        $time = date('H:i:s', strtotime($datetime));  // Formatea la hora como HH:MM

        return view('mainAdmin', ['time' => $time]);

    }
}
