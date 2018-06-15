package org.zerock.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.zerock.domain.BoardVO;
import org.zerock.domain.Criteria;
import org.zerock.domain.SearchCriteria;

public interface BoardService {
	
	//public List<BoardVO> getPage(Criteria cri) throws Exception;
	
	//public int getTotalPage(Criteria cri) throws Exception;
	
	public void create(BoardVO vo) throws Exception;
	
	public BoardVO read(int bno) throws Exception;
	
	public void delete(int bno) throws Exception;	
	
	public void update(BoardVO vo) throws Exception;	// regist 를 대신함
	
	public List<BoardVO>listAll() throws Exception;
	
	public List<BoardVO> listPage(int bno) throws Exception;
	
	public List<BoardVO> listCriteria(Criteria cri) throws Exception;
	
	public int countPaging(Criteria cri) throws Exception;
	
	public int listCountCriteria(Criteria cri) throws Exception;
	
	public List<BoardVO> listSearch(SearchCriteria cri) throws Exception;
	
	public int listSearchCount(SearchCriteria cri) throws Exception;
	
	public int updateReplyCnt(@Param("bno")Integer bno, @Param("amount") int amount) throws Exception;
	
	public int updateViewCnt(Integer bno) throws Exception;
	
	public void addAttach(String fullname) throws Exception;
	
	public String getAttach(Integer bno) throws Exception;
	
	public void deleteAttach(Integer bno)throws Exception;
	
	public void replaceAttach(@Param("fullName")String fullName, @Param("bno") Integer bno)throws Exception;
	
	public void modify(BoardVO vo)throws Exception;
	
	public void remove(Integer bno) throws Exception;
	
}
