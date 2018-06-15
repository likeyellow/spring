package org.zerock.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;
import org.zerock.domain.BoardVO;
import org.zerock.domain.Criteria;
import org.zerock.domain.SearchCriteria;
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

	@Transactional(isolation=Isolation.READ_COMMITTED)
	@Override
	public BoardVO read(int bno) throws Exception {
		
		log.info("read 호출함.....!!!!");
		
		mapper.updateViewCnt(bno);
		return mapper.read(bno);
	}

	@Override
	public void delete(int bno){
	
	//	log.info(mapper.delete(bno));

	}
	
	@Transactional
	@Override
	public void update(BoardVO vo) throws Exception {	// register 메소드 
		
		mapper.create(vo);
		
		String[] files = vo.getFiles();
		
		if(files == null) { return; }
		
		for(String fileName: files) {
			mapper.addAttach(fileName);
		}
	}
	
	
	@Override
	public List<BoardVO> listAll() throws Exception {
		
		log.info("listAll() 호출함...!!!!");
		
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

	@Override
	public int countPaging(Criteria cri) throws Exception {
		
		return mapper.countPaging(cri);
	}

	@Override
	public int listCountCriteria(Criteria cri) throws Exception {
		
		return mapper.countPaging(cri);
	}

	@Override
	public List<BoardVO> listSearch(SearchCriteria cri) throws Exception {
		
		return mapper.listSearch(cri);
	}

	@Override
	public int listSearchCount(SearchCriteria cri) throws Exception {
		
		return mapper.listSearchCount(cri);
	}

	@Override
	public int updateReplyCnt(Integer bno, int amount) throws Exception {
		
		Map<String, Object> paramMap = new HashMap<String, Object>();
		
		paramMap.put("bno", bno);
		paramMap.put("amount", amount);
		
		// session.update(namespace + ".updateReplyCnt", paramMap);	
		return mapper.updateReplyCnt(bno, amount);
	}

	@Override
	public int updateViewCnt(Integer bno) throws Exception {
		
		return mapper.updateViewCnt(bno);
	}

	@Override
	public void addAttach(String fullname) throws Exception {
		
		
		log.info("addAttach 메소드의 fullname 입니다 " + fullname);
		mapper.addAttach(fullname);
		
	}

	@Override
	public String getAttach(Integer bno) throws Exception {
		
		return mapper.getAttach(bno);
	}

	@Override
	public void deleteAttach(Integer bno) throws Exception {
		
		mapper.deleteAttach(bno);
		
	}

	@Override
	public void replaceAttach(String fullName, Integer bno) throws Exception {
	
		Map<String, Object> paramMap = new HashMap<String, Object>();
		
		paramMap.put("bno", bno);
		paramMap.put("fullName", fullName);
		
		mapper.replaceAttach(fullName, bno);
	}
	
	@Transactional
	@Override
	public void remove(Integer bno) throws Exception {
		
		mapper.deleteAttach(bno);
		mapper.delete(bno);
		
	}

	@Override
	public void modify(BoardVO vo) throws Exception {
		
		mapper.update(vo);
		
		Integer bno = vo.getBno();
		
		mapper.deleteAttach(bno);
		
		String[] files = vo.getFiles();
		
		if(files == null) {
			return;
		}
		for(String fileName : files) {
			mapper.replaceAttach(fileName, bno);
		}
	}
	
	
	
	
	
}
