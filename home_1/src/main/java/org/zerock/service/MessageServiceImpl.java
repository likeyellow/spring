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
	
	// ���� ���� ��ü�� �ٸ� ���� �ΰ�(= MessageMapper, PointMapper)�� mapper�� 
	// ���� Ȱ���ؼ� �ϳ��� �����Ͻ� ������ �ϼ��ϴ� ���·� ���

	@Setter(onMethod_= {@Autowired})
	private MessageMapper message;

	@Setter(onMethod_= {@Autowired})
	private PointMapper point;
	
	@Override
	public void addMessage(MessageVO vo) throws Exception {
		
		log.warn("-------------------------------1");
		message.create(vo);	// MessageMapper �� create()�� ȣ���ؼ� ���ο� �޽����� �߰���
		
		log.warn("-------------------------------2");
		point.updatePoint(vo.getSender(), 10); // ���ÿ� PointMapper�� updatePoint()�� �̿��ؼ� �޽����� ����������� 10���� �߰�����
		
	}

	@Override
	public MessageVO readMessage(String uid, Integer mno) throws Exception {	// �޽����� ��ȸ
		
		message.updateState(mno); 	// 1) �޽����� ���°� �����
		point.updatePoint(uid, 5);	// 2) �޽����� �� ����� ����Ʈ�� 5�� ����
		return message.readMessage(mno);	// 3) ��� �۾� �� �޽����� ��ȸ�ؼ� ��ȯ
	}
	
	
}
