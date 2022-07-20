<!DOCTYPE html>
<html>

<head>
    <title>Sistem Informasi Akademik::Edit Data Dosen</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" type="text/css" href="bootstrap4/css/bootstrap.css">
    <link rel="stylesheet" type="text/css" href="css/styleku.css">
    <script src="bootstrap4/jquery/3.3.1/jquery-3.3.1.js"></script>
    <script src="bootstrap4/js/bootstrap.js"></script>
</head>

<body>
    <?php
    require "fungsi.php";
    require "head.html";
    $idmatkul = $_GET['kode'];
    $sql = "select * from matkul where idmatkul='$idmatkul'";
    $qry = mysqli_query($koneksi, $sql);
    $row = mysqli_fetch_assoc($qry);
    ?>
    <div class="utama">
        <h2 class="mb-3 text-center">EDIT DATA Matkul</h2>
        <div class="row">
            <div class="col-sm-9">
                <form enctype="multipart/form-data" method="post" action="sv_editMatkul.php">
                    <div class="form-group">
                        <label for="nim">ID Matkul:</label>
                        <input class="form-control" type="text" name="idmatkul" id="idmatkul" value="<?php echo $row['idmatkul'] ?>">
                    </div>
                    <div class="form-group">
                        <label for="nama">Nama Matkul:</label>
                        <input class="form-control" type="text" name="namamatkul" id="namamatkul" value="<?php echo $row['namamatkul'] ?>">
                    </div>
                    <div class="form-group">
                        <label for="email">SKS:</label>
                        <input class="form-control" type="text" name="sks" id="sks" value="<?php echo $row['sks'] ?>">
                    </div>
                    <div class="form-group">
                        <label for="email">Jenis:</label>
                        <input class="form-control" type="text" name="jns" id="jns" value="<?php echo $row['jns'] ?>">
                    </div>
                    <div class="form-group">
                        <label for="email">Semester:</label>
                        <input class="form-control" type="text" name="smt" id="smt" value="<?php echo $row['smt'] ?>">
                    </div>
                    <div>
                        <button class="btn btn-primary" type="submit" id="submit">Simpan</button>
                    </div>
                    <input type="hidden" name="idmatkul" id="id" value="<?php echo $npp ?>">
                </form>
            </div>
        </div>
    </div>
    <script>
        $('#submit').on('click', function() {
            var idmatkul = $('#idmatkul').val();
            var namamatkul = $('#namamatkul').val();
            var sks = $('#sks').val();
            var jns = $('#jns').val();
            var smt = $('#smt').val();
            $.ajax({
                method: "POST",
                url: "sv_editMatkul.php",
                data: {
                    idmatkul: idmatkul,
                    namamatkul: namamatkul,
                    sks: sks,
                    jns: jns,
                    smt: smt,
                }
            });
        });
    </script>
</body>

</html>