<?php
$boardAll = str_replace([' ','|'], "", $_GET['board']);
$board = $boardAll[13] . $boardAll[12] . $boardAll[8] . $boardAll[4] . substr($boardAll, 0, 4) . $boardAll[7] . $boardAll[11] . $boardAll[15] . $boardAll[14];
$beginning = explode(" ", $_GET['beginning']);
$row = $beginning[0];
$col = $beginning[1];
$moves = explode(" ", $_GET['moves']);
$pos = 4 + (($col <= 2) ? (($row-1)*-1)-($col-1) : $row-1+$col-1);
if($row==4&&$col==3) $pos = 11;
$coins = 50;
$i=-1;
$ins = 0;
while($i++<count($moves)) {
    if ($i >= count($moves)) break;
    $move=$moves[$i];
    $pos+=$move;
    $pos%=12;
    $coins += $ins * 20;
    switch($board[$pos]) {
        case 'P':
            $coins-=5;
            break;
        case 'I':
            $ins += $coins >= 100 ? 1 : 0;
            $coins -= $coins >= 100 ? 100 : 10;
            break;
        case 'F':
            $coins += 20;
            break;
        case 'S':
            $i+=2;
            $coins -= $ins * 20;
            break;
        case 'V':
            $coins*=10;
            break;
        case 'N':
            echo "<p>You won! Nakov's force was with you!<p>";
            return;
    }
    if ($coins < 0) {
        echo "<p>You lost! You ran out of money!<p>";
        return;
    }
}
if ($ins == substr_count($board, 'I')) {
    echo "<p>You won! You own the village now! You have $coins coins!<p>";
} else {
    echo "<p>You lost! No more moves! You have $coins coins!<p>";
}