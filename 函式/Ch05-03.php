<?php
header('Content-type: text/html; charset=big5');
// �ǧ}�I�s
function square(&$x) {		// �Ѽƫe�[ &
	$x *= $x;		// �p�⥭��
	echo '�禡���� $x = ' . $x;			
}

$x = 9;			// �禡�~�� x

square($x);

echo '<br>�禡�~�� $x = ' . $x;
?>
