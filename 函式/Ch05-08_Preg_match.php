<?php
header('Content-type: text/html; charset=big5');
// 比對字串: 用來比對的規則運算式, 要比對的字串
// 檢查電話號碼的格式為: 2 個數字 + 1 個 "-" 符號 + 8 個數字
if (!preg_match('/^[0-9]{2}-[0-9]{8}$/', $_POST['telephone']))
	echo '電話號碼的格式錯誤<br>';

// 身分證字號的格式為: 1 個 A-Z 之間的英文字 (不分大小寫) + 
// 1 個數字 1 或 2 + 8 個數字
if (!preg_match('/^[A-Za-z][1-2]\d{8}$/', $_POST['id_no']))
	echo '身分證字號的格式錯誤';
?>
 																				    