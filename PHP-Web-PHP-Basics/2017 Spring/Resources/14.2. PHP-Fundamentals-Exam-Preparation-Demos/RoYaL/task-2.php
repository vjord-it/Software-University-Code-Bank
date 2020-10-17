<?php
$today = new DateTime(str_replace('/', '-', $_GET['today']));
$list = $_GET['invoices'];
$table = [];
foreach ($list as $line) {
    $line = trim($line, '"');
    $line = trim($line);
    $tokens = explode("|", $line);
    $date = new DateTime(str_replace('/', '-', trim($tokens[0])));
    $diff = $today->diff($date)->format('%y');
    if ($diff > 5 || $diff < 0 || $today < $date) {
        continue;
    }
    $now = new DateTime($date->format('d') . '-' . $date->format('m') . '-' . $today->format('Y'));
    if ($diff == 5 && $now < $today) {
        continue;
    }
    $pharmacy = trim($tokens[1]);
    $drug = trim($tokens[2]);
    $price = floatval($tokens[3]);
    $table[$date->format('d-m-Y')][$pharmacy]['drugs'][] = $drug;
    $table[$date->format('d-m-Y')][$pharmacy]['price'] =
        isset($table[$date->format('d-m-Y')][$pharmacy]['price'])
            ? $table[$date->format('d-m-Y')][$pharmacy]['price'] + $price
            : $price;
}

uksort($table, function ($k1, $k2) {
    $d1 = new DateTime($k1);
    $d2 = new DateTime($k2);
    return $d1 > $d2;
});

echo "<ul>";
foreach ($table as $date => $info) {
    $date = str_replace("-", "/", $date);
    echo "<li><p>$date</p>";
    uksort($info, function($a,$b){return strcmp($a,$b);});
    foreach ($info as $pharmacy => $data) {
        sort($data['drugs']);
        $drugs = implode(",", $data['drugs']);
        $price = $data['price'];
        echo "<ul><li><p>$pharmacy</p><ul><li><p>{$drugs}-{$price}lv</p></li></ul></li></ul>";
    }
    echo "</li>";
}
echo "</ul>";