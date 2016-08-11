package com.example.cass.rongapplication;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by Cass on 2016/8/10.
 */
public class HomeFragment extends Fragment {
   public static HomeFragment instance=null;

    public static HomeFragment getInstance(){
     if (instance==null){
         instance=new HomeFragment();

     }
        return  instance;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        TextView tv=new TextView(getActivity());
        tv.setText("第一页");
        return tv;
    }
}
