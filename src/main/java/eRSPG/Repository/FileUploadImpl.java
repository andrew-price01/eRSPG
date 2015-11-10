package eRSPG.Repository;

import eRSPG.model.UploadFile;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class FileUploadImpl  implements FileUploadDAO {
    @Autowired
    private SessionFactory sessionFactory;
     
    public FileUploadImpl() {
    }
 
    public FileUploadImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
 
    @Override
    @Transactional
    public void save(UploadFile uploadFile) {
        sessionFactory.getCurrentSession().save(uploadFile);
    }
}