<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Login</title>
    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
    <!-- Custom CSS -->
    <style>
        body {
            background-color: #000000;
            font-family: Arial, sans-serif;
            color: #333333;
        }
        .container {
            margin-top: 100px;
            max-width: 400px;
        }
        .card {
            background-color:  #ffffff;
            color: #000000;
            border-radius: 8px;
        }
        .card-header {
            text-align: center;
            background-color: #d4af37; /* Dorado */
            color:  #000000;
            font-size: 24px;
            font-weight: bold;
            border-bottom: none;
        }
        .form-label {
            color:  #000000;
        }
        .form-control {
            background-color: #333333;
            color:  #000000;
            border: 1px solid #d4af37; /* Borde dorado */
        }
        .btn-primary {
            background-color: #8b4513; /* Café */
            border: none;
        }
        .btn-primary:hover {
            background-color: #a0522d; /* Café más claro */
        }
    </style>
</head>
<body>

<div class="container">
    <div class="card">
        <div class="card-header">
            Login
        </div>
        <div class="card-body">
            <form  method="GET" action="{{ route('usuario.redirigir') }}">
                @csrf

               

                <div class="mb-3">
                    <label for="nombre" class="form-label">Nombre</label>
                    <input type="text" class="form-control" id="nombre" name="nombre" required>
                </div>

                <div class="mb-3">
                    <label for="identificacion" class="form-label">Identificación</label>
                    <input type="text" class="form-control" id="identificacion" name="identificacion" required>
                </div>

                <div class="mb-3">
                    <label for="permisos" class="form-label">Permisos</label>
                    <select class="form-select" id="permisos" name="permisos" required>
                        <option value="admin">Admin</option>
                        <option value="gerente">Gerente</option>
                        <option value="cajero">Cajero</option>
                    </select>
                </div>

                <button type="submit" class="btn btn-primary w-100">Iniciar sesión</button>
            </form>
        </div>
    </div>
</div>

<!-- Bootstrap JS -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
