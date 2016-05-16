package com.djn.huidiao.huidiao;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Administrator on 2016/5/16.
 */
public class TestAdapter extends BaseAdapter {

    private List<TestBean> mList;
    private Context context;
    public TestAdapter(Context context, List<TestBean> mList) {
        this.mList=mList;
        this.context=context;
    }

    @Override
    public int getCount() {
        return mList.size()==0?0:mList.size();
    }

    @Override
    public Object getItem(int position) {
        return mList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return mList.size()==0?0:position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if(convertView==null){
            convertView = View.inflate(context, R.layout.view_test, null);
            holder=new ViewHolder();
            holder.nameTv = (TextView) convertView.findViewById(R.id.name);
            holder.ageTv= (TextView) convertView.findViewById(R.id.age);
            convertView.setTag(holder);
        }else{
            holder = (ViewHolder) convertView.getTag();
        }

        //设置显示
        TestBean testBean = mList.get(position);
        holder.nameTv.setText(testBean.name);
        holder.ageTv.setText(String.valueOf(testBean.age));

        return convertView;
    }

    public static  class ViewHolder{
        TextView nameTv;
        TextView ageTv;
    }
}
