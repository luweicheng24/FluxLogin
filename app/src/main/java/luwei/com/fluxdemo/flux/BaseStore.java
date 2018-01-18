package luwei.com.fluxdemo.flux;

import com.squareup.otto.Bus;

/**
 * Author   : luweicheng on 2018/1/18 0018 10:21
 * E-mail   ：1769005961@qq.com
 * GitHub   : https://github.com/luweicheng24
 * funcation: 事件处理仓库基类
 **/


public abstract class BaseStore {
  private static final Bus bus = new Bus();

  // 将View层注册进Otto
  public void regist(Object view){
      bus.register(view);
  }
  // 将View层从Otto中注销
  public void unRegist(Object view){
      bus.unregister(view);
  }
  public void emitStoreChange(String type,String msg){
      bus.post(new ChangeStore(type,msg));
  }

  public void emitStoreChange(String type){
      bus.post(new ChangeStore(type));
  }
  // 子类根据action的类型进行数据发射或者封装
  protected abstract void onAction(BaseAction action);
  /* 创建一个Otto进行消息通知的承载类
  * */
  public class  ChangeStore{
      private String type;
      private String msg;

      public String getType() {
          return type;
      }

      public void setType(String type) {
          this.type = type;
      }

      public String getMsg() {
          return msg;
      }

      public void setMsg(String msg) {
          this.msg = msg;
      }

      public ChangeStore(String type, String msg) {
          this.type = type;
          this.msg = msg;
      }

      public ChangeStore(String type) {
          this.type = type;
      }
  }

}
