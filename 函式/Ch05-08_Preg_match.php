<?php
header('Content-type: text/html; charset=big5');
// ���r��: �ΨӤ�諸�W�h�B�⦡, �n��諸�r��
// �ˬd�q�ܸ��X���榡��: 2 �ӼƦr + 1 �� "-" �Ÿ� + 8 �ӼƦr
if (!preg_match('/^[0-9]{2}-[0-9]{8}$/', $_POST['telephone']))
	echo '�q�ܸ��X���榡���~<br>';

// �����Ҧr�����榡��: 1 �� A-Z �������^��r (�����j�p�g) + 
// 1 �ӼƦr 1 �� 2 + 8 �ӼƦr
if (!preg_match('/^[A-Za-z][1-2]\d{8}$/', $_POST['id_no']))
	echo '�����Ҧr�����榡���~';
?>
 																				    