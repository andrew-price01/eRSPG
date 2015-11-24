package eRSPG.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "FILES_UPLOAD")
public class UploadFile {
    @Id
    @GeneratedValue
    @Column(name = "fileId")
    private int id;

    @Column(name = "proposalId")
    private int proposalId;

    @Column(name = "fileName")
    private String fileName;

    @Column(name = "path")
    private String path;

    public UploadFile() {}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getProposalId() {
        return proposalId;
    }

    public void setProposalId(int proposalId) {
        this.proposalId = proposalId;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }
}