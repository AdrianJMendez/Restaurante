<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Platillos</title>
    <link rel="stylesheet" href="{{ asset('css/platillos.css') }}">
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Lexend+Peta:wght@100..900&family=Playpen+Sans:wght@500&display=swap" rel="stylesheet">
</head>
<body>
    <div class="header">
        <div class="left-section">
            <span id="nombreUsuario">Nombre</span>
        </div>

        <div class="center-section">
            <span>7:37</span>
        </div>

        <div class="right-section">
            <span id="nombrePermiso">Gerente</span>
        </div>
    </div>

  
    <a href="{{ route('platos.add') }}" class="grid-container-a">
    <div class="grid-container-header">
        <img src="{{ asset('images/lasana.png') }}" alt="ewe">
        <h1>Agregar Nuevo Platillo</h1>
    </div>
    </a>


    <div class="grid-container">
                @foreach($platillos as $plato)
                    <div class="grid-item">
                        <h2>{{ $plato['nombre'] }}</h2> <!-- Nombre del platillo -->
                        <p> ${{ number_format($plato['precio'], 2) }}</p> <!-- Precio del platillo -->

                        <!-- Mostrar nombres de inventarios -->
                        @foreach($plato['inventarios'] as $inventario)
                            <p> {{ $inventario['inventario']['nombre'] }}</p>
                        @endforeach
                        
                                <a href="{{ route('platos.eliminar', ['platilloId' => $plato['platilloId']]) }}">
                                    <img src="{{ asset('images/delete.png') }}" alt="">
                                </a>
                            
                    </div>
                @endforeach
    </div>




    <script>
    document.addEventListener('DOMContentLoaded', function() {
        // Recupera los valores almacenados en localStorage
        const nombreUsuario = localStorage.getItem('nombreUsuario');
        const nombrePermiso = localStorage.getItem('nombrePermiso');

        // Reemplaza los valores en la vista
        if (nombreUsuario) {
            document.getElementById('nombreUsuario').textContent = nombreUsuario;
        }

        if (nombrePermiso) {
            document.getElementById('nombrePermiso').textContent = nombrePermiso;
        }
    });
    </script>

</body>
</html>
