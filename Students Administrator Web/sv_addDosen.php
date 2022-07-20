
<?php
include "fungsi.php"; // masukan konekasi DB
// ambil variable
$npp = $_POST['npp'];
$namadosen = $_POST['namadosen'];
$homebase = $_POST['homebase'];

$sql = "insert dosen values('$npp','$namadosen','$homebase')";
mysqli_query($koneksi, $sql);
header("location:addDosen.php");

//Proses query simpan
// $simpan=mysqli_query($koneksi,"insert into mhscontoh (npp,namadosen,homebase) values ('$npp','$namadosen','$homebase')");
// if($simpan){
//     echo "Data berhasil disimpan: <a href='addMhs.php'> + Tambah data. </a>";
// }else{
//     echo "Gagal simpan data!";
// }
?>