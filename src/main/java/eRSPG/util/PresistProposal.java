package eRSPG.util;

import com.fasterxml.jackson.databind.ser.Serializers;
import eRSPG.model.Proposal;
import eRSPG.model.User;
import eRSPG.model.form.BaseForm;

/**
 * Created by iNaS2 on 11/20/2017.
 */
public class PresistProposal {

    public static void LoadFromProposal(Proposal proposal){
        
    }


    public static User getDummyUser(){
        User user = new User();
        user.setFirstName("NoName");
        user.setLastName("NaName");
        user.setEmail("po@man.do");
        user.setUserId(1);
        return user;
    }


}
