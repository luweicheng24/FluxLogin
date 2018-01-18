package luwei.com.fluxdemo.flux;

import luwei.com.fluxdemo.LoginAction;

/**
 * Author   : luweicheng on 2018/1/18 0018 10:57
 * E-mail   ：1769005961@qq.com
 * GitHub   : https://github.com/luweicheng24
 * funcation: 供View层调用进行事件流动分发
 **/


public class AppActionCreator {
    private static   Dispatcher dispatcher = Dispatcher.getInstance();
    private AppActionCreator(){}
    private static  AppActionCreator appActionCreator = null;
    public static AppActionCreator getInstance(){
        if(appActionCreator==null){
            synchronized (AppActionCreator.class){
                if(appActionCreator==null){
                    appActionCreator = new AppActionCreator();
                }
            }
        }
        return appActionCreator;
    }
  public void login(){
      dispatcher.post(new LoginAction(LoginAction.LOGIN_START,"登录中"));
      // 模拟网络请求
      if(System.currentTimeMillis()/2==0){
          dispatcher.post(new LoginAction(LoginAction.LOGIN_SUCCESS,"登录成功"));
      }else{
          dispatcher.post(new LoginAction(LoginAction.LOGIN_FAIL,"登陆失败"));
      }
  }

}
