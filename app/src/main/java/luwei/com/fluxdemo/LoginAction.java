package luwei.com.fluxdemo;

import luwei.com.fluxdemo.flux.BaseAction;

/**
 * Author   : luweicheng on 2018/1/18 0018 11:45
 * E-mail   ：1769005961@qq.com
 * GitHub   : https://github.com/luweicheng24
 * funcation:
 **/


public class LoginAction extends BaseAction<String> {
    public static final String LOGIN_START = "login_start";
    public static final String LOGIN_SUCCESS = "login_success";
    public static final String LOGIN_FAIL = "login_fail";
    public LoginAction(String type, String data) {
        super(type, data);
    }
    public LoginAction(String type) {
        super(type);
    }
}
