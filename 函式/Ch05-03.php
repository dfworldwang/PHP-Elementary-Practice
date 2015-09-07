<?php
header('Content-type: text/html; charset=big5');
// 傳址呼叫
function square(&$x) {		// 參數前加 &
	$x *= $x;		// 計算平方
	echo '函式內的 $x = ' . $x;			
}

$x = 9;			// 函式外的 x

square($x);

echo '<br>函式外的 $x = ' . $x;
?>
