
<#import "parts/common.ftl" as c>
<#import "parts/filter.ftl" as f>



<@c.page>
<link rel="stylesheet"
      href="/static/css/rating.css"/>
<script src="/static/js/rating.js"></script>
<div class="rating">
<#if error??> ${error} </#if>
    <@f.search "/rating"/>
<#if users??>
    <#list users as user>
     <p>
            ${user.username} -> ${user.money}
<p>
    </#list>
</#if>

</@c.page>