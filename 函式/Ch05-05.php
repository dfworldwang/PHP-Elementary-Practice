<?php
header('Content-type: text/html; charset=big5');

$x = 123;
testVar();
// �����ܼ�
function testVar() {
	global $x;		// �ŧi $x �������ܼ�

	if (isset($x))
		echo '$x �w�g�w�q, �ܼƭȬ� ' . $x;
	else 
		echo '$x ���w�q ';						 													
}
?>
