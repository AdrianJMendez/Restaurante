<?php

use Illuminate\Support\Facades\Route;

use App\Http\Controllers\TimeController;
use App\Http\Controllers\LoginController;
use App\Http\Controllers\ClientController;
use App\Http\Controllers\UsuarioController;
use App\Http\Controllers\FacturaController;



Route::get('/', function () {
    return view('welcome');
});

Route::get('/login', function () {
    return view('login');
});

Route::get('/admin/main', [TimeController::class, 'showTime'])->name('time.show');

Route::get('/clients', [TimeController::class, 'showTimeClients'])->name('clients');

Route::get('/admin/facture', [TimeController::class, 'showTimeFacture'])->name('time.show');

Route::get('/admin/facture/new', [TimeController::class, 'showTimeFactureNew'])->name('facture.new');

Route::post('/login/validate', [LoginController::class, 'login'])->name('login');

Route::get('/clientes', [ClientController::class, 'index'])->name('clientes.index');

Route::post('/cliente/crear', [ClientController::class, 'crearCliente'])->name('clientes.crear');

Route::get('/clientes/eliminar/{identificacion}', [ClientController::class, 'eliminar'])->name('clientes.eliminar');

Route::get('/usuarios', [UsuarioController::class, 'index'])->name('usuarios.index');

Route::post('/usuarios/crear', [UsuarioController::class, 'crear'])->name('usuarios.crear');

Route::get('/usuarios/eliminar/{id}', [UsuarioController::class, 'eliminar'])->name('usuarios.eliminar');

Route::get('/factura', [FacturaController::class, 'showFactura'])->name('factura');