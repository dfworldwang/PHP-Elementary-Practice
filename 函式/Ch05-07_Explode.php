<?php
header('Content-type: text/html; charset=big5');

echo ' 分割 71/12/03: ';
// 分割字串: 分割字元, 被分割的字串
$arr = explode('/', '71/12/03');
echo $arr[0] . '年' . $arr[1] . '月' . $arr[2] . '日<br><br>';

echo ' 網址www.yahoo.com.tw中第3個部份是 ' . 
	explode('.', 'www.yahoo.com.tw')[2];
?>	 