<!DOCTYPE html>
<html>
<head>
	<meta charset="BIG5">					
</head>
<body>
	<form method="post" action="<?php echo $_SERVER['PHP_SELF']; ?>">
		�~�Q�v: <input name="rate" required><br>
		�ٴڦ~��: <input name="year" required><br>
		�ɴڪ��B(�U�������): <input name="loan" required><br>
		<input name="submit" type="submit" value="�e�X"> &nbsp;
		&nbsp; <input name="reset" type="reset" value="�M��">							
	</form>							
<?php
	header('Content-type: text/html; charset=big5');
	// �Y 3 ���ܼƳ��s�b, �B��Ȥj�� 0 �~�i��p��
	if ((isset($_POST['loan']) && $_POST['loan'] > 0) && 
		(isset($_POST['rate']) && $_POST['rate'] > 0) &&	
		(isset($_POST['year']) && $_POST['year'] > 0)) {
			
			$month = $_POST['year'] * 12;		// �p���ٴڴ��� (���)
			$rate = $_POST['rate'] / 100 / 12;	// �p���Q�v (�~�Q�v / 12)

		// �� pow() �p�⦸��  	
		// pow: ���, ����	
		$payment = $_POST['loan'] * 10000 * pow(1 + $rate, $month) * $rate / (pow(1+$rate, $month) - 1);
		// �Ǧ^�榡�Ʀr��
		// sprintf: �]�t�Ѽƪ��r��, �U�Ѽƪ���, ......
		echo sprintf(" �C������ <b>%d</b>��", ceil($payment));
	}
?>
</body>
</html>	 								