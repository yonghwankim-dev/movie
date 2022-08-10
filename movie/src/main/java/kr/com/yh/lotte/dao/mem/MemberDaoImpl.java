package kr.com.yh.lotte.dao.mem;

import com.ibatis.sqlmap.client.SqlMapClient;
import kr.com.yh.lotte.vo.MemberSearch;
import kr.com.yh.lotte.vo.MemberVO;
import kr.com.yh.util.SqlMapClientFactory;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MemberDaoImpl implements IMemberDao {
    private SqlMapClient smc;

    private static IMemberDao memberDao;

    private MemberDaoImpl() {
        smc = SqlMapClientFactory.getInstance();
    }

    public static IMemberDao getInstance() {
        if (memberDao == null) {
            memberDao = new MemberDaoImpl();
        }
        return memberDao;
    }

    @Override
    public List<MemberVO> findMemberAll(MemberSearch memberSearch) {
        List<MemberVO> mems;

        try{
            mems = smc.queryForList("mem.findMemberAll", memberSearch);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return mems;
    }

    @Override
    public MemberVO findOne(String mem_code) {
        MemberVO member;

        try{
            member = (MemberVO) smc.queryForObject("mem.findOne", mem_code);
        } catch (SQLException e) {
            throw  new RuntimeException(e);
        }

        return member;
    }

    @Override
    public List<MemberVO> findMemberByName(String name) {
        List<MemberVO> mems = new ArrayList<>();

        try {
            mems = smc.queryForList("mem.findMemberByName", name);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return mems;
    }

    @Override
    public List<MemberVO> findMemberById(String id) {
        List<MemberVO> mems = new ArrayList<>();

        try {
            mems = smc.queryForList("mem.findMemberById", id);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return mems;
    }

    @Override
    public List<MemberVO> findMemberByContact(String contact) {
        List<MemberVO> mems = new ArrayList<>();

        try {
            mems = smc.queryForList("mem.findMemberByContact", contact);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return mems;
    }

    @Override
    public int modifyMemberByMemberCode(MemberVO mem) {
        int cnt = 0;

        try {
            smc.startTransaction();
            cnt = smc.update("mem.modifyMemberByMemberCode", mem);
            smc.commitTransaction();
        } catch (SQLException e) {
            e.printStackTrace();
            cnt = 0;
        }finally {
            try {
                smc.endTransaction();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }

        return cnt;
    }

    @Override
    public int delete(List<String> mem_codes) {
        int cnt = 0;

        try {
            smc.startTransaction();
            cnt = smc.delete("mem.deleteMemberByMemberCode", mem_codes);
            smc.commitTransaction();
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

        return cnt;
    }
}
