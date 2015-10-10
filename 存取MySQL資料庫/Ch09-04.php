<?php
header('Content-Type: text/html; charset=big5');
include("mysql.inc.php");
$perpage = 7;		// �C�����7��

$sql = "SELECT �d���s��, �m�W, �d�� FROM guestbook";
$result = mysqli_query($conn, $sql);

// ���o�d�ߵ��G������
$totalrow = mysqli_num_rows($result);
$totalpage = ceil($totalrow/$perpage);		// �p���`����

while ($arr = mysqli_fetch_array($result))
	$data[] = $arr;							// �N������Ƴ��s��  $data �}�C��

// �ھ� $_GET['page'] �ѼƭȨM�w�q�ĴX���}�l���
// �N�������ܼ� $page �� 1 �_��
if (empty($_GET['page']) || !is_numeric($_GET['page']) 
	|| $_GET['page'] < 1 || $_GET['page'] > $totalpage)
		$page = 1;
else
		$page = $_GET['page'];
?>
<!DOCTYPE html>
<html>
<head>
	<title>������ܸ��</title>
	<meta charset="BIG5">
	<style>
		table { border: 1px solid black; width: 450px;
				text-align: center }
		.grey { background-color: lightgrey }
		.narrow { width: 20% }																	
	</style>												
</head>
<body>
<table>
	<tr>
		<th class="narrow">�d���s��</th>
		<th>�m�W</th>
		<th class="narrow">�d��</th>
	</tr>
<?php 
// �ΰj���X�ثe���������
	for ($i = 0; $i < $perpage; $i++) {
		
		$index = ($page - 1) * $perpage + $i;
		if ($index >= count($data)) break;		// ���޶W�X�d��Y���X�j��
		
		if ($i % 2 == 0) echo '<tr class="grey">';		// ���Ʀ�[�ǩ�
		else echo '<tr>';

		echo "<td>{$data[$index]['�d���s��']}</td>";
		echo "<td>{$data[$index]['�m�W']}</td>";
		echo "<td>{$data[$index]['�d��']}</td>";
		echo '</tr>';
	}
echo '</table>';

// ��X�����������s��
for ($i = 1; $i <= $totalpage; $i++) {
	if ($i != 1) echo "&nbsp;";
	if ($i == $page) echo $i;
	else 
		echo sprintf('<a href="%s?page=%d">%d</a>', 
				$_SERVER['PHP_SELF'], $i, $i);																		
}
?>																						

</body>
</html>																			 																																									
