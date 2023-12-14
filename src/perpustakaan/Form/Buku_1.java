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
@Table(name = "buku", catalog = "perpustakaan", schema = "")
@NamedQueries({
    @NamedQuery(name = "Buku_1.findAll", query = "SELECT b FROM Buku_1 b")
    , @NamedQuery(name = "Buku_1.findByIdBuku", query = "SELECT b FROM Buku_1 b WHERE b.idBuku = :idBuku")
    , @NamedQuery(name = "Buku_1.findByJudulBuku", query = "SELECT b FROM Buku_1 b WHERE b.judulBuku = :judulBuku")
    , @NamedQuery(name = "Buku_1.findByPenulisBuku", query = "SELECT b FROM Buku_1 b WHERE b.penulisBuku = :penulisBuku")
    , @NamedQuery(name = "Buku_1.findByPenerbitBuku", query = "SELECT b FROM Buku_1 b WHERE b.penerbitBuku = :penerbitBuku")
    , @NamedQuery(name = "Buku_1.findByTahunPenerbit", query = "SELECT b FROM Buku_1 b WHERE b.tahunPenerbit = :tahunPenerbit")})
public class Buku_1 implements Serializable {
    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id_buku")
    private Integer idBuku;
    @Column(name = "judul_buku")
    private String judulBuku;
    @Column(name = "penulis_buku")
    private String penulisBuku;
    @Column(name = "penerbit_buku")
    private String penerbitBuku;
    @Column(name = "tahun_penerbit")
    private String tahunPenerbit;
    public Buku_1() {
    }
    public Buku_1(Integer idBuku) {
        this.idBuku = idBuku;
    }
    public Integer getIdBuku() {
        return idBuku;
    }
    public void setIdBuku(Integer idBuku) {
        Integer oldIdBuku = this.idBuku;
        this.idBuku = idBuku;
        changeSupport.firePropertyChange("idBuku", oldIdBuku, idBuku);
    }
    public String getJudulBuku() {
        return judulBuku;
    }
    public void setJudulBuku(String judulBuku) {
        String oldJudulBuku = this.judulBuku;
        this.judulBuku = judulBuku;
        changeSupport.firePropertyChange("judulBuku", oldJudulBuku, judulBuku);
    }
    public String getPenulisBuku() {
        return penulisBuku;
    }
    public void setPenulisBuku(String penulisBuku) {
        String oldPenulisBuku = this.penulisBuku;
        this.penulisBuku = penulisBuku;
        changeSupport.firePropertyChange("penulisBuku", oldPenulisBuku, penulisBuku);
    }
    public String getPenerbitBuku() {
        return penerbitBuku;
    }
    public void setPenerbitBuku(String penerbitBuku) {
        String oldPenerbitBuku = this.penerbitBuku;
        this.penerbitBuku = penerbitBuku;
        changeSupport.firePropertyChange("penerbitBuku", oldPenerbitBuku, penerbitBuku);
    }
    public String getTahunPenerbit() {
        return tahunPenerbit;
    }
    public void setTahunPenerbit(String tahunPenerbit) {
        String oldTahunPenerbit = this.tahunPenerbit;
        this.tahunPenerbit = tahunPenerbit;
        changeSupport.firePropertyChange("tahunPenerbit", oldTahunPenerbit, tahunPenerbit);
    }
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idBuku != null ? idBuku.hashCode() : 0);
        return hash;
    }
    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Buku_1)) {
            return false;
        }
        Buku_1 other = (Buku_1) object;
        if ((this.idBuku == null && other.idBuku != null) || (this.idBuku != null && !this.idBuku.equals(other.idBuku))) {
            return false;
        }
        return true;
    }
    @Override
    public String toString() {
        return judulBuku;
    }
    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }
    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }
    public static Buku_1 findByJudulBuku(String judulBuku) throws SQLException {
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/perpustakaan", "root", "");
        PreparedStatement pst = conn.prepareStatement("SELECT * FROM buku WHERE judul_buku = ?");
        pst.setString(1, judulBuku);
        ResultSet rs = pst.executeQuery();

        if (rs.next()) {
            Buku_1 buku = new Buku_1();
            buku.setIdBuku(rs.getInt("id_buku"));
            buku.setJudulBuku(rs.getString("judul_buku"));
            buku.setPenulisBuku(rs.getString("penulis_buku"));
            buku.setPenerbitBuku(rs.getString("penerbit_buku"));
            buku.setTahunPenerbit(rs.getString("tahun_penerbit"));
            rs.close();
            pst.close();
            conn.close();
            return buku;
        } else {
            rs.close();
            pst.close();
            conn.close();
            return null;
        }
    }
}
