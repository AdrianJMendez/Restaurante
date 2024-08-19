<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Platillos</title>
    <link rel="stylesheet" href="{{ asset('css/platillosAdd.css') }}">
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
        <div id="form">
            <h1>Agregar Nuevo Platillo:</h1>
            <form action="{{ route('platos.crear') }}" method="POST" enctype="multipart/form-data">
                @csrf <!-- Token de seguridad de Laravel -->
                
                <div class="form-group">
                    <label for="nombre">Nombre del Platillo:</label>
                    <input class="input-style" type="text" id="nombre" name="nombre" required>
                </div>
                
                <div class="form-group">
                    <label for="precio">Precio:</label>
                    <input class="input-style" type="number" id="precio" name="precio" step="0.01" required>
                </div>

                <div class="form-group">
                    <label for="ingredientes">Selecciona Ingredientes:</label>
                    <select id="ingredientes" class="select-style" name="ingredientes[]" multiple required>

                        <option value="1">Tomate</option>
                        <option value="2">Mozarella</option>
                        <option value="3">Pasta</option>
                        <option value="4">Basilisco</option>
                        <option value="5">Aceite de Oliva</option>
                

                    </select>
                </div>

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
