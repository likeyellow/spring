package org.zerock.persistence;

import java.util.List;

import org.zerock.domain.BoardVO;
import org.zerock.domain.Criteria;
import org.zerock.domain.MemberVO;

public interface BoardDAO {
	
	public void create(BoardVO vo) throws Exception;	// C
	
	public BoardVO read(Integer bno) throws Exception;	// R
	
	public void update(BoardVO vo) throws Exception;	// U
	
	public void delete(Integer bno) throws Exception;	// D
	
	public List<BoardVO> listAll() throws Exception;	// 화면상에 데이터의 모든 목록을 보여주는 기능

	public MemberVO getUserName() throws Exception;
	
	
	
}
