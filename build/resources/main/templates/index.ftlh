[#ftl]
[#import './_imports/common.ftlh' as c]
[@c.page]
    <h1 class="d-flex justify-content-center">The Pub</h1>
    [#list listOfUsers]
        [#items as user]
            <div class="user d-flex justify-content-center">
                <div class="name d-flex flex-column justify-content-start">
                    <h5>Customer name: ${user.name} </h5>
                    <p>Customer credit: ${user.wallet} </p>
                    <p>[#if user.adult] <span class="text-success">Customer can drink alcohol. </span>
                [#else]<span class="text-danger">Customer cannot drink alcohol.</span>
                    [/#if]</p>
                </div>
            </div>
        [/#items]
    [/#list]
[/@c.page]
