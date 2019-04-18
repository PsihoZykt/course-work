<#-- @ftlvariable name="userProfile" type="usualstudent.coursework.database.entity.Users" -->
<#import "parts/common.ftl" as c>
<link rel="stylesheet"
      href="/static/css/login.css"/>
<@c.page>
<div class="loginbox">
    <h1>Profile</h1>
    <form method="post">
        <p>  ${message?ifExists} </p>
        <#if userProfile??>
        <p>Username: ${userProfile.getUsername()!''}</p>
        <p>Email: ${userProfile.getEmail()!''}</p>
        <p>Favourite Pokemon : ${userProfile.getFavouritePokemon()!''}</p>
        <p> Money: ${userProfile.getMoney()!''}</p>
        <p> Bet Amount: ${userProfile.getBetAmount()!''}</p>
        <p>Winrate : ${userProfile.getBetWinProcent()!''}</p>
        <p>Gender :${userProfile.getGender()!''}</p>
        <p>Birth Date : ${userProfile.getBirthDate()!''}</p>
        <p>Rating :${userProfile.getRating()!''}</p>
        <p> Registraton Date: ${userProfile.getRegistrationDate()!''}</p>
        </#if>
    <div class="exitFromAccount">
        <form action="/logout">
            <button type="submit">Выйти с профиля</button>
        </form> <form action="/logout">
        <button type="submit">Изменить пароль</button>
    </form>
    </div>
</@c.page>