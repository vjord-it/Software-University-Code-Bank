<?php

$users = [
    1 => [
        'username' => 'pesho',
        'password' => '123'
    ],
    2 => [
        'username' => 'gosho',
        'password' => '321'
    ]
];

$id = $_GET['id'];
$user = $users[$id];
$user['username'] =
    isset($_POST['username'])
        ? $_POST['username']
        : $user['username'];

$user['password'] =
    isset($_POST['password'])
        ? $_POST['password']
        : $user['password'];

$users[$id] = $user;

var_dump($users);

?>
<a href="/another-forms/register.php">Go to register</a>
