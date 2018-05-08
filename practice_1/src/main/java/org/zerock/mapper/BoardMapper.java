package org.zerock.mapper;

import java.util.List;

import org.zerock.domain.BoardVO;
import org.zerock.util.Criteria;

public interface BoardMapper {

	public int update(BoardVO vo);

	public int delete(Long bno);

	public List<BoardVO> list(Criteria cri);

	public int insert(BoardVO vo);

	public BoardVO read(Long bno);
}
