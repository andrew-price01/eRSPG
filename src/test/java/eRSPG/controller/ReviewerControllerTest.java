package eRSPG.controller;

import org.junit.Test;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.servlet.view.InternalResourceView;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;

public class ReviewerControllerTest {

	@Test
	public void showAnnouncements() throws Exception {
		ReviewerController controller = new ReviewerController();
		MockMvc mockMvc = standaloneSetup(controller)
				.setSingleView(new InternalResourceView("/WEB-INF/views/announcements.jsp"))
				.build();
		mockMvc.perform(get("/reviewer/announcements")).andExpect(view().name("projectIndex"));
	}

	@Test
	public void showProposalList() throws Exception {
		ReviewerController controller = new ReviewerController();
		MockMvc mockMvc = standaloneSetup(controller)
				.setSingleView(new InternalResourceView("/WEB-INF/views/proposalList.jsp"))
				.build();
		mockMvc.perform(get("/reviewer/proposalList")).andExpect(view().name("projectIndex"));
	}

	@Test
	public void showReview() throws Exception {
		ReviewerController controller = new ReviewerController();
		MockMvc mockMvc = standaloneSetup(controller)
				.setSingleView(new InternalResourceView("/WEB-INF/views/review.jsp"))
				.build();
		mockMvc.perform(get("/reviewer/reviewProposal")).andExpect(view().name("projectIndex"));
	}
}
