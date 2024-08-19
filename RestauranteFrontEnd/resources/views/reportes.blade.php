<!DOCTYPE html>
<html lang="en">
<html>
  <head>
    <meta charset="utf-8" />

    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />

    <link rel="stylesheet" type="text/css" href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css" integrity="sha384-wvfXpqpZZVQGK6TAh5PVlGOfQNHSoD2xbE+QkPxCAFlNEevoEH3Sl0sibVcOQVnN" crossorigin="anonymous" />

    <link rel="stylesheet" href="{{ asset('css/common.css') }}">

    <link rel="stylesheet" href="{{ asset('css/fonts.css') }}">

    <link rel="stylesheet" href="{{ asset('css/reportes.css') }}">

  </head>

  <body class="flex-column">

    <section class="reportes main_section">
      <div class="flex_col">
        <div class="content_box">
          <div class="flex_row">
            <div class="flex_row1">
              <h1 class="hero_title_name">Name</h1>
            </div>
            <h1 class="hero_title_time">07:35</h1>
            <h1 class="hero_title_role">Administrador</h1>
          </div>
        </div>
        <div class="content_box1">
          <div class="flex_col1">
            <div class="flex_row2">
              <div class="flex_col2">
                <h1 class="hero_title_inventory_orders">Ordenes de Inventario</h1>
                <div class="group">
                  <div class="rect2"></div>
                  <h3 class="subtitle_order_count"> {{ $ordenesInventario }}</h3>
                </div>
              </div>
              <div class="flex_col3">
                <h1 class="hero_title_billed_orders">Ordenes Facturadas</h1>
                <div class="group1">
                  <div class="rect3"></div>
                  <h3 class="subtitle_billed_order_count">{{ $ordenesFacturadas }}</h3>
                </div>
              </div>
            </div>
            <div class="flex_row3">
              <div class="flex_col4">
                <h1 class="hero_title_total_sales">Ventas Totales</h1>
                <div class="group1">
                  <div class="rect4"></div>
                  <h3 class="subtitle_total_sales_amount">$ {{ $ventasTotales }}</h3>
                </div>
              </div>
              <div class="flex_col4">
                <h1 class="hero_title_total_profits">Ganancias Totales</h1>
                <div class="group1">
                  <div class="rect4"></div>
                  <h3 class="subtitle_total_profits_amount">$ {{ $gananciasTotales }}</h3>
                </div>
              </div>
            </div>
          </div>
        </div>
        <div class="group2">
          <h1 class="hero_title_logout">Salir</h1>
          <img class="image1" src="/assets/regresar.svg" alt="alt text" />
        </div>
      </div>
    </section>


  </body>

</html>
