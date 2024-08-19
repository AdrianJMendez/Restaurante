<?php

use Illuminate\Support\Facades\Route;

use App\Http\Controllers\TimeController;
use App\Http\Controllers\LoginController;
use App\Http\Controllers\ClientController;
use App\Http\Controllers\UsuarioController;
use App\Http\Controllers\FacturaController;
use App\Http\Controllers\PlatilloController;
use App\Http\Controllers\InventarioController;
use App\Http\Controllers\ReservaController;
use App\Http\Controllers\ReporteController;
use App\Http\Controllers\OrdenesController;


Route::get('/', function () {
    return view('welcome');
});

Route::get('/login', function () {
    return view('login');
});

Route::post('/login/validate', [LoginController::class, 'login'])->name('login');

//main

Route::get('/admin/main', [TimeController::class, 'showTime'])->name('time.show');

Route::get('/admin/facture', [TimeController::class, 'showTimeFacture'])->name('time.show');



//clientes

Route::get('/clients', [TimeController::class, 'showTimeClients'])->name('clients');

Route::get('/clientes', [ClientController::class, 'index'])->name('clientes.index');

Route::post('/cliente/crear', [ClientController::class, 'crearCliente'])->name('clientes.crear');

Route::get('/clientes/eliminar/{identificacion}', [ClientController::class, 'eliminar'])->name('clientes.eliminar');

//usuarios

Route::get('/usuarios', [UsuarioController::class, 'index'])->name('usuarios.index');

Route::post('/usuarios/crear', [UsuarioController::class, 'crear'])->name('usuarios.crear');

Route::get('/usuarios/eliminar/{id}', [UsuarioController::class, 'eliminar'])->name('usuarios.eliminar');

//platillos

Route::get('/platillos', [PlatilloController::class, 'index'])->name('platos.index');

Route::get('/platillos/agregar', [PlatilloController::class, 'create'])->name('platos.add');

Route::post('/platillos/crear', [PlatilloController::class, 'crear'])->name('platos.crear');

Route::get('/platillos/eliminar/{platilloId}', [PlatilloController::class, 'eliminar'])->name('platos.eliminar');

//Factura

Route::get('/factura', [FacturaController::class, 'showFactura'])->name('factura');

Route::get('/factura/historial', [FacturaController::class, 'showFacturaH'])->name('factura.h');

Route::get('/admin/facture/new', [TimeController::class, 'showTimeFactureNew'])->name('facture.new');

//Inventario

Route::get('/inventario', [InventarioController::class, 'show'])->name('inventario.index');

// Reservas

Route::get('/reservas', [ReservaController::class, 'index']);
Route::get('/reservas/agregar', [ReservaController::class, 'showCreateForm']);
Route::post('/reservas', [ReservaController::class, 'create']);

// Reportes
Route::get('/reportes', [ReporteController::class, 'index']);
//Ordenes
Route::get('/ordenes', [OrdenesController::class, 'index'])->name('ordenes.index');
