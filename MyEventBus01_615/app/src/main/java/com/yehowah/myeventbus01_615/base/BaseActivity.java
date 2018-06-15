package com.yehowah.myeventbus01_615.base;


import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.yehowah.myeventbus01_615.bean.Event;
import com.yehowah.myeventbus01_615.utils.EventBusUtil;

import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;



public class BaseActivity extends AppCompatActivity {
    @Override
    protected void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (isRegisterEventBus()){
            EventBusUtil.register(this);
        }
    }

    /**
     * 是否注册事件分发
     * @return true绑定EventBus事件分发，默认不绑定，子类需要绑定要重写此方法返回true
     */
    protected boolean isRegisterEventBus(){
        return false;
    }

    /**
     * 接受事件信息
     * @param event
     */
    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onEventBus(Event event){
        if (event!=null){
            receiveEvent(event);
        }
    }

    /**
     * 子类实现，接受事件方法
     * @param event
     */
    protected void receiveEvent(Event event){}

    /**
     * 接受粘性事件 方法
     *
     * @param event
     */
    @Subscribe(threadMode = ThreadMode.MAIN, sticky = true)
    public void onStickyEventBus(Event event) {
        if (event != null) {
            recStickyEvent(event);
        }
    }

    /**
     * 子类实现  接受粘性事件方法
     *
     * @param event
     */
    protected void recStickyEvent(Event event) {
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (isRegisterEventBus()){
            EventBusUtil.unregister(this);
        }
    }
}
