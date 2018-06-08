package org.zerock.service;

import org.apache.ibatis.annotations.Param;

public interface PointService {

	public void updatePoint(@Param("uid") String uid, @Param("point") int point)throws Exception;
	
}
