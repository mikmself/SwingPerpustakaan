package perpustakaan.Form;
import com.toedter.calendar.JDateChooser;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import perpustakaan.CRUD;
public class Peminjaman extends javax.swing.JFrame {
    CRUD peminjaman = new CRUD();
    String status = "";
    public Peminjaman() {
        initComponents();
        peminjaman.koneksi();
        TampilPeminjaman();
    }
    public void TampilPeminjaman(){
        String namaTable = "peminjaman";
        String daftarField[]  = {
            "id_peminjaman",
            "tanggal_peminjaman",
            "id_buku",
            "nim_mahasiswa",
            "id_pegawai"
        };
        String judulKolom[] = {
            "ID",
            "Tanggal Peminjaman",
            "ID Buku",
            "Nim Mahasiswa",
            "ID Pegawai"
        };
        tablePeminjaman.setModel(peminjaman.TampilData(namaTable, daftarField, judulKolom));
    }
    public void TambahPeminjaman() {
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
        
        String status = peminjaman.tambah("peminjaman", "id_peminjaman,tanggal_peminjaman,id_buku,nim_mahasiswa,id_pegawai",
                "'" + txtId.getText() + "'," +
                "'" + formattedDate + "'," +
                "'" + idBuku + "'," +
                "'" + nimMahasiswa + "'," +
                "'" + idPegawai + "'"
        );
        JOptionPane.showMessageDialog(null, status);
        TampilPeminjaman();
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
        pegawai_1Query1 = java.beans.Beans.isDesignTime() ? null : entityManager.createQuery("SELECT p FROM Pegawai_1 p");
        pegawai_1List1 = java.beans.Beans.isDesignTime() ? java.util.Collections.emptyList() : pegawai_1Query1.getResultList();
        entityManager0 = java.beans.Beans.isDesignTime() ? null : javax.persistence.Persistence.createEntityManagerFactory("weddingnesiadb?zeroDateTimeBehavior=convertToNullPU").createEntityManager();
        usersQuery = java.beans.Beans.isDesignTime() ? null : entityManager0.createQuery("SELECT u FROM Users u");
        usersList = java.beans.Beans.isDesignTime() ? java.util.Collections.emptyList() : usersQuery.getResultList();
        labelId = new javax.swing.JLabel();
        txtId = new javax.swing.JTextField();
        labelTanggal = new javax.swing.JLabel();
        txtTanggal = new com.toedter.calendar.JDateChooser();
        labelBuku = new javax.swing.JLabel();
        txtBuku = new javax.swing.JComboBox<>();
        labelMahasiswa = new javax.swing.JLabel();
        txtMahasiswa = new javax.swing.JComboBox<>();
        labelPegawai = new javax.swing.JLabel();
        txtPegawai = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablePeminjaman = new javax.swing.JTable();
        btnTambah = new javax.swing.JToggleButton();
        btnKembali = new javax.swing.JButton();
        jComboBox1 = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        labelId.setText("ID");

        labelTanggal.setText("Tanggal");

        labelBuku.setText("Buku");

        org.jdesktop.swingbinding.JComboBoxBinding jComboBoxBinding = org.jdesktop.swingbinding.SwingBindings.createJComboBoxBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, buku_1List, txtBuku);
        bindingGroup.addBinding(jComboBoxBinding);

        labelMahasiswa.setText("Mahasiswa");

        jComboBoxBinding = org.jdesktop.swingbinding.SwingBindings.createJComboBoxBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, mahasiswa_1List, txtMahasiswa);
        bindingGroup.addBinding(jComboBoxBinding);

        labelPegawai.setText("Pegawai");

        jComboBoxBinding = org.jdesktop.swingbinding.SwingBindings.createJComboBoxBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, pegawai_1List1, txtPegawai);
        bindingGroup.addBinding(jComboBoxBinding);

        tablePeminjaman.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(tablePeminjaman);

        btnTambah.setText("Tambah");
        btnTambah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTambahActionPerformed(evt);
            }
        });

        btnKembali.setText("Kembali");
        btnKembali.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnKembaliActionPerformed(evt);
            }
        });

        jComboBoxBinding = org.jdesktop.swingbinding.SwingBindings.createJComboBoxBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, usersList, jComboBox1);
        bindingGroup.addBinding(jComboBoxBinding);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(53, 53, 53)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(labelTanggal)
                                    .addComponent(labelBuku)
                                    .addComponent(labelMahasiswa)
                                    .addComponent(labelId)
                                    .addComponent(labelPegawai))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtId, javax.swing.GroupLayout.DEFAULT_SIZE, 280, Short.MAX_VALUE)
                                    .addComponent(txtBuku, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(txtTanggal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(txtMahasiswa, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(txtPegawai, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnTambah)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnKembali))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(109, 109, 109)
                        .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(43, 43, 43)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 543, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 524, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(labelId)
                            .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtTanggal, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(labelTanggal)))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(labelBuku)
                            .addComponent(txtBuku, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(15, 15, 15)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(labelMahasiswa)
                            .addComponent(txtMahasiswa, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(labelPegawai)
                            .addComponent(txtPegawai, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnTambah)
                            .addComponent(btnKembali))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(113, 113, 113))))
        );

        bindingGroup.bind();

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnTambahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTambahActionPerformed
        TambahPeminjaman();
    }//GEN-LAST:event_btnTambahActionPerformed

    private void btnKembaliActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnKembaliActionPerformed
        this.dispose();
        Menu menu = new Menu();
        menu.setVisible(true);
    }//GEN-LAST:event_btnKembaliActionPerformed
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Peminjaman().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnKembali;
    private javax.swing.JToggleButton btnTambah;
    private java.util.List<perpustakaan.Form.Buku_1> buku_1List;
    private javax.persistence.Query buku_1Query;
    private javax.persistence.EntityManager entityManager;
    private javax.persistence.EntityManager entityManager0;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel labelBuku;
    private javax.swing.JLabel labelId;
    private javax.swing.JLabel labelMahasiswa;
    private javax.swing.JLabel labelPegawai;
    private javax.swing.JLabel labelTanggal;
    private java.util.List<perpustakaan.Form.Mahasiswa_1> mahasiswa_1List;
    private javax.persistence.Query mahasiswa_1Query;
    private java.util.List<perpustakaan.Form.Pegawai_1> pegawai_1List;
    private java.util.List<perpustakaan.Form.Pegawai_1> pegawai_1List1;
    private javax.persistence.Query pegawai_1Query;
    private javax.persistence.Query pegawai_1Query1;
    private javax.swing.JTable tablePeminjaman;
    private javax.swing.JComboBox<String> txtBuku;
    private javax.swing.JTextField txtId;
    private javax.swing.JComboBox<String> txtMahasiswa;
    private javax.swing.JComboBox<String> txtPegawai;
    private com.toedter.calendar.JDateChooser txtTanggal;
    private java.util.List<perpustakaan.Form.Users> usersList;
    private javax.persistence.Query usersQuery;
    private org.jdesktop.beansbinding.BindingGroup bindingGroup;
    // End of variables declaration//GEN-END:variables
}
