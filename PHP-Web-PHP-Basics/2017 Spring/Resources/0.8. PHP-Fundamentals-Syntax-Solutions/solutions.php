<?php
//Ex 4
$timezone = new DateTimeZone('Europe/Sofia');
$begin = new DateTime('first day of this month', $timezone);
$end = new DateTime('last day of this month', $timezone);

while ($begin <= $end) {
	if ($begin->format('D') == 'Sun') {
		echo $begin->format('jS F,Y') . "<br>";
		$begin->modify('+7 day');
	} else {
		$begin->modify('+1 day');
	}
}

//Ex5
$num = 600;

if ($num < 100) {
	echo 'Number is not valid' . "\n";
} else {
	$limit = $num < 1000 ? $num : 1000;
	for ($i = 100; $i < $limit; $i++) {
		/*$ones = $i % 10;
		$tens = floor($i % 100 / 10);
		$hundreds = floor($i % 1000 / 100);*/
		$string = (string)$i;
		$ones = $string[0];
		$tens = $string[1];
		$hundreds = $string[2];
		
		if ($ones != $tens && $ones != $hundreds && $hundreds != $tens) {
			echo $i . " ";
		}
	}
}