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
        <a href="{{ route('platos.index') }}">
            <img src="{{ asset('images/Platos.png') }}" alt="" class="item-img"> 
        </a>
        
            Platos
        </div>

        <div class="grid-item">
        <a href="{{ route('ordenes.index') }}">
            <img src="{{ asset('images/Inventario.png') }}" alt="" class="item-img"> 
        </a>
            Ordenes
        </div>

        <div class="grid-item">
            <a href="{{ route('factura') }}">
            <img src="{{ asset('images/Facturacion.png') }}" alt="" class="item-img">
            </a>
            Facturacion
        </div>

        <div class="grid-item">
        
        <a href="{{ route('inventario.index') }}">
            <img src="{{ asset('images/Inventario.png') }}" alt="" class="item-img"> 
        </a>
                
        Inventario
        </div>

        <div class="grid-item">
        <img src="{{ asset('images/Reservacion.png') }}" alt="" class="item-img">
            Reservacion
        </div>

        <div class="grid-item">
        <img src="{{ asset('images/ventas.png') }}" alt="" class="item-img">
            Reportes
        </div>

        <div class="grid-item">

            <a href="{{ route('usuarios.index') }}">
                <img src="{{ asset('images/image 7.png') }}" alt="Empleados" class="item-img">
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

            // Tomar el `usuarioid` del controlador
            const usuarioid = "{{ $usuarioid }}"; // Pasar el usuarioid desde el controlador

            // Guardar en `localStorage`
            if (nombreUsuario && nombrePermiso && usuarioid) {
                localStorage.setItem('nombreUsuario', nombreUsuario);
                localStorage.setItem('nombrePermiso', nombrePermiso);
                localStorage.setItem('usuarioid', usuarioid);
                console.log("Datos guardados en localStorage:", nombreUsuario, nombrePermiso, usuarioid);
            } else {
                console.error("No se encontró contenido para guardar en localStorage.");
            }
        });
    </script>

</body>
</html>