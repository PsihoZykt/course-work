<#-- @ftlvariable name="user" type="usualstudent.coursework.database.entity.Users" -->
<#import "parts/common.ftl" as c>
<link rel="stylesheet"
      href="/static/css/login.css"/>
<@c.page>
<div class="loginbox">
    <h1>Profile</h1>
    <form method="post">
        <p>  ${message?ifExists} </p>
        <p>Username: ${user.getUsername()!''}</p>
        <p>Email: ${user.getEmail()!''}</p>
        <p>Favourite Pokemon : ${user.getFavouritePokemon()!''}</p>
        <p> Money: ${user.getMoney()!''}</p>
        <p> Bet Amount: ${user.getBetAmount()!''}</p>
        <p>Winrate : ${user.getBetWinProcent()!''}</p>
        <p>Gender :${user.getGender()!''}</p>
        <p>Birth Date : ${user.getBirthDate()!''}</p>
        <p>Rating :${user.getRating()!''}</p>
        <p> Registraton Date: ${user.getRegistrationDate()!''}</p>
    </form>
    <div class="exitFromAccount">
        <form action="/logout">
            <button type="submit">Выйти с профиля</button>
        </form> <form action="/logout">
        <button type="submit">Изменить пароль</button>
    </form>
    </div>
</@c.page>