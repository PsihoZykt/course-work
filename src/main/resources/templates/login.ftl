<#-- @ftlvariable name="user" type="usualstudent.coursework.database.entity.Users" -->

<#import "parts/common.ftl" as c>
<#import "parts/login.ftl" as l>

<@c.page>

<div class="login">

    <@l.login "/login" />
</div>
</@c.page>





<#--<#if user??>-->
<#--${user.username}-->
<#--<#else>-->
<#--No user-->
<#--</#if>