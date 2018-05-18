package org.zerock.service;

import java.util.List;

import org.zerock.domain.BoardVO;
import org.zerock.domain.Criteria;

public interface BoardService {
	
	//public List<BoardVO> getPage(Criteria cri) throws Exception;
	
	//public int getTotalPage(Criteria cri) throws Exception;
	
	public void create(BoardVO vo);
	
	public BoardVO read(int bno) throws Exception;
	
	public void delete(int bno) throws Exception;
	
	public void update(BoardVO vo) throws Exception;
	
	public List<BoardVO>listAll() throws Exception;
	
	public List<BoardVO> listPage(int bno) throws Exception;
	
	public List<BoardVO> listCriteria(Criteria cri) throws Exception;
	
	
}
