<#macro search path>
<form action="${path}" method="post">
    <div><label> User Name : <input type="text" name="username"/> </label></div>
    <#--<input type="hidden" name="_csrf" value="${_csrf.token}" />-->
    <div><input type="submit" value="Search"/></div>
</form>
</#macro>