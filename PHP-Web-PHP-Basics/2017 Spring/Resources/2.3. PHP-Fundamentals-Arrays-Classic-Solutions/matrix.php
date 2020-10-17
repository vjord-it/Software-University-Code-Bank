<form method="get">
	<input type="text" name="elements" />
	<input type="submit" />
</form>
<?php
if (isset($_GET['elements'])) {
	// Fill the matrix with elements v.1
	/*$input = explode(" ", $_GET['elements']);
	$cols = 5;
	$index_count = 0;
	$input_count = count($input);
	$rows = ceil($input_count / $cols);
	for ($r = 0; $r < $rows; ++$r) {
		$matrix[$r] = [];
		for ($c = 0; $c < $cols; ++$c) {
			if ($index_count < $input_count) {
				$matrix[$r][$c] = $input[$index_count++];
			} else {
				break 2;
			}
			
		}
	}*/
	
	// Fill the matrix with elements v.2
	$input = explode(" ", $_GET['elements']);
	$cols = 4;
	$input_count = count($input);
	$rows = ceil($input_count / $cols);
	for ($r = 0; $r < $rows; ++$r) {
		$matrix[$r] = [];
		$offset = $r * $cols;
		for ($c = 0; $c < $cols; ++$c) {
			$position = $offset + $c;
			if ($position < $input_count) {
				$matrix[$r][$c] = $input[$position];
			} else {
				break 2;
			}
			
		}
	}
	
	echo "<pre>";
	print_r($matrix);
	echo "</pre>";
	// Find biggest and smallest number
	$biggestNum = $matrix[0][0];
	$smallestNum = $matrix[0][0];
	foreach ($matrix as $row) {
		foreach ($row as $column) {
			if ($column > $biggestNum) {
			   $biggestNum = $column;
			}
			if ($column < $smallestNum) {
			   $smallestNum = $column;
			}
		}
	}
	echo $biggestNum . " ";
	echo $smallestNum;
}
?>

