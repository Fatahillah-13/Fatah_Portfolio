import java.awt.*;
import java.awt.event.*;
import java.io.*;
import javax.swing.*;
import java.sql.*;

public class FLogin06454 extends JFrame implements ActionListener, FocusListener {
    private JPanel pPgw = new JPanel();
    private JLabel lNip = new JLabel ("N I P "),
    lNama = new JLabel ("Nama "),
    lPassword = new JLabel ("Password "),
    lcreate = new JLabel ("nama");

    private JTextField fNip = new JTextField (),

    fNama = new JTextField ();

    private TextField fPassword = new TextField ();
    private JButton btnOk = new JButton (),

    btnBatal = new JButton ();

    public FLogin06454() {
    setPreferredSize(new Dimension(350,230));
    setTitle("LOGIN");
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    JDesktopPane dLogin = new JDesktopPane();

    /* Mengatur letak objek Label Di container*/
    lNip.setBounds (15, 20, 100, 25);
    lNama.setBounds (15, 55, 100, 25);
    lPassword.setBounds (15, 90, 100, 25);

    /* Mengatur letak objek Text Di Container */
    fNip.setBounds (110, 20, 100, 25);
    fNama.setBounds (110, 55, 205, 25);
    fPassword.setBounds (110, 90, 92, 25);
    fPassword.setEchoChar('ò');
    fNip.setToolTipText("Isi Nip dengan Angka !");

    /* Mengatur letak objek Button di Container */
    btnOk.setBounds (130, 140, 85, 25);
    btnOk.setLabel("Ok");
    btnBatal.setBounds (230, 140, 85, 25);
    btnBatal.setLabel("Batal");
    btnBatal.setToolTipText("Mengakhiri Program");

    // Mengatur objek untuk dapat berinteraksi
    fNip.addFocusListener (this);
    btnOk.addActionListener (this);
    btnBatal.addActionListener (this);

    // Meletakkan seluruh kontrol pada objek panel */
    dLogin.add (lNip);

    dLogin.add (fNip);
    dLogin.add (lNama);
    dLogin.add (fNama);
    dLogin.add (lPassword);
    dLogin.add (fPassword);
    dLogin.add (btnOk);
    dLogin.add (btnBatal);

    /* Menambahkan objek panel (pPgr) ke container frame */
    getContentPane().add (dLogin).setBackground(Color.getHSBColor(180,100,200));

    /* Menampilkan frame ke layar monitor */
    pack();
    setLocationRelativeTo(null);
    Kosong();
    }

    public static void main(String[] args) {
        new FLogin06454().setVisible(true);
    }

    /* Fungsi untuk memeriksa kursor saat meninggalkan objek txtKode_Barang */
    public void focusGained (FocusEvent fe) { }
    public void focusLost (FocusEvent fe) {
        if (fNip.getText().equals ("")) { }
        else {
            int xcari = Cari();
            if (xcari == 1) {
                fPassword.requestFocus();
            }

            else {
            btnBatal.requestFocus();
            }
        }
    }

    /* Fungsi jika user melakukan action penekanan tombol Button */
    public void actionPerformed (ActionEvent ae) {
        Object obj = ae.getSource();
        if (obj == btnOk) {
            int xcari = CariPassword();
            if (xcari == 1)
            {
                this.dispose();
                FMenu06454 xmenu = new FMenu06454();
                xmenu.setVisible(true);
            }
        }
        
        if (obj == btnBatal)
        {
            System.exit(0);
        }
    }

    // Fungsi untuk mencari Kode_Barang ke tabel barang
    int Cari(){
    int x = 0;
    try {
    KoneksiDBMS CnPenjualan = new KoneksiDBMS();

    Connection con = CnPenjualan.BukaCn();
    Statement stat = con.createStatement();
    String strsql = "SELECT * FROM pegawai6454 WHERE nip ='" + fNip.getText
    () + "'";
    ResultSet rs = stat.executeQuery(strsql);

    if(rs.next())
    {
        fNama.setText (rs.getString ("nama"));
        x = 1;
    }
    else {
        // Jika Nip tidak ditemukan
        fNip.setText("");
        JOptionPane.showMessageDialog(this, "Data tidak ditemukan !");
        fNip.requestFocus ();
    }
    rs.close();
    con.close();

    }
    catch(SQLException e)
    {
        JOptionPane.showMessageDialog(this, "Data kosong !");
    }
    return x;
    }

    // Fungsi untuk mencari Kode_Barang ke tabel barang
    int CariPassword(){
    int x = 0;
    try {
        KoneksiDBMS CnPenjualan = new KoneksiDBMS();
        Connection con = CnPenjualan.BukaCn();
        Statement stat = con.createStatement();
        String strsql = "SELECT * FROM pegawai6454 WHERE nip ='" + fNip.getText
        () + "' and password ='" + fPassword.getText () + "'";
        ResultSet rs = stat.executeQuery(strsql);

        if(rs.next())
        {
            fNama.setText (rs.getString ("nama"));
            x = 1;
        }
        else
        {
            fPassword.setText("");
            fPassword.requestFocus();
            JOptionPane.showMessageDialog(this,"Password Salah !");
        }
        rs.close();
        con.close();
    }
        catch(SQLException e)
    { }
    return x;
    }

    // Fungsi untuk mengkosongkan Objek masukan
    void Kosong ()
    {
        fNip.setText ("");
        fNama.setText ("");
        fPassword.setText ("");
        fNip.requestFocus ();
    }
}