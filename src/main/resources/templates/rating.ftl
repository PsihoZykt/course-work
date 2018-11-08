
<#import "parts/common.ftl" as c>
<#import "parts/filter.ftl" as f>



<@c.page>
<link rel="stylesheet"
      href="/static/css/rating.css"/>
<div class="rating">
<#if error??> ${error} </#if>
    <@f.search "/rating"/>
<#if users??>
<ol>
    <#list users as user >

        <li>${user.username}  --> ${user.rating} pts</li>
    </#list>
</ol>
</#if>

</@c.page>