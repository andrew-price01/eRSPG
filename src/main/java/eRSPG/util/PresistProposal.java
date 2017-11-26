package eRSPG.util;

import eRSPG.model.User;

/**
 * Created by iNaS2 on 11/20/2017.
 */
public class PresistProposal {



    public static User getDummyUser(){
        User user = new User();
        user.setFirstName("NoName");
        user.setLastName("NaName");
        user.setEmail("po@man.do");
        user.setUserId(42);
        return user;
    }
}
