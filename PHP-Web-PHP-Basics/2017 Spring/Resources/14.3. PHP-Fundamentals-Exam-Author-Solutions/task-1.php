<?php
$words = explode(",",$_GET['rocks']);
$elements = 0;
foreach (range('a','z') as $ch) {
    $found = true;
    foreach ($words as $word) {
        if (strpos($word, $ch) === false) {
            $found = false;
            break;
        }
    }
    if ($found) {
        $elements++;
    }
}
echo $elements;