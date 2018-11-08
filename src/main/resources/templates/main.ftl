<#-- @ftlvariable name="user" type="usualstudent.coursework.database.entity.Users" -->

<#import "parts/common.ftl" as c>
<#import "parts/login.ftl" as l>
<@c.page>
<div class="mainText">
    <p> ${message?ifExists} </p>
<p >
    Любишь рисковать? <br>
    Считаешь, что лучше всех разбираешься в покемонах? <br>
    Ты сдал 2-ю лабу по программированию с 1 раза на 12 баллов?<br>
    Тогда PokeBet - для тебя!<br>
    Данна платформа предоставляет тебе уникальную возможность делать ставки на не менее уникальные бои покемонов!<br>
    Все, что тебе нужно сделать - это зарегистрироваться на сайте и начать зарабатывать ПиКоины!<br>
    PokeBet - животный азарт и холодный расчет!<br>
</p>
</div>
<div class="textWithImg">
  <p>   <a href="/login"> Начни зарабатывать ПиКоины уже сейчас!</a> </p>


    <img src="../static/img/charmander400x200.png">

</div>
<#--<@l.logout/>-->

<#--<#if user??>-->
<#--User's info-->
<#--<p> ${user.username}</p>-->
<#--<p>${user.password}</p>-->
<#--<p>${user.email}</p>-->
<#--<p>${user.birthDate}</p>-->
<#--<p>${user.gender}</p>-->
    <#--<#list user.roles as role>-->
    <#--<li>${role}</li>-->
    <#--</#list>-->
<#--</#if>-->
</@c.page>