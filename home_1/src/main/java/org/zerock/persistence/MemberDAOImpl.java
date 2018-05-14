package org.zerock.persistence;

import java.util.HashMap;
import java.util.Map;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;
import org.zerock.domain.MemberVO;

@Repository // @Repository는  DAO를 스프링에 인식시키기 위해서 사용
public class MemberDAOImpl implements MemberDAO {

	
	@Inject
	private SqlSession sqlSession; 
	
	
/*	@Setter(onMethod_= {@Autowired})
	private TodoMapper mapper;	   이렇게 하면 ????? DAO 만드는 것과 개념이 다른가???	*/
	
	private static final String namespace =
			"org.zerock.mapper.memberMapper";
	
	@Override
	public String getTime() {
		
		return sqlSession.selectOne(namespace+".getTime");	// selectOne 이게 뭐징????
	}

	@Override
	public void insertMember(MemberVO vo) {
		sqlSession.insert(namespace+".insertMember", vo);

	}

	@Override
	public MemberVO readMember(String userid) throws Exception {
		
		return (MemberVO)sqlSession.selectOne(namespace+".selectMember", userid);
	}

	@Override
	public MemberVO readWithPW(String userid, String userpw) throws Exception {
		
		Map<String, Object> paramMap = new HashMap<String, Object>();
		
		paramMap.put("userid",  userid);
		return null;
	}
	
	

}
