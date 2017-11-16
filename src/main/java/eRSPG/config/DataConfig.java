package eRSPG.config;

import eRSPG.model.*;
import eRSPG.Repository.*;
import eRSPG.model.*;
import org.apache.commons.dbcp2.BasicDataSource;
import org.hibernate.SessionFactory;
import org.jasig.cas.client.authentication.AuthenticationFilter;
import org.jasig.cas.client.session.SingleSignOutFilter;
import org.jasig.cas.client.session.SingleSignOutHttpSessionListener;
import org.jasig.cas.client.util.HttpServletRequestWrapperFilter;
import org.jasig.cas.client.validation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.embedded.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBuilder;

import javax.sql.DataSource;

import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

import javax.sql.DataSource;
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
                FundType.class, Participant.class, ProjectType.class, Proposal.class, ProposalStatus.class, RequestAward.class, RoleType.class,
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

    @Autowired
    @Bean(name= "userDAO")
    public UserDAO getUserDao(SessionFactory sessionFactory){ return new UserImpl(sessionFactory); }

    @Autowired
    @Bean(name="proposalStatusDAO")
    public ProposalStatusDAO getProposalStatus(SessionFactory sessionFactory) {
        return new ProposalStatusImpl(sessionFactory);
    }

    @Bean
    public AuthenticationFilter authenticationFilter(){
        AuthenticationFilter mAuthenticationFilter = new AuthenticationFilter();
        mAuthenticationFilter.setCasServerLoginUrl(Constants.CAS_URL_LOGIN);
        mAuthenticationFilter.setRenew(false);
        mAuthenticationFilter.setGateway(false);
        //mAuthenticationFilter.setServerName(Constants.APP_SERVER);
        mAuthenticationFilter.setService(Constants.CAS_SERVICE_URL);
        return mAuthenticationFilter;
    }

    @Bean
    public Cas10TicketValidationFilter cas10TicketValidationFilter(){
        Cas10TicketValidationFilter mCas10TicketValidationFilter = new Cas10TicketValidationFilter();
        mCas10TicketValidationFilter.setService(Constants.CAS_SERVICE_URL);
        mCas10TicketValidationFilter.setUseSession(true);
        mCas10TicketValidationFilter.setRedirectAfterValidation(true);
        mCas10TicketValidationFilter.setTicketValidator(cas10TicketValidator());
        return mCas10TicketValidationFilter;
    }

    @Bean
    public Cas10TicketValidator cas10TicketValidator(){
        return  new Cas10TicketValidator(Constants.CAS_URL_PREFIX);
    }

    @Bean
    public Saml11TicketValidationFilter saml11TicketValidationFilter(){
        Saml11TicketValidationFilter mSaml11TicketValidationFilter = new Saml11TicketValidationFilter();
        mSaml11TicketValidationFilter.setService(Constants.CAS_SERVICE_URL);
        mSaml11TicketValidationFilter.setUseSession(true);
        mSaml11TicketValidationFilter.setRedirectAfterValidation(true);
        mSaml11TicketValidationFilter.setTicketValidator(saml11TicketValidator());
        return mSaml11TicketValidationFilter;
    }

    @Bean
    public Saml11TicketValidator saml11TicketValidator(){
        return  new Saml11TicketValidator(Constants.CAS_URL_PREFIX);
    }

    @Bean
    public Cas20ProxyReceivingTicketValidationFilter cas20ProxyReceivingTicketValidationFilter(){
        Cas20ProxyReceivingTicketValidationFilter mCas20ProxyReceivingTicketValidationFilter = new Cas20ProxyReceivingTicketValidationFilter();
        //mCas20ProxyReceivingTicketValidationFilter.setServerName(Constants.APP_SERVER);
        mCas20ProxyReceivingTicketValidationFilter.setService(Constants.CAS_SERVICE_URL);
        mCas20ProxyReceivingTicketValidationFilter.setUseSession(true);
        mCas20ProxyReceivingTicketValidationFilter.setRedirectAfterValidation(true);
        mCas20ProxyReceivingTicketValidationFilter.setTicketValidator(cas20ProxyTicketValidator());
        return mCas20ProxyReceivingTicketValidationFilter;
    }

    @Bean
    public Cas20ProxyTicketValidator cas20ProxyTicketValidator(){
        return new Cas20ProxyTicketValidator(Constants.CAS_URL_PREFIX);
    }

    @Bean
    public Cas30ProxyReceivingTicketValidationFilter cas30ProxyReceivingTicketValidationFilter(){
        Cas30ProxyReceivingTicketValidationFilter mCas30ProxyReceivingTicketValidationFilter = new Cas30ProxyReceivingTicketValidationFilter();
        mCas30ProxyReceivingTicketValidationFilter.setServerName(Constants.APP_SERVER);
        mCas30ProxyReceivingTicketValidationFilter.setService(Constants.CAS_SERVICE_URL);
        mCas30ProxyReceivingTicketValidationFilter.setRedirectAfterValidation(true);
        mCas30ProxyReceivingTicketValidationFilter.setUseSession(true);
        mCas30ProxyReceivingTicketValidationFilter.setTicketValidator(cas30ProxyTicketValidator());
        return mCas30ProxyReceivingTicketValidationFilter;
    }

    @Bean
    public Cas30ProxyTicketValidator cas30ProxyTicketValidator(){
        return new Cas30ProxyTicketValidator(Constants.CAS_URL_PREFIX);
    }

    @Bean
    public CommonsMultipartResolver multipartResolver(){
        CommonsMultipartResolver mCommonsMultipartResolver = new CommonsMultipartResolver();
        mCommonsMultipartResolver.setMaxUploadSize(268435456);
        return mCommonsMultipartResolver;
    }
}
