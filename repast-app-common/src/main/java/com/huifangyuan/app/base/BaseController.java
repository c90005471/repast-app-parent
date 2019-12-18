package com.huifangyuan.app.base;

import com.huifangyuan.app.status.LoginStatus;
import com.huifangyuan.app.status.ReturnApplyStatus;
import com.huifangyuan.app.status.StatusEnum;
import org.springframework.stereotype.Controller;

/**
 * @Company AAA软件教育
 * @Author Lee
 * @Date Create in 2019/11/21 18:56
 * @Description
 **/
@Controller
public class BaseController {
    private ResultData resultData = new ResultData();
    /**
     * @Author Lee
     * @Description
     *  登录成功，使用系统消息
     * @Param  * @param
     * @Return com.huifangyuan.app.base.ResultData
     * @Date 2019/11/21
     */

    public ResultData loginSuccess(){
        ResultData resultData = new ResultData();
        resultData.setCode(LoginStatus.LOGIN_SUCCESS.getCode());
        resultData.setMsg(LoginStatus.LOGIN_SUCCESS.getMsg());
        return resultData;

    }
   /**
    * @Author Lee
    * @Description
    * 登录成功，自定义返回消息
    * @Param  * @param msg
    * @Return com.huifangyuan.app.base.ResultData
    * @Date 2019/11/21
    */
    protected ResultData loginSuccess(String msg) {
        ResultData resultData = new ResultData();
        resultData.setCode(LoginStatus.LOGIN_SUCCESS.getCode());
        resultData.setMsg(msg);
        return resultData;
    }

   /**
    * @Author Lee
    * @Description
    *
    * 登录成功，使用系统消息，自定义返回值
    * @Param  * @param data
    * @Return com.huifangyuan.app.base.ResultData
    * @Date 2019/11/21
    */
    protected ResultData loginSuccess(Object data) {
        ResultData resultData = new ResultData();
        resultData.setCode(LoginStatus.LOGIN_SUCCESS.getCode());
        resultData.setMsg(LoginStatus.LOGIN_SUCCESS.getMsg());
        resultData.setData(data);
        return resultData;
    }

  /**
   * @Author Lee
   * @Description
   * 登录成功，自定义消息，自定义返回值
   * @Param  * @param msg
 * @param data
   * @Return com.huifangyuan.app.base.ResultData
   * @Date 2019/11/21
   */
    protected ResultData loginSuccess(String msg, Object data) {
        ResultData resultData = new ResultData();
        resultData.setCode(LoginStatus.LOGIN_SUCCESS.getCode());
        resultData.setMsg(msg);
        resultData.setData(data);
        return resultData;
    }

 /**
  * @Author Lee
  * @Description
  * 登录失败，返回系统消息
  * @Param  * @param
  * @Return com.huifangyuan.app.base.ResultData
  * @Date 2019/11/21
  */

    protected ResultData loginFailed() {
        resultData.setCode(LoginStatus.LOGIN_FAILED.getCode());
        resultData.setMsg(LoginStatus.LOGIN_FAILED.getMsg());
        return resultData;
    }

    /**
     * @Author Zhang Lee
     * @Description
     *      操作成功，返回系统信息
     * @Param  * @param
     * @Return com.huifangyuan.app.base.ResultData
     * @Date 2019/11/23
     */
    protected ResultData operateSuccess(){
        resultData.setCode(StatusEnum.SUCCESS.getCode());
        resultData.setMsg(StatusEnum.SUCCESS.getMsg());
        return resultData;
    }
    /**
     * @Author Zhang Lee
     * @Description
     *      操作成功返回自定义信息
     * @Param  * @param msg
     * @Return com.huifangyuan.app.base.ResultData
     * @Date 2019/11/23
     */
    protected ResultData operateSuccess(String msg){
        resultData.setCode(StatusEnum.SUCCESS.getCode());
        resultData.setMsg(msg);
        return resultData;
    }
    /**
     * @Author Zhang Lee
     * @Description
     *      操作成功，返回系统信息，自定义数据
     * @Param  * @param data
     * @Return com.huifangyuan.app.base.ResultData
     * @Date 2019/11/23
     */
    protected ResultData operateSuccess(Object data){
        resultData.setCode(StatusEnum.SUCCESS.getCode());
        resultData.setMsg(StatusEnum.SUCCESS.getMsg());
        resultData.setData(data);
        return resultData;
    }
    /**
     * @Author Zhang Lee
     * @Description
     *      操作成功，返回自定义信息，自定义数据
     * @Param  * @param msg
     * @param data
     * @Return com.huifangyuan.app.base.ResultData
     * @Date 2019/11/23
     */
    protected ResultData operateSuccess(String msg,Object data){
        resultData.setCode(StatusEnum.SUCCESS.getCode());
        resultData.setMsg(msg);
        resultData.setData(data);
        return resultData;
    }
    /**
     * @Author Lee
     * @Description
     *      操作失败，返回系统消息
     * @Param  * @param
     * @Return com.huifangyuan.app.base.ResultData
     * @Date 2019/11/21
     */
    protected ResultData operateFailed(){
        resultData.setCode(StatusEnum.FAILED.getCode());
        resultData.setMsg(StatusEnum.FAILED.getMsg());
        return resultData;
    }

    /**
     * @Author Zhang Wei
     * @Description
     *      操作失败，返回自定义消息
     * @Param  * @param
     * @Return com.huifangyuan.app.base.ResultData
     * @Date 2019/11/21
     */
    protected ResultData operateFailed(String msg){
        resultData.setCode(StatusEnum.FAILED.getCode());
        resultData.setMsg(msg);
        return resultData;
    }

    /**
     * @Author Lee
     * @Description
     *      信息存在，返回自定义信息，自定义数据
     * @Param  * @param msg
     * @param data
     * @Return com.huifangyuan.app.base.ResultData
     * @Date 2019/11/23
     */
    protected ResultData exist(String msg,Object data){
        resultData.setCode(StatusEnum.EXIST.getCode());
        resultData.setMsg(msg);
        resultData.setData(data);
        return resultData;
    }
    /**
     * @Author Lee
     * @Description
     *      信息存在，返回系统信息，自定义数据
     * @Param  * @param data
     * @Return com.huifangyuan.app.base.ResultData
     * @Date 2019/11/23
     */
    protected ResultData exist(Object data){
        resultData.setCode(StatusEnum.EXIST.getCode());
        resultData.setMsg(StatusEnum.EXIST.getMsg());
        resultData.setData(data);
        return resultData;
    }
    /**
     * @Author Lee
     * @Description
     *      信息存在，返回系统信息
     * @Param  * @param
     * @Return com.huifangyuan.app.base.ResultData
     * @Date 2019/11/23
     */
    public ResultData exist(){
        resultData.setCode(StatusEnum.EXIST.getCode());
        resultData.setMsg(StatusEnum.EXIST.getMsg());
        return resultData;
    }
    /**
     * @Author Zhang Wei
     * @Description
     *      信息不存在，返回系统信息
     * @Param  * @param
     * @Return com.huifangyuan.app.base.ResultData
     * @Date 2019/11/23
     */
    public ResultData notExist(){
        resultData.setCode(StatusEnum.NOT_EXIST.getCode());
        resultData.setMsg(StatusEnum.NOT_EXIST.getMsg());
        return resultData;
    }

    /**
     * 退货申请成功，返回系统消息
     * @return
     */
    protected ResultData returnApplySuccess() {
        ResultData resultData = new ResultData();
        resultData.setCode(ReturnApplyStatus.APPLY_SUCCESS.getCode());
        resultData.setMsg(ReturnApplyStatus.APPLY_SUCCESS.getMsg());
        return resultData;
    }

    /**
     * 退货申请成功，返回系统消息，自定义返回值
     * @return
     */
    protected ResultData returnApplySuccess(Object data) {
        ResultData resultData = new ResultData();
        resultData.setCode(ReturnApplyStatus.APPLY_SUCCESS.getCode());
        resultData.setMsg(ReturnApplyStatus.APPLY_SUCCESS.getMsg());
        resultData.setData(data);
        return resultData;
    }

    /**
     * 退货申请失败，返回系统消息
     * @return
     */
    protected ResultData returnApplyFailed() {
        ResultData resultData = new ResultData();
        resultData.setCode(ReturnApplyStatus.APPLY_FAILED.getCode());
        resultData.setMsg(ReturnApplyStatus.APPLY_FAILED.getMsg());
        return resultData;
    }

    /**
     * 商家审核通过，返回系统消息，自定义返回值
     * @param data
     * @return
     */
    protected ResultData returnApplyApproved(Object data){
        ResultData resultData = new ResultData();
        resultData.setCode(ReturnApplyStatus.APPLY_APPROVED.getCode());
        resultData.setMsg(ReturnApplyStatus.APPLY_APPROVED.getMsg());
        resultData.setData(data);
        return resultData;
    }

    /**
     * 商家审核通过，返回自定义消息
     * @param msg
     * @return
     */
    protected ResultData returnApplyApproved(String msg){
        ResultData resultData = new ResultData();
        resultData.setCode(ReturnApplyStatus.APPLY_APPROVED.getCode());
        resultData.setMsg(msg);
        return resultData;
    }

    /**
     * 退款成功，返回系统消息，自定义返回值
     * @param data
     * @return
     */
    protected ResultData returnApplyRefundSucceed(Object data){
        ResultData resultData = new ResultData();
        resultData.setCode(ReturnApplyStatus.APPLY_REFUND_SUCCEED.getCode());
        resultData.setMsg(ReturnApplyStatus.APPLY_REFUND_SUCCEED.getMsg());
        return resultData;
    }

    /**
     * 退款成功，返回自定义消息
     * @param msg
     * @return
     */
    protected ResultData returnApplyRefundSucceed(String msg){
        ResultData resultData = new ResultData();
        resultData.setCode(ReturnApplyStatus.APPLY_REFUND_SUCCEED.getCode());
        resultData.setMsg(msg);
        return resultData;
    }

    /**
     * 退款失败，商家拒绝退款，返回系统消息，自定义返回值
     * @param data
     * @return
     */
    protected ResultData returnApplyRefused(Object data){
        ResultData resultData = new ResultData();
        resultData.setCode(ReturnApplyStatus.APPLY_REFUSED.getCode());
        resultData.setMsg(ReturnApplyStatus.APPLY_REFUSED.getMsg());
        resultData.setData(data);
        return resultData;
    }

    /**
     * 退款失败，商家拒绝退款，返回自定义消息
     * @param msg
     * @return
     */
    protected ResultData returnApplyRefused(String msg){
        ResultData resultData = new ResultData();
        resultData.setCode(ReturnApplyStatus.APPLY_REFUSED.getCode());
        resultData.setMsg(msg);
        return resultData;
    }

    /**
     * token丢失，返回系统消息
     * @return
     */
    protected ResultData tokenLost(){
        ResultData resultData = new ResultData();
        resultData.setCode(StatusEnum.TOKEN_LOST.getCode());
        resultData.setMsg(StatusEnum.TOKEN_LOST.getMsg());
        return resultData;
    }
}
