package com.djn.huidiao.huidiao;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import org.greenrobot.eventbus.EventBus;

import java.io.Serializable;

/**
 * Created by Administrator on 2016/5/16.
 */
public class SecondActivity extends Activity {
    private Button mBtn;
    private TestBean testBean;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_second);

        mBtn = (Button) findViewById(R.id.btn);

        testBean = (TestBean) getIntent().getSerializableExtra("testBean");

        mBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                testBean.age++;
                //发送消息
                EventBus.getDefault().post(testBean);
            }
        });
    }
}
