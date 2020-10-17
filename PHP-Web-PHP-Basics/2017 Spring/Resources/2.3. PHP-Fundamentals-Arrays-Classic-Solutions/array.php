<form method="get">
	<input type="text" name="elements" />
	<input type="submit" />
</form>
<?php
if (isset($_GET['elements'])) {
	$input = explode(",", $_GET['elements']);
	$elementsCount = count($input);
	for ($i = 0, $end = ceil($elementsCount / 2); $i < $end; ++$i) {
		if ($i !== $elementsCount - 1 - $i) {
			echo $input[$i] . " " . $input[$elementsCount - 1 - $i];
		} else {
			echo $input[$i];
		}

		echo "<br>";
	}
}
?>

