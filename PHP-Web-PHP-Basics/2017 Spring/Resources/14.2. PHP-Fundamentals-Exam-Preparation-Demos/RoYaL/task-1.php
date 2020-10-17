<?php
$list = explode(", ", $_GET['list']);
$parts = [
    'CPU' => [0,85],
    'ROM' => [0,45],
    'RAM' => [0,35],
    'VIA' => [0,45]
];
$bought = [];
$computers = 0;
$expenses = 0;
$income = 0;
foreach ($list as $part) {
    if (!array_key_exists($part, $parts)) {
        continue;
    }
    $parts[$part][0]++;
    $bought[$part] = isset($bought[$part]) ? $bought[$part]+1 : 1;
    if (count($bought) == count($parts)) {
        foreach(array_keys($parts) as $partName) {
            $bought[$partName]--;
            if ($bought[$partName] == 0) {
                unset($bought[$partName]);
            }
        }
        $computers++;
    }
}
foreach ($parts as $part) {
    $modifier = $part[0] >= 5 ? 0.5 : 1;
    $expenses += $part[0] * $part[1] * $modifier;
}
$income = ($computers * 420) - $expenses;
foreach ($bought as $partName => $boughtValue) {
    $income += ($parts[$partName][1]/2) * $boughtValue;
}
$partsLeft = array_sum($bought);
$did = $income > 0 ? 'gained' : 'lost';
echo "<ul><li>$computers computers assembled</li><li>$partsLeft parts left</li></ul><p>Nakov $did $income leva</p>";