<%-- 
    Document   : login
    Created on : 8/05/2019, 17:20:13 AM
    Author     : Alejo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Inicio de Sesión</title>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
        <link rel="stylesheet" href="css/estilos.css">
        <meta charset="utf-8">
    </head>
    <body  style="background-color: #f7cd62;">
        <div class="container">
            <div class="row">
                <div class="col-md-3" > </div>
                <div class="col-md-6" > 
                    <div class="card card-login mx-auto mt-5">
                        <div class="card-header">
                            <center> <p style="color: #4f4d4a; font-family: 'sans-serif'; font-size: 12pt;">INGRESA A TU CUENTA </p> </center>
                            <form action="index.xhtml" method="POST">
                                <div class="card-body">
                                    <input type="hidden" value="<%=request.getParameter("usuario")%>"><!--tipo de usuario que ingresa-->
                                    <p>${pageContext.exception.message}</p>                             
                                    <input type="hidden" name="accion" value="validarUsuario">
                                    <div class="form-group">
                                        <input class="form-control" name="usuario"  type="text"  placeholder="Usuario">
                                    </div>
                                    <div class="form-group">
                                        <input class="form-control" name="password"  type="password" placeholder="Contraseña">
                                    </div>
                                    <input class="btn btn-primary btn-block" type="submit" id="ingresar" name="Submit" value="Iniciar Sesión">
                                    <input class="btn btn-primary btn-block" type="submit" id="ingresar" name="Submit" value="Crear Usuario">
                                </div>
                        </div>
                    </div>
                </div>
                <div class="col-md-3" > </div>
            </div>
        </div>

    </form>
</body>
</html>
