package com.SBcollege.in.collegemanagementsystem;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import com.SBcollege.in.collegemanagementsystem.entity.Department;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = CollegeManagementSystemApplication.class , webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class CollegeManagementSystemApplicationTests {

	@Autowired
	private TestRestTemplate restTemplate;
	
	@Test
	public void contextLoads() {
	}
	
	private String getRootUrl() {
		return "http://localhost:" + 8080;
	}
	
	@Test
	public void testCreateDepartment() {
		/*
		 * Department d=new Department(5,"etc","ETC");
		 * when(deptService.createDepartment(d)).thenReturn("data added");
		 * assertEquals(d, d);
		 */
		Department d=new Department();
		d.setId(6);
		d.setDeptName("etc");
		d.setDeptCode("EC");
		ResponseEntity<String> response = restTemplate.postForEntity(getRootUrl() + "/admin/department/create" ,
				 d, String.class);
		
		System.out.println(response);
		//assertNotNull(response);
		assertNotNull(response.getBody());
		
	}
	
	
	/*
	 * @Bean TestRestTemplate restTemplate() { return new TestRestTemplate(); }
	 */
}
