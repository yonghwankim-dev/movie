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
	void 회원전체검색() throws Exception{
		//given
		List<MemberVO> members;

		String content = null;
		String category = "NAME";

		MemberSearch memberSearch = MemberSearch.builder()
												.content(content)
												.memberSearchCategory(MemberSearchCategory.valueOf(category))
												.build();

		//when
		members = smc.queryForList("mem.findAll", memberSearch);

		//then
		assertThat(members).isNotNull();
	}

	@Test
	void 회원전체검색_이름() throws Exception{
		//given
		List<MemberVO> members;
		MemberSearch memberSearch = MemberSearch.builder()
												.content("홍길")
												.memberSearchCategory(MemberSearchCategory.NAME)
												.build();

		//when
		members = smc.queryForList("mem.findAll", memberSearch);

		//then
		assertThat(members).isNotNull();
	}

	@Test
	void 회원전체검색_아이디() throws Exception{
		//given
		List<MemberVO> members;
		MemberSearch memberSearch = MemberSearch.builder()
												.content("user")
												.memberSearchCategory(MemberSearchCategory.ID)
												.build();

		//when
		members = smc.queryForList("mem.findAll", memberSearch);


		//then
		assertThat(members).isNotNull();
	}

	@Test
	void 회원전체검색_연락처(){
		//given
		List<MemberVO> members;
		MemberSearch memberSearch = MemberSearch.builder()
												.content("010-1111-2222")
												.memberSearchCategory(MemberSearchCategory.CONTACT)
												.build();

		//when
		try{
			members = smc.queryForList("mem.findAll", memberSearch);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}

		//then
		assertThat(members).isNotNull();
		assertThat(members.get(0).getContact()).isEqualTo("010-1111-2222");
	}


	@Test
	void 회원전체검색_이름값(){
		List<MemberVO> mems = null;
		String id = "user";

		try{
			mems = smc.queryForList("mem.findAllById", id);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		Assert.assertNotNull(mems);
	}

	@Test
	void 회원전체검색_연락처값(){
		List<MemberVO> mems = null;
		String contact = "010-1111-1111";

		try{
			mems = smc.queryForList("mem.findAllByContact", contact);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		Assert.assertNotNull(mems);
	}

	@Test
	void 회원단일검색(){
		MemberVO mem = null;
		String mem_code = "MEM61";

		try{
			mem = (MemberVO) smc.queryForObject("mem.findOne", mem_code);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		Assert.assertNotNull(mem);
	}

	@Test
	void 회원단일검색_아이디값(){
		MemberVO mem = null;
		String id = "user1";

		try{
			mem = (MemberVO) smc.queryForObject("mem.findOneById", id);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		assertThat(mem.getId()).isEqualTo("user1");
	}

	@Test
	void 회원단일검색_연락처값(){
		MemberVO mem = null;
		String contact = "010-1111-2222";

		try{
			mem = (MemberVO) smc.queryForObject("mem.findOneByContact", contact);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		assertThat(mem.getContact()).isEqualTo("010-1111-2222");
	}



	@Test
	void 회원수정(){
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
			cnt = smc.update("mem.modifyOne", mem);
			smc.endTransaction();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}

		Assert.assertEquals(1, cnt);
	}

	@Test
	void 회원다수삭제(){
		int cnt = 0;
		List<String> mem_codes = Arrays.asList(new String[]{"MEM7"});

		try {
			smc.startTransaction();
			cnt = smc.delete("mem.deleteAll", mem_codes);
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				smc.endTransaction();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		assertThat(cnt).isEqualTo(1);
	}

	@Test
	void 회원단일삭제(){
		int cnt = 0;
		String mem_code = "MEM7";

		try {
			smc.startTransaction();
			cnt = smc.delete("mem.deleteOne", mem_code);
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				smc.endTransaction();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		assertThat(cnt).isEqualTo(1);
	}

}
