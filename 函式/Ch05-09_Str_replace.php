<!DOCTYPE html>
<html>
<head>
	<meta charset="BIG5">
</head>
<body>
	<form method="post" action="<?php echo $_SERVER['PHP_SELF']; ?>">
		原始字串: <input name="str" required><br>
		尋找字串: <input name="search" required><br>
		取代為: <input name="replace"><br>
		<input name="submit" type="submit" value="送出"> &nbsp;
		&nbsp; <input name="reset" type="reset" value="清除">                         					
	</form>
	<?php 
		header('Content-type: text/html; charset=big5');
		if (isset($_POST['str']) && isset($_POST['search']) && 
			isset($_POST['replace'])) {
			$str = $_POST['str'];
			$search = $_POST['search'];
			$replace = $_POST['replace'];

			// 若 $str 和 $search 都不是空字串
			// 取代字串的內容: string 的部分字串, 要用來取代 search 的字串, 被取代的字串
			if ($str != '' && $search != '') {
				echo "<p>str_replace('$search', '$replace', '$str') " .
					'執行結果為=&gt;<b>' .
					str_replace($search, $replace, $str) . 
					'</b></p>';			 										
			}   
		}		
	?>				
</body>
</html>
