package kr.com.yh.lotte.dao.mem;

import com.ibatis.sqlmap.client.SqlMapClient;
import kr.com.yh.lotte.vo.MemberVO;
import kr.com.yh.util.SqlMapClientFactory;

import java.sql.SQLException;
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
    public List<MemberVO> findMemberAll() {
        List<MemberVO> mems;

        try{
            mems = smc.queryForList("mem.findMemberAll");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return mems;
    }

    @Override
    public int deleteMemberByMemberCode(List<String> mem_codes) {
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

    @Override
    public MemberVO findMemberByMemberCode(String mem_code) {
        MemberVO mem;

        try{
            mem = (MemberVO) smc.queryForObject("mem.findMemberByMemberCode", mem_code);
        } catch (SQLException e) {
            e.printStackTrace();
            mem = null;
        }

        return mem;
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
}
