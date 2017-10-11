package eRSPG.controller;

import eRSPG.model.AwardType;
import eRSPG.model.form.AwardTypeForm;
import eRSPG.model.form.DepartmentForm;
import org.junit.Test;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.servlet.view.InternalResourceView;

import static org.junit.Assert.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

public class ProposalControllerTest {

    @Test
    public void testAwardTypeForm() throws Exception
    {

        ProposalController controller = new ProposalController()
        {
            @ModelAttribute
            public DepartmentForm mockModel1()
            {
                DepartmentForm deptForm = new DepartmentForm();
                deptForm.setSemesterID(1);
                return deptForm;
            }

            @ModelAttribute
            public AwardTypeForm mockModel2()
            {
                AwardTypeForm awardTypeForm = new AwardTypeForm();
                return awardTypeForm;
            }

        };
        MockMvc mockMvc = standaloneSetup(controller)
                .setSingleView(new InternalResourceView("/WEB-INF/views/projectIndex.jsp"))
                .build();

        mockMvc.perform(get("/proposal/awardType"))
            .andExpect(view().name("projectIndex"))
            .andExpect(model().attributeExists("semester"))
            .andExpect(model().attribute("semester", "Spring"));


    }

}