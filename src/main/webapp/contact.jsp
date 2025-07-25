<%@ page pageEncoding="UTF-8" contentType="text/html;charset=UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Formulaire de Contact</title>
    <link rel="stylesheet" href="css/style.css">
</head>
<body>
    <h2>Contactez-nous</h2>
    <form action="contact" method="post">
        Nom : <input type="text" name="nom"><br>
        Email : <input type="email" name="email"><br>
        Message : <textarea name="message"></textarea><br>
        <button type="submit">Envoyer</button>
    </form>
</body>
</html>
