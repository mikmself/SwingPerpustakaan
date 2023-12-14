package perpustakaan.Form;

import com.toedter.calendar.JDateChooser;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;
import perpustakaan.CRUD;

public class Pengembalian extends javax.swing.JFrame {
    CRUD peminjaman = new CRUD();
    String status = "";
    public Pengembalian() {
        initComponents();
        peminjaman.koneksi();
        TampilPengembalian();
    }
    public void TampilPengembalian(){
        String namaTable = "pengembalian";
        String daftarField[]  = {
            "id_pengembalian",
            "tanggal_pengembalian",            
            "denda",
            "id_buku",
            "nim_mahasiswa",
            "id_pegawai"
        };
        String judulKolom[] = {
            "ID",
            "Tanggal Pengembalian",            
            "Denda",
            "ID Buku",
            "Nim Mahasiswa",
            "ID Pegawai"
        };
        tablePengembalian.setModel(peminjaman.TampilData(namaTable, daftarField, judulKolom));
    }
     public void TambahPengembalian() {
        Date selectedDate = txtTanggal.getDate();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String formattedDate = dateFormat.format(selectedDate);
        int idBuku = -1;         
        int nimMahasiswa = -1; 
        int idPegawai = -1;
//        Buku
        try {
            String judulBuku = txtBuku.getSelectedItem().toString();
            Buku_1 buku = Buku_1.findByJudulBuku(judulBuku);
            if (buku != null) {
                idBuku = buku.getIdBuku();
            } else {
                idBuku = -1;
            }
        } catch (SQLException e) {
            e.printStackTrace(); 
            return;
        }
//        Mahasiswa
        try {
            String namaMahasiswa = txtMahasiswa.getSelectedItem().toString();
            Mahasiswa_1 mahasiswa = Mahasiswa_1.findByNamaMahasiswa(namaMahasiswa);
            if (mahasiswa != null) {
                nimMahasiswa = mahasiswa.getNimMahasiswa();
            } else {
                nimMahasiswa = -1;
            }
        } catch (SQLException e) {
            e.printStackTrace(); 
            return;
        }
//        Pegawai
        try {
            String namaPegawai = txtPegawai.getSelectedItem().toString();
            Pegawai_1 pegawai = Pegawai_1.findByNamaPegawai(namaPegawai);
            if (pegawai != null) {
                idPegawai = pegawai.getIdPegawai();
            } else {
                idPegawai = -1;
            }
        } catch (SQLException e) {
            e.printStackTrace(); 
            return;
        }
        
        String status = peminjaman.tambah("pengembalian", "id_pengembalian,tanggal_pengembalian,denda,id_buku,nim_mahasiswa,id_pegawai",
                "'" + txtId.getText() + "'," +
                "'" + formattedDate + "'," +
                "'" + txtDenda.getText() + "'," +
                "'" + idBuku + "'," +
                "'" + nimMahasiswa + "'," +
                "'" + idPegawai + "'"
        );
        JOptionPane.showMessageDialog(null, status);
        TampilPengembalian();
        kosongkan();
    }
     public void kosongkan(){
        JDateChooser txtTanggal = new JDateChooser();
        txtId.setText("");
        txtTanggal.setDate(new java.util.Date());
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        bindingGroup = new org.jdesktop.beansbinding.BindingGroup();

        entityManager = java.beans.Beans.isDesignTime() ? null : javax.persistence.Persistence.createEntityManagerFactory("perpustakaan?zeroDateTimeBehavior=convertToNullPU").createEntityManager();
        buku_1Query = java.beans.Beans.isDesignTime() ? null : entityManager.createQuery("SELECT b FROM Buku_1 b");
        buku_1List = java.beans.Beans.isDesignTime() ? java.util.Collections.emptyList() : buku_1Query.getResultList();
        mahasiswa_1Query = java.beans.Beans.isDesignTime() ? null : entityManager.createQuery("SELECT m FROM Mahasiswa_1 m");
        mahasiswa_1List = java.beans.Beans.isDesignTime() ? java.util.Collections.emptyList() : mahasiswa_1Query.getResultList();
        pegawai_1Query = java.beans.Beans.isDesignTime() ? null : entityManager.createQuery("SELECT p FROM Pegawai_1 p");
        pegawai_1List = java.beans.Beans.isDesignTime() ? java.util.Collections.emptyList() : pegawai_1Query.getResultList();
        labelId = new javax.swing.JLabel();
        txtId = new javax.swing.JTextField();
        labelTanggal = new javax.swing.JLabel();
        txtTanggal = new com.toedter.calendar.JDateChooser();
        labelBuku = new javax.swing.JLabel();
        labelMahasiswa = new javax.swing.JLabel();
        labelPegawai = new javax.swing.JLabel();
        btnTambah = new javax.swing.JButton();
        txtBuku = new javax.swing.JComboBox<>();
        txtMahasiswa = new javax.swing.JComboBox<>();
        txtPegawai = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablePengembalian = new javax.swing.JTable();
        labelDenda = new javax.swing.JLabel();
        txtDenda = new javax.swing.JTextField();
        btnKembali = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        labelId.setText("ID");

        labelTanggal.setText("Tanggal Pengembalian");

        labelBuku.setText("Buku");

        labelMahasiswa.setText("Mahasiswa");

        labelPegawai.setText("Pegawai");

        btnTambah.setText("Tambah");
        btnTambah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTambahActionPerformed(evt);
            }
        });

        org.jdesktop.swingbinding.JComboBoxBinding jComboBoxBinding = org.jdesktop.swingbinding.SwingBindings.createJComboBoxBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, buku_1List, txtBuku);
        bindingGroup.addBinding(jComboBoxBinding);

        jComboBoxBinding = org.jdesktop.swingbinding.SwingBindings.createJComboBoxBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, mahasiswa_1List, txtMahasiswa);
        bindingGroup.addBinding(jComboBoxBinding);

        jComboBoxBinding = org.jdesktop.swingbinding.SwingBindings.createJComboBoxBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, pegawai_1List, txtPegawai);
        bindingGroup.addBinding(jComboBoxBinding);

        tablePengembalian.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(tablePengembalian);

        labelDenda.setText("Denda");

        txtDenda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDendaActionPerformed(evt);
            }
        });

        btnKembali.setText("Kembali");
        btnKembali.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnKembaliActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(labelTanggal)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(labelBuku)
                            .addComponent(labelMahasiswa)
                            .addComponent(labelPegawai)
                            .addComponent(labelDenda)
                            .addComponent(labelId)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnTambah)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnKembali)))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(txtMahasiswa, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtBuku, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtId, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtTanggal, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 282, Short.MAX_VALUE)
                    .addComponent(txtDenda, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtPegawai, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 464, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 343, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(labelId)
                            .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(txtTanggal, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txtDenda, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(labelDenda))
                                .addGap(7, 7, 7))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(16, 16, 16)
                                .addComponent(labelTanggal)
                                .addGap(5, 5, 5)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtBuku, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(labelBuku))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtMahasiswa, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(labelMahasiswa))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtPegawai, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(labelPegawai))
                        .addGap(17, 17, 17)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnTambah)
                            .addComponent(btnKembali))))
                .addContainerGap(273, Short.MAX_VALUE))
        );

        bindingGroup.bind();

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnTambahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTambahActionPerformed
        TambahPengembalian();
    }//GEN-LAST:event_btnTambahActionPerformed

    private void btnKembaliActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnKembaliActionPerformed
        this.dispose();
        Menu menu = new Menu();
        menu.setVisible(true);
    }//GEN-LAST:event_btnKembaliActionPerformed

    private void txtDendaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDendaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDendaActionPerformed
    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Pengembalian.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Pengembalian.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Pengembalian.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Pengembalian.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Pengembalian().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnKembali;
    private javax.swing.JButton btnTambah;
    private java.util.List<perpustakaan.Form.Buku_1> buku_1List;
    private javax.persistence.Query buku_1Query;
    private javax.persistence.EntityManager entityManager;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel labelBuku;
    private javax.swing.JLabel labelDenda;
    private javax.swing.JLabel labelId;
    private javax.swing.JLabel labelMahasiswa;
    private javax.swing.JLabel labelPegawai;
    private javax.swing.JLabel labelTanggal;
    private java.util.List<perpustakaan.Form.Mahasiswa_1> mahasiswa_1List;
    private javax.persistence.Query mahasiswa_1Query;
    private java.util.List<perpustakaan.Form.Pegawai_1> pegawai_1List;
    private javax.persistence.Query pegawai_1Query;
    private javax.swing.JTable tablePengembalian;
    private javax.swing.JComboBox<String> txtBuku;
    private javax.swing.JTextField txtDenda;
    private javax.swing.JTextField txtId;
    private javax.swing.JComboBox<String> txtMahasiswa;
    private javax.swing.JComboBox<String> txtPegawai;
    private com.toedter.calendar.JDateChooser txtTanggal;
    private org.jdesktop.beansbinding.BindingGroup bindingGroup;
    // End of variables declaration//GEN-END:variables
}
