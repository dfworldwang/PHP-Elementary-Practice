<?php
header('Content-type: text/html; charset=big5');

echo ' ���� 71/12/03: ';
// ���Φr��: ���Φr��, �Q���Ϊ��r��
$arr = explode('/', '71/12/03');
echo $arr[0] . '�~' . $arr[1] . '��' . $arr[2] . '��<br><br>';

echo ' ���}www.yahoo.com.tw����3�ӳ����O ' . 
	explode('.', 'www.yahoo.com.tw')[2];
?>	 