<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

    <nav class="navbar fixed-top navbar-expand-lg navbar-dark bg-dark rounded">
        <a class="navbar-brand" href="#">BABY_CLOTHES</a>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarsExample09" aria-controls="navbarsExample09" aria-expanded="false" aria-label="Toggle navigation">
          <span class="navbar-toggler-icon"></span>
        </button>

        <div class="collapse navbar-collapse" id="navbarsExample09">
          <ul class="navbar-nav mr-auto">
            <li class="nav-item active">
              <a class="nav-link" href="listarFornecedor.jsp">Fornecedor <span class="sr-only">(current)</span></a>
            </li>
            <li class="nav-item">
              <a class="nav-link" href="listarLote.jsp">Lote</a>
            </li>
            <li class="nav-item">
              <a class="nav-link " href="listarRoupa.jsp">Roupa</a>
            </li>
          </ul>
          <form class="form-inline my-2 my-md-0">
            <input class="form-control" type="text" placeholder="Search" aria-label="Search">
          </form>
          <form method="link" action="logout.jsp" class="form-inline my-2 my-md-0">
    		<input type="submit" class="form-control" value="Logout"/>
		  </form>
        </div>
    </nav>
    
