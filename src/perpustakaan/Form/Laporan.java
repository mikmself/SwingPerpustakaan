package perpustakaan.Form;
import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTextArea;

public class Laporan extends javax.swing.JFrame {
    public Laporan() {
        initComponents();
        updateLaporan();
    }
    private void updateLaporan() {
        try {
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/perpustakaan", "root", "");
            PreparedStatement bukuStmt = conn.prepareStatement("SELECT COUNT(*) FROM buku");
            ResultSet bukuResult = bukuStmt.executeQuery();
            bukuResult.next();
            int jumlahBuku = bukuResult.getInt(1);
            PreparedStatement pegawaiStmt = conn.prepareStatement("SELECT COUNT(*) FROM pegawai");
            ResultSet pegawaiResult = pegawaiStmt.executeQuery();
            pegawaiResult.next();
            int jumlahPegawai = pegawaiResult.getInt(1);
            PreparedStatement mahasiswaStmt = conn.prepareStatement("SELECT COUNT(*) FROM mahasiswa");
            ResultSet mahasiswaResult = mahasiswaStmt.executeQuery();
            mahasiswaResult.next();
            int jumlahMahasiswa = mahasiswaResult.getInt(1);
            PreparedStatement peminjamanStmt = conn.prepareStatement("SELECT COUNT(*) FROM peminjaman");
            ResultSet peminjamanResult = peminjamanStmt.executeQuery();
            peminjamanResult.next();
            int jumlahPeminjaman = peminjamanResult.getInt(1);
            PreparedStatement pengembalianStmt = conn.prepareStatement("SELECT COUNT(*) FROM pengembalian");
            ResultSet pengembalianResult = pengembalianStmt.executeQuery();
            pengembalianResult.next();
            int jumlahPengembalian = pengembalianResult.getInt(1);
            txtLaporan.setText( "LAPORAN PERPUSTAKAAN LULULUCU" + System.lineSeparator()
                    + System.lineSeparator()
                    + "Jumlah Buku: " + jumlahBuku + System.lineSeparator()
                    + "Jumlah Pegawai: " + jumlahPegawai + System.lineSeparator()
                    + "Jumlah Mahasiswa: " + jumlahMahasiswa + System.lineSeparator()
                    + "Jumlah Peminjaman: " + jumlahPeminjaman + System.lineSeparator()
                    + "Jumlah Pengembalian: " + jumlahPengembalian);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        txtLaporan = new javax.swing.JTextArea();
        btnPdf = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        txtLaporan.setColumns(20);
        txtLaporan.setRows(5);
        jScrollPane1.setViewportView(txtLaporan);

        btnPdf.setText("Cetak PDF");
        btnPdf.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPdfActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel1.setText("Laporan Perpustakaan LULULUCU");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 865, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnPdf, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(300, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addComponent(jLabel1)
                .addGap(31, 31, 31)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 401, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnPdf)
                .addContainerGap(46, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnPdfActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPdfActionPerformed
        try {                                       
            Document doc = new Document();
            try {
                PdfWriter.getInstance(doc, new FileOutputStream("laporan.pdf"));
            } catch (DocumentException ex) {
                Logger.getLogger(Laporan.class.getName()).log(Level.SEVERE, null, ex);
            }
            doc.open();
            doc.add(new Paragraph(txtLaporan.getText()));
            doc.close();
        } catch (DocumentException ex) {
            Logger.getLogger(Laporan.class.getName()).log(Level.SEVERE, null, ex);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Laporan.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnPdfActionPerformed
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Laporan().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnPdf;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea txtLaporan;
    // End of variables declaration//GEN-END:variables
}

