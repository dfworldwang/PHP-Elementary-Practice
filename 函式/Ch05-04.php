<?php
header('Content-type: text/html; charset=big5');
// �ϰ��ܼ�
$x = 123;
testVar();

function testVar() {
	// isset() �i�����ܼƬO�_�w�g�w�q
	if (isset($x)) 
		echo '$x �w�g�w�q, �ܼƭȬ� ' . $x;
	else
		echo '$x ���w�q';							 																										
}
?>
