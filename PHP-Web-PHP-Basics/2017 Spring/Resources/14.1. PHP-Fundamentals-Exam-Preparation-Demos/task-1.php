<?php
$data = $_GET['data'];
$lines = explode(", ", $data);
$resources = [
    "Gold" => 0,
    "Silver" => 0,
    "Diamonds" => 0
];

foreach ($lines as $line) {
    //mine bobovDol gold 10
    $tokens = explode(" ", $line);
    if (count($tokens) != 4) {
        continue;
    }
    if ($tokens[0] != "mine") {
        continue;
    }

    $tokens[2] = ucfirst(strtolower($tokens[2]));
    if (!array_key_exists($tokens[2], $resources)) {
        continue;
    }

    if ($tokens[3] != intval($tokens[3])) {
        continue;
    }

    $resources[$tokens[2]] += $tokens[3];
}

foreach ($resources as $type => $quantity) {
    echo "<p>*$type: $quantity</p>";
}