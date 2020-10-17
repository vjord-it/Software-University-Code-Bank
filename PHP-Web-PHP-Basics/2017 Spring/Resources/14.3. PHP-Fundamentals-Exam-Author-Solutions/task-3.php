<?php
$input = explode(",", $_GET['string']);
$end = [];
$makeUpExams = [];
foreach ($input as $item) {
    $split = explode("-", $item);
    $resultAndExam = explode(":", $split[1]);
    $name = trim($split[0]);
    $result = intval(trim($resultAndExam[1]));
    $exam = trim($resultAndExam[0]);
    
    if ($result > 400) {
        continue;
    }

    if (!array_key_exists($exam, $end)) {
        $end[$exam] = [];
    }

    if (!array_key_exists($name, $end[$exam])) {
        $end[$exam][$name] = [$result, 0];

    } else {
        $end[$exam][$name][1]++;
    }

    if ($result > $end[$exam][$name][0]) {
        $end[$exam][$name][0] = $result;
    }


}
echo "<table>" . PHP_EOL . "<tr><th>Subject</th><th>Name</th><th>Result</th><th>MakeUpExams</th>" . PHP_EOL;

foreach ($end as $exam => $names) {
    ksort($names);
    uasort($names, function ($a, $b) {

        if ($a[0] > $b[0]) {
            return -1;
        }
        if ($a[0] < $b[0]) {
            return 1;
        }
        if ($a[0] == $b[0]) {
            if ($a[1] > $b[1]) {
                return 1;
            }
            if ($a[1] < $b[1]) {
                return -1;
            }
        }
    });
    foreach ($names as $ime => $row) {
        echo "<tr><td>" . $exam . "</td>";
        echo "<td>" . $ime . "</td>";
        echo "<td>" . $row[0] . "</td>";
        echo "<td>" . $row[1] . "</td>";
        echo "</tr>" . PHP_EOL;
    }
}

echo "</table>";