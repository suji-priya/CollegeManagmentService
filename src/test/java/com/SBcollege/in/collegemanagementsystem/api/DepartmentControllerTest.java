package com.SBcollege.in.collegemanagementsystem.api;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.times;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;

import com.SBcollege.in.collegemanagementsystem.entity.Department;
import com.SBcollege.in.collegemanagementsystem.service.DepartmentService;

//@ExtendWith(MockitoExtension.class)
@RunWith(MockitoJUnitRunner.class)

public class DepartmentControllerTest {

	@InjectMocks
	DepartmentController departmentController;

	@Mock
	DepartmentService departmentService;

	 @Mock
	 BindingResult result;
	 
	  @Mock 
	  Department d ;
	 
	
	
	
	  @Before public void setupObject() {
		    d.setId(1);
			d.setDeptName("etc");
			d.setDeptCode("EC");
	  }
	 
	 

	@Test
	public void testCreateDepartment() {
		//Department d=new Department();
//		d.setId(1);
//		d.setDeptName("etc");
//		d.setDeptCode("EC");


		when(departmentService.createDepartment(any(Department.class))).thenReturn(d);

		ResponseEntity<Object> response = departmentController.createDepartment(d, result);
		System.out.println(response);
		 assertNotNull(response.getBody());
		// Department dd=departmentService.createDepartment(d);
		// System.out.println(dd.getId());
		// assertNotNull(dd);

		assertThat(response.getStatusCodeValue()).isEqualTo(201);
		//assertThat(response.getHeaders().getLocation().getPath()).isEqualTo("/1");

	}

	@Test
	public void testViewDepartment() {
        int id=1;
		//Department d=new Department();
	    when(departmentService.viewDepartment(id)).thenReturn(d);
	    ResponseEntity<Object> response = departmentController.viewDepartment(id);
		System.out.println(response);
		//assertNotNull(response.getBody());
		assertThat(response.getStatusCodeValue()).isEqualTo(200);

	}
	
	@Test
	public void testDeleteDepartment()
	{
	    int id=1;
	    when(departmentService.deleteDepartment(id)).thenReturn("deleted");
	    ResponseEntity<String> response = departmentController.deleteDepartment(id);
		System.out.println(response);
		//assertNotNull(response.getBody());
                verify(departmentService, times(1)).deleteDepartment(id);
		assertThat(response.getStatusCodeValue()).isEqualTo(200);
	    
	}
	
	@Test
	public void testUpdateDepartment()
	{
		

		when(departmentService.updateDepartment(any(Department.class))).thenReturn("updated");

		ResponseEntity<Object> response = departmentController.updateDepartment(d);
		System.out.println(response);
		assertThat(response.getStatusCodeValue()).isEqualTo(200);
	}
	
	

}
