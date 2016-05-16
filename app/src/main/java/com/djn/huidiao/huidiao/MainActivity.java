package com.djn.huidiao.huidiao;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ListView mLv;
    private List<TestBean> mList;
    private TestAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EventBus.getDefault().register(this);

        initView();
        initData();
        initListener();


    }

    private void initListener() {
        mLv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent=new Intent(MainActivity.this,SecondActivity.class);
                TestBean tBean = mList.get(position);
                tBean.flag=position;
                intent.putExtra("testBean",tBean);
                startActivity(intent);
            }
        });
    }

    //接收到消息做的事情
    @Subscribe
    public void onEventMainThread(TestBean event) {
        View view = mLv.getChildAt(event.flag);
        TestAdapter.ViewHolder holder= (TestAdapter.ViewHolder) view.getTag();
        holder.ageTv.setText(String.valueOf(event.age));
        Toast.makeText(this,event.name+"::::"+event.age, Toast.LENGTH_SHORT).show();
    }

    private void initData() {
        mList=new ArrayList<TestBean>();
        for (int i = 1; i <=10 ; i++) {
            TestBean tb=new TestBean();
            tb.name="小明"+i;
            tb.age=i;
            mList.add(tb);
        }
        mAdapter=new TestAdapter(this,mList);
        mLv.setAdapter(mAdapter);
    }

    private void initView() {
        mLv = (ListView) findViewById(R.id.lv);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }
}
