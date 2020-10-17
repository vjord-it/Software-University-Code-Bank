<?php
$key = intval($_GET['key']);
$string = $_GET['string'];
$small = [];
$capital = [];
for ($i = "a"; $i < "z"; ++$i) {
    $small[] = $i;
}
$small[] = "z";
for ($i = "A"; $i < "Z"; ++$i) {
    $capital[] = $i;
}
$capital[] = "Z";
$result = "";
for ($i = 0; $i < strlen($string); ++$i) {
    if (preg_match("/[a-z]/", $string[$i])) {
        $index = array_search($string[$i], $small);
        $index += $key;
        $index %= 26;
        $result .= $small[$index];
    } elseif (preg_match("/[A-Z]/", $string[$i])) {
        $index = array_search($string[$i], $capital);
        $index += $key;
        $index %= 26;
        $result .= $capital[$index];
    } else {
        $result .= $string[$i];
    }

}
echo $result;