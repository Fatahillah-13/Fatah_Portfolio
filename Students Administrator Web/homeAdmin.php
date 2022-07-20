<?php
// session_start()
?>
<!DOCTYPE html>
<html>

<head>
	<title>Halaman Home Admin</title>
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<link rel="stylesheet" type="text/css" href="bootstrap4/css/bootstrap.css">
	<link rel="stylesheet" type="text/css" href="css/styleku.css">
	<link rel="stylesheet" href="dist/hamburgers.css" rel="stylesheet">
	<script src="bootstrap4/jquery/3.3.1/jquery-3.3.1.js"></script>
	<script src="bootstrap4/js/bootstrap.js"></script>
</head>

<body>
	<?php
	//memanggil file berisi fungsi2 yang sering dipakai
	require "fungsi.php";
	require "head.html";

	//cek logout
	// if (!isset($_SESSION['username'])){
	//	if (!isset['username']){

	//	header("location:index1.php");
	//}
	?>
	<div class="utama" id="main">
		<br><br>
		<h1 class="text-center">Selamat Datang di Halaman Administrator</h1>
		<button class="hamburger hamburger--squeeze is-active" type="button">
			<span class="hamburger-box">
				<span class="hamburger-inner"></span>
			</span>
		</button>
		<!-- h1 class="text-center">Selamat Datang di Halaman Administrator saudara -->

		<?php
		// echo strtoupper($_SESSION['username'])
		?>
		</h1>
	</div>
	<script src="js/scriptHead.js"></script>
</body>

</html>