<?php

use Illuminate\Support\Facades\Route;

use App\Http\Controllers\TimeController;

Route::get('/', function () {
    return view('welcome');
});

Route::get('/login', function () {
    return view('login');
});

Route::get('/admin/main', [TimeController::class, 'showTime'])->name('time.show');

Route::get('/admin/clients', [TimeController::class, 'showTimeClients'])->name('time.show');

Route::get('/admin/facture', [TimeController::class, 'showTimeFacture'])->name('time.show');