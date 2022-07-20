import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

// Program Menu..........................................................
class FMenu06454 extends JFrame {
    // property/fields...................................................
    private JTextArea m_editArea = new JTextArea(20, 50);
    private JPanel JPMenu = new JPanel();
    private JPopupMenu m_popup = new JPopupMenu();
    private JLabel lNama = new JLabel ("Fatahillah Abid A."),
    lAlamat = new JLabel ("A12.2020.06454"); 
    //Nama Ganti dengan Nama dan NIM anda.......... !

    // constructor.......................................................
    public FMenu06454() { // 06454 ganti dengan 5 digit nim terakhir......
        setPreferredSize(new Dimension(800,600));
        setTitle("MENU PENJUALAN");
        
        JDesktopPane JDPMenu = new JDesktopPane();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        lNama.setBounds (15, 20, 400, 50);
        lAlamat.setBounds (15, 55, 200, 25);
        lNama.setFont(new Font("Arial", Font.BOLD, 32));
        lNama.setForeground(new Color(220, 10, 10)); 
        lAlamat.setFont(new Font("Verdana", Font.PLAIN, 15));
        lAlamat.setForeground(new Color(10, 10, 220)); 
        
        //sub menu (M0) Pegawai..................................... 
        JMenuItem M01Pegawai = new JMenuItem("Pegawai");
        M01Pegawai.setMnemonic('P');
        M01Pegawai.setAccelerator(KeyStroke.getKeyStroke("control P"));
        JMenuItem M02Password = new JMenuItem("PaSsword");
        M02Password.setMnemonic('S');
        M02Password.setEnabled(false);
        M02Password.setAccelerator(KeyStroke.getKeyStroke("control S"));
        JMenuItem M03Quit = new JMenuItem("Quit");
        M03Quit.setMnemonic('Q');
        M03Quit.setAccelerator(KeyStroke.getKeyStroke("control Q"));

        //sub menu (M1) Barang..................................... 
        JMenuItem M11Barang = new JMenuItem("Barang");
        M11Barang.setMnemonic('B');
        M11Barang.setAccelerator(KeyStroke.getKeyStroke("control B"));
        JMenuItem M12Stok = new JMenuItem("Stock Minim");
        M12Stok.setMnemonic('M');
        M12Stok.setEnabled(false);
        M12Stok.setAccelerator(KeyStroke.getKeyStroke("control M"));

        //sub menu (M2) Transaksi..................................... 
        JMenuItem M21Pengadaan = new JMenuItem("PengaDaan");
        M21Pengadaan.setMnemonic('D');
        M21Pengadaan.setEnabled(false);
        M21Pengadaan.setAccelerator(KeyStroke.getKeyStroke("control D"));
        JMenuItem M22Penjualan = new JMenuItem("PenJualan");
        M22Penjualan.setMnemonic('J');
        M22Penjualan.setEnabled(true);
        M22Penjualan.setAccelerator(KeyStroke.getKeyStroke("control J"));
        JMenuItem M23Laporan = new JMenuItem("Laporan");
        M23Laporan.setMnemonic('L');
        M23Laporan.setEnabled(true);
        M23Laporan.setAccelerator(KeyStroke.getKeyStroke("control L")); 
        
        // (2) Build menubar, menus, and add menuitems....................
        JMenuBar menubar = new JMenuBar(); // Create new menu bar.........
        JMenu MenuPegawai = new JMenu("Pegawai"); // Create new menu...
        MenuPegawai.setMnemonic('P');
        menubar.add(MenuPegawai); 
        MenuPegawai.add(M01Pegawai);
        MenuPegawai.add(M02Password); 
        MenuPegawai.addSeparator(); 
        MenuPegawai.add(M03Quit);
        JMenu MenuBarang = new JMenu("Barang");
        MenuBarang.setMnemonic('B');
        menubar.add(MenuBarang);
        MenuBarang.add(M11Barang);
        MenuBarang.add(M12Stok);
        JMenu MenuTransaksi = new JMenu("Transaksi");
        MenuTransaksi.setMnemonic('T');
        menubar.add(MenuTransaksi);
        MenuTransaksi.add(M21Pengadaan);
        MenuTransaksi.add(M22Penjualan);
        MenuTransaksi.add(M23Laporan);

        //Siap untuk menjalankan pilihan.....................
        M01Pegawai.addActionListener(new BukaPegawai());
        M03Quit.addActionListener(new QuitAction());
        M11Barang.addActionListener(new BukaBarang()); 
        M22Penjualan.addActionListener(new BukaJual()); 
        M23Laporan.addActionListener(new Laporan());

        // Add the (unused) text area to the content pane............
        JPanel content = new JPanel();
        content.setLayout(new BorderLayout());
        content.add(m_editArea, BorderLayout.CENTER);

        //... Add menu items to popup menu, add popup menu to text area.
        m_popup.add(new JMenuItem("Testing"));
        m_editArea.setComponentPopupMenu(m_popup);

        //... Set the JFrame's content pane and menu bar.
        setContentPane(content);
        setJMenuBar(menubar);
        JDPMenu.add (lNama);
        JDPMenu.add (lAlamat);
        getContentPane().add (JDPMenu).setBackground(Color.getHSBColor(180,100,200));
        pack();
        setLocationRelativeTo(null);
    }

    class OpenAction implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            JOptionPane.showMessageDialog(FMenu06454.this, "Can't Open.");
        }
    }

    class BukaPegawai implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            FPegawai6454 xPegawai = new FPegawai6454();
            xPegawai.setVisible(true);
            
            // dua perintah diatas "//"nya dihapus !
            
            //..........................................
            //panggil Form pegawai untuk menjalankan program pegawai !
            //Perintah System.exit(0); pada FPegawai ganti dengan perintah
            // this.dispose();
            // System.exit(0); menjadi this.dispose();
        }
    }

    class BukaBarang implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            FBarang6454 xBarang = new FBarang6454();
            xBarang.setVisible(true);
        }
    }

    class BukaJual implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            FJual06454 xJual = new FJual06454();
            xJual.setVisible(true);
        }
    }

    class Laporan implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            CetakBarangMin06454 xLaporan = new CetakBarangMin06454();
            xLaporan.setVisible(true);
        }
    }

    class QuitAction implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            System.exit(0); // Terminate the program..........
        }
    }

    // main method................................................
    public static void main(String[] args) {
        JFrame win = new FMenu06454();
        win.setVisible(true);
    }
}