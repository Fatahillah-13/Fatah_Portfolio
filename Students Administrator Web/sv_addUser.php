
<?php
include "fungsi.php"; // masukan konekasi DB
// ambil variable
$iduser = $_POST['iduser'];
$username = $_POST['username'];
$password = $_POST['password'];
$status = $_POST['status'];

//enkripsi password
// $password = password_hash($password, PASSWORD_DEFAULT);
$password = md5($password);
//Proses query simpan
$simpan = mysqli_query($koneksi, "insert into user values ('$iduser','$username','$password','$status')");
if ($simpan) {
    echo "Data berhasil disimpan: <a href='addUser.php'> + Tambah data. </a>";
} else {
    echo "Gagal simpan data!";
}
?>