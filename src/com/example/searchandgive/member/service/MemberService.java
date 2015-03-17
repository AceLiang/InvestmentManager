package com.example.searchandgive.member.service;

import java.util.List;

import com.app.client.investment.entity.Member;

public interface MemberService {

	public String getValue();
	
	public Member update(Member member);
	
	public List<Member> findAll();
	
	public int delete(Member member);
	
	public Member getMemberById(int id);
	
	public List<Member> queryMember(Member member);
}
