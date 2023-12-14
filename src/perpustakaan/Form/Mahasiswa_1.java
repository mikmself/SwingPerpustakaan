package perpustakaan.Form;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "mahasiswa", catalog = "perpustakaan", schema = "")
@NamedQueries({
    @NamedQuery(name = "Mahasiswa_1.findAll", query = "SELECT m FROM Mahasiswa_1 m")
    , @NamedQuery(name = "Mahasiswa_1.findByNimMahasiswa", query = "SELECT m FROM Mahasiswa_1 m WHERE m.nimMahasiswa = :nimMahasiswa")
    , @NamedQuery(name = "Mahasiswa_1.findByNamaMahasiswa", query = "SELECT m FROM Mahasiswa_1 m WHERE m.namaMahasiswa = :namaMahasiswa")
    , @NamedQuery(name = "Mahasiswa_1.findByJurusan", query = "SELECT m FROM Mahasiswa_1 m WHERE m.jurusan = :jurusan")
    , @NamedQuery(name = "Mahasiswa_1.findByNoTelpMahasiswa", query = "SELECT m FROM Mahasiswa_1 m WHERE m.noTelpMahasiswa = :noTelpMahasiswa")
    , @NamedQuery(name = "Mahasiswa_1.findByAlamatMahasiswa", query = "SELECT m FROM Mahasiswa_1 m WHERE m.alamatMahasiswa = :alamatMahasiswa")})
public class Mahasiswa_1 implements Serializable {

    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "nim_mahasiswa")
    private Integer nimMahasiswa;
    @Column(name = "nama_mahasiswa")
    private String namaMahasiswa;
    @Column(name = "jurusan")
    private String jurusan;
    @Column(name = "no_telp_mahasiswa")
    private Integer noTelpMahasiswa;
    @Column(name = "alamat_mahasiswa")
    private String alamatMahasiswa;

    public Mahasiswa_1() {
    }

    public Mahasiswa_1(Integer nimMahasiswa) {
        this.nimMahasiswa = nimMahasiswa;
    }

    public Integer getNimMahasiswa() {
        return nimMahasiswa;
    }

    public void setNimMahasiswa(Integer nimMahasiswa) {
        Integer oldNimMahasiswa = this.nimMahasiswa;
        this.nimMahasiswa = nimMahasiswa;
        changeSupport.firePropertyChange("nimMahasiswa", oldNimMahasiswa, nimMahasiswa);
    }

    public String getNamaMahasiswa() {
        return namaMahasiswa;
    }

    public void setNamaMahasiswa(String namaMahasiswa) {
        String oldNamaMahasiswa = this.namaMahasiswa;
        this.namaMahasiswa = namaMahasiswa;
        changeSupport.firePropertyChange("namaMahasiswa", oldNamaMahasiswa, namaMahasiswa);
    }

    public String getJurusan() {
        return jurusan;
    }

    public void setJurusan(String jurusan) {
        String oldJurusan = this.jurusan;
        this.jurusan = jurusan;
        changeSupport.firePropertyChange("jurusan", oldJurusan, jurusan);
    }

    public Integer getNoTelpMahasiswa() {
        return noTelpMahasiswa;
    }

    public void setNoTelpMahasiswa(Integer noTelpMahasiswa) {
        Integer oldNoTelpMahasiswa = this.noTelpMahasiswa;
        this.noTelpMahasiswa = noTelpMahasiswa;
        changeSupport.firePropertyChange("noTelpMahasiswa", oldNoTelpMahasiswa, noTelpMahasiswa);
    }

    public String getAlamatMahasiswa() {
        return alamatMahasiswa;
    }

    public void setAlamatMahasiswa(String alamatMahasiswa) {
        String oldAlamatMahasiswa = this.alamatMahasiswa;
        this.alamatMahasiswa = alamatMahasiswa;
        changeSupport.firePropertyChange("alamatMahasiswa", oldAlamatMahasiswa, alamatMahasiswa);
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (nimMahasiswa != null ? nimMahasiswa.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Mahasiswa_1)) {
            return false;
        }
        Mahasiswa_1 other = (Mahasiswa_1) object;
        if ((this.nimMahasiswa == null && other.nimMahasiswa != null) || (this.nimMahasiswa != null && !this.nimMahasiswa.equals(other.nimMahasiswa))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return namaMahasiswa;
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }
    public static Mahasiswa_1 findByNamaMahasiswa(String judulBuku) throws SQLException {
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/perpustakaan", "root", "");
        PreparedStatement pst = conn.prepareStatement("SELECT * FROM mahasiswa WHERE nama_mahasiswa = ?");
        pst.setString(1, judulBuku);
        ResultSet rs = pst.executeQuery();

        if (rs.next()) {
            Mahasiswa_1 mahasiswa = new Mahasiswa_1();
            mahasiswa.setNimMahasiswa(rs.getInt("nim_mahasiswa"));
            mahasiswa.setNamaMahasiswa(rs.getString("nama_mahasiswa"));
            mahasiswa.setJurusan(rs.getString("jurusan"));
            mahasiswa.setNoTelpMahasiswa(rs.getInt("no_telp_mahasiswa"));
            mahasiswa.setAlamatMahasiswa(rs.getString("alamat_mahasiswa"));
            rs.close();
            pst.close();
            conn.close();
            return mahasiswa;
        } else {
            rs.close();
            pst.close();
            conn.close();
            return null;
        }
    }
}
