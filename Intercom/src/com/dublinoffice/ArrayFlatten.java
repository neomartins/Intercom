package com.dublinoffice;

public class ArrayFlatten {

	public static void main(String[] args) {
		ArrayConvert convert =  new ArrayConvert();
		Object[] array = new Object[] { new Object[] { 1,2, new Object[] { 3 } }, 4};
		
		System.out.println(convert.flatten(array));
	}
}
