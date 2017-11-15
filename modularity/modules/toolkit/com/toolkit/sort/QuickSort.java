package com.toolkit.sort;

import com.service.toolkit.Sort;
import java.util.List;
import java.util.stream.Collectors;


public class QuickSort implements Sort{
	
	public <T> List<T> sort(List<T> elements){
		return elements.stream().sorted().collect(Collectors.toList());
	}
}