package org.zerock.test2;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.zerock.domain.BoardVO;
import org.zerock.mapper.BoardMapper;
import org.zerock.util.Criteria;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class BoardMapperTest {

	@Setter(onMethod_ = { @Autowired })
	private BoardMapper mapper;

	@Test
	public void update() {
		BoardVO vo = mapper.read(40L);

		vo.setTitle("¶ö¶ö¶ó");
		vo.setContent("26ÀÏ Å×½ºÆ®");
		log.info(mapper.update(vo));
	}

	@Test
	public void delete() {
		mapper.delete(50L);
	}

	@Test
	public void list() {
		mapper.list(new Criteria(4)).forEach(vo -> log.info(vo));
	}

	@Test
	public void insert() {
		for (int i = 0; i < 10; i++) {
			BoardVO vo = new BoardVO();
			vo.setTitle("yoo");
			vo.setContent("cc");
			vo.setWriter("me");
			log.info(mapper.insert(vo));

		}
	}

	@Test
	public void read() {
		log.info(mapper.read(50L));
	}
}
