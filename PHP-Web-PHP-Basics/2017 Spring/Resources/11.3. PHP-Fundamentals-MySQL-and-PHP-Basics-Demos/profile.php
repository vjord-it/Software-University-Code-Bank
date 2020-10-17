<?php
require_once 'app.php';
if (!isset($_SESSION['user_id'])) {
    header("Location: login.php");
    exit;
    throw new Exception("This page is restricted to logged in users");
}

$query = "SELECT first_name, last_name, picture FROM people
WHERE id = ?";
$stmt = $db->prepare($query);
$stmt->execute(
    [
        $_SESSION['user_id']
    ]
);
$currentUser = $stmt->fetch(PDO::FETCH_ASSOC);

include 'profile_frontend.php';