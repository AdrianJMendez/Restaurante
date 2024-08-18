<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <link rel="stylesheet" type="text/css" href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css" integrity="sha384-wvfXpqpZZVQGK6TAh5PVlGOfQNHSoD2xbE+QkPxCAFlNEevoEH3Sl0sibVcOQVnN" crossorigin="anonymous">
    <link rel="stylesheet" type="text/css" href="{{ asset('css/common.css') }}">
    <link rel="stylesheet" type="text/css" href="{{ asset('css/fonts.css') }}">
    <link rel="stylesheet" type="text/css" href="{{ asset('css/Platos.css') }}">
</head>
<body class="flex-column">
    <main class="platos main">
        <section class="mainContentSection">
            <div class="flexColumnLayout">
                <div class="contentGroup">
                    <div class="rectangleBlock1"></div>
                    <div class="flexRowLayout">
                        <img class="heroImage" src="{{ asset('assets/7112dc73b7a78887d4e5c33698b0055f.svg') }}" alt="alt text">
                        <h1 class="heroTitleName">Name</h1>
                        <h1 class="heroTitleTime">07:35</h1>
                        <h1 class="heroTitleRole">Administrador</h1>
                    </div>
                </div>
                <div class="flexColumnLayout1">
                    <div class="coverImageGroup">
                        <img class="coverImage" src="{{ asset('assets/dc632c330a864f7365f960e423e6d2c8.png') }}" alt="alt text">
                        <div class="flexRowLayout1">
                            <img class="additionalHeroImage" src="{{ asset('assets/0387638dbb7e029c26904d6aa22fbd5f.png') }}" alt="alt text">
                            <h1 class="heroTitleDishes">¡PLATILLOS!</h1>
                        </div>
                    </div>
                    <div class="dishesGroup">
                        <div class="flexRowLayout2">
                            <div class="dishGroup1">
                                <div class="rectangleBlock"></div>
                                <img class="dishImage1" src="{{ asset('assets/e272d6b9253ea44650a1b73658c6a0a1.png') }}" alt="alt text">
                                <div class="flexColumnLayout2">
                                    <h2 class="mediumTitleDish">Lasaña - 150 Lps.</h2>
                                    <p class="ingredientsHighlight">Ingredientes:</p>
                                </div>
                            </div>
                            <div class="dishGroup2">
                                <div class="rectangleBlock2"></div>
                                <img class="dishImage2" src="{{ asset('assets/fcc44eae52bb0a84034c0d2d0a096426.png') }}" alt="alt text">
                            </div>
                            <div class="dishGroup3">
                                <div class="rectangleBlock3"></div>
                                <h2 class="mediumTitleAddDish">Agregar Platillo</h2>
                            </div>
                        </div>
                        <img class="heroImage3" src="{{ asset('assets/c62c8dc1c5e7ae41a08f1a599b06d3c0.svg') }}" alt="alt text">
                    </div>
                </div>
            </div>
        </section>
    </main>
</body>
</html>


