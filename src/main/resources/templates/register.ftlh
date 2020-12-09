<#import "parts/htmlWrapper.ftlh" as h>
<#import "parts/headerWrapper.ftlh" as e>

<@h.html "Register page">
    <@e.header>
        <div class="container">
            <#if error??>
                <div class="alert alert-danger">
                    <strong>Oops!</strong> ${error}
                </div>
            </#if>
            <form method="post" action="/register">
                <div class="form-group">
                    <label for="inputUsername">Username</label>
                    <input name="username" type="text" class="form-control" id="inputUsername" placeholder="Username">
                </div>
                <div class="form-group">
                    <label for="inputPassword">Password</label>
                    <input name="password" type="password" class="form-control" id="inputPassword" placeholder="Password">
                </div>
                <div class="form-group">
                    <label class="form-check-label"><input type="checkbox"> Remember me</label>
                </div>
                <button type="submit" class="btn btn-primary">Create</button>
                <input type="hidden" name="_csrf" value="${_csrf.token}"/>
            </form>
        </div>
    </@e.header>
</@h.html>