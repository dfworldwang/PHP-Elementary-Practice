<!DOCTYPE html>
<html>
<head>
	<meta charset="BIG5">
</head>
<body>
	<form method="post" action="<?php echo $_SERVER['PHP_SELF']; ?>">
		��l�r��: <input name="str" required><br>
		�M��r��: <input name="search" required><br>
		���N��: <input name="replace"><br>
		<input name="submit" type="submit" value="�e�X"> &nbsp;
		&nbsp; <input name="reset" type="reset" value="�M��">                         					
	</form>
	<?php 
		header('Content-type: text/html; charset=big5');
		if (isset($_POST['str']) && isset($_POST['search']) && 
			isset($_POST['replace'])) {
			$str = $_POST['str'];
			$search = $_POST['search'];
			$replace = $_POST['replace'];

			// �Y $str �M $search �����O�Ŧr��
			// ���N�r�ꪺ���e: string �������r��, �n�ΨӨ��N search ���r��, �Q���N���r��
			if ($str != '' && $search != '') {
				echo "<p>str_replace('$search', '$replace', '$str') " .
					'���浲�G��=&gt;<b>' .
					str_replace($search, $replace, $str) . 
					'</b></p>';			 										
			}   
		}		
	?>				
</body>
</html>
