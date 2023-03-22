<%@page contentType="text/html" pageEncoding="UTF-8" import="java.time.format.*"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<jsp:include page="layout/header.jsp" />
<h1>${titulo}</h1>
<p><a href="${pageContext.request.contextPath}/cursos" class="btn btn-light">volver</a></p>
<form action="${pageContext.request.contextPath}/cursos/form" method="post">
    <div class="row mb-2">
        <label for="nombre" class="col-form-label col-sm-2">Nombre</label>
        <div class="col-sm-4">
            <input type="text" name="nombre" id="nombre" value="${curso.nombre}" class="form-control">
        </div>
        <c:if test="${errores != null && errores.containsKey('nombre')}">
            <div style="color:red;">${errores.nombre}</div>
        </c:if>
    </div>
    <div class="row mb-2">
        <label for="profesor" class="col-form-label col-sm-2">Profesor</label>
        <div class="col-sm-4">
            <input type="text" name="instructor" id="profesor" value="${curso.profesor}" class="form-control">
        </div>
        <c:if test="${errores != null && errores.containsKey('profesor')}">
            <div style="color:red;">${errores.profesor}</div>
        </c:if>
    </div>
    <div class="row mb-2">
        <label for="duracion" class="col-form-label col-sm-2">Duracion</label>
        <div class="col-sm-4">
            <input type="text" name="duracion" id="duracion" value="${curso.duracion != null && curso.duracion > 0? curso.duracion: ""}" class="form-control">
        </div>
        <c:if test="${errores != null && errores.containsKey('duracion')}">
            <div style="color:red;">${errores.duracion}</div>
        </c:if>
    </div>
    <div class="row mb-2">
        <label for="descripcion" class="col-form-label col-sm-2">Descripción</label>
        <div class="col-sm-4">
            <textarea name="descripcion" id="descripcion" class="form-control">${curso.descripcion}</textarea>
        </div>
        <c:if test="${errores != null && errores.containsKey('descripcion')}">
            <div style="color:red;">${errores.descripcion}</div>
        </c:if>
    </div>
    <div class="row mb-6">
        <div><input type="submit" value="${curso.id!=null && curso.id>0? "Editar": "Crear"}" class="btn btn-primary"></div>
    </div>
    <input type="hidden" name="id" value="${curso.id}">
</form>
<jsp:include page="layout/footer.jsp" />