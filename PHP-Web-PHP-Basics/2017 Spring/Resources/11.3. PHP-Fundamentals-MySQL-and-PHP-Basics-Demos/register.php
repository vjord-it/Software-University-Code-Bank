<?php
require_once 'app.php';

if (isset($_POST['register'])) {
    $birthday = new DateTime($_POST['birthday']);
    $interval = $birthday->diff(new DateTime('now'));
    if ($interval->y < 18) {
        throw new Exception("Underaged not allowed");
    }
    if ($_POST['password'] != $_POST['confirm']) {
        throw new Exception("Password mismatch");
    }
    $_POST['password'] = password_hash($_POST['password'], PASSWORD_BCRYPT);
    $dataForDb = $_POST;
    unset($dataForDb['register']);
    unset($dataForDb['confirm']);
    $avatarInfo = $_FILES['avatar'];
    $dataForDb['avatar'] = null;
    if (!empty($avatarInfo['name'])) {
        $fileName = $avatarInfo['name'];
        if ($avatarInfo['type'] != 'image/png') {
            throw new Exception("Not supported file format");
        }
        if ($avatarInfo['size'] > 3500000) {
            throw new Exception("File too big!");
        }
        $path = 'avatars/' . uniqid() . '_' . $fileName;
        $result = move_uploaded_file(
            $avatarInfo['tmp_name'],
            $path
        );
        $dir = basename(__DIR__);
        if ($result !== false) {
            $dataForDb['avatar'] =
                '/' . $dir . '/' . $path;
        }
    }

    $query = "INSERT INTO people (
   first_name,
   last_name,
   nickname,
   email,
   phone,
   password,
   gender_id,
   born_on,
   sexual_orientation_id,
   country_id,
   city_id,
   description,
   picture
) VALUES (
   ?,
   ?,
   ?,
   ?,
   ?,
   ?,
   ?,
   ?,
   ?,
   ?,
   ?,
   ?,
   ?
);";
    $dataForDb = array_values($dataForDb);
    $stmt = $db->prepare($query);
    $result = "";
    if ($stmt->execute($dataForDb)) {
        $result = "Success";
    } else {
        $result = "Error :(";
    }
}

$stmt = $db->prepare("SELECT id, name FROM genders ORDER BY name");
$stmt->execute();
$genders = $stmt->fetchAll(PDO::FETCH_ASSOC);

$stmt = $db->prepare("SELECT id, name FROM cities ORDER BY name");
$stmt->execute();
$cities = $stmt->fetchAll(PDO::FETCH_ASSOC);

$stmt = $db->prepare("SELECT id, name FROM countries ORDER BY name");
$stmt->execute();
$countries = $stmt->fetchAll(PDO::FETCH_ASSOC);

$stmt = $db->prepare("SELECT id, name FROM sexual_orientations ORDER BY id");
$stmt->execute();
$orientations = $stmt->fetchAll(PDO::FETCH_ASSOC);

include 'register_frontend.php';