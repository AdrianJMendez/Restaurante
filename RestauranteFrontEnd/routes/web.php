<?php

use Illuminate\Support\Facades\Route;

use App\Http\Controllers\TimeController;

Route::get('/', function () {
    return view('welcome');
});

Route::get('/login', function () {
    return view('login');
});

// Route::get('/admin/main', function () {
//     return view('mainAdmin');
// });

Route::get('/admin/main', [TimeController::class, 'showTime'])->name('time.show');
