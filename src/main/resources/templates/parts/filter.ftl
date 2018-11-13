<#macro search path>
<form action="${path}/" method="post" ">
    <div><label> User Name : <input id="username" type="text" name="username"/> </label></div>
    <input type="hidden" name="_csrf" value="${_csrf.token}" />
    <div><input type="button" value="Search" onclick="loadUser()"/> </div>
    <ol class="userList">

    </ol>
</form>
</#macro>