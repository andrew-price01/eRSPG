package eRSPG.Repository;

import eRSPG.model.UploadFile;
 
public interface FileUploadDAO {
    void save(UploadFile uploadFile);
}