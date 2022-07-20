<?php
//memanggil file pustaka fungsi
require "fungsi.php";

//memindahkan data kiriman dari form ke var biasa
$iduser = $_GET["kode"];

//membuat query hapus data
$sql = "delete from user where iduser=$iduser";
mysqli_query($koneksi, $sql);
header("location:updateUser.php");
