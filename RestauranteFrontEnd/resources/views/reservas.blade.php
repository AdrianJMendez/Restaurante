<!DOCTYPE html>
<html>

<head>
    <meta charset="utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
    <link rel="stylesheet" type="text/css" href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css" integrity="sha384-wvfXpqpZZVQGK6TAh5PVlGOfQNHSoD2xbE+QkPxCAFlNEevoEH3Sl0sibVcOQVnN" crossorigin="anonymous" />
    <link rel="stylesheet" href="{{ asset('css/commons.css') }}">
    <link rel="stylesheet" href="{{ asset('css/fonts.css') }}">
    <link rel="stylesheet" href="{{ asset('css/Reservas.css') }}">
    <script>
        function agregarReserva() {
            var nombreCliente = prompt("Ingrese el nombre del cliente:");
            var numeroMesa = prompt("Ingrese el número de la mesa:");

            if (nombreCliente && numeroMesa) {
                var mesa = document.getElementById("mesa" + numeroMesa);
                if (mesa) {
                    mesa.src = "{{ asset('images/reservado.png') }}";
                    alert("Reserva agregada para " + nombreCliente + " en la mesa " + numeroMesa);
                } else {
                    alert("Número de mesa no válido.");
                }
            } else {
                alert("Debe ingresar el nombre del cliente y el número de mesa.");
            }
        }

        function cancelarReserva() {
            var numeroMesa = prompt("Ingrese el número de la mesa para cancelar la reserva:");

            if (numeroMesa) {
                var mesa = document.getElementById("mesa" + numeroMesa);
                if (mesa) {
                    mesa.src = "{{ asset('images/disponible.png') }}";
                    alert("Reserva cancelada para la mesa " + numeroMesa);
                } else {
                    alert("Número de mesa no válido.");
                }
            } else {
                alert("Debe ingresar el número de mesa.");
            }
        }
    </script>
</head>

<body class="flex-column">
    <section class="reserva main_section">
        <div class="flex_col_container">
            <div class="content_group">
                <div class="rect_element"></div>
                <div class="flex_row_container">
                    <div class="hero_image_row">
                        <h1 class="hero_title_text">Name</h1>
                    </div>
                    <h1 class="time_display">07:35</h1>
                    <h1 class="admin_title">Administrador</h1>
                </div>
            </div>
            <div class="secondary_content_group">
                <div class="rect_element_1"></div>
                <div class="image_grid">
                    <div class="grid_item">
                        <img id="mesa1" class="grid_item_image" src="{{ asset('images/disponible.png') }}" alt="Mesa Disponible" />
                        <button class="mesa_button" onclick="agregarReserva()">Mesa 1</button>
                    </div>
                    <div class="grid_item">
                        <img id="mesa2" class="grid_item_image" src="{{ asset('images/disponible.png') }}" alt="Mesa Disponible" />
                        <button class="mesa_button" onclick="agregarReserva()">Mesa 2</button>
                    </div>
                    <div class="grid_item">
                        <img id="mesa3" class="grid_item_image" src="{{ asset('images/disponible.png') }}" alt="Mesa Disponible" />
                        <button class="mesa_button" onclick="agregarReserva()">Mesa 3</button>
                    </div>
                    <div class="grid_item">
                        <img id="mesa4" class="grid_item_image" src="{{ asset('images/disponible.png') }}" alt="Mesa Disponible" />
                        <button class="mesa_button" onclick="agregarReserva()">Mesa 4</button>
                    </div>
                    <div class="grid_item">
                        <img id="mesa5" class="grid_item_image" src="{{ asset('images/disponible.png') }}" alt="Mesa Disponible" />
                        <button class="mesa_button" onclick="agregarReserva()">Mesa 5</button>
                    </div>
                    <div class="grid_item">
                        <img id="mesa6" class="grid_item_image" src="{{ asset('images/disponible.png') }}" alt="Mesa Disponible" />
                        <button class="mesa_button" onclick="agregarReserva()">Mesa 6</button>
                    </div>
                    <div class="grid_item">
                        <img id="mesa7" class="grid_item_image" src="{{ asset('images/disponible.png') }}" alt="Mesa Disponible" />
                        <button class="mesa_button" onclick="agregarReserva()">Mesa 7</button>
                    </div>
                    <div class="grid_item">
                        <img id="mesa8" class="grid_item_image" src="{{ asset('images/disponible.png') }}" alt="Mesa Disponible" />
                        <button class="mesa_button" onclick="agregarReserva()">Mesa 8</button>
                    </div>
                    <div class="grid_item">
                        <img id="mesa9" class="grid_item_image" src="{{ asset('images/disponible.png') }}" alt="Mesa Disponible" />
                        <button class="mesa_button" onclick="agregarReserva()">Mesa 9</button>
                    </div>
                    <div class="grid_item">
                        <img id="mesa10" class="grid_item_image" src="{{ asset('images/disponible.png') }}" alt="Mesa Disponible" />
                        <button class="mesa_button" onclick="agregarReserva()">Mesa 10</button>
                    </div>
                    <div class="grid_item">
                        <img id="mesa11" class="grid_item_image" src="{{ asset('images/disponible.png') }}" alt="Mesa Disponible" />
                        <button class="mesa_button" onclick="agregarReserva()">Mesa 11</button>
                    </div>
                    <div class="grid_item">
                        <img id="mesa12" class="grid_item_image" src="{{ asset('images/disponible.png') }}" alt="Mesa Disponible" />
                        <button class="mesa_button" onclick="agregarReserva()">Mesa 12</button>
                    </div>
                </div>
                <div class="flex_row_section">
                    <div class="flex_col_section_1">
                        <img class="admin_image_1" src="{{ asset('images/entrada.png') }}" alt="Entrada" />
                        <img class="admin_image_2" src="{{ asset('images/registradora.png') }}" alt="Registradora" />
                        <img class="admin_image_3" src="{{ asset('images/cocina.png') }}" alt="Cocina" />
                    </div>
                </div>
                <div class="flex_row_section_2">
                    <img class="admin_image_4" src="{{ asset('images/bano.png') }}" alt="Baño" />
                    <div class="group_with_title">
                    
                    </div>
                </div>
                <div class="flex_row_section_2">
                    <div class="group_with_title">
                        <div class="rect_element_2"></div>
                        <button class="cancel_reservation_button" onclick="cancelarReserva()">Cancelar Reserva</button>
                    </div>
                </div>
            </div>
        </div>
        <div class="return_content_group">
            <button class="return_button">Regresar</button>
            <img class="return_image" src="{{ asset('images/regresar.svg') }}" alt="Regresar" />
        </div>
    </section>
</body>

</html>
