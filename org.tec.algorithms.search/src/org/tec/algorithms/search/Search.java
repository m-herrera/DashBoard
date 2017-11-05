package org.tec.algorithms.search;

import java.util.List;

public class Search <T extends Comparable<T>>{
	
	public T linearSearch(T value, List<T> list) {
		for (T element : list) {
			if (element.compareTo(value) == 0) {
				return element;
			}
		}
		return null;
	}
	
	public T binarySearch(T value, List<T> list) {
		return null;
	}
	
}
