<?php
header('Content-type: text/html; charset=big5');

$x = 123;
testVar();
// 办跑计
function testVar() {
	global $x;		//  $x 办跑计

	if (isset($x))
		echo '$x 竒﹚竡, 跑计 ' . $x;
	else 
		echo '$x ゼ﹚竡 ';						 													
}
?>
