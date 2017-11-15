package com.service.toolkit;

import java.util.List;
import java.util.ServiceLoader;

public interface Sort {
	<T> List<T> sort(List<T> elements);
	
	static Sort lookup(){
		return ServiceLoader.load(Sort.class)
		                    .findFirst()
                            .orElseThrow(() -> new RuntimeException("No Sort service found."));
	}
	
}