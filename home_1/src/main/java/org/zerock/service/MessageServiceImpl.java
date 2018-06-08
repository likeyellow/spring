package org.zerock.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.zerock.domain.MessageVO;
import org.zerock.persistence.MessageMapper;
import org.zerock.persistence.PointMapper;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@Log4j
@Service
public class MessageServiceImpl implements MessageService {
	
	// 기존 서비스 객체와 다른 점은 두개(= MessageMapper, PointMapper)의 mapper를 
	// 같이 활용해서 하나의 비지니스 로직을 완성하는 형태로 사용

	@Setter(onMethod_= {@Autowired})
	private MessageMapper message;

	@Setter(onMethod_= {@Autowired})
	private PointMapper point;
	
	@Override
	public void addMessage(MessageVO vo) throws Exception {
		
		log.warn("-------------------------------1");
		message.create(vo);	// MessageMapper 에 create()를 호출해서 새로운 메시지를 추가함
		
		log.warn("-------------------------------2");
		point.updatePoint(vo.getSender(), 10); // 동시에 PointMapper의 updatePoint()를 이용해서 메시지를 보낸사람에게 10점을 추가해줌
		
	}

	@Override
	public MessageVO readMessage(String uid, Integer mno) throws Exception {	// 메시지를 조회
		
		message.updateState(mno); 	// 1) 메시지의 상태가 변경됨
		point.updatePoint(uid, 5);	// 2) 메시지를 본 사람의 포인트가 5점 증가
		return message.readMessage(mno);	// 3) 모든 작업 후 메시지를 조회해서 반환
	}
	
	
}
