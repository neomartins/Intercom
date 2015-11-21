package com.dublioffice;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import com.dublinoffice.ArrayConvert;

public class ArrayConvertTest {

	Object[] array1 = new Object[] { new Object[] { 1,2, new Object[] { 3 } }, 4};
	Object[] array2 = new Object[] { 1, 2, new Object[] { 3, new Object[] { 4, 5 } }, 6, 7 };
	ArrayConvert arrayConvert =  new ArrayConvert();
	
	@Test
	public void test1() {
		List<Integer> list = new ArrayList<>();
		for(int i = 1;i<5;i++){
			list.add(i);
		}
		assertEquals(list, arrayConvert.flatten(array1));
	}
	
	@Test
	public void test2() {
		List<Integer> list = new ArrayList<>();
		for(int i = 1;i<8;i++){
			list.add(i);
		}
		assertEquals(list, arrayConvert.flatten(array2));
	}
	
}
