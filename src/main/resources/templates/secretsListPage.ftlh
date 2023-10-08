<!DOCTYPE html>
<html>
<head>
    <title>Space Secret</title>
</head>
<body>
<h1>Secrets</h1><hr>
<#list secrets as secret>
    <div>
        <p><b>${secret.name}</b> | <a href="/secret/${secret.id}">Details</a></p>
    </div>
</#list>
<hr>
<form action="/spaceSecret/createSecret" method="get">
    <input type="submit" value="Create new Secret"/>
</form>
</body>
</html>