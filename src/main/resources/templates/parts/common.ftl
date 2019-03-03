

<#macro page>
    <#import "mylogin.ftl" as l>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Sweater</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
    <link rel="stylesheet"
          href="/static/css/main.css" />
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js"></script>

    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">

</head>

<body>
<header>
     <img src="../../static/img/logo400x100.png">
    <#if user??>
        <span class="profile">    <@l.logout /> </span>
        <span class="profile"> <a href="/user/profile"> Hello, ${user.username}  !</span>


    <#else>
        <span class="profile"> <a href="/login"> Войти \ зарегистрироваться </a></span>
    </#if>

</header>
<nav class="nav">
    <ul>
        <li> <a href="/login"> Log in</a></li>
        <li> <a href="/"> Home </a></li>
        <li> <a href="/shop">  Shop </a></li>
        <li> <a href="/rating">Rating </a></li>
        <li> <a href="/schedule"> Schedule </a></li>
        <li> <a href="/about">  about </a></li>



    </ul>

</nav>


    <#nested>


</body>
</html>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>


</script>
</#macro>