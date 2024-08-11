<?php

use Illuminate\Support\Facades\Route;

use App\Http\Controllers\usuarioController;

Route::get('/', function () {
    return view('welcome');
});

Route::get('/login', function () {
    return view('login');
});

Route::get('/main', [usuarioController::class, 'redirectUser'])->name('usuario.redirigir');
