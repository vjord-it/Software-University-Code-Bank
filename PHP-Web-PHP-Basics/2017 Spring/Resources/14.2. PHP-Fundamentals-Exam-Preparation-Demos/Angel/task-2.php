<?php 
	// $_GET = array (
	// 		  'today' => '27/08/2014',
	// 		  'invoices' => 
	// 		  array (
	// 		    0 => '11/05/2013 | Sopharma | Paracetamol | 20.54lv.',
	// 		    1 => '02/12/2011 | Actavis | Aulin | 120.54lv.',
	// 		    2 => '13/05/2009 | Sopharma | Tamiflu | 221.54lv.',
	// 		    3 => '23/01/2014 | Actavis | Paracetamol | 7.54lv.',
	// 		    4 => '11/05/2013 | Sopharma | Analgin | 20.54lv.',
	// 		  ),
	// 		);

	function replaceDate($date) {
		return str_replace('/', '-', $date);
	}

	$date = replaceDate($_GET['today']);
	$date = new DateTime($date);
	$fiveYearsAgo = new DateTime(replaceDate($_GET['today']));
	$fiveYearsAgo->modify('-5 years');
	$invoices = $_GET['invoices'];

	$result = [];
	$prices = [];

	foreach ($invoices as $invoice) {
		$invoice = explode('|', $invoice);
		$invoice_date = new DateTime(replaceDate(trim($invoice[0])));
		$company = trim($invoice[1]);
		$drug = trim($invoice[2]);
		$price = (double)trim($invoice[3]);

		if ($invoice_date >= $fiveYearsAgo && $invoice_date <= $date) {
			if (!array_key_exists($invoice_date->format('d/m/Y'), $result)) {
				$result[$invoice_date->format('d/m/Y')] = array();
				$prices[$invoice_date->format('d/m/Y')] = array();
			}

			if (!array_key_exists($company, $result[$invoice_date->format('d/m/Y')])) {
				$result[$invoice_date->format('d/m/Y')][$company] = array();
				$prices[$invoice_date->format('d/m/Y')][$company] = 0;
			}

			$result[$invoice_date->format('d/m/Y')][$company][] = $drug;
			$prices[$invoice_date->format('d/m/Y')][$company] += $price;
		}
	}

	uksort($result, function ($d1, $d2) {
		$d1 = new DateTime(replaceDate($d1));
		$d2 = new DateTime(replaceDate($d2));

		return $d1 > $d2;
	});

	echo "<ul>";

	//sort companies
	foreach ($result as $date => $companies) {
		ksort($companies);

		echo "<li>";
		echo "<p>$date</p>";

		//sort drugs
		foreach ($companies as $company => $drugs) {
			echo "<ul>";
			asort($drugs);

			echo "<li>";
				echo "<p>$company</p>";
					echo "<ul><li><p>" . implode(',', $drugs) . "-" . $prices[$date][$company] . "lv</p></li></ul>";
			echo "</li>";
			echo "</ul>";
		}
		echo "</li>";
	}

	echo "</ul>";
?>