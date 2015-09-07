<?php
header('Content-type: text/html; charset=big5');
// 跋办跑计
$x = 123;
testVar();

function testVar() {
	// isset() 代刚跑计琌竒﹚竡
	if (isset($x)) 
		echo '$x 竒﹚竡, 跑计 ' . $x;
	else
		echo '$x ゼ﹚竡';							 																										
}
?>
