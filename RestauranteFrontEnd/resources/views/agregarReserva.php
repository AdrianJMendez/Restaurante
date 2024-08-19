<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Agregar Reserva</title>
    <link rel="stylesheet" href="{{ asset('css/agregar_reserva.css') }}">
</head>
<body>
    <div id="reservationModal" class="modal">
        <div class="modal-content">
            <span class="close" onclick="closeModal()">×</span>
            <h2>Nueva Reserva</h2>
            <form action="{{ url('/reservas') }}" method="POST">
                @csrf
                <label for="cliente">Nombre del Cliente:</label>
                <input type="text" id="cliente" name="cliente" required>
                <button type="submit">Registrar</button>
            </form>
        </div>
    </div>

    <script>
        function closeModal() {
            window.location.href = '/reservas';
        }
    </script>
</body>
</html>
