<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Clientes</title>
    <link rel="stylesheet" href="{{ asset('css/clients.css') }}">
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Lexend+Peta:wght@100..900&family=Playpen+Sans:wght@500&display=swap" rel="stylesheet">
</head>
<body>
    <div class="header">
        <div class="left-section">
            <span>Nombre</span>
        </div>

        <div class="center-section">
            <span>7:37</span>
        </div>

        <div class="right-section">
            <span>Administrador</span>
        </div>
    </div>

    <div class="grid-container">
        <div class="grid-item">
            <input type="text" id="myInput" onkeyup="myFunction()" placeholder="Buscar por nombres..">

            <table border="1">
                <thead>
                    <tr>
                        <th>Identificación</th>
                        <th>Nombre</th>
                        <th>Apellido</th>
                        <th>Acción</th>
                    </tr>
                </thead>
                <tbody>
                    @foreach($clientes as $cliente)
                        <tr>
                            <td>{{ $cliente['identificacion'] }}</td>
                            <td>{{ $cliente['nombre'] }}</td>
                            <td>{{ $cliente['apellido'] }}</td>
                            <td>
                                <a href="{{ route('clientes.eliminar', ['identificacion' => $cliente['identificacion']]) }}">
                                    <img src="{{ asset('images/delete.png') }}" alt="">
                                </a>
                            </td>
                        </tr>
                    @endforeach
                </tbody>
            </table>
        </div>

        <div class="grid-item">
            <div id="form">
                <h1>Crear nuevo cliente:</h1>
                <form action="{{ route('clientes.crear') }}" method="POST">
                    @csrf <!-- Token de seguridad de Laravel -->
                    <div class="form-group">
                        <label for="identificacion">Identificación:</label>
                        <input class="input-style" type="text" id="identificacion" name="identificacion" required>
                    </div>
                    <div class="form-group">
                        <label for="nombre">Nombre:</label>
                        <input class="input-style" type="text" id="nombre" name="nombre" required>
                    </div>
                    <div class="form-group">
                        <label for="apellido">Apellido:</label>
                        <input class="input-style" type="text" id="apellido" name="apellido" required>
                    </div>
                    <input type="submit" value="Guardar">
                </form>
            </div>
        </div>
    </div>
</body>
</html>
