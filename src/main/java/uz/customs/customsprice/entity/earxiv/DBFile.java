package uz.customs.customsprice.entity.earxiv;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

@Entity
@Table(name = "FREEHASH")
public class DBFile {
    @Id
    private String hash;

    @Lob
    private byte[] filedata;

    private String instime;

    public DBFile() {
    }

    public DBFile(String hash, byte[] filedata, String instime) {
        this.hash = hash;
        this.filedata = filedata;
        this.instime = instime;
    }

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

    public String getInstime() {
        return instime;
    }

    public void setInstime(String instime) {
        this.instime = instime;
    }
}