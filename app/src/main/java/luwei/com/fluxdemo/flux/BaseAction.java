package luwei.com.fluxdemo.flux;

/**
 * Author   : luweicheng on 2018/1/18 0018 10:17
 * E-mail   ：1769005961@qq.com
 * GitHub   : https://github.com/luweicheng24
 * funcation: 事件的包装基类
 **/
public abstract class BaseAction<T> {

     protected String eventType; // 事件类型
     protected  T  data; // 处理的数据

     public BaseAction(String type,T data){
         this.eventType = type;
        this.data = data;
    }
    public BaseAction(String type){
         this.eventType = type;
    }

    public String getEventType() {
        return eventType;
    }

    public void setEventType(String eventType) {
        this.eventType = eventType;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
