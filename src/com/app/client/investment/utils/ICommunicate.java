package com.app.client.investment.utils;
import android.os.Message;
/*****
 * 
 * @author Mattliang@apjcorp.com
 * @date Mar 12, 2015 
 * @version 1.0
 * ˵����
 */
public interface ICommunicate {

	/******
	 * @author Mattliang@apjcorp.com
	 * @version 1.0
	 * @date Mar 13, 2015
	 * ˵����
	 * 1.activity �� fragment ����
	 * 		activityʵ�ָýӿڣ���fragment��Ҫpassdata��activity��ʱ��
	 * 		����fragment.getActivity()��Ȼ��ICommunicate iInterface = (ICommunicate)activity;
	 * 		iInterface.sendData();
	 * 
	 * 
	 * 
	 * 2.��fragment����fragment������Ƕ�� Fragment ��
	 * 		��fragmentʵ�ָýӿڣ�Ȼ����fragment.getParentFragment������ͬ��
	 * @param data
	 */
	public void	sendData(Message data);
}
