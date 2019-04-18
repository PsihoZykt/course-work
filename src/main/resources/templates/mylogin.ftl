<#-- @ftlvariable name="user" type="usualstudent.coursework.database.entity.Users" -->

<#import "parts/common.ftl" as c>
<#import "parts/mylogin.ftl" as l>

<@c.page>

<div class="login">

    <@l.login "/mylogin" />
</div>
</@c.page>





<#--<#if user??>-->
<#--${user.username}-->
<#--<#else>-->
<#--No user-->
<#--</#if>