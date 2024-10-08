<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Factura</title>
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
    
        <!-- <div class="item1">item 1</div>
            <div class="item2">item 2</div>
            <div class="item3">item 3</div>

        </div> -->
        <div class="grid-item">
            
            <input type="text" id="myInput" onkeyup="myFunction()" placeholder="Buscar por nombres..">

            <table border="1">
                <thead>
                    <tr>
                        <th>Usuario</th>
                        <th>cliente</th>
                        <th>Fecha</th>
                        <th>MetodoPago</th>
                        <th>Total</th>
                    </tr>
                </thead>
                <tbody>
                @foreach($facturas as $item)
                            <tr>
                                <td>{{ $item['usuario']['usuarioid'] }}</td>
                                <td>{{ $item['cliente']['clienteid'] }}</td>
                                <td>{{ $item['fecha'] }}</td>
                                <td>{{ $item['metodoDePago'] }}</td>
                                <td>{{ $item['total'] }}</td>

                                
                            </tr>
                @endforeach
                </tbody>

            </table>
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
