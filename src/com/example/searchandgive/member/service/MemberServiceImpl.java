package com.example.searchandgive.member.service;

import java.util.List;

import com.app.client.investment.entity.Member;
import com.example.searchandgive.member.dao.MemberDao;
import com.google.inject.Inject;

public class MemberServiceImpl implements MemberService {
	@Inject
	private MemberDao memberDao;
	
	@Override
	public String getValue() {
		// TODO Auto-generated method stub
		return memberDao.getValue();
	}

	@Override
	public Member update(Member member) {
		// TODO Auto-generated method stub
		return memberDao.update(member);
	}

	@Override
	public List<Member> findAll() {
		// TODO Auto-generated method stub
		return memberDao.findAll();
	}

	@Override
	public int delete(Member member) {
		// TODO Auto-generated method stub
		return memberDao.delete(member);
	}

	@Override
	public Member getMemberById(int id) {
		// TODO Auto-generated method stub
		return memberDao.getMemberById(id);
	}

	@Override
	public List<Member> queryMember(Member member) {
		// TODO Auto-generated method stub
		return memberDao.queryMember(member);
	}

	
}
