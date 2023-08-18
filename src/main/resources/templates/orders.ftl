<#import "base.ftl" as b>
<@b.page>
<h1 align="center">Заказы</h1>

<div class="card-columns" id="message-list">

    <#if messages??>
    <#list messages as me>


        <div class="card my-3" data-id="${me.id}">

            <div class="m-2">

                <i>${me.type} ${me.price}
                <form method="post" action="orders/${me.id}">
                    <input type="hidden" name="_csrf" value="${_csrf.token}" />
                    <button type="submit" class="btn btn-primary">Отправить</button>
                </form>
                </i>
            </div>



    </#list>
    </#if>


<form method="POST" <#if messages??>action="orders/send/${total}"</#if>>
    <div align="center">
    <#if messages??>
        ${total}
    </#if>
        <input type="hidden" name="_csrf" value="${_csrf.token}" />
        <button type="submit" class="btn btn-primary">Отправить</button>
    </div>
</form>
</@b.page>