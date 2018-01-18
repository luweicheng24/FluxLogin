package luwei.com.fluxdemo.flux;

import java.util.ArrayList;
import java.util.List;

/**
 * Author   : luweicheng on 2018/1/18 0018 10:46
 * E-mail   ：1769005961@qq.com
 * GitHub   : https://github.com/luweicheng24
 * funcation: 事件分发处理类 管理store 发送Action
 **/


public class Dispatcher {

    private static final List<BaseStore> stores = new ArrayList<>(); // 储存所有交由Dispatcher管理的store
    private Dispatcher(){}
    private static Dispatcher dispatcher ;

    public static Dispatcher getInstance(){
        if(dispatcher==null){
            synchronized (Dispatcher.class){
                if(dispatcher==null){
                    dispatcher = new Dispatcher();
                }
            }
        }
        return dispatcher;
    }
  // store 注册给dispatcher
  public void regist(BaseStore store){
      stores.add(store);
  }
  // 注销store从dispatcher
  public void unRegist(BaseStore store){
      stores.remove(store);
  }
// 接受view中触发的action 遍历所有store 将事件发送给注册了该store的view层
  public  void post(BaseAction action ){
      for (BaseStore s : stores) {
          s.onAction(action);
      }
  }
}
