<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Clientes</title>
    <link rel="stylesheet" href="{{ asset('css/facture.css') }}">
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Lexend+Peta:wght@100..900&family=Playpen+Sans:wght@500&display=swap" rel="stylesheet">
</head>
<body>
        <div class="header">
            <div class="left-section">
                <span>Nombre</span>
            </div>

            <div class="center-section" >
            <span>{{ $time }}</span>
            </div>

            <div class="right-section">
                <span>Administrador</span>
            </div>
        </div>

        <div class="grid-container">
            <div class="grid-item">
                <img src="{{ asset('images/image 14.png') }}" alt="">
                <h1>Nueva Factura</h1>
            </div>

            <div class="grid-item">
               
                <img src="{{ asset('images/image 17.png') }}" alt="">
                <h1>Historial de Facturas</h1>

            </div>
       </div>
       

</body>
</html>