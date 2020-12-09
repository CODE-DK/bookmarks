<#macro header>
    <nav class="navbar navbar-expand-lg navbar-light bg-light">
        <#if user??>
            <a class="navbar-brand" href="/home">
                <img src="#{static/logo.png}" width="30" height="30" alt="">${(user.username)}
            </a>
        <#else>
            <a class="navbar-brand" href="/login">
                <img src="/static/logo.png" width="30" height="30" alt="">VBookmarks
            </a>
        </#if>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>

        <div class="collapse navbar-collapse" id="navbarSupportedContent">
            <ul class="navbar-nav mr-auto">
                <li class="nav-item">
                    <a class="nav-link" href="/home">Home <span class="sr-only">(current)</span></a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="/profile">Profile</a>
                </li>
                <li class="nav-item dropdown">
                    <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                        Settings
                    </a>
                    <div class="dropdown-menu" aria-labelledby="navbarDropdown">
                        <a class="dropdown-item" href="/bookmarks">Create</a>
                        <a class="dropdown-item" href="/share">Share</a>
                        <div class="dropdown-divider"></div>
                        <a class="dropdown-item" href="/feedback">FAQ</a>
                    </div>
                </li>
            </ul>
            <form class="form-inline my-2 my-lg-0" action="/find" method="post">
                <input class="form-control mr-sm-2" type="search" placeholder="Search" aria-label="Search">
                <button class="btn btn-outline-primary my-2 my-sm-0" type="submit">Find</button>
                <input type="hidden" name="_csrf" value="${_csrf.token}"/>
            </form>
        </div>
    </nav>
    <#nested>
</#macro>