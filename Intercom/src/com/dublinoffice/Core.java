package com.dublinoffice;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 * @author Neo
 *
 */
public class Core {

	/**
	 * 
	 */
	private static final double R = 6371.0; // earths mean radius in km

	/**
	 * @param path
	 * @return List of customer
	 * @throws ParseException, IOException
	 */ 
	public List<CustomerBean> readCustomer(String path) {
		JSONParser parser = new JSONParser();
		List<CustomerBean> custumerList = new ArrayList();

		RandomAccessFile accessFile;
		try {
			accessFile = new RandomAccessFile(new File(path), "rw");

			String line = null;

			while ((line = accessFile.readLine()) != null) {
				Object obj = parser.parse(line);

				JSONObject jsonObject = (JSONObject) obj;

				custumerList.add(new CustomerBean((Long) jsonObject.get("user_id"), (String) jsonObject.get("name"),
						(String) jsonObject.get("latitude"), (String) jsonObject.get("longitude")));
			}

			accessFile.close();
		} catch (ParseException | IOException e) {
			e.printStackTrace();
		}
		return custumerList;
	}

	/**
	 * @param allcustomers
	 * @param officeLatitude
	 * @param officeLongitude
	 * @return List of customer within 100km
	 */
	public List<CustomerBean> getNearCustomer(final List<CustomerBean> allcustomers, Double officeLatitude,
			Double officeLongitude) {
		Double longitude;
		Double latitude;

		List<CustomerBean> custumerList = new ArrayList();

		for (CustomerBean customer : allcustomers) {
			latitude = Math.toRadians(customer.getLatitude());
			longitude = Math.toRadians(customer.getLongitude());
			// great circle distance in radians
			double distance = R * Math.acos(Math.sin(Math.toRadians(officeLatitude)) * Math.sin(latitude)
					+ Math.cos(Math.toRadians(officeLatitude)) * Math.cos(latitude)
							* Math.cos(Math.toRadians(officeLongitude) - longitude));
			if (distance <= 100) {
				custumerList.add(new CustomerBean(customer.getCustomerId(), customer.getCustumerName(),
						customer.getLatitude().toString(), customer.getLongitude().toString()));
			}
		}
		return custumerList;
	}

	/**
	 * @param sortedCustomers
	 * @param path
	 * @throws IOException
	 */
	public void writeCustomertoFile(final List<CustomerBean> sortedCustomers, String path) {
		JSONObject jsonObject = new JSONObject();

		FileWriter writeFile;
		try {
			writeFile = new FileWriter(path);

			Collections.sort(sortedCustomers);
			for (CustomerBean customer : sortedCustomers) {

				jsonObject.put("user_id", customer.getCustomerId());
				jsonObject.put("name", customer.getCustumerName());
				writeFile.write(jsonObject.toJSONString() + "\n");
			}
			writeFile.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
