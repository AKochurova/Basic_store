<#import "base.ftl" as b>

<@b.page>


<div class="jumbotron jumbotron-fluid">
    <div class="container">
        <h1 align="center" class="display-3">Заголовок </h1>
        <p class="lead"> текст </p>


    </div>

    <div class="row">
     <div class="col-sm-6 col-lg-4">
            <div class="card" data-id="11">
                <img class="card-img-top" src="https://pilotrus.ru/wa-data/public/shop/products/61/01/161/images/7025/7025.970.jpg" >

                <div class="card-body">
                    <form method="post" action="home/11">
                        <input type="hidden" name="_csrf" value="${_csrf.token}" />
                        <button type="submit" name="товар2" value="ручка" class="btn btn-primary">Отправить</button>
                    </form>
                </div>


            </div>
        </div>


        <div class="col-sm-6 col-lg-4">
            <div class="card" data-id="12">
                <img class="card-img-top" src="https://galamart.ru/images_1000/5QZZRAD.jpg" >

                <div class="card-body">
                    <form method="post" action="home/12"}>
                        <input type="hidden" name="_csrf" value="${_csrf.token}" />
                        <button type="submit" name="товар1" value="ластик" class="btn btn-primary">Отправить</button>
                    </form>
                </div>


            </div>
        </div>


<#if products??>
    <#list products as pr>

<i><div class="col-sm-6 col-lg-4">
            <div class="card" data-id="${pr.id}">
            <#if pr.filename??>
                <img class="card-img-top" src="/Users/macbook/Desktop/Java/basic_store/src/main/resources/img/${pr.filename}" >
            </#if>

                <div class="card-body">
                ${pr.price}
                    <form method="post" action="home/${pr.id}/${pr.price}"}>
                        <input type="hidden" name="_csrf" value="${_csrf.token}" />
                        <button type="submit" name="товар5" value="ластик5" class="btn btn-primary">Отправить</button>
                    </form>
                </div>


             </div>
     </i>  </div>

  </#list>
    </#if>

    </div>
</@b.page>

