package com.dublioffice;

import java.io.File;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import com.dublinoffice.Core;
import com.dublinoffice.CustomerBean;

public class CoreTest  {
	
	private String userDir = System.getProperty("user.dir");
	private String testFilePath = System.getProperty("user.dir") + File.separator + "test" + File.separator + "gistfile.txt";
	private String dumpFilePath = System.getProperty("user.dir") + File.separator + "test" + File.separator + "customer.txt";
	private Core core = new Core();
	private Double officeLatitude = 53.3381985;
	private Double officeLongitude = -6.2592576; 
	
	@Before
	public void loadTest(){
		new File(dumpFilePath).delete();	
	}

	@Test
	public void readCustomerTest (){
		assertNotNull(core.readCustomer(testFilePath));
		assertEquals(32, core.readCustomer(testFilePath).size());
	}
	
	@Test
	public void getNearCustomerTest() {
		List<CustomerBean> customerList = core.readCustomer(testFilePath);
		assertNotNull(core.getNearCustomer(customerList, officeLatitude, officeLongitude));
		assertEquals(16, core.getNearCustomer(customerList, officeLatitude, officeLongitude).size());
		
	}
	
	@Test
	public void writeCustomertoFileTest() {
		List<CustomerBean> customerList = core.readCustomer(testFilePath);
		List<CustomerBean> nearOfficeList = core.getNearCustomer(customerList, officeLatitude, officeLongitude);
		core.writeCustomertoFile(nearOfficeList, dumpFilePath);
		assertTrue(new File(dumpFilePath).exists());
	}
}
