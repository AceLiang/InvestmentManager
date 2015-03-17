package com.example.searchandgive.member.adapter;

import java.util.List;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.app.client.investment.R;
import com.app.client.investment.entity.Member;
import com.example.searchandgive.member.common.PrintMessagUtil;
import com.example.searchandgive.member.service.MemberService;

public class MemberListAdapter extends BaseAdapter {

	private LayoutInflater mInflater;    
	private List<Member> data;
	private MemberService memberService;
	private Context mContext;
	
	public MemberListAdapter(Context c,List<Member> data, MemberService memberService) {
		this.mContext = c;
		this.mInflater = LayoutInflater.from(c); 
		this.data = data;
		this.memberService = memberService;
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return data.size();
	}

	@Override
	public Object getItem(int arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public long getItemId(int arg0) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		// TODO Auto-generated method stub
		MemberTag tag = null;
        if (convertView == null) {  
        	 convertView = mInflater.inflate(R.layout.activity_member_item, null);   
        	 tag = new MemberTag();
        	 tag.setId((TextView)convertView.findViewById(R.id.activity_member_item_id_textView));
        	 tag.setName((TextView)convertView.findViewById(R.id.activity_member_item_name_textView));
        	 tag.setAge((TextView)convertView.findViewById(R.id.activity_member_item_age_textView));
        	 tag.setDeleteImg((ImageView)convertView.findViewById(R.id.activity_member_item_delete_imageView));
        	 convertView.setTag(tag);
        	
        } else {
        	tag = (MemberTag) convertView.getTag(); 
        }

        tag.getId().setText(String.valueOf(data.get(position).getId()));
        tag.getName().setText(data.get(position).getName());
        tag.getAge().setText(String.valueOf(data.get(position).getAge()));
        
        setDeleteOnClick(tag, position);
        
        return convertView;
	}
	
	public void setDeleteOnClick(MemberTag tag, final int position) {
		final ImageView deleteImg = tag.getDeleteImg();
		final Member member = data.get(position);
		deleteImg.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				new AlertDialog.Builder(mContext)    
		        .setTitle("确认删除")    
		        .setMessage("是否要删除该条记录？")    
		        .setPositiveButton("确定", new DialogInterface.OnClickListener() {    
		            @Override   
		           public void onClick(DialogInterface dialog, int which) {    
		            	if(memberService.delete(member) > 0){
		            		PrintMessagUtil.showToast(mContext, "删除成功");
		            		data.remove(position);
		            		MemberListAdapter.this.notifyDataSetChanged();
		            	}else{
		            		PrintMessagUtil.showToast(mContext, "删除失败");
		            	}
		           }    
		        })
		        .setNegativeButton("取消", null)
		        .show();
				
			}
		});
	}
	
	class MemberTag {
		private TextView  id;
		private TextView  name;
		private TextView age;
		private ImageView deleteImg;
		public TextView getId() {
			return id;
		}
		public void setId(TextView id) {
			this.id = id;
		}
		public TextView getName() {
			return name;
		}
		public void setName(TextView name) {
			this.name = name;
		}
		public TextView getAge() {
			return age;
		}
		public void setAge(TextView age) {
			this.age = age;
		}
		public ImageView getDeleteImg() {
			return deleteImg;
		}
		public void setDeleteImg(ImageView deleteImg) {
			this.deleteImg = deleteImg;
		}
		
	}
	
}
