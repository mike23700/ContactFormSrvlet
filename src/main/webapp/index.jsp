<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<!DOCTYPE html>
<html>
<head>
    <title>Formulaire de contact</title>
    <link rel="stylesheet" href="css/style.css">
</head>
<body>
<h2>Contactez-nous</h2>
<form action="/contact-form/index" method="post">
    Nom : <input type="text" name="nom"><br><br>
    Email : <input type="email" name="email"><br><br>
    Message : <br>
    <textarea name="message" rows="5" cols="30"></textarea><br><br>
    <input type="submit" value="Envoyer">
</form>
</body>
</html>
