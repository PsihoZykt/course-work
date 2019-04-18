<#-- @ftlvariable name="user" type="usualstudent.coursework.database.entity.Users" -->

<#import "parts/common.ftl" as c>
<@c.page>
Ударить дурака банхаммером по голове
<form action="/adminpanel" method="post">
    <input type="text" name="name" value="">

    <input type="hidden" value="${user.id}"  name="userId">
    <#--<input type="hidden" value="${_csrf.token}" name="_csrf">-->
    <button type="submit"> Забанить</button>
</form>
</@c.page>