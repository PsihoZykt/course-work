<#-- @ftlvariable name="user" type="usualstudent.coursework.database.entity.Users" -->

<#import "parts/common.ftl" as c>
<@c.page>
<table>
    <thead>
    <tr>
        <th>Name</th>
        <th> Role</th>
        <th></th>
    </tr>
        <#list users as user>
        <tr>
            <td>
              ${user.username}
              ${user.getBanned()?string("Забанен", "не забанен")}

            </td>
            <td>
                <#list user.roles as role> ${role}<#sep>,  </#list>
            </td>
            <td>
                <a href="user/#{user.id}"> Edit </a>
            </td>
        </tr>
        </#list>

    </thead>
</table>
</@c.page>