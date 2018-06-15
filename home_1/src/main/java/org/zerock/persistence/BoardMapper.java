package org.zerock.persistence;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.zerock.domain.BoardVO;
import org.zerock.domain.Criteria;
import org.zerock.domain.MemberVO;
import org.zerock.domain.SearchCriteria;

public interface BoardMapper {

/*	@Select("select now()")
	public String getTime();
	
	@Select("select email from tbl_member3 "
			+ " where userid= #{id} and userpw = #{pw}")
	public String getEmail();
	
	public String getUserName(
			@Param("id")String id,
			@Param("pw")String pw);
	
	public void create(
			@Param("title")String title,
			@Param("content")String content,
			@Param("writer")String writer
			);
	
	public String read2(
			@Param("bno")Integer bno
			);
	
	public void update2(
			@Param("title")String title,
			@Param("content")String content,
			@Param("bno")Integer bno
			);
	
	public void delete2(
			@Param("bno")Integer bno
			);
	
	@Select("select bno, title,content, writer, regdate, viewcnt "
			+ " from tbl_board3 where bno > 0 " 
			+ "order by bno desc, regdate desc")
	public String listAll2();
	*/
	//----------------------------------------------
	
	public void create(BoardVO vo) throws Exception;	// C
	
	public BoardVO read(Integer bno) throws Exception;	// R
	
	public void update(BoardVO vo) throws Exception;	// U
	
	public void delete(Integer bno) throws Exception;	// D
	
	public List<BoardVO> listAll() throws Exception;	// 화면상에 데이터의 모든 목록을 보여주는 기능

	public MemberVO getUserName() throws Exception;
	 
	public void regist(BoardVO vo) throws Exception;	// 이 기능은 update 메소드로 대체함
	
	public List<BoardVO> listPage(int bno) throws Exception;

	public List<BoardVO> listCriteria(Criteria cri)throws Exception;
	
	
	
	public int countPaging(Criteria cri) throws Exception;
	
	public int listCountCriteria(Criteria cri) throws Exception;
	
	public List<BoardVO> listSearch(SearchCriteria cri) throws Exception;
	
	public int listSearchCount(SearchCriteria cri) throws Exception;
	
	public int updateReplyCnt(@Param("bno")Integer bno, @Param("amount")int amount)throws Exception;
	
	public int updateViewCnt(Integer bno) throws Exception;
	
	public void addAttach(String fullname) throws Exception;
	
	public String getAttach(Integer bno) throws Exception;	// ??? return type 이상함. 이상해......... >.<
	
	public void deleteAttach(Integer bno)throws Exception;
	
	public void replaceAttach(@Param("fullName") String fullName, @Param("bno") Integer bno)throws Exception;
	
}
