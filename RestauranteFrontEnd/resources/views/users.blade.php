<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Usuarios</title>
    <link rel="stylesheet" href="{{ asset('css/clients.css') }}">
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
        <div class="grid-item">
            <input type="text" id="myInput" onkeyup="myFunction()" placeholder="Buscar por nombres..">

            <table border="1">
                <thead>
                    <tr>
                        <th>Id</th>
                        <th>Nombre</th>
                        <th>Permiso</th>
                        <th>Acción</th>
                    </tr>
                </thead>
                <tbody>
                    @foreach($usuarios as $usuario)
                        <tr>
                            <td>{{ $usuario['usuarioid'] }}</td>
                            <td>{{ $usuario['user'] }}</td>
                            <td>{{ $usuario['categoriaPermiso']['nombre'] }}</td>
                            <td>
                                <a href="{{ route('usuarios.eliminar', ['id' => $usuario['usuarioid']]) }}">
                                    <img src="{{ asset('images/delete.png') }}" alt="Eliminar">
                                </a>
                            </td>
                        </tr>
                    @endforeach
                </tbody>

            </table>
        </div>

        <div class="grid-item">
            <div id="form">
                <h1>Crear nuevo usuario:</h1>
                <form action="{{ route('usuarios.crear') }}" method="POST">
                    @csrf 
                    <div class="form-group">
                        <label for="user">Nombre:</label>
                        <input class="input-style" type="text" id="user" name="user" required>
                    </div>
                    <div class="form-group">
                        <label for="contrasena">Contraseña:</label>
                        <input class="input-style" type="password" id="contrasena" name="contrasena" required>
                    </div>
                    <select id="categoriaPermiso" name="categoriaPermiso" class="select-style" required>
                        <option value="1">Gerente</option>
                        <option value="2">Administrador</option>
                        <option value="3">Cajero</option>
                    </select>

                    <input type="submit" value="Guardar">
                </form>
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
