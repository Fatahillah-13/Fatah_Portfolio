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
    $iduser = $_GET['kode'];
    $sql = "select * from user where iduser='$iduser'";
    $qry = mysqli_query($koneksi, $sql);
    $row = mysqli_fetch_assoc($qry);
    ?>
    <div class="utama">
        <h2 class="mb-3 text-center">EDIT DATA User</h2>
        <div class="row">
            <div class="col-sm-9">
                <form enctype="multipart/form-data" method="post" action="sv_editUser.php">
                    <div class="form-group">
                        <label for="nim">ID:</label>
                        <input class="form-control" type="text" name="iduser" id="iduser" value="<?php echo $row['iduser'] ?>" readonly>
                    </div>
                    <div class="form-group">
                        <label for="nama">Username:</label>
                        <input class="form-control" type="text" name="username" id="username" value="<?php echo $row['username'] ?>">
                    </div>
                    <div class="form-group">
                        <label for="email">Password:</label>
                        <input class="form-control" type="text" name="password" id="password" value="<?php echo $row['password'] ?>" readonly>
                    </div>
                    <div class="form-group">
                        <label for="email">Status:</label>
                        <input class="form-control" type="text" name="status" id="sttaus" value="<?php echo $row['status'] ?>">
                    </div>
                    <div>
                        <button class="btn btn-primary" type="submit" id="submit">Simpan</button>
                    </div>
                    <input type="hidden" name="iduser" id="iduser" value="<?php echo $iduser ?>">
                </form>
            </div>
        </div>
    </div>
    <script>
        $('#submit').on('click', function() {
            var iduser = $('#iduser').val();
            var username = $('#username').val();
            var password = $('#password').val();
            var status = $('#status').val();
            $.ajax({
                method: "POST",
                url: "sv_editUser.php",
                data: {
                    iduser: iduser,
                    username: username,
                    password: password,
                    status: status,
                }
            });
        });
    </script>
</body>

</html>