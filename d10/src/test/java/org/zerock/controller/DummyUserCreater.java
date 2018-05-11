package org.zerock.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import org.zerock.domain.MemberAuthVO;
import org.zerock.domain.MemberVO;
import org.zerock.mapper.MemberMapper;

import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({ "file:src/main/webapp/WEB-INF/spring/root-context.xml",
		"file:src/main/webapp/WEB-INF/spring/security-context.xml" })
@Log4j
public class DummyUserCreater {

	@Autowired
	private PasswordEncoder encoder;

	@Autowired
	private MemberMapper mapper;

	@Test
	public void testRead() {

		MemberVO vo = mapper.read("user99");
		log.info(vo);
	}

	@Test
	public void testInsert() {

		for (int i = 0; i < 100; i++) {
			MemberVO vo = new MemberVO();
			vo.setUid("user" + i);
			vo.setUpw(encoder.encode("pw" + i));
			vo.setUname("»ç¿ëÀÚ" + i);

			mapper.insert(vo);

			if (i >= 0) {
				MemberAuthVO auth1 = new MemberAuthVO();
				auth1.setUid("user" + i);
				auth1.setAuth("ROLE_USER");
				mapper.insertAuth(auth1);
			}

			if (i >= 80) {
				MemberAuthVO authMan = new MemberAuthVO();
				authMan.setUid("user" + i);
				authMan.setAuth("ROLE_MANAGER");
				mapper.insertAuth(authMan);
			}

			if (i >= 90) {
				MemberAuthVO authAdmin = new MemberAuthVO();
				authAdmin.setUid("user" + i);
				authAdmin.setAuth("ROLE_ADMIN");
				mapper.insertAuth(authAdmin);
			}

		}
	}
}
