package org.zerock.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.zerock.domain.BoardVO;
import org.zerock.domain.Criteria;
import org.zerock.persistence.BoardMapper;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@Log4j
@Service
public class BoardServiceImpl implements BoardService {
	
	@Setter(onMethod_= {@Autowired})
	BoardMapper mapper;
	
	
	@Override
	public void create(BoardVO vo) {

		log.info("implements create....." );
		//log.info(mapper.create(vo));
		
		try {
		
			mapper.create(vo);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//return null;
	}

	@Override
	public BoardVO read(int bno) throws Exception {
		
		log.info("read ȣ����.....!!!!");
		
		return mapper.read(bno);
	}

	@Override
	public void delete(int bno){
	
	//	log.info(mapper.delete(bno));

	}

	@Override
	public void update(BoardVO vo) throws Exception {
		
		
	}

	@Override
	public List<BoardVO> listAll() throws Exception {
		
		log.info("listAll() ȣ����...!!!!");
		
		return null;
	}

	@Override
	public List<BoardVO> listPage(int page) throws Exception {
		
		if(page <=0) {
			page = 1;
		}
		page = (page -1) *10;
		return mapper.listPage(page);
	}

	@Override
	public List<BoardVO> listCriteria(Criteria cri) throws Exception {
		
		return mapper.listCriteria(cri);
	}
}
