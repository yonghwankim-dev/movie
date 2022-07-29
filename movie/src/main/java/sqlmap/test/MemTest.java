package sqlmap.test;

import com.ibatis.sqlmap.client.SqlMapClient;
import kr.com.yh.lotte.vo.MemberVO;
import kr.com.yh.util.SqlMapClientFactory;
import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.sql.Date;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;

class MemTest {

	private SqlMapClient smc;
	
	@BeforeEach
	public void setup() {
		smc = SqlMapClientFactory.getInstance();
	}

	@Test
	void findMemberAllTest(){
		List<MemberVO> mems;

		try{
			mems = smc.queryForList("mem.findMemberAll");
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}

		Assert.assertNotNull(mems);
	}

	@Test
	void deleteMemberByMemberCode(){
		int cnt = 0;
		List<String> mem_codes = Arrays.asList(new String[]{"MEM8"});

		try {
			smc.startTransaction();
			cnt = smc.delete("mem.deleteMemberByMemberCode", mem_codes);
		} catch (SQLException e) {
			e.printStackTrace();
			cnt = 0;
		}finally {
			try {
				smc.endTransaction();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		Assert.assertEquals(1, cnt);
	}

	@Test
	void findMemberByMemberCode(){
		MemberVO mem;
		String mem_code = "MEM61";

		try{
			mem = (MemberVO) smc.queryForObject("mem.findMemberByMemberCode", mem_code);
		} catch (SQLException e) {
			e.printStackTrace();
			mem = null;
		}

		Assert.assertNotNull(mem);
	}

	@Test
	void modifyMemberByMemberCodeTest(){
		int cnt = 0;

		String mem_code = "MEM61";
		String name     = "김갑수";
		Date birthday   = Date.valueOf("1990-01-01");
		String contact  = "010-1111-6542";
		String addr     = "서울";
		String email    = "user61@gmail.com";
		String id       = "user61";
		String gender   = "F";

		MemberVO mem = MemberVO.builder()
				.mem_code(mem_code)
				.name(name)
				.birthday(birthday)
				.contact(contact)
				.addr(addr)
				.email(email)
				.id(id)
				.gender(gender)
				.build();

		try {
			smc.startTransaction();
			cnt = smc.update("mem.modifyMemberByMemberCode", mem);
			smc.endTransaction();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}

		Assert.assertEquals(1, cnt);
	}

}
