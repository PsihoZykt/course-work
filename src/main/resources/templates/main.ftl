<#-- @ftlvariable name="user" type="usualstudent.coursework.database.entity.Users" -->
<#import "parts/common.ftl" as c>
<#import "parts/login.ftl" as l>

<@c.page>
Main page
<@l.logout/>
${user.username}
${user.password}
${user.email}
${user.birthDate}
${user.gender}

</@c.page>