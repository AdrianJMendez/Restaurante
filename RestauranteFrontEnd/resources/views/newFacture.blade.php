<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Clientes</title>
    <link rel="stylesheet" href="{{ asset('css/facturenew.css') }}">
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

        

        <div id="form">
                <form action="{{ route('clientes.crear') }}" method="POST">
                    @csrf <!-- Token de seguridad de Laravel -->

                    <div class="grid-container">

                            <div class="grid-item">

                            <div class="form-group">
                                <label for="identificacion">RTN:</label>
                                <input class="input-style" type="text" id="identificacion" name="identificacion" required>
                            </div>
                            <div class="grid-container">
                                
                            </div>

                            </div>

                            <div class="grid-item">
                                <h2>Metodo de Pago</h2>
                            <select id="MetododePago" name="MetododePago" class="select-style" required>
                                
                                <option value="1">Debito/Credito</option>
                                <option value="2">Cash</option>
                            </select>
                            
                            <div class="form-group">
                                <label for="nombre">Fecha:</label>
                                <input class="input-style" type="text" id="nombre" name="nombre" required>
                            </div>

                            <div class="form-group">
                                <label for="nombre">Total:</label>
                                <input class="input-style" type="text" id="nombre" name="nombre" readonly value="1000 Lps.">
                            </div>


                            <input type="submit" value="Guardar">

                            </div>

                    </div>

                </form>
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