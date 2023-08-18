<#macro page>
<!DOCTYPE html>
<html>
<head>
    <title> Заголовок окна</title>

    <link
            rel="stylesheet"
            href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css"
            integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh"
            crossorigin="anonymous"
    />
    <link
            rel="stylesheet"
            href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css"
            crossorigin="anonymous"
    />
    <title></title>
</head>
<body>
<nav class="navbar navbar-expand-lg bg-light">
    <ul class="navbar-nav">
        <li class="navbar-item"> <a href="/home" class="nav-link">Домашняя страница</a> </li>
        <li class="navbar-item"> <a href="/login" class="nav-link">Вход</a> </li>
        <li class="navbar-item"> <a href="/registration" class="nav-link">Регистрация </a></li>
        <li class="navbar-item"> <a href="/orders" class="nav-link">Заказы</a></li>
        <li class="navbar-item"> <a href="/sells" class="nav-link">Продажа</a></li>
    </ul>
</nav>






<div class="container"><#nested></div>

</body>
<script
        src="https://code.jquery.com/jquery-3.2.1.slim.min.js"
        integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN"
        crossorigin="anonymous"
></script>
<script
        src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"
        integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl"
        crossorigin="anonymous"
></script>
</html>
</#macro>
