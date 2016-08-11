package com.example.cass.rongapplication;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import io.rong.imkit.RongIM;

/**
 * Created by Cass on 2016/8/10.
 */
public class FriendFragment extends Fragment {
    public static FriendFragment instance=null;

    public static FriendFragment getInstance(){
        if (instance==null){
            instance=new FriendFragment();

        }
        return  instance;
    }
    private View mView;

    private Button mButton;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mView=inflater.inflate(R.layout.friend_fragment,null);
        mButton= (Button) mView.findViewById(R.id.friend);
        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (RongIM.getInstance()!=null){
                    RongIM.getInstance().startPrivateChat(getActivity(),"wohand2","私人聊天");
                }
            }
        });
        return mView;
    }
}
