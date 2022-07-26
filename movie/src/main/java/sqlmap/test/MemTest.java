package sqlmap.test;

import com.ibatis.sqlmap.client.SqlMapClient;
import kr.com.yh.lotte.vo.MemberVO;
import kr.com.yh.util.SqlMapClientFactory;
import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

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

}
