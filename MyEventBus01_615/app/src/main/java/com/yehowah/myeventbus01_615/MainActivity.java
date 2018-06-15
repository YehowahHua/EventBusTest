package com.yehowah.myeventbus01_615;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.yehowah.myeventbus01_615.base.BaseActivity;
import com.yehowah.myeventbus01_615.bean.Event;
import com.yehowah.myeventbus01_615.bean.EventCode;
import com.yehowah.myeventbus01_615.bean.EventMessage;

public class MainActivity extends BaseActivity implements View.OnClickListener{
    private static final String TAG = "MainActivity";
    private Button firstActivity_Bt;
    private TextView getdata_Tv;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();

//        if(!EventBus.getDefault().isRegistered( this)) {
//            //1.注册事件
//            EventBus.getDefault().register( this);
//            Log.i(TAG, "onCreate: 注册");
//        }else{
//            Toast.makeText( this,"请勿重复注册事件",Toast.LENGTH_SHORT).show();
//        }


    }
    private void initView(){
        firstActivity_Bt = (Button) findViewById(R.id.firstActivity_Bt);
        getdata_Tv = (TextView) findViewById(R.id.getdata_Tv);
        firstActivity_Bt.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.firstActivity_Bt:
                Intent intent = new Intent(this, SecondActivity.class);
                startActivity(intent);
                break;
        }
    }

    /**
     * @return true 注册EventBus
     */
    @Override
    protected boolean isRegisterEventBus() {
        return true;
    }

    /**
     * 实现方法 接受事件信息
     * @param event
     */
    @Override
    protected void receiveEvent(Event event) {
        super.receiveEvent(event);
        switch (event.getTabCode()){
            case EventCode.A:
                EventMessage eventMessage = (EventMessage) event.getData();
                Log.i(TAG, "receiveEvent: "+eventMessage.getMessage());
                getdata_Tv.setText(eventMessage.getMessage());
                break;
        }
    }

    //    //在UI线程中显示
//    //必须是public 如果是private则出现 its super classes have no public methods with the @Subscribe annotation
//    @Subscribe(threadMode = ThreadMode.MAIN)
//    public void onMoodEvent(EventMessage eventMessage){
//        Log.i(TAG, "onMoodEvent: getMessage--"+eventMessage.getMessage());
//        getdata_Tv.setText(eventMessage.getMessage());
//        Log.i(TAG, "onMoodEvent: getText--"+ getdata_Tv.getText());
//    }
//    @Override
//    protected void onDestroy() {
//        super.onDestroy();
////        EventBus.getDefault().unregister(this);
//    }
}
