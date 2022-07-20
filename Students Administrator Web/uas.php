<html>

<head>
    <meta charset="utf-8">
    <title>JavaScript Prompt Box by PHP</title>
    <?php
    function  createConfirmationmbox()
    {

        echo '<script type="text/javascript"> ';
        echo 'var inputnilai = prompt("Masukkan Nilai","");';
        echo '</script>';
    }
    ?>
    <?php
    createConfirmationmbox();
    $nakhir = "inputnilai";
    $grade = "D";
    if ($nakhir > 85) {
        echo "A";
    } elseif (85 < $nakhir && $nakhir >= 75) {
        echo "B";
    } elseif (75 < $nakhir && $nakhir > 65) {
        echo "C";
    } else {
        echo "D";
    }
    ?>
</head>

<body>
</body>

</html>


<?php
