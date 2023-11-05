<!DOCTYPE html>
<html>
<head>
    <title>Create Secret</title>
</head>
<body>
<form action="/secret/save/${secret.secretSpaceId}/${secret.id}" method="post">
    Secret name: <input type="text" name="name" value="${secret.name}"/><br><br>
    Login: <input type="text" name="login" value="${secret.login}"/><br><br>
    Password: <input type="text" name="password" value="${secret.password}"/><br><br>
    Note: <input type="text" name="note" value="${secret.note}"/><br><br>
    <input type="submit" value="save">
</form>
<form action="/secret/delete/${secret.secretSpaceId}/${secret.id}" method="post">
    <input type="submit" value="delete">
</form>
<hr><h4>Generate password</h4>
<form action="" method="post">
    Use setting 1: <input type="checkbox"/><br><br>
    Use setting 2: <input type="checkbox"/><br><br>
    Use setting 3: <input type="checkbox"/><br><br>
    Use setting 4: <input type="checkbox"/><br><br>
    Use setting 5: <input type="checkbox"/><br><br>
    <input type="submit" value="create password">
</form>
</body>
</html>