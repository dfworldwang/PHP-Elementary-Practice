<!DOCTYPE html>
<html>
<head>
	<meta charset="BIG5">					
</head>
<body>
	<form method="post" action="<?php echo $_SERVER['PHP_SELF']; ?>">
		年利率: <input name="rate" required><br>
		還款年限: <input name="year" required><br>
		借款金額(萬元為單位): <input name="loan" required><br>
		<input name="submit" type="submit" value="送出"> &nbsp;
		&nbsp; <input name="reset" type="reset" value="清除">							
	</form>							
<?php
	header('Content-type: text/html; charset=big5');
	// 若 3 個變數都存在, 且其值大於 0 才進行計算
	if ((isset($_POST['loan']) && $_POST['loan'] > 0) && 
		(isset($_POST['rate']) && $_POST['rate'] > 0) &&	
		(isset($_POST['year']) && $_POST['year'] > 0)) {
			
			$month = $_POST['year'] * 12;		// 計算還款期數 (月數)
			$rate = $_POST['rate'] / 100 / 12;	// 計算月利率 (年利率 / 12)

		// 用 pow() 計算次方  	
		// pow: 基數, 指數	
		$payment = $_POST['loan'] * 10000 * pow(1 + $rate, $month) * $rate / (pow(1+$rate, $month) - 1);
		// 傳回格式化字串
		// sprintf: 包含參數的字串, 各參數的值, ......
		echo sprintf(" 每月應還 <b>%d</b>元", ceil($payment));
	}
?>
</body>
</html>	 								