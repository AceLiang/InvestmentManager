/**   
* @Title: IResponseListener.java 
* @Package com.towngas.cpim.datasync.protocol 
* @Description: TODO
* @author ole.jibin.li 
* @date Nov 21, 2014 4:46:01 PM 
* @version V1.0   
*/
package com.app.client.investment.protocol;

/** 
 * @ClassName: IResponseListener 
 * @Description: TODO  调用web service时的callback接口
 * @author ole.jibin.li
 * @date Nov 21, 2014 4:46:01 PM 
 *  
 */
public interface IResponseListener {

	/**
	 *  The HTTP request is successful
	* @Title: onSuccessful 
	* @Description: TODO
	* @param   
	* @return void 
	* @throws
	 */
	public void onSuccessful(Object requestClient);
	/**
	 * The HTTP request failed
	* @Title: onFailed 
	* @Description: TODO
	* @param @param requestClient  
	* @return void 
	* @throws
	 */
	public void onFailed(Object requestClient);
}
