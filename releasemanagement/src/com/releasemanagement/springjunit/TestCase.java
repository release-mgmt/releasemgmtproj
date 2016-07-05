package com.releasemanagement.springjunit;


import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.io.File;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.releasemanagement.pojo.ReleaseInfo;
import com.fasterxml.jackson.databind.ObjectMapper;




@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "file:WebContent/WEB-INF/spring/appServlet/servlet-context.xml")
@WebAppConfiguration
public class TestCase{

	private MockMvc mockMvc;

	/*@Autowired
	UserServiceImpl userService;*/
	@Autowired
	WebApplicationContext wac;

	@Before
	public void setup() {
		MockitoAnnotations.initMocks(this);

		this.mockMvc = MockMvcBuilders.webAppContextSetup(this.wac).build();
		System.out.println("In setup");
		System.out.println("WebApplicationContext::"+wac);
	}

	protected MockMvc getMockMvc() {

		if (mockMvc == null) {
			throw new RuntimeException("MockMVC has not been initialized");
		}
		else
		{
			System.out.println("mockMvc has been initialzed : "+mockMvc);
		}
		return mockMvc;
	}

	protected void initializeMockMvc() {

		MockitoAnnotations.initMocks(this);

		mockMvc = MockMvcBuilders.webAppContextSetup(wac).build();
		System.out.println("insideinitializedMockMvc");

	}

	protected WebApplicationContext getWebApplicationContext() {

		if (wac == null) {
			throw new RuntimeException("WebApplicationContext is null");
		}
		return wac;
	}

	@Test
	public void getAllReleases() throws Exception {
		
		System.out.println("In test method");
		this.getMockMvc().perform(get("/project/projectReleaseList/123001"))
				.andExpect(status().isOk());
		//this.getMockMvc().perform(get("/cricket/sachin"));
						
		 
			
			//System.out.println("\n\n\n"+content);
		 
		 
		 //assertEquals("<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?><country><capital>Delhi</capital><country>india</country><currency>Rupees</currency></country>", a);

	}

}
