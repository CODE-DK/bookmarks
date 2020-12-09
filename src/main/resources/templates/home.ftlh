<#import "parts/htmlWrapper.ftlh" as h>
<#import "parts/headerWrapper.ftlh" as e>

<@h.html "Home page">
    <@e.header>
        <#if user??>
            <h1>Hello user, ${user}!</h1>
        <#else>
            <h1>Welcome!!</h1>
            <a href="/login">Sing in</a>
            <a href="/register">Create</a>
        </#if>
    </@e.header>
</@h.html>