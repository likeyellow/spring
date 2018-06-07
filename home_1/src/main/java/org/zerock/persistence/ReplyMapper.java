package org.zerock.persistence;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.zerock.domain.Criteria;
import org.zerock.domain.ReplyVO;

public interface ReplyMapper {
	
	public List<ReplyVO> list(Integer bno) throws Exception;
	
	public void create(ReplyVO vo) throws Exception;
	
	public void update(ReplyVO vo) throws Exception;
	
	public void delete(Integer rno) throws Exception;

	public List<ReplyVO> listPage(@Param("bno") Integer bno, @Param("cri") Criteria cri) throws Exception;
	
	public int count(Integer bno) throws Exception;
}
