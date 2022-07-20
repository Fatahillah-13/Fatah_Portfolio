
<?php
include "fungsi.php"; // masukan konekasi DB
// ambil variable
$idmatkul = $_POST['idmatkul'];
$namamatkul = $_POST['namamatkul'];
$sks = $_POST["sks"];
$jns = $_POST["jns"];
$smt = $_POST["smt"];

$sql = "insert matkul values('$idmatkul','$namamatkul','$sks','$jns','$smt')";
mysqli_query($koneksi, $sql);
header("location:addMatkul.php");

//Proses query simpan
// $simpan=mysqli_query($koneksi,"insert into mhscontoh (npp,namamatkul,sks) values ('$npp','$namamatkul','$sks')");
// if($simpan){
//     echo "Data berhasil disimpan: <a href='addMhs.php'> + Tambah data. </a>";
// }else{
//     echo "Gagal simpan data!";
// }
?>