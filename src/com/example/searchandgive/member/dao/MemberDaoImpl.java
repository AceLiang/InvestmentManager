package com.example.searchandgive.member.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.app.client.investment.InvestmentApplication;
import com.app.client.investment.datacenter.DBOpenHelper;
import com.app.client.investment.entity.Member;
import com.example.searchandgive.member.common.StringUtil;
import com.j256.ormlite.android.apptools.OpenHelperManager;
import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.stmt.QueryBuilder;
import com.j256.ormlite.stmt.Where;

public class MemberDaoImpl implements MemberDao {
	
	private static DBOpenHelper openHelper = null;
	private Dao<Member, Integer>  memberDao;
	
	public MemberDaoImpl() {
		try {
			memberDao = getOpenHelper().getMemberDao();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static DBOpenHelper getOpenHelper() {
		if(openHelper == null) {
			openHelper = OpenHelperManager.getHelper(InvestmentApplication.getInstance(), DBOpenHelper.class);
		}
		return openHelper;
	}

	@Override
	public String getValue() {
		// TODO Auto-generated method stub
		return "Java18 is a good man!";
	}

	public int add(Member member) {
		try {  
			return memberDao.create(member);
        } catch (SQLException e) {  
            e.printStackTrace();  
        }
		return 0;
	}
	
	public List<Member> findAll() {  
        
        List<Member> list = new ArrayList<Member>();  
        try {  
        	list = memberDao.queryForAll();
        } catch (SQLException e) {  
            e.printStackTrace();  
        }
        return list;  
    }

	@Override
	public Member update(Member member) {
		// TODO Auto-generated method stub
		try {  
			 memberDao.createOrUpdate(member);
			 return member;
        } catch (SQLException e) {  
            e.printStackTrace();  
        }
		return null;
	}

	@Override
	public int delete(Member member) {
		// TODO Auto-generated method stub
		 try {
	     	return memberDao.delete(member);
	     } catch (SQLException e) {
            // TODO: Exception Handling
            e.printStackTrace();
         } 
	     return 0;
	}

	@Override
	public Member getMemberById(int id) {
		// TODO Auto-generated method stub
		try {
			return memberDao.queryForId(id);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<Member> queryMember(Member member) {
		// TODO Auto-generated method stub
		try {
			QueryBuilder<Member, Integer> qb =  memberDao.queryBuilder();
			Where<Member, Integer> where = qb.where();
			where.isNotNull("id");
			
			if(StringUtil.isNotEmpty(member.getName())){
				where.and().eq("name", member.getName());
			}
			
			if(StringUtil.isNotEmpty(member.getAge())){
				where.and().eq("age", member.getAge());
			}
		
			qb.orderBy("id", true);
			System.out.println(qb.prepareStatementString());
			return qb.query();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
}
