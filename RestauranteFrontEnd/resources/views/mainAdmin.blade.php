<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Admin</title>
    <link rel="stylesheet" href="{{ asset('css/main.css') }}">
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Lexend+Peta:wght@100..900&family=Playpen+Sans:wght@500&display=swap" rel="stylesheet">
</head>
<body>
        <div class="header">
            <div class="left-section">
                <span>Nombre</span>
            </div>

            <div class="center-section" >
            <span>{{ $time }}</span>
            </div>

            <div class="right-section">
                <span>Administrador</span>
            </div>
        </div>

        <div class="grid-container">
        <div class="grid-item">
            <img src="{{ asset('images/Clientes.png') }}" alt="" class="item-img">
            Clientes
        </div>

        <div class="grid-item">
        <img src="{{ asset('images/Platos.png') }}" alt="" class="item-img">
            Platos
        </div>

        <div class="grid-item">
        <img src="{{ asset('images/Clientes.png') }}" alt="" class="item-img">
            Ordenes
        </div>

        <div class="grid-item">
        <img src="{{ asset('images/Facturacion.png') }}" alt="" class="item-img">
            Facturacion
        </div>

        <div class="grid-item">
        <img src="{{ asset('images/Inventario.png') }}" alt="" class="item-img">
            Inventario
        </div>

        <div class="grid-item">
        <img src="{{ asset('images/Reservacion.png') }}" alt="" class="item-img">
            Reservacion
        </div>

        <div class="grid-item">
        <img src="{{ asset('images/Compras.png') }}" alt="" class="item-img">
            Compras
        </div>

        <div class="grid-item">
        <img src="{{ asset('images/Clientes.png') }}" alt="" class="item-img">
            Ventas
        </div>

        <div class="grid-item">
        <img src="{{ asset('images/Clientes.png') }}" alt="" class="item-img">
            Empleados
        </div>

        </div>
        



</body>
</html>