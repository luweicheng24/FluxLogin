package luwei.com.fluxdemo;

import luwei.com.fluxdemo.flux.BaseAction;
import luwei.com.fluxdemo.flux.BaseStore;

/**
 * Author   : luweicheng on 2018/1/18 0018 11:52
 * E-mail   ：1769005961@qq.com
 * GitHub   : https://github.com/luweicheng24
 * funcation:
 **/


public class LoginStore extends BaseStore {

    @Override
    protected void onAction(BaseAction action) {
      String type =  action.getEventType();
        switch (type){
            case LoginAction.LOGIN_START:
                emitStoreChange(type,(String) action.getData());
                break;
            case LoginAction.LOGIN_SUCCESS:
                emitStoreChange(type,(String) action.getData());
                break;
            case LoginAction.LOGIN_FAIL:
                emitStoreChange(type,(String) action.getData());
                break;
        }
    }
}
