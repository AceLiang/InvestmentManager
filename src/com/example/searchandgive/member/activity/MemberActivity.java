package com.example.searchandgive.member.activity;

import java.util.ArrayList;
import java.util.List;

import roboguice.activity.RoboActivity;
import roboguice.inject.InjectView;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import com.app.client.investment.R;
import com.app.client.investment.entity.Member;
import com.example.searchandgive.member.adapter.MemberListAdapter;
import com.example.searchandgive.member.common.PrintMessagUtil;
import com.example.searchandgive.member.common.StringUtil;
import com.example.searchandgive.member.service.MemberService;
import com.google.inject.Inject;

public class MemberActivity extends RoboActivity {

	@InjectView(R.id.activity_member_id_textView)
	private TextView idTextView;
	
	@InjectView(R.id.activity_member_name_editText)
	private EditText nameEditView;
	
	@InjectView(R.id.activity_member_age_editText)
	private EditText ageEditView;
	
	@InjectView(android.R.id.list)
	private ListView memberListView;
	
	private MemberListAdapter mAdapter;
	private List<Member> memberList = new ArrayList<Member>();
	
	@Inject
	private MemberService memberService;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_member);
		search(null);
		setEventListener();
	}

	public void setEventListener() {
		memberListView.setOnItemClickListener(memberListViewOnItemClickListener);
	}
	
	OnItemClickListener memberListViewOnItemClickListener = new OnItemClickListener() {
       @Override
       public void onItemClick(AdapterView<?> a, View v, int position, long id) { 
    	   idTextView.setText(String.valueOf(memberList.get(position).getId()));
    	   nameEditView.setText(memberList.get(position).getName());
    	   ageEditView.setText(String.valueOf(memberList.get(position).getAge()));
       }  
	};
	
	public void save(View v) {
		Member member  = new Member();
		if(StringUtil.isNotEmpty(idTextView.getText().toString())){
			member.setId(Integer.parseInt(idTextView.getText().toString()));
		}else{
			member.setId(null);
		}
		if(StringUtil.isNotEmpty(nameEditView.getText().toString())) {
			member.setName(nameEditView.getText().toString());
		}else{
			PrintMessagUtil.showToast(this, "姓名不能为空");
			return;
		}		
		if(StringUtil.isNotEmpty(ageEditView.getText().toString())) {
			member.setAge(Integer.parseInt(ageEditView.getText().toString()));
		}else{
			PrintMessagUtil.showToast(this, "年龄不能为空");
			return;
		}
		
		Member m = memberService.update(member);
		if(m != null) {
			PrintMessagUtil.showToast(this, "数据更新成功");
			memberList.clear();
			memberList.addAll(memberService.queryMember(new Member()));
			mAdapter.notifyDataSetChanged();
		}else {
			PrintMessagUtil.showToast(this, "数据更新失败");
		}
		clearMemberInfo();
	}
	
	private void clearMemberInfo() {
		nameEditView.setText("");
		ageEditView.setText("");
		idTextView.setText("");
	}
	
	public void search(View v) {
		Member member  = new Member();
		member.setName(nameEditView.getText().toString());
		if(StringUtil.isNotEmpty(ageEditView.getText().toString())){
			member.setAge(Integer.parseInt(ageEditView.getText().toString()));
		}else{
			member.setAge(null);
		}			
		
		memberList = memberService.queryMember(member);		
		mAdapter = new MemberListAdapter(MemberActivity.this, memberList, memberService);
		memberListView.setAdapter(mAdapter);
	}

	public void clear(View v) {
		clearMemberInfo();
	}
}
