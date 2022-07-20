import java.awt.Graphics;
import java.awt.print.PageFormat;
import java.awt.print.Printable;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import javax.swing.JPanel;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import javax.swing.*;
import java.sql.*;
import javax.swing.table.DefaultTableModel;

public class CetakBarangMin06454 extends JFrame implements ActionListener { 
    private JPanel pBrg = new JPanel();
    private JLabel lMinim = new JLabel ("Stok Minim ");

    private JTextField fKode = new JTextField ();

    private JButton btnAdd = new JButton (),
    btnSelesai = new JButton ();

    private ResultSet rs;
    String[] header = {"Kode","Nama","Harga Beli"};

    DefaultTableModel tabMode1;
    JTable tabel = new JTable();
    JScrollPane skrTabel = new JScrollPane();
    Integer isikanjml = 5;

    public CetakBarangMin06454() {
        setPreferredSize(new Dimension(300,250));
        setTitle("Cetak Laporan");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        new BorderLayout();
        JDesktopPane pBrg = new JDesktopPane();
        add(pBrg, BorderLayout.CENTER);

        /* Mengatur letak objek Label Di container*/
        lMinim.setBounds (15, 20, 100, 25);
        
        /* Mengatur letak objek Text Di Container */
        fKode.setBounds (115, 20, 130, 25);

        /* Mengatur letak objek Button di Container */
        btnAdd.setBounds (50, 90, 85, 60);
        btnAdd.setLabel("Cetak");
        btnAdd.setBackground(Color.BLUE);
        btnAdd.setForeground(Color.getHSBColor(250,0,255));
        btnSelesai.setBounds (140, 90, 85, 60);
        btnSelesai.setLabel("Selesai");
        btnSelesai.setToolTipText("Mengakhiri Program");
        
        /* Objek Button di Non Aktifkan dan di aktifkan */
        btnAdd.setEnabled(true);
        btnSelesai.setEnabled(true);
        // Mengatur objek untuk dapat berinteraksi
        btnAdd.addActionListener (this);
        btnSelesai.addActionListener (this);
        
        // Meletakkan seluruh kontrol pada objek panel */
        pBrg.add (lMinim);
        pBrg.add (fKode);
        pBrg.add (btnAdd);
        pBrg.add (btnSelesai);

        /* Menambahkan objek panel (pBrg) ke container frame */
        getContentPane().add (pBrg);
        
        /* Menampilkan frame ke layar monitor */
        pack();
        setLocationRelativeTo(null);
        setVisible (true);
    }
    public static void main(String[] args) {
        new CetakBarangMin06454().setVisible(true);
    }

    /* Fungsi jika user melakukan action penekanan tombol Button */
    public void actionPerformed (ActionEvent ae) {
        Object obj = ae.getSource();
        if (obj == btnAdd) 
        { 
            CetakOK();
        }
        if (obj == btnSelesai) 
        { 
        //System.exit(0);
            this.dispose();
        }
    }

    // Fungsi untuk menambahkan data ke tabel barang
    void CetakOK() {
        try {
            PrinterJob pjob = PrinterJob.getPrinterJob();
            pjob.setJobName("Graphics Demo Printout");
            pjob.setCopies(1);
            pjob.setPrintable(new Printable() 
            {
            public int print(Graphics g1, PageFormat pf, int pageNum) {
                if (pageNum > 0) // we only print one page
                    return Printable.NO_SUCH_PAGE; // ie., end of job
                g1.drawString("Create by Fatahillah Abid A. A12.2020.06454", 10, 10);
                
                //cetak data....................................
                try
                {
                    //Koneksi ke table barang..................
                    KoneksiDBMS CnPenjualan = new KoneksiDBMS();
                    Connection con = CnPenjualan.BukaCn();
                    Statement stat = con.createStatement();
                    isikanjml = Integer.parseInt(fKode.getText());
                    String strsql = "SELECT * FROM barang6454 where jumlah <= '" + 
                    isikanjml + "'";
                    
                    ResultSet rs = stat.executeQuery(strsql);
                    int i1, x1, y1;
                    
                    //Header
                    g1.drawString("Laporan Barang", 50, 100);
                    g1.drawString("CV. Mekar Indah", 50, 130);
                    g1.drawLine(50, 140, 450, 140);
                    g1.drawString("No.", 50 ,155);
                    g1.drawString("Kode", 80, 155);
                    g1.drawString("Nama", 150, 155);
                    g1.drawString("Harga", 295, 155);
                    g1.drawString("Jumlah", 380, 155);
                    g1.drawLine(50, 165, 450, 165);
                    x1 = 50;
                    y1 = 190;
                    i1 = 1;
                    //Cetak Record Barang.................
                    while(rs.next())
                    {
                        g1.drawString(" " + i1 + ".", 50, y1);
                        g1.drawString(rs.getString(1),80,y1);
                        g1.drawString(rs.getString(2),150,y1);
                        g1.drawString(rs.getString(3),300,y1);
                        g1.drawString(rs.getString(5),390,y1);
                        y1 += 14;
                        i1++;
                    }
                    
                    g1.drawLine(x1, y1, 450, y1);
                    
                    rs.close();
                    con.close();
                }

                catch(Exception e)
                {
                    System.out.println("Ada Kesalahan !");
                }
                return Printable.PAGE_EXISTS;
            }
            });

            if (pjob.printDialog() == false) // choose printer
            return; 
            pjob.print(); 
        }
        catch (PrinterException pe) {
        pe.printStackTrace();
        }
    }
}