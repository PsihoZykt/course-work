<#import "parts/common.ftl" as c>
<#import "parts/mylogin.ftl" as l>

<@c.page>
<link rel="stylesheet"
      href="/static/css/shop.css"/>

    <#if shop??>
    <ol>
        <#list shop as item >

            <li>
                <div class="item">
                    <span class = "name">
                    ${item.productName}
                        </span>
                    <span class = "price"> ${item.productPrice}</span>
                    <span class = "amount"> ${item.amount}</span>
                </div>
            </li>
        </#list>
    </ol>
    </#if>
</@c.page>