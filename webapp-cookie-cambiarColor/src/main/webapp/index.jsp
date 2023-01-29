<%@page contentType="text/html" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <title>Tarea 4: cambiar el color de los textos utilizando cookies</title>
</head>
<body>
<div class="container-md mt-2">
    <h3 style="color: ${cookie.color.getValue() == null? "black": cookie.color.getValue()}">Tarea 4: cambiar el color de
        los textos</h3>
    <p style="color: ${cookie.color.getValue() == null? "black": cookie.color.getValue()}">Hola este es un texto que
        cambia de color segun las opciones</p>

    <form action="/webapp-cookie-cambiarColor/cambiar-color" method="get">
        <div class="mb-3">
            <label for="color" class="form-label">Cambiar color</label>
            <div class="mb-2 px-2">
                <select class="form-select" aria-label="Default select example" name="color" id="color">
                    <option value="blue">Azul</option>
                    <option value="red">Rojo</option>
                    <option value="green">Verde</option>
                    <option value="aqua">Aqua</option>
                    <option value="BlueViolet">Violeta</option>
                    <option value="Cyan">Cyan</option>
                    <option value="Gray">Gris</option>
                    <option value="Yellow">Amarillo</option>
                    <option value="Black">Negro</option>
                    <option value="Orange">Naranja</option>


                </select>
            </div>

        </div>
        <div class="mb-2 px-2">
            <input type="submit" value="Cambiar" class="btn btn-primary">
        </div>

    </form>
</div>
</body>
</html>
