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
@Table(name = "pegawai", catalog = "perpustakaan", schema = "")
@NamedQueries({
    @NamedQuery(name = "Pegawai_1.findAll", query = "SELECT p FROM Pegawai_1 p")
    , @NamedQuery(name = "Pegawai_1.findByIdPegawai", query = "SELECT p FROM Pegawai_1 p WHERE p.idPegawai = :idPegawai")
    , @NamedQuery(name = "Pegawai_1.findByNamaPegawai", query = "SELECT p FROM Pegawai_1 p WHERE p.namaPegawai = :namaPegawai")
    , @NamedQuery(name = "Pegawai_1.findByJabatanPegawai", query = "SELECT p FROM Pegawai_1 p WHERE p.jabatanPegawai = :jabatanPegawai")
    , @NamedQuery(name = "Pegawai_1.findByNoTelpPegawai", query = "SELECT p FROM Pegawai_1 p WHERE p.noTelpPegawai = :noTelpPegawai")
    , @NamedQuery(name = "Pegawai_1.findByAlamatPegawai", query = "SELECT p FROM Pegawai_1 p WHERE p.alamatPegawai = :alamatPegawai")})
public class Pegawai_1 implements Serializable {

    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id_pegawai")
    private Integer idPegawai;
    @Column(name = "nama_pegawai")
    private String namaPegawai;
    @Column(name = "jabatan_pegawai")
    private String jabatanPegawai;
    @Column(name = "no_telp_pegawai")
    private Integer noTelpPegawai;
    @Column(name = "alamat_pegawai")
    private String alamatPegawai;

    public Pegawai_1() {
    }

    public Pegawai_1(Integer idPegawai) {
        this.idPegawai = idPegawai;
    }

    public Integer getIdPegawai() {
        return idPegawai;
    }

    public void setIdPegawai(Integer idPegawai) {
        Integer oldIdPegawai = this.idPegawai;
        this.idPegawai = idPegawai;
        changeSupport.firePropertyChange("idPegawai", oldIdPegawai, idPegawai);
    }

    public String getNamaPegawai() {
        return namaPegawai;
    }

    public void setNamaPegawai(String namaPegawai) {
        String oldNamaPegawai = this.namaPegawai;
        this.namaPegawai = namaPegawai;
        changeSupport.firePropertyChange("namaPegawai", oldNamaPegawai, namaPegawai);
    }

    public String getJabatanPegawai() {
        return jabatanPegawai;
    }

    public void setJabatanPegawai(String jabatanPegawai) {
        String oldJabatanPegawai = this.jabatanPegawai;
        this.jabatanPegawai = jabatanPegawai;
        changeSupport.firePropertyChange("jabatanPegawai", oldJabatanPegawai, jabatanPegawai);
    }

    public Integer getNoTelpPegawai() {
        return noTelpPegawai;
    }

    public void setNoTelpPegawai(Integer noTelpPegawai) {
        Integer oldNoTelpPegawai = this.noTelpPegawai;
        this.noTelpPegawai = noTelpPegawai;
        changeSupport.firePropertyChange("noTelpPegawai", oldNoTelpPegawai, noTelpPegawai);
    }

    public String getAlamatPegawai() {
        return alamatPegawai;
    }

    public void setAlamatPegawai(String alamatPegawai) {
        String oldAlamatPegawai = this.alamatPegawai;
        this.alamatPegawai = alamatPegawai;
        changeSupport.firePropertyChange("alamatPegawai", oldAlamatPegawai, alamatPegawai);
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idPegawai != null ? idPegawai.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof Pegawai_1)) {
            return false;
        }
        Pegawai_1 other = (Pegawai_1) object;
        if ((this.idPegawai == null && other.idPegawai != null) || (this.idPegawai != null && !this.idPegawai.equals(other.idPegawai))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return namaPegawai;
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }
    public static Pegawai_1 findByNamaPegawai(String judulBuku) throws SQLException {
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/perpustakaan", "root", "");
        PreparedStatement pst = conn.prepareStatement("SELECT * FROM pegawai WHERE nama_pegawai= ?");
        pst.setString(1, judulBuku);
        ResultSet rs = pst.executeQuery();

        if (rs.next()) {
            Pegawai_1 pegawai = new Pegawai_1();
            pegawai.setIdPegawai(rs.getInt("id_pegawai"));
            pegawai.setNamaPegawai(rs.getString("nama_pegawai"));
            pegawai.setJabatanPegawai(rs.getString("jabatan_pegawai"));
            pegawai.setNoTelpPegawai(rs.getInt("no_telp_pegawai"));
            pegawai.setAlamatPegawai(rs.getString("alamat_pegawai"));
            rs.close();
            pst.close();
            conn.close();
            return pegawai;
        } else {
            rs.close();
            pst.close();
            conn.close();
            return null;
        }
    }
}
