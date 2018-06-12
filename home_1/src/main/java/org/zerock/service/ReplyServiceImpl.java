package org.zerock.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.zerock.domain.Criteria;
import org.zerock.domain.ReplyVO;
import org.zerock.persistence.BoardMapper;
// import org.zerock.mapper.BoardMapper;    (???? � ���� import �ؾ�����??? .mapper ��Ű�� �ΰ�? �ƴϸ�, persistence ��Ű���ΰ�? �ƴϸ� �������?) 
import org.zerock.persistence.ReplyMapper;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@Log4j
@Service
public class ReplyServiceImpl implements ReplyService {
	
	@Setter(onMethod_= {@Autowired})
	private ReplyMapper reply;
	
	@Setter(onMethod_= {@Autowired})
	private BoardMapper board;
	
	@Transactional
	@Override
	public void addReply(ReplyVO vo) throws Exception {
		
		reply.create(vo);
		board.updateReplyCnt(vo.getBno(), 1);
	}

	@Override
	public List<ReplyVO> listReply(Integer bno) throws Exception {
		
		return reply.list(bno);
	}

	@Override
	public void modifyReply(ReplyVO vo) throws Exception {
		
		reply.update(vo);
	}
	
	@Transactional
	@Override
	public void removeReply(Integer rno) throws Exception {
		
		int bno = reply.getBno(rno);
		reply.delete(rno);
		board.updateReplyCnt(bno, -1);
	}

/*	@Override
	public List<ReplyVO> listPage(Integer bno, Criteria cri) throws Exception {
		
		Map<String, Object> paramMap = new HashMap<>();
		paramMap.put("bno",  bno);
		paramMap.put("cri", cri);
		
		return reply.listPage(bno, cri); //   ????????? �� ��������� ����????
	}*/

	@Override
	public int count(Integer bno) throws Exception {
		
		return reply.count(bno);
	}

	@Override
	public List<ReplyVO> listReplyPage(Integer bno, Criteria cri) throws Exception {
		
		return reply.listPage(bno, cri);
	}

	@Override
	public int getBno(Integer rno) throws Exception {
		
		return reply.getBno(rno);
	}
}
