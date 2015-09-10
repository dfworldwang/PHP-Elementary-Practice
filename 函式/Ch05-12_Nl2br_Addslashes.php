<?php
header('Content-type: text/html; charset=big5');

// 定義一個包含換行符號的字串
$string = "Linux 系統應用\nYahoo網站公司";

echo '<p>未處理過的字串:</p>' . $string;
// 處理換行字元
// nl2br: 欲處理的字串
echo '<hr><p>nl2br() 處理過的字串:</p>' . nl2br($string);

echo '<br>';

// 括號與反斜線的處理
// addslashes: 會在字串中的\ ' "等字元前面再加上一個\
echo addslashes('Just say "WOW"');

echo '<br>';

// stripslashes: 會將字串中所有反斜線刪除
echo stripslashes('Taipei \nTaiwan');

// 處理HTML特殊字元
// htmlspecialchars: 欲處理的字串, 指定要取代哪些括號
?>