<#import "parts/common.ftl" as c>
<#import "parts/mylogin.ftl" as l>
<link rel="stylesheet"
      href="/static/css/schedule.css"/>
<@c.page>
    <#if battles??>
    <ol>
        <#list battles as battle >

            <li>
                <div class="battle">
                    <span class = pokemonName1>
            ${battle.pokemonName1}
                        </span>
                    <span class = "time"> ${battle.date}</span>
                    <span class = "pokemonName2"> ${battle.pokemonName2}</span>
                </div>
            </li>
        </#list>
    </ol>
    </#if>
</@c.page>