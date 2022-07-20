<?php
//memanggil file pustaka fungsi
require "fungsi.php";

//memindahkan data kiriman dari form ke var biasa
$idmatkul = $_GET["kode"];

//membuat query hapus data
$sql = "delete from matkul where idmatkul=$idmatkul";
mysqli_query($koneksi, $sql);
header("location:updateMatkul.php");
