package com.dublinoffice;

import java.util.List;

/**
 * @author Neo
 *
 */
public class DublinOffice {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		 Core c = new Core();
		 Double officeLatitude = 53.3381985;
		 Double officeLongitude = -6.2592576; 
		 List<CustomerBean> custumerRead = c.readCustomer(args[0]);
		 List<CustomerBean> nearCustomer = c.getNearCustomer(custumerRead, officeLatitude, officeLongitude);
		 c.writeCustomertoFile(nearCustomer, args[1]);
    }
}
