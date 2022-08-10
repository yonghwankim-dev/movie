package test.java.kr.com.yh.service;

import com.ibatis.sqlmap.client.SqlMapClient;
import kr.com.yh.lotte.vo.MemberSearch;
import kr.com.yh.lotte.vo.MemberSearchCategory;
import kr.com.yh.lotte.vo.MemberVO;
import kr.com.yh.util.SqlMapClientFactory;
import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.sql.Date;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class MemberServiceTest {

	private SqlMapClient smc;
	
	@BeforeEach
	public void setup() {
		smc = SqlMapClientFactory.getInstance();
	}

	@Test
	void findMemberAllTest() throws Exception{
		//given
		List<MemberVO> members;

		String content = null;
		String category = "NAME";

		MemberSearch memberSearch = MemberSearch.builder()
												.content(content)
												.memberSearchCategory(MemberSearchCategory.valueOf(category))
												.build();

		//when
		members = smc.queryForList("mem.findMemberAll", memberSearch);

		//then
		assertThat(members).isNotNull();
	}

	@Test
	void findMemberAllByNameTest() throws Exception{
		//given
		List<MemberVO> members;
		MemberSearch memberSearch = MemberSearch.builder()
												.content("홍길")
												.memberSearchCategory(MemberSearchCategory.NAME)
												.build();

		//when
		members = smc.queryForList("mem.findMemberAll", memberSearch);

		//then
		assertThat(members).isNotNull();
	}

	@Test
	void findMemberAllByIdTest() throws Exception{
		//given
		List<MemberVO> members;
		MemberSearch memberSearch = MemberSearch.builder()
				.content("user")
				.memberSearchCategory(MemberSearchCategory.ID)
				.build();

		//when
		members = smc.queryForList("mem.findMemberAll", memberSearch);


		//then
		assertThat(members).isNotNull();
	}

	@Test
	void findMemberAllByContactTest(){
		//given
		List<MemberVO> members;
		MemberSearch memberSearch = MemberSearch.builder()
												.content("010-1111-1111")
												.memberSearchCategory(MemberSearchCategory.CONTACT)
												.build();

		//when
		try{
			members = smc.queryForList("mem.findMemberAll", memberSearch);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}

		//then
		assertThat(members).isNotNull();
		assertThat(members.get(0).getContact()).isEqualTo("010-1111-1111");
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

	@Test
	void findMemberByNameTest(){
		List<MemberVO> mems = null;
		String name = "김";

		try{
			mems = smc.queryForList("mem.findMemberByName", name);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		Assert.assertNotNull(mems);
	}


	@Test
	void findMemberByIdTest(){
		List<MemberVO> mems = null;
		String id = "user";

		try{
			mems = smc.queryForList("mem.findMemberById", id);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		Assert.assertNotNull(mems);
	}

	@Test
	void findMemberByContactTest(){
		List<MemberVO> mems = null;
		String contact = "010-1111-1111";

		try{
			mems = smc.queryForList("mem.findMemberByContact", contact);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		Assert.assertNotNull(mems);
	}
}
