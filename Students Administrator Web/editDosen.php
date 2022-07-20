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
    $npp = $_GET['kode'];
    $sql = "select * from dosen where npp='$npp'";
    $qry = mysqli_query($koneksi, $sql);
    $row = mysqli_fetch_assoc($qry);
    ?>
    <div class="utama">
        <h2 class="mb-3 text-center">EDIT DATA DOSEN</h2>
        <div class="row">
            <div class="col-sm-9">
                <form enctype="multipart/form-data" method="post" action="sv_editDosen.php">
                    <div class="form-group">
                        <label for="nim">NPP:</label>
                        <input class="form-control" type="text" name="npp" id="npp" value="<?php echo $row['npp'] ?>" readonly>
                    </div>
                    <div class="form-group">
                        <label for="nama">Nama:</label>
                        <input class="form-control" type="text" name="namadosen" id="nama" value="<?php echo $row['namadosen'] ?>">
                    </div>
                    <div class="form-group">
                        <label for="email">Homebase:</label>
                        <input class="form-control" type="text" name="homebase" id="email" value="<?php echo $row['homebase'] ?>">
                    </div>
                    <div>
                        <button class="btn btn-primary" type="submit" id="submit">Simpan</button>
                    </div>
                    <input type="hidden" name="npp" id="id" value="<?php echo $npp ?>">
                </form>
            </div>
        </div>
    </div>
    <script>
        $('#submit').on('click', function() {
            var npp = $('#npp').val();
            var namadosen = $('#namadosen').val();
            var homebase = $('#homebase').val();
            $.ajax({
                method: "POST",
                url: "sv_editDosen.php",
                data: {
                    npp: npp,
                    namadosen: namadosen,
                    homebase: homebase,
                }
            });
        });
    </script>
</body>

</html>