<?php
header('Content-type: text/html; charset=big5');

// �w�q�@�ӥ]�t����Ÿ����r��
$string = "Linux �t������\nYahoo�������q";

echo '<p>���B�z�L���r��:</p>' . $string;
// �B�z����r��
// nl2br: ���B�z���r��
echo '<hr><p>nl2br() �B�z�L���r��:</p>' . nl2br($string);

echo '<br>';

// �A���P�ϱ׽u���B�z
// addslashes: �|�b�r�ꤤ��\ ' "���r���e���A�[�W�@��\
echo addslashes('Just say "WOW"');

echo '<br>';

// stripslashes: �|�N�r�ꤤ�Ҧ��ϱ׽u�R��
echo stripslashes('Taipei \nTaiwan');

// �B�zHTML�S��r��
// htmlspecialchars: ���B�z���r��, ���w�n���N���ǬA��
?>