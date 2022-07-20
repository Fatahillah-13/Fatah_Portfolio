import java.awt.Graphics;
import java.awt.print.PageFormat;
import java.awt.print.Printable;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import java.sql.*;
import javax.swing.JPanel;

public class CetakBarang06454 extends JPanel {
    public static void main(String[] args) {
        try {
            PrinterJob pjob = PrinterJob.getPrinterJob();
            pjob.setJobName("Graphics Demo Printout");
            pjob.setCopies(1);
            pjob.setPrintable(new Printable() 
            {
            public int print(Graphics g1, PageFormat pf, int pageNum) {
                if (pageNum > 0) // we only print one page
                return Printable.NO_SUCH_PAGE; // ie., end of job
                g1.drawString("Fatahillah Abid A. A12.2020.06454", 10, 10);
                //cetak data....................................
                try {
                    //Koneksi ke table barang..................
                    KoneksiDBMS CnPenjualan = new KoneksiDBMS();
                    Connection con = CnPenjualan.BukaCn();
                    Statement stat = con.createStatement();
                    
                    String strsql = "SELECT * FROM barang6454";
                    ResultSet rs = stat.executeQuery(strsql);
                    int i1, x1, y1;
                    
                    //Header
                    g1.drawString("Laporan Barang", 50, 100);
                    g1.drawString("CV. Mekar Indah", 50, 130);
                    g1.drawLine(50, 140, 500, 140);
                    g1.drawString("No.", 50 ,155);
                    g1.drawString("Kode", 80, 155);
                    g1.drawString("Nama", 150, 155);
                    g1.drawString("Harga", 300, 155);
                    g1.drawString("Jumlah", 450, 155);
                    g1.drawLine(50, 165, 500, 165);
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
                        g1.drawString(rs.getString(4),450,y1);
                        y1 += 14;
                        i1++;
                    }
                    
                    g1.drawLine(x1, y1, 500, y1);
                    
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