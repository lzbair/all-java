import com.service.toolkit.Sort;
import com.toolkit.sort.QuickSort;
module toolkit {
	opens com.toolkit.monitor to shop;
	requires spi;
	provides Sort with com.toolkit.sort.QuickSort; 
}