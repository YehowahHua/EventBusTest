package com.yehowah.myeventbus01_615;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.yehowah.myeventbus01_615.base.BaseActivity;
import com.yehowah.myeventbus01_615.bean.Event;
import com.yehowah.myeventbus01_615.bean.EventCode;
import com.yehowah.myeventbus01_615.bean.EventMessage;
import com.yehowah.myeventbus01_615.utils.EventBusUtil;


public class SecondActivity extends BaseActivity implements View.OnClickListener{
    private static final String TAG = "SecondActivity";
    private TextView data_Tv;
    private Button postData_Bt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        data_Tv = findViewById(R.id.data_Tv);
        postData_Bt = (Button) findViewById(R.id.postData_Bt);
        postData_Bt.setOnClickListener(this);
//        EventBus.getDefault().register(this);


//        if(!EventBus.getDefault().isRegistered( this)) {
//            //1.注册事件
//            EventBus.getDefault().register( this);
//        }else{
//            Toast.makeText( this,"请勿重复注册事件",Toast.LENGTH_SHORT).show();
//        }

    }
    //在UI线程中显示
    //必须是public 如果是private则出现 its super classes have no public methods with the @Subscribe annotation
//    @Subscribe(threadMode = ThreadMode.MAIN)
//    public void onMoodEvent(EventMessage eventMessage){
//        Log.i(TAG, "onMoodEvent: getMessage--"+eventMessage.getMessage());
//        getdata_Tv.setText(eventMessage.getMessage());
//        Log.i(TAG, "onMoodEvent: getText--"+ getdata_Tv.getText());
//    }

//    @Subscribe(sticky = true, threadMode = ThreadMode.MAIN)
//    public void onStrckyEvent(EventMessage eventMessage){
//        Log.i(TAG, "onMoodEvent: getMessage--"+eventMessage.getMessage());
//        getdata_Tv.setText(eventMessage.getMessage());
//        Log.i(TAG, "onMoodEvent: getText--"+ getdata_Tv.getText());
//    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
//        EventBus.getDefault().unregister(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.postData_Bt:
                    new Thread(new Runnable() {
                        @Override
                        public void run() {
                            Log.i(TAG, "run: "+data_Tv.getText().toString());
//                            EventBus.getDefault().post(new EventMessage(data_Tv.getText().toString()));
                            EventMessage eventMessage = new EventMessage(data_Tv.getText().toString());
                            EventBusUtil.sendEvent(new Event<EventMessage>(EventCode.A,eventMessage));
                        }
                    }).start();
                break;
        }

    }
}
