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
            <span>{{ $nombreUsuario }}</span> <!-- Nombre del usuario -->
            </div>

            <div class="center-section" >
            <span>7:35</span>
            </div>

            <div class="right-section">
            <span>{{ $nombrePermiso }}</span> <!-- Nombre del permiso -->
            </div>
        </div>

        <div class="grid-container">
        <div class="grid-item">
            <a href="{{ route('clientes.index') }}">
                <img src="{{ asset('images/Clientes.png') }}" alt="" class="item-img"> 
            </a>
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
            <a href="{{ route('factura') }}">
            <img src="{{ asset('images/Facturacion.png') }}" alt="" class="item-img">
            </a>
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

            <a href="{{ route('usuarios.index') }}">
                <img src="{{ asset('images/Clientes.png') }}" alt="Empleados" class="item-img">
            </a>       
            Empleados
        </div>

        </div>
        


        <script>
            document.addEventListener('DOMContentLoaded', function() {
                // Tomar el contenido del `span` en la sección izquierda
                const nombreUsuario = document.querySelector('.left-section span').textContent;
                
                // Tomar el contenido del `span` en la sección derecha
                const nombrePermiso = document.querySelector('.right-section span').textContent;

                // Guardar en `localStorage`
                if (nombreUsuario && nombrePermiso) {
                    localStorage.setItem('nombreUsuario', nombreUsuario);
                    localStorage.setItem('nombrePermiso', nombrePermiso);
                    console.log("Datos guardados en localStorage:", nombreUsuario, nombrePermiso);
                } else {
                    console.error("No se encontró contenido en los spans para guardar en localStorage.");
                }
            });
        </script>

</body>
</html>