CREATE SCHEMA `erspg` ;


USE erspg;

CREATE TABLE Announcement(
    announcementID int NOT NULL AUTO_INCREMENT PRIMARY KEY,
    title nvarchar(200) NOT NULL,
    message nvarchar(255) NOT NULL,
    date nvarchar(100) NOT NULL
);

CREATE TABLE RoleType (
        roleTypeID              smallint        not null AUTO_INCREMENT PRIMARY KEY,
    roleDesc                text not null
);

INSERT INTO RoleType (roleDesc) VALUES ('user');
INSERT INTO RoleType (roleDesc) VALUES ('committee');
INSERT INTO RoleType (roleDesc) VALUES ('admin');
INSERT INTO RoleType (roleDesc) VALUES ('chairman');

CREATE TABLE User(
        userID                      int     not null AUTO_INCREMENT     PRIMARY KEY,
    email                       nvarchar(100)       not null,
    userFirstName       nvarchar(50)        not null,
    userLastName        nvarchar(50)        not null,
    username            nvarchar(50),
    wNumber             nvarchar(9)
);
    
CREATE TABLE UserRole (
        userRoleID              int     not null        AUTO_INCREMENT PRIMARY KEY,
    userID                      int not null,
    roleTypeID              int not null,
    revoked                     datetime        null,
    updateAt                datetime        null
);


CREATE TABLE Department (
        departmentID        smallint not null AUTO_INCREMENT        PRIMARY KEY,
    departmentName      varchar(50)
);


CREATE TABLE EssayQuestion (
        questionID              int not null  AUTO_INCREMENT        PRIMARY KEY,
    question                longtext not null
);


CREATE TABLE Semester (
        semesterID              smallint not null AUTO_INCREMENT        PRIMARY KEY,
    semesterName        varchar(15)
);


CREATE TABLE AwardType (
        awardTypeID             smallint not null       AUTO_INCREMENT PRIMARY KEY,
    awardName               varchar(50)
);





CREATE TABLE ProjectType (
        projectTypeID       smallint not null AUTO_INCREMENT        PRIMARY KEY,
    projectTypeName     varchar(100) not null
);


CREATE TABLE FundType (
        fundTypeID              smallint not null AUTO_INCREMENT        PRIMARY KEY,
    fundTypeName        varchar(50)
);


CREATE TABLE SourceType (
        sourceTypeID        smallint not null AUTO_INCREMENT        PRIMARY KEY,
    sourceTypeName      varchar(50)
);


CREATE TABLE FundCategory (
        fundCategoryID      smallint not null AUTO_INCREMENT        PRIMARY KEY,
    fundCategoryName        varchar(100)
);

CREATE TABLE ProposalStatus (
  proposalStatusID          smallint not null AUTO_INCREMENT      PRIMARY KEY,
  proposalDescription       varchar(50) not null
);

alter table ProposalStatus add CONSTRAINT UNIQUE (proposalDescription);

CREATE TABLE Proposal (
    proposalID              int not null AUTO_INCREMENT     PRIMARY KEY,
    proposalTitle       varchar(100) not null,
    semesterID              smallint not null,
    proposalYear        smallint not null,
    projectTypeID       smallint not null,
    proposalSubmissionDate      datetime not null,
    projectDirector     varchar(100) not null,
    departmentID        smallint        not null,
    proposalEmail       nvarchar(50) not null,
    proposalMailCode        char(20),
    proposalExtension       char(10),
    proposalReqStudentAssistance bit not null,
    proposalStatusID        SMALLINT not null,
    proposalParticipants nvarchar(400),
	  userID               int,
    updatedDate             datetime not null
);


ALTER TABLE Proposal
        ADD CONSTRAINT fk_Semeseter_SemesterID FOREIGN KEY(semesterID) REFERENCES Semester(semesterID)
;


ALTER TABLE Proposal
        ADD CONSTRAINT fk_ProjectType_ProjetTypeID FOREIGN KEY(projectTypeID) REFERENCES ProjectType(projectTypeID)
;


ALTER TABLE Proposal
        ADD CONSTRAINT fk_Department_Proposal FOREIGN KEY(departmentID) REFERENCES Department(departmentID)
;

ALTER TABLE Proposal
        ADD CONSTRAINT fk_user_UserID FOREIGN KEY(userID) REFERENCES User(userID)
;

ALTER TABLE Proposal
        ADD CONSTRAINT fk_ProposalStatus_ProposalStatusID FOREIGN KEY(proposalStatusID) REFERENCES ProposalStatus(proposalStatusID)
;
 
CREATE TABLE Fund (
        fundID                      int not null AUTO_INCREMENT PRIMARY KEY,
    proposalID              int not null,
        fundTypeID              smallint not null,
    sourceTypeID        smallint not null,
    fundCategoryID      smallint not null,
    fundAmount              double      not null,
    comments                longtext,
    description				longtext
);


ALTER TABLE Fund
        ADD CONSTRAINT fk_Proposal_ProposalID1 FOREIGN KEY(proposalID) REFERENCES Proposal(proposalID)
;


ALTER TABLE Fund
        ADD CONSTRAINT fk_FundType_FundTypeID1 FOREIGN KEY(fundTypeID) REFERENCES FundType(fundTypeID)
;


ALTER TABLE Fund
        ADD CONSTRAINT fk_SourceType_SourceTyeID2 FOREIGN KEY(sourceTypeID) REFERENCES SourceType(sourceTypeID)
;


ALTER TABLE Fund
        ADD CONSTRAINT fk_FundCategory_FundCategoryID1 FOREIGN KEY(fundCategoryID) REFERENCES FundCategory(fundCategoryID)
;


CREATE TABLE EssayAnswer (
        answerID                int not null AUTO_INCREMENT PRIMARY KEY,
    answer                      longtext not null,
    questionID              int not null,
    proposalID              int not null,
    updated_date        datetime,
    CONSTRAINT fk_Proposal_ProposalID       FOREIGN KEY(proposalID) REFERENCES Proposal(proposalID) ON DELETE CASCADE ON UPDATE CASCADE,
    CONSTRAINT fk_Question_QuestionID       FOREIGN KEY(questionID) REFERENCES EssayQuestion(questionID)
);






CREATE TABLE RequestAward (
        requestAwardID      int     not null AUTO_INCREMENT PRIMARY KEY,
    awardTypeID             smallint not null,
    proposalID              int not null,
    CONSTRAINT fk_AwardType_AwardID1 FOREIGN KEY(awardTypeID) REFERENCES AwardType(awardTypeID),
    CONSTRAINT fk_Proposal_ProposalID3 FOREIGN KEY(proposalID) REFERENCES Proposal(proposalID) ON DELETE CASCADE ON UPDATE CASCADE
);


CREATE TABLE Reviewer (
        reveiwerID              int not null AUTO_INCREMENT     PRIMARY KEY,
    proposalID              int     not null,
    userID                      int not null,
    departmentID        smallint not null,
        reviewComment       longtext,
    updatedAt               datetime,
    constraint fk_User_UserID2 FOREIGN KEY(userID) REFERENCES User(userID),
    constraint fk_Department_DepartmentID2 FOREIGN KEY(departmentID) REFERENCES Department(departmentID),
        constraint fk_Proposal_ProposalID4 FOREIGN KEY(proposalID) REFERENCES Proposal(proposalID)
);


CREATE TABLE Awarded (
        awardedID               int not null AUTO_INCREMENT PRIMARY KEY,
    proposalID              int not null,
    awardedAmount       double      not null,
    awardTypeID             smallint not null,
    constraint fk_Proposal_Awarded FOREIGN KEY(proposalID) REFERENCES Proposal(proposalID),
    constraint fk_AwardType_Awarded FOREIGN KEY(awardTypeID) REFERENCES AwardType(awardTypeID)
);

CREATE TABLE File_Upload(
fileUploadID        int not null AUTO_INCREMENT PRIMARY KEY,
proposalID      int not null,
fileName        nvarchar(100),
path            nvarchar(1000),
    constraint fk_Proposal_FileUpload FOREIGN KEY(proposalID) REFERENCES Proposal(proposalID)

);

INSERT INTO ProposalStatus (proposalDescription) values ('DRAFT');
INSERT INTO ProposalStatus (proposalDescription) VALUES ('SUBMITTED');
INSERT INTO ProposalStatus (proposalDescription) VALUES ('IN REVIEW');
INSERT INTO ProposalStatus (proposalDescription) VALUES ('APPROVED');
INSERT INTO ProposalStatus (proposalDescription) VALUES ('REJECTED');


INSERT INTO Department(departmentName)
VALUES('Computer Science');


INSERT INTO Semester( semesterName)
VALUES("Fall");

INSERT INTO Semester( semesterName)
VALUES("Spring");

INSERT INTO Semester( semesterName)
VALUES("Summer");


INSERT INTO SourceType(sourceTypeName)
VALUES('ERSPG');

INSERT INTO SourceType(sourceTypeName)
VALUES('Source 1');

INSERT INTO SourceType(sourceTypeName)
VALUES("Source 2");

INSERT INTO SourceType(sourceTypeName)
VALUES("Source 3");

INSERT INTO ProjectType(projectTypeName)
VALUES("Travel to attend");

INSERT INTO ProjectType(projectTypeName)
VALUES("Travel to present");

INSERT INTO ProjectType(projectTypeName)
VALUES("Research, creative endeavor, or service oriented project");


INSERT INTO AwardType(awardName)
VALUES("Research Grant");

INSERT INTO AwardType(awardName)
VALUES("Instructional Improvement Grant");

INSERT INTO AwardType(awardName)
VALUES("Hemingway Faculty Vitality Grant");
INSERT INTO AwardType(awardName)
VALUES("Hemingway New Faculty Grant");
INSERT INTO AwardType(awardName)
VALUES("Hemingway Excellence Award");
INSERT INTO AwardType(awardName)
VALUES("Hemingway Collaborative Award");
INSERT INTO AwardType(awardName)
VALUES("Hemingway Adjunct Faculty Grant");


INSERT INTO FundCategory(fundCategoryName)
VALUES("Personnel Resources");

INSERT INTO FundCategory(fundCategoryName)
VALUES("Benefits for personnel resources");

INSERT INTO FundCategory(fundCategoryName)
VALUES("equipment and resources");

INSERT INTO FundCategory(fundCategoryName)
VALUES("travel");

INSERT INTO FundCategory(fundCategoryName)
VALUES("other");

INSERT INTO FundType(fundTypeName)
VALUES("committed");

INSERT INTO FundType(fundTypeName)
VALUES("requested");

INSERT INTO EssayQuestion(question)
VALUES("PROJECT SUMMARY (ABSTRACT)");

INSERT INTO EssayQuestion(question)
VALUES("BACKGROUND AND OBJECTIVES OF RESEARCH/PROJECT. (Describe the nature and significance of the problem and provide a brief review of the relevant literature and expected outcomes. Include a bibliography as an appendix, if appropriate.)");

INSERT INTO EssayQuestion(question)
VALUES("If applying for a Hemingway award for Faculty Excellence, please describe what the impact of your project will be on the larger community. In short, what makes this project qualify for a Hemingway Award?");

INSERT INTO EssayQuestion(question)
VALUES("If applying for a Hemingway Collaborative Award, explain the collaborative nature of the project. What faculty and disciplines are involved?");

INSERT INTO EssayQuestion(question)
VALUES("PROCEDURES AND METHODS. (Indicate how the goals and objectives will be met. Include a discussion of the steps involved in the design, development and implementation of the project).");

INSERT INTO EssayQuestion(question)
VALUES("TIME-LINE. (Provide a time frame for the completion of the project.)");

INSERT INTO EssayQuestion(question)
VALUES("EVALUATION AND DISSEMINATION. (Include a plan for evaluating or documenting outcomes as well as a plan for the dissemination of project results.");

INSERT INTO EssayQuestion(question)
VALUES("PROVIDE A BUDGET NARRATIVE that clearly explains any budget items that are not self-explanatory, including justification for the number of hours requested (if any) as reassigned time or stipend.");

INSERT INTO EssayQuestion(question)
VALUES("What RSPG funding have you applied for or have been awarded in the past 5 years. For awarded projects, please provide information regarding these projects including (1) the project title, (2) the status of the project, and (3) the outcome(s) of the project. Please indicate whether a final report has been submitted for each RSPG award. (It is recommended that a copy of the final report be included as an appendix.)");

INSERT INTO EssayQuestion(question)
VALUES("What other sources of funding have you sought for this project?");

INSERT INTO EssayQuestion(question)
VALUES("Have you checked with the Office of Sponsored Projects (URL: http://weber.edu/osp/) to determine if this office is an appropriate place to seek additional funding? Please explain.");

INSERT INTO EssayQuestion(question)
VALUES("Is this the type of project your department or college would normally fund? Please explain.");

INSERT INTO EssayQuestion(question)
VALUES("Would completion of this project create opportunities for external funding (for example, is this proposal a request for a pilot study or seed money that may lead to a larger project)?");

INSERT INTO EssayQuestion(question)
VALUES("If you are applying for release time or a stipend, please list what your course load would be if you received the reassigned time. You MUST include any overload courses which you plan on teaching.");

INSERT INTO EssayQuestion(question)
VALUES("For instructional improvement proposals, are course fees an appropriate place to seek additional funding? Please explain.");


create table Budget(
	budgetID      int     not null AUTO_INCREMENT PRIMARY KEY,
    budgetYear int not null,
    totalBudget int not null
);

insert into Budget(budgetYear, totalBudget) values(2017, 2000);
commit;


CREATE USER 'erspg_admin'@'localhost' IDENTIFIED BY 'P@$$w0rd';


GRANT ALL ON erspg.* TO 'erspg_admin'@'localhost';


