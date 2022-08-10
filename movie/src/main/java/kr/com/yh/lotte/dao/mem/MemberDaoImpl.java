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
    public List<MemberVO> findAll(MemberSearch memberSearch) {
        List<MemberVO> mems;

        try{
            mems = smc.queryForList("mem.findAll", memberSearch);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return mems;
    }

    @Override
    public List<MemberVO> findAllByName(String name) {
        List<MemberVO> mems = new ArrayList<>();

        try {
            mems = smc.queryForList("mem.findAllByName", name);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return mems;
    }

    @Override
    public List<MemberVO> findAllById(String id) {
        List<MemberVO> mems = new ArrayList<>();

        try {
            mems = smc.queryForList("mem.findAllById", id);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return mems;
    }

    @Override
    public List<MemberVO> findAllByContact(String contact) {
        List<MemberVO> mems = new ArrayList<>();

        try {
            mems = smc.queryForList("mem.findAllByContact", contact);
        } catch (SQLException e) {
            e.printStackTrace();
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
    public MemberVO findOneById(String id) {
        MemberVO member;

        try{
            member = (MemberVO) smc.queryForObject("mem.findOneById", id);
        } catch (SQLException e) {
            throw  new RuntimeException(e);
        }

        return member;
    }

    @Override
    public MemberVO findOneByContact(String contact) {
        MemberVO member;

        try{
            member = (MemberVO) smc.queryForObject("mem.findOneByContact", contact);
        } catch (SQLException e) {
            throw  new RuntimeException(e);
        }

        return member;
    }

    @Override
    public int modifyOne(MemberVO mem) {
        int cnt = 0;

        try {
            smc.startTransaction();
            cnt = smc.update("mem.modifyOne", mem);
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
    public int deleteAll(List<String> mem_codes) {
        int cnt = 0;

        try {
            smc.startTransaction();
            cnt = smc.delete("mem.deleteAll", mem_codes);
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
