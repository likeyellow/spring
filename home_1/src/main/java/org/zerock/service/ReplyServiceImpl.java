package org.zerock.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.zerock.domain.ReplyVO;
import org.zerock.persistence.BoardMapper;
import org.zerock.persistence.ReplyMapper;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@Log4j
@Service
public class ReplyServiceImpl implements ReplyService {
	
	@Setter(onMethod_= {@Autowired})
	ReplyMapper reply;
	
	@Override
	public void addReply(ReplyVO vo) throws Exception {
		
		reply.create(vo);
	}

	@Override
	public List<ReplyVO> listReply(Integer bno) throws Exception {
		
		return reply.list(bno);
	}

	@Override
	public void modifyReply(ReplyVO vo) throws Exception {
		
		reply.update(vo);
	}

	@Override
	public void removeReply(Integer rno) throws Exception {
		
		reply.delete(rno);
	}

}
