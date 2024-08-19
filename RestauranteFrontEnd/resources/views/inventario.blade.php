<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Inventario</title>
    <link rel="stylesheet" href="{{ asset('css/FacturaH.css') }}">
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

    <div class="grid-container">
        <div class="flex-container">
            <div class="grid-item">
                <input type="text" id="myInput" onkeyup="myFunction()" placeholder="Buscar por nombres..">

                <table border="1">
                    <thead>
                        <tr>
                            <th>Id</th>
                            <th>Nombre</th>
                            <th>Precio</th>
                            <th>Cantidad</th>
                            <th>Unidad</th>
                        </tr>
                    </thead>
                    <tbody>
                    <tbody>
                        @foreach($inventario as $item)
                            <tr>
                                <td>{{ $item['inventarioId'] }}</td>
                                <td>{{ $item['nombre'] }}</td>
                                <td>{{ $item['preciocompra'] }}</td>
                                <td>{{ $item['cantidad'] }}</td>
                                <td>{{ $item['unidadmetrica'] }}</td>
                            </tr>
                        @endforeach
                    </tbody>

                    </tbody>
                </table>
            </div>
        </div>
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
