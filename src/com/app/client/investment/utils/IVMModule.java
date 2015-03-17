package com.app.client.investment.utils;

import com.example.searchandgive.member.dao.MemberDao;
import com.example.searchandgive.member.dao.MemberDaoImpl;
import com.example.searchandgive.member.service.MemberService;
import com.example.searchandgive.member.service.MemberServiceImpl;
import com.google.inject.AbstractModule;

public class IVMModule extends AbstractModule {

	@Override
	protected void configure() {
		// TODO Auto-generated method stub
		bind(MemberDao.class).to(MemberDaoImpl.class);
		bind(MemberService.class).to(MemberServiceImpl.class);
	}

}
