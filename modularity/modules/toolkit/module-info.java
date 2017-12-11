import com.service.toolkit.Sort;

module toolkit {
	opens com.toolkit.monitor to shop;
	requires spi;
	provides Sort with com.toolkit.sort.QuickSort; 
}