package org.zerock.search;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

public interface SearchMapper {

	public String getTime();
	
	public List<String> map1(Map<String, String> param);
	
	
	
	public List<String> arr1(
			@Param("arr") String[] arr,
			@Param("keyword") String keyword);
	
	
	
	public List<String> search1(
	@Param("type")String type,
	@Param("keyword") String keyword);

	public List<String> search2(Map<String, String> m);
	
	
	
}
