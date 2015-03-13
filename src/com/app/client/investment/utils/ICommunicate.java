package com.app.client.investment.utils;
import android.os.Message;
/*****
 * 
 * @author Mattliang@apjcorp.com
 * @date Mar 12, 2015 
 * @version 1.0
 * 说明：
 */
public interface ICommunicate {

	/******
	 * @author Mattliang@apjcorp.com
	 * @version 1.0
	 * @date Mar 13, 2015
	 * 说明：
	 * 1.activity 和 fragment 交互
	 * 		activity实现该接口，当fragment需要passdata给activity的时候，
	 * 		调用fragment.getActivity()，然后ICommunicate iInterface = (ICommunicate)activity;
	 * 		iInterface.sendData();
	 * 
	 * 
	 * 
	 * 2.父fragment与子fragment交互（嵌套 Fragment ）
	 * 		父fragment实现该接口，然后子fragment.getParentFragment，其它同上
	 * @param data
	 */
	public void	sendData(Message data);
}
