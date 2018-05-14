package org.zerock.persistence;

import java.util.HashMap;
import java.util.Map;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;
import org.zerock.domain.MemberVO;

@Repository // @Repository��  DAO�� �������� �νĽ�Ű�� ���ؼ� ���
public class MemberDAOImpl implements MemberDAO {

	
	@Inject
	private SqlSession sqlSession; 
	
	
/*	@Setter(onMethod_= {@Autowired})
	private TodoMapper mapper;	   �̷��� �ϸ� ????? DAO ����� �Ͱ� ������ �ٸ���???	*/
	
	private static final String namespace =
			"org.zerock.mapper.memberMapper";
	
	@Override
	public String getTime() {
		
		return sqlSession.selectOne(namespace+".getTime");	// selectOne �̰� ��¡????
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
