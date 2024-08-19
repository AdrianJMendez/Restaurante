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

        

        <form action="{{ route('factura.crear') }}" method="POST">
        @csrf
                    <div class="grid-container">
                        <div class="grid-item">
                            <div class="form-group">
                                <label for="usuarioid">Id Usuario:</label>
                                <input class="input-style" type="number" id="usuarioid" name="usuarioid" readonly>
                            </div>

                            <div class="form-group">
                                <label for="identificacion">RTN:</label>
                                <input class="input-style" type="number" id="identificacion" name="identificacion" required>
                            </div>

                            <div class="form-group">
                                <label for="platillos">Selecciona Platillos:</label>
                                <select id="platillos" class="select-style" name="platillos[]" multiple required>
                                    @foreach($platillos as $plato)
                                        <option value="{{ $plato['platilloId'] }}">{{ $plato['platilloId'] }}</option>
                                    @endforeach
                                </select>
                            </div>

                            <div class="form-group">
                                <label for="cantidad">Selecciona cantidad:</label>
                                <input class="input-style" type="number" id="cantidad" name="cantidad" required value="5">
                            </div>
                        </div>

                        <div class="grid-item">
                            <h2>Método de Pago</h2>
                            <select id="metodoDePago" name="metodoDePago" class="select-style" required>
                                <option value="Debito/Credito">Debito/Credito</option>
                                <option value="Cash">Cash</option>
                            </select>
                            
                            <div class="form-group">
                                <label for="fecha">Fecha:</label>
                                <input class="input-style" type="datetime-local" id="fecha" name="fecha" required>
                            </div>

                            <input type="submit" value="Guardar">
                        </div>
                    </div>
        </form>


        <script>
            document.addEventListener('DOMContentLoaded', function() {
                // Recupera los valores almacenados en localStorage
                const nombreUsuario = localStorage.getItem('nombreUsuario');
                const nombrePermiso = localStorage.getItem('nombrePermiso');
                const usuarioid = localStorage.getItem('usuarioid');

                // Reemplaza los valores en la vista
                if (nombreUsuario) {
                    document.getElementById('nombreUsuario').textContent = nombreUsuario;
                }

                if (nombrePermiso) {
                    document.getElementById('nombrePermiso').textContent = nombrePermiso;
                }

                // Asigna el usuarioid al campo de entrada
                if (usuarioid) {
                    document.getElementById('usuarioid').value = usuarioid;
                }
            });
        </script>

</body>
</html>