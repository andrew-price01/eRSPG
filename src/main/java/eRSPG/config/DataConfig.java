package eRSPG.config;

import eRSPG.model.*;
import org.apache.commons.dbcp2.BasicDataSource;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBuilder;

import javax.sql.DataSource;

import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import java.util.Properties;
import eRSPG.Repository.*;

@Configuration
@EnableTransactionManagement
@EnableWebMvc
public class DataConfig {

    @Bean(name = "dataSource")
    public DataSource getDataSource() {
        BasicDataSource dataSource = new BasicDataSource();
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://localhost:3306/erspg");
        dataSource.setUsername("erspg_admin");
        dataSource.setPassword("P@$$w0rd");

        return dataSource;
    }

    @Autowired
    @Bean(name = "sessionFactory")
    public SessionFactory getSessionFactory(DataSource dataSource) {

        LocalSessionFactoryBuilder sessionBuilder = new LocalSessionFactoryBuilder(dataSource);

        sessionBuilder.addAnnotatedClasses(Announcement.class, Awarded.class, AwardType.class, Department.class, EssayAnswer.class, EssayQuestion.class, Fund.class, FundCategory.class,
                FundType.class, Participant.class, ProjectType.class, Proposal.class, RequestAward.class, RoleType.class,
                Semester.class, Reviewer.class, SourceType.class, UploadFile.class, User.class, UserRole.class);
        //sessionBuilder.scanPackages("eRPSG.model");
        sessionBuilder.addProperties(getHibernateProperties());
        return sessionBuilder.buildSessionFactory();
    }

    private Properties getHibernateProperties() {
        Properties properties = new Properties();
        properties.put("hibernate.show_sql", "true");
        properties.put("hibernate.dialect", "org.hibernate.dialect.MySQL5Dialect");
        return properties;
    }

    @Autowired
    @Bean(name = "transactionManager")
    public HibernateTransactionManager getTransactionManager(
            SessionFactory sessionFactory) {
        HibernateTransactionManager transactionManager = new HibernateTransactionManager(
                sessionFactory);

        return transactionManager;
    }

    @Autowired
    @Bean(name = "announcementDao")
    public AnnouncementDAO getAnnouncementDao(SessionFactory sessionFactory) {
        return new AnnouncementImpl(sessionFactory);
    }

    @Autowired
    @Bean(name = "proposalDao")
    public ProposalDAO getProposalDao(SessionFactory sessionFactory) {
        return new ProposalImpl(sessionFactory);
    }

    @Autowired
    @Bean(name = "awardTypeDao")
    public AwardTypeDAO getAwardTypeDao(SessionFactory sessionFactory) {
        return new  AwardTypeImpl(sessionFactory);
    }

    @Autowired
    @Bean(name= "requestAwardDao")
    public RequestAwardDAO getRequestAwardDao(SessionFactory sessionFactory){

        return new RequestAwardImpl(sessionFactory);
    }

    @Autowired
    @Bean(name= "departmentDAO")
    public DepartmentDAO getDepartmentDao(SessionFactory sessionFactory){

        return new DepartmentImpl(sessionFactory);
    }

    @Autowired
    @Bean(name= "semesterDAO")
    public SemesterDAO getSemesterDao(SessionFactory sessionFactory){

        return new SemesterImpl(sessionFactory);
    }

    @Autowired
    @Bean(name= "fundDAO")
    public FundImpl getFundDao(SessionFactory sessionFactory){

        return new FundImpl(sessionFactory);
    }

    @Autowired
    @Bean(name= "essayAnswerDAO")
    public EssayAnswerDAO getEssayAnswerDao(SessionFactory sessionFactory){

        return new EssayAnswerImpl(sessionFactory);
    }

    @Autowired
    @Bean(name= "fileUploadDAO")
    public FileUploadDAO getFileUploadDao(SessionFactory sessionFactory){

        return new FileUploadImpl(sessionFactory);
    }

    @Autowired
    @Bean(name= "userDAO")
    public UserDAO getUserDao(SessionFactory sessionFactory){ return new UserImpl(sessionFactory); }

}
