package eRSPG.controller;

import org.junit.Test;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.servlet.view.InternalResourceView;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;

public class ChairmanControllerTest {

	@Test
	public void showUserManagement() throws Exception {
		ChairmanController controller = new ChairmanController();
		MockMvc mockMvc = standaloneSetup(controller)
				.setSingleView(new InternalResourceView("/WEB-INF/views/userManagement.jsp"))
				.build();
		mockMvc.perform(get("/chair/userManagement")).andExpect(view().name("userManagement"));
	}

	@Test
	public void showChangeChairman() throws Exception {
		ChairmanController controller = new ChairmanController();
		MockMvc mockMvc = standaloneSetup(controller)
				.setSingleView(new InternalResourceView("/WEB-INF/views/changeChairman.jsp"))
				.build();
		mockMvc.perform(get("/chair/changeChair")).andExpect(view().name("changeChair"));
	}

}
