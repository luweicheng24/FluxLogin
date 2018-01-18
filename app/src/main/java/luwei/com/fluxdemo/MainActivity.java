package luwei.com.fluxdemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

import com.squareup.otto.Subscribe;

import luwei.com.fluxdemo.flux.AppActionCreator;
import luwei.com.fluxdemo.flux.BaseStore;
import luwei.com.fluxdemo.flux.Dispatcher;

public class MainActivity extends AppCompatActivity {
    private LoginStore loginStore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        loginStore = new LoginStore();
        loginStore.regist(this);
        Dispatcher.getInstance().regist(loginStore);
    }
//   登录
    public void login(View v) {
        AppActionCreator.getInstance().login();
    }

    @Override
    protected void onStop() {
        super.onStop();
        loginStore.unRegist(this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Dispatcher.getInstance().unRegist(loginStore);
    }
    // Otto的回调监听
    @Subscribe
    public void LoginListener(BaseStore.ChangeStore changEvent) {
        String type = changEvent.getType();
        String msg = changEvent.getMsg();
        Toast.makeText(this, type+msg, Toast.LENGTH_SHORT).show();

    }
}
