<#-- @ftlvariable name="user" type="usualstudent.coursework.database.entity.Users" -->
<#import "parts/common.ftl" as c>
<#import "parts/login.ftl" as l>

<@c.page>
Login page
    <@l.login "/login" />
<#if user??>
    ${user}
<#else>
No user
</#if>
<a href="/registration">Add new user</a>
</@c.page>