<#import "parts/htmlWrapper.ftlh" as h>
<#import "parts/headerWrapper.ftlh" as e>

<@h.html "Login page">
    <@e.header>
        <#if error??>
            error
        </#if>
        <div class="container">
            <form method="post" action="/login">
                <div class="form-group">
                    <label for="inputUsername">Username</label>
                    <input name="username" type="text" class="form-control" id="inputUsername" placeholder="${(user.username)!"Type username here..."}">
                </div>
                <div class="form-group">
                    <label for="inputPassword">Password</label>
                    <input name="password" type="password" class="form-control" id="inputPassword" placeholder="${(user.password)!"Type password here..."}">
                </div>
                <div class="form-group">
                    <label class="form-check-label"><input type="checkbox"> Remember me</label>
                </div>
                <button type="submit" class="btn btn-primary">Sign in</button>
                <a href="/register" class="btn btn-primary">Create new</a>
                <input type="hidden" name="_csrf" value="${_csrf.token}"/>
            </form>
        </div>
    </@e.header>
</@h.html>