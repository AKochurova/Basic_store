<#import "base.ftl" as b>

<@b.page>

<div class="form-group mt-3">
        <form method="post" enctype="multipart/form-data">
            <div class="form-group">
                <input type="text"
                    name="type" placeholder="Введите сообщение" />

            </div>

            <div class="form-group">
                            <input type="text"
                                name="price" placeholder="Введите цену" />
                        </div>

            <div class="form-group">
                <div class="custom-file">
                    <input type="file" name="file" id="customFile" />
                    <label class="custom-file-label" for="customFile">Choose file</label>
                </div>
            </div>
            <input type="hidden" name="_csrf" value="${_csrf.token}" />

            <div class="form-group">
                <button type="submit" class="btn btn-primary">Save message</button>
            </div>
        </form>
    </div>

</@b.page>