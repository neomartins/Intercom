package com.dublinoffice;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Neo
 *
 */

public class ArrayConvert {

	/**
	 * @param array
	 * @return array after flatten
	 */ 
	public List<Integer> flatten(Object[] array) {
		List<Integer> flatArray = new ArrayList<>();
		if (array != null) {
			for (Object element : array) {
				if (element instanceof Integer) {
					flatArray.add((Integer) element);
				} else {
					flatArray.addAll(flatten((Object[]) element));
				}
			}
		}
		return flatArray;
	}
}
