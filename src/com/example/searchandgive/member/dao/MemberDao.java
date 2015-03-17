package com.example.searchandgive.member.dao;

import java.util.List;

import com.app.client.investment.entity.Member;

public interface MemberDao {

	public String getValue();
	
	public int add(Member member);
	
	public List<Member> findAll();
	
	public Member update(Member member);
	
	public int delete(Member member);
	
	public Member getMemberById(int id);
	
	public List<Member> queryMember(Member member);
}
