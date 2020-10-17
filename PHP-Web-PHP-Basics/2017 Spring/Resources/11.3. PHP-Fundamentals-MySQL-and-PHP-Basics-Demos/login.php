<?php
require_once 'app.php';

if (isset($_POST['login'])) {
    $username = $_POST['nickname'];
    $password = $_POST['password'];
    $query = "SELECT
   id,
   password
FROM
   people
WHERE
   nickname = ?";
    $stmt = $db->prepare($query);
    $stmt->execute(
        [
            $username
        ]
    );
    $user = $stmt->fetch(PDO::FETCH_ASSOC);
    if (!$user) {
        throw new Exception("No such nickname");
    }

    $passwordHash = $user['password'];
    if (password_verify($password, $passwordHash)) {
        $_SESSION['user_id'] = $user['id'];
        header("Location: profile.php");
        exit;
    }

    throw new Exception("Password mismatch!");
}
include 'login_frontend.php';