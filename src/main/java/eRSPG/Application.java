package eRSPG;

import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.web.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import eRSPG.Repository.AwardTypeDAO;
import eRSPG.Repository.AwardTypeImpl;
import eRSPG.Repository.DepartmentDAO;
import eRSPG.Repository.DepartmentImpl;
import eRSPG.Repository.EssayAnswerDAO;
import eRSPG.Repository.EssayAnswerImpl;
import eRSPG.Repository.FileUploadDAO;
import eRSPG.Repository.FileUploadImpl;
import eRSPG.Repository.FundImpl;
import eRSPG.Repository.ProposalDAO;
import eRSPG.Repository.ProposalImpl;
import eRSPG.Repository.RequestAwardDAO;
import eRSPG.Repository.RequestAwardImpl;
import eRSPG.Repository.SemesterDAO;
import eRSPG.Repository.SemesterImpl;
import eRSPG.model.AwardType;
import eRSPG.model.Awarded;
import eRSPG.model.Department;
import eRSPG.model.EssayAnswer;
import eRSPG.model.EssayQuestion;
import eRSPG.model.Fund;
import eRSPG.model.FundCategory;
import eRSPG.model.FundType;
import eRSPG.model.Participant;
import eRSPG.model.ProjectType;
import eRSPG.model.Proposal;
import eRSPG.model.RequestAward;
import eRSPG.model.Reviewer;
import eRSPG.model.RoleType;
import eRSPG.model.Semester;
import eRSPG.model.SourceType;
import eRSPG.model.UploadFile;
import eRSPG.model.User;
import eRSPG.model.UserRole;
//test change for testing push this is from Riley.
@EnableWebMvc
@EnableTransactionManagement
@SpringBootApplication
public class Application extends SpringBootServletInitializer {

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(Application.class);
    }

    public static void main(String[] args) throws Exception {
        SpringApplication.run(Application.class, args);
    }

    @Bean
    public InternalResourceViewResolver getInternalResourceViewResolver()
    {
    	InternalResourceViewResolver resolver = new InternalResourceViewResolver();
    	resolver.setPrefix("/WEB-INF/views/");
    	resolver.setSuffix(".jsp");
    	return resolver;
    }
    
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
     
        sessionBuilder.addAnnotatedClasses(Awarded.class, AwardType.class, Department.class, EssayAnswer.class, EssayQuestion.class, Fund.class, FundCategory.class,
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
}