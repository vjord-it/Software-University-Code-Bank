<?php
$from = new DateTime($_GET['dateOne']);
$to = new DateTime($_GET['dateTwo']);
$holidays = explode(PHP_EOL, $_GET['holidays']);
$output = "";
for ($date = $from; $date <= $to; $date = $date->add(new DateInterval("P1D"))) {
    if($date->format("l") == 'Saturday' ||
        $date->format("l") == 'Sunday' ||
        in_array($date->format('d-m-Y'), $holidays))  {
        continue;
    }
    $output .= "<li>".$date->format("d-m-Y")."</li>";
}
if (!$output) {
    echo "<h2>No workdays</h2>";
} else {
    echo "<ol>".$output."</ol>";
}
