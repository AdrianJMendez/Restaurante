<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <link rel="stylesheet" type="text/css" href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css" integrity="sha384-wvfXpqpZZVQGK6TAh5PVlGOfQNHSoD2xbE+QkPxCAFlNEevoEH3Sl0sibVcOQVnN" crossorigin="anonymous">
    <link rel="stylesheet" type="text/css" href="{{ asset('css/common.css') }}">
    <link rel="stylesheet" type="text/css" href="{{ asset('css/fonts.css') }}">
    <link rel="stylesheet" type="text/css" href="{{ asset('css/Inventario.css') }}">
    <title>Inventario</title>
</head>
<body class="flex-column">
    <main class="inventario main">
        <section class="adminOverviewSection">
            <div class="adminContainerDiv">
                <div class="flexRowContainerDiv">
                    <div class="flexRowImageTitleDiv">
                        <img class="adminImage" src="{{ asset('images/b826be9582946e209721917eb1682f57.svg') }}" alt="alt text">
                        <h1 class="adminTitleH1">Name</h1>
                    </div>
                    <div class="flexRowTimeRoleDiv">
                        <h1 class="adminTimeH1">07:35</h1>
                        <h1 class="adminRoleH1">Administrador</h1>
                    </div>
                </div>
            </div>
        </section>
        <section class="inventoryManagementSection">
            <div class="inventoryManagementSection1">
                <div class="flex_row">
                    <img class="image4" src="{{ asset('images/c80c605bd450297045d5d4956d2529d9.png') }}" alt="alt text">
                    <button class="btn">Ordenar Inventario</button>
                </div>
                <div class="content_box4">
                    <div class="content_box3"><h2 class="medium_title">Inventario</h2></div>
                </div>
                <div class="flex_col">
                    <img class="image2" src="{{ asset('images/a19400014154fb64c1431c559748dae7.png') }}" alt="alt text">
                    <div class="content_box2">
                        <div class="content_box">
                            <div class="flex_row1">
                                <h2 class="medium_title1">Id. de Producto</h2>
                                <h2 class="medium_title1">Ingrediente</h2>
                                <h2 class="medium_title1">En Inventario</h2>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="content_box1">
                    <div class="flex_row2">
                        <div class="flex_col1">
                            <h3 class="subtitle">20221002626</h3>
                            <h3 class="subtitle1">20221002626</h3>
                        </div>
                        <div class="flex_col2">
                            <h3 class="subtitle">Carne para hamburguesa</h3>
                            <h3 class="subtitle5">Lechuga</h3>
                        </div>
                        <div class="flex_col3">
                            <h3 class="subtitle">23 kg</h3>
                            <h3 class="subtitle3">10 kg</h3>
                        </div>
                    </div>
                </div>
            </div>
        </section>
    </main>
</body>
</html>
