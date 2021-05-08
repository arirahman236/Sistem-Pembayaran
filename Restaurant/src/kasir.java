
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import javax.swing.JFrame;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import javax.swing.JOptionPane;import com.mysql.jdbc.Statement;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author user
 */
public class kasir extends javax.swing.JFrame implements data{
    private Statement stm;
    
    public kasir() {
        initComponents();
        
        try{
            CreateConnection conn = new CreateConnection();
            stm = (Statement) conn.getConnection().createStatement();
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, "On Start: "+e.getMessage());
        }
        
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        
                    Calendar kal = new GregorianCalendar();
                    int tahun = kal.get(Calendar.YEAR);
                    int bulan = kal.get(Calendar.MONTH)+1;
                    int hari = kal.get(Calendar.DAY_OF_MONTH);
                    int jam = kal.get(Calendar.HOUR_OF_DAY);
                    int menit = kal.get(Calendar.MINUTE);
                    int detik = kal.get(Calendar.SECOND);
                    String kode = bulan+""+tahun+""+jam+""+menit+""+detik;
                    id.setText(kode);
                    
        this.setLocationRelativeTo(null);
        new Thread(){
            @Override
            public void run(){
                while(true){
                    Calendar kal = new GregorianCalendar();
                    int tahun = kal.get(Calendar.YEAR);
                    int bulan = kal.get(Calendar.MONTH)+1;
                    int hari = kal.get(Calendar.DAY_OF_MONTH);
                    int jam = kal.get(Calendar.HOUR_OF_DAY);
                    int menit = kal.get(Calendar.MINUTE);
                    int detik = kal.get(Calendar.SECOND);
                    String tanggal = hari+"/"+bulan+"/"+tahun;
                    lbwaktu.setText(tanggal);
                }
            }
        }.start();
    }
    
    public int hargaLalapan = 15000;
    public int hargaNasgor = 12000;
    public int hargaRamen = 18000;
    public int hargaPecel = 10000;
    public int hargaGado = 10000;
    public int hargaRawon = 13000;
    public int hargaAyam = 25000;
    public int hargaSate = 18000;
    public int hargaSoto = 10000;
    public int jmlLalapan;
    public int jmlNasgor;
    public int jmlRamen;
    public int jmlPecel;
    public int jmlGado;
    public int jmlRawon;
    public int jmlAyam;
    public int jmlSate;
    public int jmlSoto;
    public int totalMakanan;
    public int totalMinuman;
    public int hargaJusApel = 8000;
    public int hargaJusMangga = 8000;
    public int hargaJusAlpukat = 8000;
    public int hargaEsTeh = 4000;
    public int hargaEsJeruk = 5000;
    public int hargaEsCokelat = 7500;
    public int hargaEsSusu = 7500;
    public int hargaEsCappucino = 8000;
    public int jmlEsCappucino;
    public int jmlEsSusu;
    public int jmlEsCokelat;
    public int jmlEsJeruk;
    public int jmlEsTeh;
    public int jmlJusMangga;
    public int jmlJusApel;
    public int jmlJusAlpukat;
    public int hargaKopiHitam = 4000;
    public int hargaKopiLuwak = 20000;
    public int hargaCoklat = 5000;
    public int hargaSusu = 5000;
    public int hargaCappucino = 8000;
    public int hargaTehPanas = 4000;
    public int hargaJerukPanas = 4000;
    public int hargaTehSusu = 8000;
    public int jmlKopiHitam;
    public int jmlKopiLuwak;
    public int jmlCoklat;
    public int jmlSusu;
    public int jmlCappucino;
    public int jmlTehPanas;
    public int jmlJerukPanas;
    public int jmlTehSusu;
    public int bayar;
    public int total_makanan;
    public int total_minuman;
    
    @Override
    public void tampilTotal(){
        
        int total = this.total_makanan + this.total_minuman;
        lbTotal.setText(""+total);
        
    }
    @Override
    public void kembalian(){
        int total = Integer.parseInt(lbTotal.getText());
        int kembali = bayar - total;
        lbKembalian.setText(""+kembali);
    }
    @Override
    public void tampilMakanan(){
        int jml = 0;
        jml += this.hargaLalapan * this.jmlLalapan;
        jml += this.hargaNasgor * this.jmlNasgor;
        jml += this.hargaRamen * this.jmlRamen;
        jml += this.hargaPecel * this.jmlPecel;
        jml += this.hargaGado * this.jmlGado;
        jml += this.hargaRawon  * this.jmlRawon;
        jml += this.hargaAyam * this.jmlAyam;
        jml += this.hargaSate * this.jmlSate;
        jml += this.hargaSoto * this.jmlSoto;
        this.total_makanan = jml;
        lbmakanan.setText(""+jml);
        this.tampilTotal();
        
    }
    @Override
    public void tampilMinuman(){
        int jml = 0;
        jml += this.hargaJusApel * this.jmlJusApel;
        jml += this.hargaJusMangga * this.jmlJusMangga;
        jml += this.hargaJusAlpukat * this.jmlJusAlpukat;
        jml += this.hargaEsTeh * this.jmlEsTeh;
        jml += this.hargaEsJeruk * this.jmlEsJeruk;
        jml += this.hargaEsCokelat * this.jmlEsCokelat;
        jml += this.hargaEsSusu * this.jmlEsSusu;
        jml += this.hargaEsCappucino * this.jmlEsCappucino;
        jml += this.hargaKopiHitam * this.jmlKopiHitam;
        jml += this.hargaKopiLuwak * this.jmlKopiLuwak;
        jml += this.hargaCoklat * this.jmlCoklat;
        jml += this.hargaSusu * this.jmlSusu;
        jml += this.hargaCappucino * this.jmlCappucino;
        jml += this.hargaTehPanas * this.jmlTehPanas;
        jml += this.hargaJerukPanas * this.jmlJerukPanas;
        jml += this.hargaTehSusu * this.jmlTehSusu;
        this.total_minuman = jml;
        lbminuman.setText("" + jml);
        this.tampilTotal();
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel48 = new javax.swing.JLabel();
        lbwaktu = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        m1 = new javax.swing.JLabel();
        m2 = new javax.swing.JLabel();
        m3 = new javax.swing.JLabel();
        m4 = new javax.swing.JLabel();
        m5 = new javax.swing.JLabel();
        m6 = new javax.swing.JLabel();
        m7 = new javax.swing.JLabel();
        m8 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        tflalapan = new javax.swing.JTextField();
        tfnasgor = new javax.swing.JTextField();
        tfpecel = new javax.swing.JTextField();
        tfgado = new javax.swing.JTextField();
        tfrawon = new javax.swing.JTextField();
        tfayam = new javax.swing.JTextField();
        tfsate = new javax.swing.JTextField();
        m9 = new javax.swing.JLabel();
        tfsoto = new javax.swing.JTextField();
        cbLalapan = new javax.swing.JCheckBox();
        cbNasgor = new javax.swing.JCheckBox();
        cbpecel = new javax.swing.JCheckBox();
        cbRamen = new javax.swing.JCheckBox();
        cbgado = new javax.swing.JCheckBox();
        cbrawon = new javax.swing.JCheckBox();
        cbayam = new javax.swing.JCheckBox();
        cbsate = new javax.swing.JCheckBox();
        cbsoto = new javax.swing.JCheckBox();
        tframen = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        tfNama = new javax.swing.JTextField();
        no_meja = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        lbmakanan = new javax.swing.JLabel();
        lbminuman = new javax.swing.JLabel();
        lbTotal = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel21 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        jLabel33 = new javax.swing.JLabel();
        jLabel34 = new javax.swing.JLabel();
        tfApel = new javax.swing.JTextField();
        tfMangga = new javax.swing.JTextField();
        tfAlpukat = new javax.swing.JTextField();
        tfEsTeh = new javax.swing.JTextField();
        tfEsJeruk = new javax.swing.JTextField();
        tfEsCokelat = new javax.swing.JTextField();
        tfEsCappucino = new javax.swing.JTextField();
        jLabel35 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jLabel36 = new javax.swing.JLabel();
        jLabel37 = new javax.swing.JLabel();
        jLabel38 = new javax.swing.JLabel();
        jLabel41 = new javax.swing.JLabel();
        jLabel39 = new javax.swing.JLabel();
        jLabel40 = new javax.swing.JLabel();
        jLabel42 = new javax.swing.JLabel();
        jLabel44 = new javax.swing.JLabel();
        jLabel45 = new javax.swing.JLabel();
        jLabel32 = new javax.swing.JLabel();
        tfEsSusu = new javax.swing.JTextField();
        jLabel47 = new javax.swing.JLabel();
        tfKopiHitam = new javax.swing.JTextField();
        tfKopiLuwak = new javax.swing.JTextField();
        tfCoklat = new javax.swing.JTextField();
        tfSusu = new javax.swing.JTextField();
        tfCappucino = new javax.swing.JTextField();
        tfJerukPanas = new javax.swing.JTextField();
        tfTehSusu = new javax.swing.JTextField();
        cbApel = new javax.swing.JCheckBox();
        cbMangga = new javax.swing.JCheckBox();
        cbAlpukat = new javax.swing.JCheckBox();
        cbEsTeh = new javax.swing.JCheckBox();
        cbEsJeruk = new javax.swing.JCheckBox();
        cbEsCokelat = new javax.swing.JCheckBox();
        cbEsSusu = new javax.swing.JCheckBox();
        cbEsCappucino = new javax.swing.JCheckBox();
        cbKopiHitam = new javax.swing.JCheckBox();
        cbkopiLuwak = new javax.swing.JCheckBox();
        cbCoklat = new javax.swing.JCheckBox();
        cbSusu = new javax.swing.JCheckBox();
        cbCappucino = new javax.swing.JCheckBox();
        cbJerukPanas = new javax.swing.JCheckBox();
        cbTehSusu = new javax.swing.JCheckBox();
        cbTehPanas = new javax.swing.JCheckBox();
        jLabel43 = new javax.swing.JLabel();
        tfTehPanas = new javax.swing.JTextField();
        jLabel50 = new javax.swing.JLabel();
        tfPembayaran = new javax.swing.JTextField();
        jLabel51 = new javax.swing.JLabel();
        lbKembalian = new javax.swing.JLabel();
        lbPembayaran = new javax.swing.JLabel();
        btnBayar = new javax.swing.JButton();
        btn_exit = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        id = new javax.swing.JLabel();
        pilihan1 = new javax.swing.JLabel();
        pilihan2 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jumlah = new javax.swing.JLabel();
        pilihan3 = new javax.swing.JLabel();
        jumlah1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel2.setBackground(new java.awt.Color(204, 255, 204));

        jLabel1.setFont(new java.awt.Font("Trajan Pro", 1, 48)); // NOI18N
        jLabel1.setText("KASIR RESTAURANT");

        jLabel48.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel48.setText("Tanggal :");

        lbwaktu.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        lbwaktu.setPreferredSize(new java.awt.Dimension(20, 20));
        lbwaktu.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                lbwaktuKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addComponent(jLabel48)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbwaktu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1)
                .addGap(405, 405, 405))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lbwaktu, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
                    .addComponent(jLabel48, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(51, 51, 51)));
        jPanel1.setForeground(new java.awt.Color(255, 102, 102));

        jLabel2.setFont(new java.awt.Font("Sylfaen", 2, 36)); // NOI18N
        jLabel2.setText("Makanan");

        jLabel5.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel5.setText("Nama");

        jLabel12.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel12.setText("Harga");

        m1.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        m1.setForeground(new java.awt.Color(102, 102, 102));
        m1.setText("Rp.15.000");

        m2.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        m2.setForeground(new java.awt.Color(102, 102, 102));
        m2.setText("Rp.12.000");

        m3.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        m3.setForeground(new java.awt.Color(102, 102, 102));
        m3.setText("Rp.18.000");

        m4.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        m4.setForeground(new java.awt.Color(102, 102, 102));
        m4.setText("Rp.10.000");

        m5.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        m5.setForeground(new java.awt.Color(102, 102, 102));
        m5.setText("Rp.10.000");

        m6.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        m6.setForeground(new java.awt.Color(102, 102, 102));
        m6.setText("Rp.13.000");

        m7.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        m7.setForeground(new java.awt.Color(102, 102, 102));
        m7.setText("Rp.25.000");

        m8.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        m8.setForeground(new java.awt.Color(102, 102, 102));
        m8.setText("Rp.18.000");

        jLabel22.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel22.setText("Jumlah");

        tflalapan.setEditable(false);
        tflalapan.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        tflalapan.setForeground(new java.awt.Color(102, 102, 102));
        tflalapan.setText("0");
        tflalapan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tflalapanActionPerformed(evt);
            }
        });
        tflalapan.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tflalapanKeyReleased(evt);
            }
        });

        tfnasgor.setEditable(false);
        tfnasgor.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        tfnasgor.setForeground(new java.awt.Color(102, 102, 102));
        tfnasgor.setText("0");
        tfnasgor.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tfnasgorKeyReleased(evt);
            }
        });

        tfpecel.setEditable(false);
        tfpecel.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        tfpecel.setForeground(new java.awt.Color(102, 102, 102));
        tfpecel.setText("0");
        tfpecel.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tfpecelKeyReleased(evt);
            }
        });

        tfgado.setEditable(false);
        tfgado.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        tfgado.setForeground(new java.awt.Color(102, 102, 102));
        tfgado.setText("0");
        tfgado.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tfgadoKeyReleased(evt);
            }
        });

        tfrawon.setEditable(false);
        tfrawon.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        tfrawon.setForeground(new java.awt.Color(102, 102, 102));
        tfrawon.setText("0");
        tfrawon.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tfrawonKeyReleased(evt);
            }
        });

        tfayam.setEditable(false);
        tfayam.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        tfayam.setForeground(new java.awt.Color(102, 102, 102));
        tfayam.setText("0");
        tfayam.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tfayamKeyReleased(evt);
            }
        });

        tfsate.setEditable(false);
        tfsate.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        tfsate.setForeground(new java.awt.Color(102, 102, 102));
        tfsate.setText("0");
        tfsate.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tfsateKeyReleased(evt);
            }
        });

        m9.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        m9.setForeground(new java.awt.Color(102, 102, 102));
        m9.setText("Rp.10.000");

        tfsoto.setEditable(false);
        tfsoto.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        tfsoto.setForeground(new java.awt.Color(102, 102, 102));
        tfsoto.setText("0");
        tfsoto.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tfsotoKeyReleased(evt);
            }
        });

        cbLalapan.setBackground(new java.awt.Color(255, 255, 255));
        cbLalapan.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        cbLalapan.setForeground(new java.awt.Color(102, 102, 102));
        cbLalapan.setText("Lalapan");
        cbLalapan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbLalapanActionPerformed(evt);
            }
        });

        cbNasgor.setBackground(new java.awt.Color(255, 255, 255));
        cbNasgor.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        cbNasgor.setForeground(new java.awt.Color(102, 102, 102));
        cbNasgor.setText("Nasi Goreng");
        cbNasgor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbNasgorActionPerformed(evt);
            }
        });

        cbpecel.setBackground(new java.awt.Color(255, 255, 255));
        cbpecel.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        cbpecel.setForeground(new java.awt.Color(102, 102, 102));
        cbpecel.setText("Pecel");
        cbpecel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbpecelActionPerformed(evt);
            }
        });

        cbRamen.setBackground(new java.awt.Color(255, 255, 255));
        cbRamen.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        cbRamen.setForeground(new java.awt.Color(102, 102, 102));
        cbRamen.setText("Ramen");
        cbRamen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbRamenActionPerformed(evt);
            }
        });

        cbgado.setBackground(new java.awt.Color(255, 255, 255));
        cbgado.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        cbgado.setForeground(new java.awt.Color(102, 102, 102));
        cbgado.setText("Gado Gado");
        cbgado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbgadoActionPerformed(evt);
            }
        });

        cbrawon.setBackground(new java.awt.Color(255, 255, 255));
        cbrawon.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        cbrawon.setForeground(new java.awt.Color(102, 102, 102));
        cbrawon.setText("Rawon");
        cbrawon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbrawonActionPerformed(evt);
            }
        });

        cbayam.setBackground(new java.awt.Color(255, 255, 255));
        cbayam.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        cbayam.setForeground(new java.awt.Color(102, 102, 102));
        cbayam.setText("Ayam Bakar");
        cbayam.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbayamActionPerformed(evt);
            }
        });

        cbsate.setBackground(new java.awt.Color(255, 255, 255));
        cbsate.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        cbsate.setForeground(new java.awt.Color(102, 102, 102));
        cbsate.setText("Sate Ayam");
        cbsate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbsateActionPerformed(evt);
            }
        });

        cbsoto.setBackground(new java.awt.Color(255, 255, 255));
        cbsoto.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        cbsoto.setForeground(new java.awt.Color(102, 102, 102));
        cbsoto.setText("Soto");
        cbsoto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbsotoActionPerformed(evt);
            }
        });

        tframen.setEditable(false);
        tframen.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        tframen.setForeground(new java.awt.Color(102, 102, 102));
        tframen.setText("0");
        tframen.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tframenKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(44, 44, 44)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 1, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(cbRamen, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(cbNasgor, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(cbLalapan, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(8, 8, 8))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(cbpecel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(cbgado, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(cbrawon, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(cbayam, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(cbsate, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(cbsoto, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(m4)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(m5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(m6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(m7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(m8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(m9))
                            .addComponent(m3)
                            .addComponent(m2)
                            .addComponent(m1))
                        .addGap(40, 40, 40)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(tflalapan, javax.swing.GroupLayout.DEFAULT_SIZE, 77, Short.MAX_VALUE)
                            .addComponent(tfpecel)
                            .addComponent(tfgado)
                            .addComponent(tfrawon)
                            .addComponent(tfayam)
                            .addComponent(tfsate)
                            .addComponent(tfsoto)
                            .addComponent(tfnasgor)
                            .addComponent(tframen))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 99, Short.MAX_VALUE)
                        .addComponent(jLabel12)
                        .addGap(57, 57, 57)
                        .addComponent(jLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(36, 36, 36))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addGap(134, 134, 134))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(jLabel5)
                    .addComponent(jLabel22))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tflalapan, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(cbLalapan)
                        .addComponent(m1, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(m2, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfnasgor, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbNasgor))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbRamen)
                    .addComponent(m3, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tframen, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbpecel)
                    .addComponent(m4, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfpecel, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbgado)
                    .addComponent(m5, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfgado, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbrawon)
                    .addComponent(m6, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfrawon, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(m7, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tfayam, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(m8, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tfsate, javax.swing.GroupLayout.DEFAULT_SIZE, 32, Short.MAX_VALUE)
                            .addComponent(cbsate)))
                    .addComponent(cbayam))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbsoto)
                    .addComponent(m9, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfsoto, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(54, 54, 54))
        );

        jLabel3.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel3.setText("Nama     :");

        jLabel4.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel4.setText("No.Meja :");

        tfNama.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N

        no_meja.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        no_meja.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "01", "02", "03", "04", "05", "06", "07", "08", "09", "10" }));
        no_meja.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                no_mejaActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel6.setText("Total Makanan  :");

        jLabel7.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel7.setText("Total Minuman :");

        jLabel8.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel8.setText("Total Bayar       :");

        lbmakanan.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N

        lbminuman.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N

        lbTotal.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel21.setFont(new java.awt.Font("Sylfaen", 2, 36)); // NOI18N
        jLabel21.setText("Minuman");

        jLabel23.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel23.setText("Dingin");

        jLabel24.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel24.setText("Nama");

        jLabel25.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel25.setText("Harga");

        jLabel26.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel26.setForeground(new java.awt.Color(102, 102, 102));
        jLabel26.setText("Rp.8.000");

        jLabel27.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel27.setForeground(new java.awt.Color(102, 102, 102));
        jLabel27.setText("Rp.8.000");

        jLabel28.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel28.setForeground(new java.awt.Color(102, 102, 102));
        jLabel28.setText("Rp.8.000");

        jLabel29.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel29.setForeground(new java.awt.Color(102, 102, 102));
        jLabel29.setText("Rp.4.000");

        jLabel30.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel30.setForeground(new java.awt.Color(102, 102, 102));
        jLabel30.setText("Rp.5.000");

        jLabel31.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel31.setForeground(new java.awt.Color(102, 102, 102));
        jLabel31.setText("Rp.7.500");

        jLabel33.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel33.setForeground(new java.awt.Color(102, 102, 102));
        jLabel33.setText("Rp.8.000");

        jLabel34.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel34.setText("Jumlah");

        tfApel.setEditable(false);
        tfApel.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        tfApel.setText("0");
        tfApel.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tfApelKeyReleased(evt);
            }
        });

        tfMangga.setEditable(false);
        tfMangga.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        tfMangga.setText("0");
        tfMangga.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfManggaActionPerformed(evt);
            }
        });
        tfMangga.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tfManggaKeyReleased(evt);
            }
        });

        tfAlpukat.setEditable(false);
        tfAlpukat.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        tfAlpukat.setText("0");

        tfEsTeh.setEditable(false);
        tfEsTeh.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        tfEsTeh.setText("0");
        tfEsTeh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfEsTehActionPerformed(evt);
            }
        });

        tfEsJeruk.setEditable(false);
        tfEsJeruk.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        tfEsJeruk.setText("0");

        tfEsCokelat.setEditable(false);
        tfEsCokelat.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        tfEsCokelat.setText("0");

        tfEsCappucino.setEditable(false);
        tfEsCappucino.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        tfEsCappucino.setText("0");
        tfEsCappucino.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfEsCappucinoActionPerformed(evt);
            }
        });

        jLabel35.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel35.setText("Panas");

        jPanel4.setBackground(new java.awt.Color(0, 0, 0));
        jPanel4.setPreferredSize(new java.awt.Dimension(2, 350));

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 2, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 350, Short.MAX_VALUE)
        );

        jLabel36.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel36.setText("Nama");

        jLabel37.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel37.setText("Harga");

        jLabel38.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel38.setForeground(new java.awt.Color(102, 102, 102));
        jLabel38.setText("Rp.4.000");

        jLabel41.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel41.setForeground(new java.awt.Color(102, 102, 102));
        jLabel41.setText("Rp.20.000");

        jLabel39.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel39.setForeground(new java.awt.Color(102, 102, 102));
        jLabel39.setText("Rp.5.000");

        jLabel40.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel40.setForeground(new java.awt.Color(102, 102, 102));
        jLabel40.setText("Rp.5.000");

        jLabel42.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel42.setForeground(new java.awt.Color(102, 102, 102));
        jLabel42.setText("Rp.8.000");

        jLabel44.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel44.setForeground(new java.awt.Color(102, 102, 102));
        jLabel44.setText("Rp.4.000");

        jLabel45.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel45.setForeground(new java.awt.Color(102, 102, 102));
        jLabel45.setText("Rp.5.000");

        jLabel32.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel32.setForeground(new java.awt.Color(102, 102, 102));
        jLabel32.setText("Rp.7.500");

        tfEsSusu.setEditable(false);
        tfEsSusu.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        tfEsSusu.setText("0");

        jLabel47.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel47.setText("Jumlah");

        tfKopiHitam.setEditable(false);
        tfKopiHitam.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        tfKopiHitam.setText("0");
        tfKopiHitam.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tfKopiHitamKeyReleased(evt);
            }
        });

        tfKopiLuwak.setEditable(false);
        tfKopiLuwak.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        tfKopiLuwak.setText("0");
        tfKopiLuwak.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tfKopiLuwakKeyReleased(evt);
            }
        });

        tfCoklat.setEditable(false);
        tfCoklat.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        tfCoklat.setText("0");
        tfCoklat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfCoklatActionPerformed(evt);
            }
        });

        tfSusu.setEditable(false);
        tfSusu.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        tfSusu.setText("0");

        tfCappucino.setEditable(false);
        tfCappucino.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        tfCappucino.setText("0");

        tfJerukPanas.setEditable(false);
        tfJerukPanas.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        tfJerukPanas.setText("0");

        tfTehSusu.setEditable(false);
        tfTehSusu.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        tfTehSusu.setText("0");

        cbApel.setBackground(new java.awt.Color(255, 255, 255));
        cbApel.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        cbApel.setForeground(new java.awt.Color(102, 102, 102));
        cbApel.setText("Jus Apel");
        cbApel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbApelActionPerformed(evt);
            }
        });

        cbMangga.setBackground(new java.awt.Color(255, 255, 255));
        cbMangga.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        cbMangga.setForeground(new java.awt.Color(102, 102, 102));
        cbMangga.setText("Jus Mangga");
        cbMangga.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbManggaActionPerformed(evt);
            }
        });

        cbAlpukat.setBackground(new java.awt.Color(255, 255, 255));
        cbAlpukat.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        cbAlpukat.setForeground(new java.awt.Color(102, 102, 102));
        cbAlpukat.setText("Jus Alpukat");
        cbAlpukat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbAlpukatActionPerformed(evt);
            }
        });

        cbEsTeh.setBackground(new java.awt.Color(255, 255, 255));
        cbEsTeh.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        cbEsTeh.setForeground(new java.awt.Color(102, 102, 102));
        cbEsTeh.setText("Es Teh");
        cbEsTeh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbEsTehActionPerformed(evt);
            }
        });

        cbEsJeruk.setBackground(new java.awt.Color(255, 255, 255));
        cbEsJeruk.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        cbEsJeruk.setForeground(new java.awt.Color(102, 102, 102));
        cbEsJeruk.setText("Es Jeruk");
        cbEsJeruk.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbEsJerukActionPerformed(evt);
            }
        });

        cbEsCokelat.setBackground(new java.awt.Color(255, 255, 255));
        cbEsCokelat.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        cbEsCokelat.setForeground(new java.awt.Color(102, 102, 102));
        cbEsCokelat.setText("Es Cokelat");
        cbEsCokelat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbEsCokelatActionPerformed(evt);
            }
        });

        cbEsSusu.setBackground(new java.awt.Color(255, 255, 255));
        cbEsSusu.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        cbEsSusu.setForeground(new java.awt.Color(102, 102, 102));
        cbEsSusu.setText("Es Susu");
        cbEsSusu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbEsSusuActionPerformed(evt);
            }
        });

        cbEsCappucino.setBackground(new java.awt.Color(255, 255, 255));
        cbEsCappucino.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        cbEsCappucino.setForeground(new java.awt.Color(102, 102, 102));
        cbEsCappucino.setText("Es Capucino");
        cbEsCappucino.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbEsCappucinoActionPerformed(evt);
            }
        });

        cbKopiHitam.setBackground(new java.awt.Color(255, 255, 255));
        cbKopiHitam.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        cbKopiHitam.setForeground(new java.awt.Color(102, 102, 102));
        cbKopiHitam.setText("Kopi Hitam");
        cbKopiHitam.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbKopiHitamActionPerformed(evt);
            }
        });

        cbkopiLuwak.setBackground(new java.awt.Color(255, 255, 255));
        cbkopiLuwak.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        cbkopiLuwak.setForeground(new java.awt.Color(102, 102, 102));
        cbkopiLuwak.setText("Kopi Luwak");
        cbkopiLuwak.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbkopiLuwakActionPerformed(evt);
            }
        });

        cbCoklat.setBackground(new java.awt.Color(255, 255, 255));
        cbCoklat.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        cbCoklat.setForeground(new java.awt.Color(102, 102, 102));
        cbCoklat.setText("Cokelat");
        cbCoklat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbCoklatActionPerformed(evt);
            }
        });

        cbSusu.setBackground(new java.awt.Color(255, 255, 255));
        cbSusu.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        cbSusu.setForeground(new java.awt.Color(102, 102, 102));
        cbSusu.setText("Susu");
        cbSusu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbSusuActionPerformed(evt);
            }
        });

        cbCappucino.setBackground(new java.awt.Color(255, 255, 255));
        cbCappucino.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        cbCappucino.setForeground(new java.awt.Color(102, 102, 102));
        cbCappucino.setText("Cappucino");
        cbCappucino.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbCappucinoActionPerformed(evt);
            }
        });

        cbJerukPanas.setBackground(new java.awt.Color(255, 255, 255));
        cbJerukPanas.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        cbJerukPanas.setForeground(new java.awt.Color(102, 102, 102));
        cbJerukPanas.setText("Jeruk Panas");
        cbJerukPanas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbJerukPanasActionPerformed(evt);
            }
        });

        cbTehSusu.setBackground(new java.awt.Color(255, 255, 255));
        cbTehSusu.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        cbTehSusu.setForeground(new java.awt.Color(102, 102, 102));
        cbTehSusu.setText("Teh Susu");
        cbTehSusu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbTehSusuActionPerformed(evt);
            }
        });

        cbTehPanas.setBackground(new java.awt.Color(255, 255, 255));
        cbTehPanas.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        cbTehPanas.setForeground(new java.awt.Color(102, 102, 102));
        cbTehPanas.setText("Teh Panas");
        cbTehPanas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbTehPanasActionPerformed(evt);
            }
        });

        jLabel43.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel43.setForeground(new java.awt.Color(102, 102, 102));
        jLabel43.setText("Rp.4.000");

        tfTehPanas.setEditable(false);
        tfTehPanas.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        tfTehPanas.setText("0");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(41, 41, 41)
                                .addComponent(jLabel24)
                                .addGap(87, 87, 87))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(cbEsCappucino, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(cbEsCokelat, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(cbEsSusu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(cbEsJeruk, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(cbApel, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(cbMangga, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(cbAlpukat, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(cbEsTeh, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(18, 18, 18)))
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jLabel26, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel28, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel29, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel30, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel31, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel33, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel32, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(jLabel27)
                            .addComponent(jLabel25)))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(134, 134, 134)
                        .addComponent(jLabel23)))
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(tfApel)
                                        .addComponent(jLabel34, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(tfAlpukat)
                                        .addComponent(tfEsTeh)
                                        .addComponent(tfEsJeruk)
                                        .addComponent(tfEsCokelat)
                                        .addComponent(tfEsCappucino)
                                        .addComponent(tfEsSusu))
                                    .addComponent(tfMangga, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(30, 30, 30)
                                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addGap(35, 35, 35)
                                        .addComponent(jLabel36)
                                        .addGap(78, 78, 78))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                                                    .addGap(1, 1, 1)
                                                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(cbCoklat, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(cbSusu, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                            .addComponent(cbTehPanas, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 119, Short.MAX_VALUE)
                                                            .addComponent(cbCappucino, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                    .addComponent(cbKopiHitam, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                    .addComponent(cbkopiLuwak, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                            .addGroup(jPanel3Layout.createSequentialGroup()
                                                .addGap(1, 1, 1)
                                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(cbTehSusu, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(cbJerukPanas)))))))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel21)
                                .addGap(78, 78, 78)))
                        .addGap(17, 17, 17)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel45, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel37)
                            .addComponent(jLabel38, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel41)
                            .addComponent(jLabel39, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel40, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel42, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel43, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel44, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(32, 32, 32)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel47, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(tfKopiHitam)
                            .addComponent(tfKopiLuwak, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(tfCoklat)
                            .addComponent(tfSusu)
                            .addComponent(tfCappucino)
                            .addComponent(tfJerukPanas)
                            .addComponent(tfTehSusu)
                            .addComponent(tfTehPanas))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jLabel35)
                        .addGap(204, 204, 204))))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(jLabel21)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel35, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel23))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel24)
                            .addComponent(jLabel25)
                            .addComponent(jLabel34))
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(11, 11, 11)
                                .addComponent(tfApel, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel26, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(cbApel))))
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel27, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(cbMangga)))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(7, 7, 7)
                                .addComponent(tfMangga, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cbAlpukat)
                            .addComponent(jLabel28, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tfAlpukat, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(5, 5, 5)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel29, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cbEsTeh)
                            .addComponent(tfEsTeh, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cbEsJeruk)
                            .addComponent(jLabel30, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tfEsJeruk, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cbEsCokelat)
                            .addComponent(jLabel31, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tfEsCokelat, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cbEsSusu)
                            .addComponent(jLabel32, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tfEsSusu, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cbEsCappucino)
                            .addComponent(jLabel33, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tfEsCappucino, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel36)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel37)
                                .addComponent(jLabel47)))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel38, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cbKopiHitam)
                            .addComponent(tfKopiHitam, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel41, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(cbkopiLuwak))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel39, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(cbCoklat)
                                    .addComponent(tfCoklat, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(tfKopiLuwak, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tfSusu, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(cbSusu)
                                .addComponent(jLabel40, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(cbCappucino)
                                .addComponent(jLabel42, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(tfCappucino))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel43, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(tfTehPanas, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(cbTehPanas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cbJerukPanas)
                            .addComponent(jLabel44, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tfJerukPanas, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cbTehSusu)
                            .addComponent(jLabel45, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tfTehSusu, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
        );

        jLabel50.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel50.setText("Pembayaran :");

        tfPembayaran.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        tfPembayaran.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tfPembayaranKeyReleased(evt);
            }
        });

        jLabel51.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel51.setText("Kembalian    :");

        lbKembalian.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        lbKembalian.setText("Rp.");

        lbPembayaran.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        lbPembayaran.setText("Rp.");

        btnBayar.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        btnBayar.setText("Bayar");
        btnBayar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBayarActionPerformed(evt);
            }
        });

        btn_exit.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        btn_exit.setText("Logout");
        btn_exit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_exitActionPerformed(evt);
            }
        });

        jButton1.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jButton1.setText("Detail");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel10.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel10.setText("Kode      :");

        id.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N

        pilihan1.setFont(new java.awt.Font("Tahoma", 0, 1)); // NOI18N
        pilihan1.setForeground(new java.awt.Color(240, 240, 240));
        pilihan1.setText("jLabel11");

        pilihan2.setFont(new java.awt.Font("Tahoma", 0, 1)); // NOI18N
        pilihan2.setForeground(new java.awt.Color(240, 240, 240));
        pilihan2.setText("jLabel9");

        jButton2.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jButton2.setText("Cetak");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jumlah.setFont(new java.awt.Font("Tahoma", 0, 1)); // NOI18N
        jumlah.setForeground(new java.awt.Color(240, 240, 240));
        jumlah.setText("jLabel9");

        pilihan3.setFont(new java.awt.Font("Tahoma", 0, 1)); // NOI18N
        pilihan3.setForeground(new java.awt.Color(240, 240, 240));
        pilihan3.setText("jLabel9");

        jumlah1.setFont(new java.awt.Font("Tahoma", 0, 1)); // NOI18N
        jumlah1.setForeground(new java.awt.Color(240, 240, 240));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(51, 51, 51)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tfNama, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(id, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(no_meja, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(89, 89, 89)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabel8)
                            .addComponent(jLabel7)
                            .addComponent(jLabel6))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(lbminuman, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 180, Short.MAX_VALUE)
                            .addComponent(lbmakanan, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lbTotal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(btnBayar)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jLabel51, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel50, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(lbKembalian, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(lbPembayaran)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(tfPembayaran)))
                            .addComponent(jButton2))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(266, 266, 266)
                                        .addComponent(pilihan3))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(427, 427, 427)
                                        .addComponent(jumlah1))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(pilihan1)
                                            .addComponent(pilihan2))
                                        .addGap(167, 167, 167)
                                        .addComponent(jumlah)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButton1)
                                .addGap(54, 54, 54)
                                .addComponent(btn_exit))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(85, 85, 85)
                                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addGap(50, 50, 50))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(id, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lbmakanan, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel50)
                        .addComponent(tfPembayaran, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lbPembayaran)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(lbminuman, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel51, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lbKembalian)
                    .addComponent(jLabel3)
                    .addComponent(tfNama))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel8)
                        .addComponent(lbTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel4)
                        .addComponent(no_meja))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnBayar)
                            .addComponent(jButton2))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(btn_exit)
                                .addGroup(layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(pilihan3))
                                    .addGap(13, 13, 13)))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(pilihan1)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(pilihan2))
                                    .addComponent(jumlah))
                                .addContainerGap())))
                    .addComponent(jumlah1, javax.swing.GroupLayout.Alignment.TRAILING)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void no_mejaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_no_mejaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_no_mejaActionPerformed

    private void tfEsCappucinoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfEsCappucinoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfEsCappucinoActionPerformed

    private void lbwaktuKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_lbwaktuKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_lbwaktuKeyReleased

    private void cbLalapanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbLalapanActionPerformed
        // TODO add your handling code here:
       if(cbLalapan.isSelected() == true){
            tflalapan.setEditable (true);
            tflalapan.setText("1");
            
            this.jmlLalapan = 1;
            
        }else {
            tflalapan.setEditable (false);
            tflalapan.setText("0");
            
            this.jmlLalapan = 0;
        }
        
        this.tampilMakanan();
    }//GEN-LAST:event_cbLalapanActionPerformed

    private void cbRamenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbRamenActionPerformed
        // TODO add your handling code here:
        if(cbRamen.isSelected() == true){
            tframen.setEditable (true);
            tframen.setText("1");
            
            this.jmlRamen = 1;
            
        }else {
            tframen.setEditable (false);
            tframen.setText("0");
            
            this.jmlRamen = 0;
        }
        
        this.tampilMakanan();
    }//GEN-LAST:event_cbRamenActionPerformed

    private void cbgadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbgadoActionPerformed
        // TODO add your handling code here:
        if(cbgado.isSelected() == true){
            tfgado.setEditable (true);
            tfgado.setText("1");
            
            this.jmlGado = 1;
            
        }else {
            tfgado.setEditable (false);
            tfgado.setText("0");
            
            this.jmlGado = 0;
        }
        
        this.tampilMakanan();
    }//GEN-LAST:event_cbgadoActionPerformed

    private void tfManggaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfManggaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfManggaActionPerformed

    private void cbEsCokelatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbEsCokelatActionPerformed
        // TODO add your handling code here:
        if(cbEsCokelat.isSelected() == true){
            tfEsCokelat.setEditable (true);
            tfEsCokelat.setText("1");
            
            this.jmlEsCokelat = 1;
            
        }else {
            tfEsCokelat.setEditable (false);
            tfEsCokelat.setText("0");
            
            this.jmlEsCokelat = 0;
        }
        
        this.tampilMinuman();
    }//GEN-LAST:event_cbEsCokelatActionPerformed

    private void cbkopiLuwakActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbkopiLuwakActionPerformed
        // TODO add your handling code here:
        if(cbkopiLuwak.isSelected() == true){
            tfKopiLuwak.setEditable (true);
            tfKopiLuwak.setText("1");
            
            this.jmlKopiLuwak = 1;
            
        }else {
            tfKopiLuwak.setEditable (false);
            tfKopiLuwak.setText("0");
            
            this.jmlKopiLuwak = 0;
        }
        
        this.tampilMinuman();
    }//GEN-LAST:event_cbkopiLuwakActionPerformed

    private void tflalapanKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tflalapanKeyReleased
        // TODO add your handling code here:
        int jml = Integer.parseInt(tflalapan.getText());
        int subTotal = jml * this.hargaLalapan;
        
        this.jmlLalapan = jml;
        
        lbmakanan.setText("" + subTotal);
        
        this.tampilMakanan();
    }//GEN-LAST:event_tflalapanKeyReleased

    private void cbNasgorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbNasgorActionPerformed
        // TODO add your handling code here:
        if(cbNasgor.isSelected() == true){
            tfnasgor.setEditable (true);
            tfnasgor.setText("1");
            
            this.jmlNasgor = 1;
            
        }else {
            tfnasgor.setEditable (false);
            tfnasgor.setText("0");
            
            this.jmlNasgor = 0;
        }
        
        this.tampilMakanan();
    }//GEN-LAST:event_cbNasgorActionPerformed

    private void cbpecelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbpecelActionPerformed
        // TODO add your handling code here:
        if(cbpecel.isSelected() == true){
            tfpecel.setEditable (true);
            tfpecel.setText("1");
            
            this.jmlPecel = 1;
            
        }else {
            tfpecel.setEditable (false);
            tfpecel.setText("0");
            
            this.jmlPecel = 0;
        }
        
        this.tampilMakanan();
    }//GEN-LAST:event_cbpecelActionPerformed

    private void cbrawonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbrawonActionPerformed
        // TODO add your handling code here:
        if(cbrawon.isSelected() == true){
            tfrawon.setEditable (true);
            tfrawon.setText("1");
            
            this.jmlRawon = 1;
            
        }else {
            tfrawon.setEditable (false);
            tfrawon.setText("0");
            
            this.jmlRawon = 0;
        }
        
        this.tampilMakanan();
    }//GEN-LAST:event_cbrawonActionPerformed

    private void cbayamActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbayamActionPerformed
        // TODO add your handling code here:
        if(cbayam.isSelected() == true){
            tfayam.setEditable (true);
            tfayam.setText("1");
            
            this.jmlAyam = 1;
            
        }else {
            tfayam.setEditable (false);
            tfayam.setText("0");
            
            this.jmlAyam = 0;
        }
        
        this.tampilMakanan();
    }//GEN-LAST:event_cbayamActionPerformed

    private void cbsateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbsateActionPerformed
        // TODO add your handling code here:
        if(cbsate.isSelected() == true){
            tfsate.setEditable (true);
            tfsate.setText("1");
            
            this.jmlSate = 1;
            
        }else {
            tfsate.setEditable (false);
            tfsate.setText("0");
            
            this.jmlSate = 0;
        }
        
        this.tampilMakanan();
    }//GEN-LAST:event_cbsateActionPerformed

    private void cbsotoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbsotoActionPerformed
        // TODO add your handling code here:
        if(cbsoto.isSelected() == true){
            tfsoto.setEditable (true);
            tfsoto.setText("1");
            
            this.jmlSoto = 1;
            
        }else {
            tfsoto.setEditable (false);
            tfsoto.setText("0");
            
            this.jmlSoto = 0;
        }
        
        this.tampilMakanan();
    }//GEN-LAST:event_cbsotoActionPerformed

    private void tflalapanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tflalapanActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tflalapanActionPerformed

    private void tfnasgorKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfnasgorKeyReleased
        // TODO add your handling code here:
        int jml = Integer.parseInt(tfnasgor.getText());
        int subTotal = jml * this.hargaNasgor;
        
        this.jmlNasgor = jml;
        
        lbmakanan.setText("" + subTotal);
        
        this.tampilMakanan();
    }//GEN-LAST:event_tfnasgorKeyReleased

    private void tframenKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tframenKeyReleased
        // TODO add your handling code here:
        int jml = Integer.parseInt(tframen.getText());
        int subTotal = jml * this.hargaRamen;
        
        this.jmlRamen = jml;
        
        lbmakanan.setText("" + subTotal);
        
        this.tampilMakanan();
    }//GEN-LAST:event_tframenKeyReleased

    private void tfpecelKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfpecelKeyReleased
        // TODO add your handling code here:
        int jml = Integer.parseInt(tfpecel.getText());
        int subTotal = jml * this.hargaPecel;
        
        this.jmlPecel = jml;
        
        lbmakanan.setText("" + subTotal);
        
        this.tampilMakanan();
    }//GEN-LAST:event_tfpecelKeyReleased

    private void tfgadoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfgadoKeyReleased
        // TODO add your handling code here:
        int jml = Integer.parseInt(tfgado.getText());
        int subTotal = jml * this.hargaGado;
        
        this.jmlGado = jml;
        
        lbmakanan.setText("" + subTotal);
        
        this.tampilMakanan();
    }//GEN-LAST:event_tfgadoKeyReleased

    private void cbApelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbApelActionPerformed
        // TODO add your handling code here:
        if(cbApel.isSelected() == true){
            tfApel.setEditable (true);
            tfApel.setText("1");
            
            this.jmlJusApel = 1;
            
        }else {
            tfApel.setEditable (false);
            tfApel.setText("0");
            
            this.jmlJusApel = 0;
        }
        
        this.tampilMinuman();
    }//GEN-LAST:event_cbApelActionPerformed

    private void tfApelKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfApelKeyReleased
        // TODO add your handling code here:
        int jml = Integer.parseInt(tfApel.getText());
        int subTotal = jml * this.hargaJusApel;
        
        this.jmlJusApel = jml;
        
        lbminuman.setText("" + subTotal);
        
        this.tampilMinuman();
    }//GEN-LAST:event_tfApelKeyReleased

    private void cbManggaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbManggaActionPerformed
        // TODO add your handling code here:
        if(cbMangga.isSelected() == true){
            tfMangga.setEditable (true);
            tfMangga.setText("1");
            
            this.jmlJusMangga = 1;
            
        }else {
            tfMangga.setEditable (false);
            tfMangga.setText("0");
            
            this.jmlJusMangga = 0;
        }
        
        this.tampilMinuman();
    }//GEN-LAST:event_cbManggaActionPerformed

    private void cbKopiHitamActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbKopiHitamActionPerformed
        // TODO add your handling code here:
        if(cbKopiHitam.isSelected() == true){
            tfKopiHitam.setEditable (true);
            tfKopiHitam.setText("1");
            
            this.jmlKopiHitam = 1;
            
        }else {
            tfKopiHitam.setEditable (false);
            tfKopiHitam.setText("0");
            
            this.jmlKopiHitam = 0;
        }
        
        this.tampilMinuman();
    }//GEN-LAST:event_cbKopiHitamActionPerformed

    private void tfManggaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfManggaKeyReleased
        // TODO add your handling code here:
         int jml = Integer.parseInt(tfMangga.getText());
        int subTotal = jml * this.hargaJusMangga;
        
        this.jmlJusMangga = jml;
        
        lbminuman.setText("" + subTotal);
        
        this.tampilMinuman();
    }//GEN-LAST:event_tfManggaKeyReleased

    private void tfKopiHitamKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfKopiHitamKeyReleased
        // TODO add your handling code here:
         int jml = Integer.parseInt(tfKopiHitam.getText());
        int subTotal = jml * this.hargaKopiHitam;
        
        this.jmlKopiHitam = jml;
        
        lbminuman.setText("" + subTotal);
        
        this.tampilMinuman();
    }//GEN-LAST:event_tfKopiHitamKeyReleased

    private void tfKopiLuwakKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfKopiLuwakKeyReleased
        // TODO add your handling code here:
         int jml = Integer.parseInt(tfKopiLuwak.getText());
        int subTotal = jml * this.hargaKopiLuwak;
        
        this.jmlKopiLuwak = jml;
        
        lbminuman.setText("" + subTotal);
        
        this.tampilMinuman();
    }//GEN-LAST:event_tfKopiLuwakKeyReleased

    private void tfrawonKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfrawonKeyReleased
        // TODO add your handling code here:
        int jml = Integer.parseInt(tfrawon.getText());
        int subTotal = jml * this.hargaRawon;
        
        this.jmlRawon = jml;
        
        lbmakanan.setText("" + subTotal);
        
        this.tampilMakanan();
    }//GEN-LAST:event_tfrawonKeyReleased

    private void btn_exitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_exitActionPerformed
        // TODO add your handling code here:
        int selectOption = JOptionPane.showConfirmDialog(null, "Apakah anda ingin kembali?", "Kembali", JOptionPane.YES_NO_OPTION);
        
        if (selectOption == JOptionPane.YES_OPTION) {
            login l = new login();
            l.setVisible(true);
            
            this.dispose();
        }
    }//GEN-LAST:event_btn_exitActionPerformed

    private void tfayamKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfayamKeyReleased
        // TODO add your handling code here:
        int jml = Integer.parseInt(tfayam.getText());
        int subTotal = jml * this.hargaAyam;
        
        this.jmlAyam = jml;
        
        lbmakanan.setText("" + subTotal);
        
        this.tampilMakanan();
    }//GEN-LAST:event_tfayamKeyReleased

    private void tfsateKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfsateKeyReleased
        // TODO add your handling code here:
        int jml = Integer.parseInt(tfsate.getText());
        int subTotal = jml * this.hargaSate;
        
        this.jmlSate = jml;
        
        lbmakanan.setText("" + subTotal);
        
        this.tampilMakanan();
    }//GEN-LAST:event_tfsateKeyReleased

    private void tfsotoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfsotoKeyReleased
        // TODO add your handling code here:
        int jml = Integer.parseInt(tfsoto.getText());
        int subTotal = jml * this.hargaSoto;
        
        this.jmlSoto = jml;
        
        lbmakanan.setText("" + subTotal);
        
        this.tampilMakanan();
    }//GEN-LAST:event_tfsotoKeyReleased

    private void cbAlpukatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbAlpukatActionPerformed
        // TODO add your handling code here:
        if(cbAlpukat.isSelected() == true){
            tfAlpukat.setEditable (true);
            tfAlpukat.setText("1");
            
            this.jmlJusAlpukat = 1;
            
        }else {
            tfAlpukat.setEditable (false);
            tfAlpukat.setText("0");
            
            this.jmlJusAlpukat = 0;
        }
        
        this.tampilMinuman();
    }//GEN-LAST:event_cbAlpukatActionPerformed

    private void cbEsTehActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbEsTehActionPerformed
        // TODO add your handling code here:
        if(cbEsTeh.isSelected() == true){
            tfEsTeh.setEditable (true);
            tfEsTeh.setText("1");
            
            this.jmlEsTeh = 1;
            
        }else {
            tfEsTeh.setEditable (false);
            tfEsTeh.setText("0");
            
            this.jmlEsTeh = 0;
        }
        
        this.tampilMinuman();
    }//GEN-LAST:event_cbEsTehActionPerformed

    private void tfEsTehActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfEsTehActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfEsTehActionPerformed

    private void cbEsJerukActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbEsJerukActionPerformed
        // TODO add your handling code here:
        if(cbEsJeruk.isSelected() == true){
            tfEsJeruk.setEditable (true);
            tfEsJeruk.setText("1");
            
            this.jmlEsJeruk = 1;
            
        }else {
            tfEsJeruk.setEditable (false);
            tfEsJeruk.setText("0");
            
            this.jmlEsJeruk = 0;
        }
        
        this.tampilMinuman();
    }//GEN-LAST:event_cbEsJerukActionPerformed

    private void cbEsSusuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbEsSusuActionPerformed
        // TODO add your handling code here:
        if(cbEsSusu.isSelected() == true){
            tfEsSusu.setEditable (true);
            tfEsSusu.setText("1");
            
            this.jmlEsSusu = 1;
            
        }else {
            tfEsSusu.setEditable (false);
            tfEsSusu.setText("0");
            
            this.jmlEsSusu = 0;
        }
        
        this.tampilMinuman();
    }//GEN-LAST:event_cbEsSusuActionPerformed

    private void cbEsCappucinoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbEsCappucinoActionPerformed
        // TODO add your handling code here:
        if(cbEsCappucino.isSelected() == true){
            tfEsCappucino.setEditable (true);
            tfEsCappucino.setText("1");
            
            this.jmlEsCappucino = 1;
            
        }else {
            tfEsCappucino.setEditable (false);
            tfEsCappucino.setText("0");
            
            this.jmlEsCappucino = 0;
        }
        
        this.tampilMinuman();
    }//GEN-LAST:event_cbEsCappucinoActionPerformed

    private void tfPembayaranKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfPembayaranKeyReleased
        // TODO add your handling code here:
        bayar = Integer.parseInt(tfPembayaran.getText());
        this.kembalian();
        
    }//GEN-LAST:event_tfPembayaranKeyReleased

    private void btnBayarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBayarActionPerformed
        // TODO add your handling code here:
        
                    Calendar kal = new GregorianCalendar();
                    int tahun = kal.get(Calendar.YEAR);
                    int bulan = kal.get(Calendar.MONTH)+1;
                    int hari = kal.get(Calendar.DAY_OF_MONTH);
                    int jam = kal.get(Calendar.HOUR_OF_DAY);
                    int menit = kal.get(Calendar.MINUTE);
                    int detik = kal.get(Calendar.SECOND);
                    String kode = bulan+""+tahun+""+jam+""+menit+""+detik;
                    id.setText(kode);
                    
        String nama_makanan;
        nama_makanan = "";
        String harga_makanan;
        harga_makanan = "";
        String nama_minuman;
        nama_minuman = "";
        String harga_minuman;
        harga_minuman = "";
        String nama_minuman2;
        nama_minuman2 = "";
        
        int jumlah_makanan = jmlLalapan+jmlNasgor+jmlRamen+jmlPecel+jmlGado+jmlRawon+jmlAyam+jmlSate+jmlSoto;
        jumlah.setText(""+jumlah_makanan);
        
        int jumlah_minuman = jmlJusApel+jmlEsCappucino+jmlEsSusu+jmlEsCokelat+jmlEsJeruk+jmlEsTeh+jmlJusMangga+jmlJusAlpukat+jmlKopiHitam+jmlKopiLuwak+jmlCoklat+jmlSusu+jmlCappucino+jmlTehPanas+jmlJerukPanas+jmlTehSusu;
        jumlah1.setText(""+jumlah_minuman);
        
        if(cbLalapan.isSelected()){
            nama_makanan += cbLalapan.getText() + ", ";
        }
        if(cbNasgor.isSelected()){
            nama_makanan += cbNasgor.getText() + ", ";
        }
        if(cbRamen.isSelected()){
            nama_makanan += cbRamen.getText() + ", ";
        }
        if(cbpecel.isSelected()){
            nama_makanan += cbpecel.getText() + ", ";
        }
        if(cbgado.isSelected()){
            nama_makanan += cbgado.getText() + ", ";
        }
        if(cbrawon.isSelected()){
            nama_makanan += cbrawon.getText() + ", ";
        }
        if(cbayam.isSelected()){
            nama_makanan += cbayam.getText() + ", ";
        }
        if(cbsate.isSelected()){
            nama_makanan += cbsate.getText() + ", ";
        }
        if(cbsoto.isSelected()){
            nama_makanan += cbsoto.getText() + ", ";
        }
        else{
            nama_makanan = nama_makanan.substring(0,nama_makanan.length()-2)+".";
        }
        pilihan1.setText(nama_makanan);
        
        if(cbApel.isSelected()){
            nama_minuman += cbApel.getText() + ", ";
        }
        if(cbMangga.isSelected()){
            nama_minuman += cbMangga.getText() + ", ";
        }
        if(cbAlpukat.isSelected()){
            nama_minuman += cbAlpukat.getText() + ", ";
        }
        if(cbEsTeh.isSelected()){
            nama_minuman += cbEsTeh.getText() + ", ";
        }
        if(cbEsJeruk.isSelected()){
            nama_minuman += cbEsJeruk.getText() + ", ";
        }
        if(cbEsCokelat.isSelected()){
            nama_minuman += cbEsCokelat.getText() + ", ";
        }
        if(cbEsSusu.isSelected()){
            nama_minuman += cbEsSusu.getText() + ", ";
        }
        if(cbEsCappucino.isSelected()){
            nama_minuman += cbEsCappucino.getText() + ", ";
        }
        else{
            nama_minuman = nama_minuman.substring(0,nama_minuman.length()-2)+".";
        }
        pilihan2.setText(nama_minuman);
        
        if(cbKopiHitam.isSelected()){
            nama_minuman2 += cbKopiHitam.getText() + ", ";
        }
        if(cbkopiLuwak.isSelected()){
            nama_minuman2 += cbkopiLuwak.getText() + ", ";
        }
        if(cbCoklat.isSelected()){
            nama_minuman2 += cbCoklat.getText() + ", ";
        }
        if(cbSusu.isSelected()){
            nama_minuman2 += cbSusu.getText() + ", ";
        }
        if(cbCappucino.isSelected()){
            nama_minuman2 += cbCappucino.getText() + ", ";
        }
        if(cbTehPanas.isSelected()){
            nama_minuman2 += cbTehPanas.getText() + ", ";
        }
        if(cbJerukPanas.isSelected()){
            nama_minuman2 += cbJerukPanas.getText() + ", ";
        }
        if(cbTehSusu.isSelected()){
            nama_minuman2 += cbTehSusu.getText() + ", ";
        }
       
        pilihan3.setText(nama_minuman2);
        
        
        try{
            String query = "INSERT INTO menu VALUES('"
                    +id.getText()+"', '"
                    +tfNama.getText()+"', '"
                    +lbwaktu.getText()+"', '"
                    +pilihan1.getText()+"', '"
                    +lbmakanan.getText()+"', '"
                    +pilihan2.getText()+"', '"
                    +lbminuman.getText()+"', '"
                    +lbTotal.getText()+"'); ";
            stm.executeUpdate(query);
            
            JOptionPane.showMessageDialog(null, "Berhasil");
            
            Document doc = new Document();
            try {
                PdfWriter.getInstance(doc, new FileOutputStream("Report.pdf"));
            } catch (FileNotFoundException ex) {
                Logger.getLogger(kasir.class.getName()).log(Level.SEVERE, null, ex);
            }
            doc.open();
            doc.add(new Paragraph("                                          Restaurant Legend"));
            doc.add(new Paragraph("                                      Jl. Code-ink no 45, Malang"));
            doc.add(new Paragraph("                                      Tanggal : "+lbwaktu.getText()));
            doc.add(new Paragraph("                                           Bukti Pembayaran"));
            doc.add(new Paragraph("                                      ====================="));
            doc.add(new Paragraph("                          ================================="));
            doc.add(new Paragraph("                          Kode                       : "+id.getText()));
            doc.add(new Paragraph("                          Nama                      : "+tfNama.getText()));
            doc.add(new Paragraph("                          No Meja                  : "+no_meja.getSelectedItem().toString()));
            doc.add(new Paragraph("                          ================================="));
            doc.add(new Paragraph("                          Nama Makanan      : "+pilihan1.getText()));
            doc.add(new Paragraph("                          Jumlah Makanan    : "+jumlah.getText()));
            doc.add(new Paragraph("                          Nama Minuman      : "+pilihan2.getText()+""+pilihan3.getText()));
            doc.add(new Paragraph("                          Jumlah Minuman    : "+jumlah1.getText()));
            doc.add(new Paragraph("                          Total Makanan        : "+lbmakanan.getText()));
            doc.add(new Paragraph("                          Total Minuman        : "+lbminuman.getText()));
            doc.add(new Paragraph("                          ================================="));
            doc.add(new Paragraph("                          Harga Total             : "+lbTotal.getText()));
            doc.add(new Paragraph("                          Bayar                      : "+tfPembayaran.getText()));
            doc.add(new Paragraph("                          Kembalian               : "+lbKembalian.getText()));
            doc.add(new Paragraph("                          ================================="));
            doc.add(new Paragraph("                                      ====================="));
            doc.add(new Paragraph("                               Terimakasih Atas Kunjungan Anda     "));
            doc.close();
            
            tfNama.setText("");
            tfPembayaran.setText("");
            lbKembalian.setText("Rp. ");
            lbmakanan.setText("Rp. ");
            lbminuman.setText("Rp. "); 
            lbTotal.setText("");
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, "Gagal : " + e);
        }
    }//GEN-LAST:event_btnBayarActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        int selectOption = JOptionPane.showConfirmDialog(null, "Apakah anda ingin melihat detail?", "Detail", JOptionPane.YES_NO_OPTION);
        
        if (selectOption == JOptionPane.YES_OPTION) {
            new data_pelanggan().show();
            this.setVisible(false);
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void cbCappucinoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbCappucinoActionPerformed
        // TODO add your handling code here:
        if(cbCappucino.isSelected() == true){
            tfCappucino.setEditable (true);
            tfCappucino.setText("1");
            
            this.jmlCappucino = 1;
            
        }else {
            tfCappucino.setEditable (false);
            tfCappucino.setText("0");
            
            this.jmlCappucino = 0;
        }
        
        this.tampilMinuman();
    }//GEN-LAST:event_cbCappucinoActionPerformed

    private void cbCoklatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbCoklatActionPerformed
        // TODO add your handling code here:
        if(cbCoklat.isSelected() == true){
            tfCoklat.setEditable (true);
            tfCoklat.setText("1");
            
            this.jmlCoklat = 1;
            
        }else {
            tfCoklat.setEditable (false);
            tfCoklat.setText("0");
            
            this.jmlCoklat = 0;
        }
        
        this.tampilMinuman();
    }//GEN-LAST:event_cbCoklatActionPerformed

    private void tfCoklatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfCoklatActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfCoklatActionPerformed

    private void cbSusuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbSusuActionPerformed
        // TODO add your handling code here:
        if(cbSusu.isSelected() == true){
            tfSusu.setEditable (true);
            tfSusu.setText("1");
            
            this.jmlSusu = 1;
            
        }else {
            tfSusu.setEditable (false);
            tfSusu.setText("0");
            
            this.jmlSusu = 0;
        }
        
        this.tampilMinuman();
    }//GEN-LAST:event_cbSusuActionPerformed

    private void cbTehPanasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbTehPanasActionPerformed
        // TODO add your handling code here:
        if(cbTehPanas.isSelected() == true){
            tfTehPanas.setEditable (true);
            tfTehPanas.setText("1");
            
            this.jmlTehPanas = 1;
            
        }else {
            tfTehPanas.setEditable (false);
            tfTehPanas.setText("0");
            
            this.jmlTehPanas = 0;
        }
        
        this.tampilMinuman();
    }//GEN-LAST:event_cbTehPanasActionPerformed

    private void cbJerukPanasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbJerukPanasActionPerformed
        // TODO add your handling code here:
        if(cbJerukPanas.isSelected() == true){
            tfJerukPanas.setEditable (true);
            tfJerukPanas.setText("1");
            
            this.jmlJerukPanas = 1;
            
        }else {
            tfJerukPanas.setEditable (false);
            tfJerukPanas.setText("0");
            
            this.jmlJerukPanas = 0;
        }
        
        this.tampilMinuman();
    }//GEN-LAST:event_cbJerukPanasActionPerformed

    private void cbTehSusuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbTehSusuActionPerformed
        // TODO add your handling code here:
        if(cbTehSusu.isSelected() == true){
            tfTehSusu.setEditable (true);
            tfTehSusu.setText("1");
            
            this.jmlTehSusu = 1;
            
        }else {
            tfTehSusu.setEditable (false);
            tfTehSusu.setText("0");
            
            this.jmlTehSusu = 0;
        }
        
        this.tampilMinuman();
    }//GEN-LAST:event_cbTehSusuActionPerformed
    private pstatic class openpdf {

            public openpdf() {
                
            }

        private void setVisible(boolean b) {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }
    }
    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        try {
            Runtime.getRuntime().exec("rundll32 url.dll,FileProtocolHandler " + "E:\\NetBeansProject\\Restaurant\\Report.pdf");
        } catch (Exception ex) {
            Logger.getLogger(openpdf.class.getName()).log(Level.SEVERE,null,ex);
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(kasir.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(kasir.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(kasir.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(kasir.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new login().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBayar;
    private javax.swing.JButton btn_exit;
    private javax.swing.JCheckBox cbAlpukat;
    private javax.swing.JCheckBox cbApel;
    private javax.swing.JCheckBox cbCappucino;
    private javax.swing.JCheckBox cbCoklat;
    private javax.swing.JCheckBox cbEsCappucino;
    private javax.swing.JCheckBox cbEsCokelat;
    private javax.swing.JCheckBox cbEsJeruk;
    private javax.swing.JCheckBox cbEsSusu;
    private javax.swing.JCheckBox cbEsTeh;
    private javax.swing.JCheckBox cbJerukPanas;
    private javax.swing.JCheckBox cbKopiHitam;
    private javax.swing.JCheckBox cbLalapan;
    private javax.swing.JCheckBox cbMangga;
    private javax.swing.JCheckBox cbNasgor;
    private javax.swing.JCheckBox cbRamen;
    private javax.swing.JCheckBox cbSusu;
    private javax.swing.JCheckBox cbTehPanas;
    private javax.swing.JCheckBox cbTehSusu;
    private javax.swing.JCheckBox cbayam;
    private javax.swing.JCheckBox cbgado;
    private javax.swing.JCheckBox cbkopiLuwak;
    private javax.swing.JCheckBox cbpecel;
    private javax.swing.JCheckBox cbrawon;
    private javax.swing.JCheckBox cbsate;
    private javax.swing.JCheckBox cbsoto;
    private javax.swing.JLabel id;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel43;
    private javax.swing.JLabel jLabel44;
    private javax.swing.JLabel jLabel45;
    private javax.swing.JLabel jLabel47;
    private javax.swing.JLabel jLabel48;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel50;
    private javax.swing.JLabel jLabel51;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JLabel jumlah;
    private javax.swing.JLabel jumlah1;
    private javax.swing.JLabel lbKembalian;
    private javax.swing.JLabel lbPembayaran;
    private javax.swing.JLabel lbTotal;
    private javax.swing.JLabel lbmakanan;
    private javax.swing.JLabel lbminuman;
    private javax.swing.JLabel lbwaktu;
    private javax.swing.JLabel m1;
    private javax.swing.JLabel m2;
    private javax.swing.JLabel m3;
    private javax.swing.JLabel m4;
    private javax.swing.JLabel m5;
    private javax.swing.JLabel m6;
    private javax.swing.JLabel m7;
    private javax.swing.JLabel m8;
    private javax.swing.JLabel m9;
    private javax.swing.JComboBox<String> no_meja;
    private javax.swing.JLabel pilihan1;
    private javax.swing.JLabel pilihan2;
    private javax.swing.JLabel pilihan3;
    private javax.swing.JTextField tfAlpukat;
    private javax.swing.JTextField tfApel;
    private javax.swing.JTextField tfCappucino;
    private javax.swing.JTextField tfCoklat;
    private javax.swing.JTextField tfEsCappucino;
    private javax.swing.JTextField tfEsCokelat;
    private javax.swing.JTextField tfEsJeruk;
    private javax.swing.JTextField tfEsSusu;
    private javax.swing.JTextField tfEsTeh;
    private javax.swing.JTextField tfJerukPanas;
    private javax.swing.JTextField tfKopiHitam;
    private javax.swing.JTextField tfKopiLuwak;
    private javax.swing.JTextField tfMangga;
    private javax.swing.JTextField tfNama;
    private javax.swing.JTextField tfPembayaran;
    private javax.swing.JTextField tfSusu;
    private javax.swing.JTextField tfTehPanas;
    private javax.swing.JTextField tfTehSusu;
    private javax.swing.JTextField tfayam;
    private javax.swing.JTextField tfgado;
    private javax.swing.JTextField tflalapan;
    private javax.swing.JTextField tfnasgor;
    private javax.swing.JTextField tfpecel;
    private javax.swing.JTextField tframen;
    private javax.swing.JTextField tfrawon;
    private javax.swing.JTextField tfsate;
    private javax.swing.JTextField tfsoto;
    // End of variables declaration//GEN-END:variables
}
