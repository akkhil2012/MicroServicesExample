import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.security.core.userdetails.UserDetails;

import com.sample.approval.ApprovalMicroService.app.controller.ApprovalResource;
import com.sample.approval.ApprovalMicroService.model.User;
import com.sample.approval.ApprovalMicroService.service.IApproval;
import com.sample.approval.ApprovalMicroService.service.impl.ApprovalImpl;



public class ApprovalApplicationTest {
	
	
	@InjectMocks
	private ApprovalResource approvalController;
	
	@Mock
	private IApproval approvalService;
	
	
	@Before
	public void setUp() throws Exception{
		 MockitoAnnotations.initMocks(this);
	
		 
	}
	
	@Test
	public void testUserService() {
		List<User> mockList = new ArrayList<>();

		User mockUser1 = Mockito.mock(User.class);
		mockList.add(mockUser1);
		mockList.add(mockUser1);
		// Test for User Service
		when(approvalService.fetchAllAdminUserProfiles()).thenReturn(mockList);
		verify(approvalService);
		
	}
	
	
	
	

}
