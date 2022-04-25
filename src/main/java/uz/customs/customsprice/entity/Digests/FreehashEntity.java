package uz.customs.customsprice.entity.Digests;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Arrays;
import java.util.Objects;

@Entity
@Table(name = "FREEHASH", schema = "PCABINET", catalog = "")
public class FreehashEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "HASH")
    private String hash;
    @Basic
    @Column(name = "FILEDATA")
    private byte[] filedata;
    @Basic
    @Column(name = "INSTIME")
    private Timestamp instime;

    public String getHash() {
        return hash;
    }

    public void setHash(String hash) {
        this.hash = hash;
    }

    public byte[] getFiledata() {
        return filedata;
    }

    public void setFiledata(byte[] filedata) {
        this.filedata = filedata;
    }

    public Timestamp getInstime() {
        return instime;
    }

    public void setInstime(Timestamp instime) {
        this.instime = instime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FreehashEntity that = (FreehashEntity) o;
        return Objects.equals(hash, that.hash) && Arrays.equals(filedata, that.filedata) && Objects.equals(instime, that.instime);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(hash, instime);
        result = 31 * result + Arrays.hashCode(filedata);
        return result;
    }
}
