package com.example.cass.rongapplication.activity;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.cass.rongapplication.R;
import com.example.cass.rongapplication.beans.Friend;

import java.util.ArrayList;
import java.util.List;

import io.rong.imkit.RongIM;
import io.rong.imlib.RongIMClient;
import io.rong.imlib.model.UserInfo;

public class MainActivity extends Activity implements View.OnClickListener,RongIM.UserInfoProvider{


    private static final String token1="xc1J4mDDswUxvAlmtcoqa+LIbUk6JoHDtw3Zb526P4v1vD4oyaZn6CYULzFLz+3BlflMBoHLFjObOpzgLvMWXw==";
    private static final String token2="ESbIKNkgtNzXf0ip/muSfa+MKkEGmIbxpwSsokIAMANTLKy56xbJIRvI9RtDanc1/D9ISD4uKd7jZ/mtASEo2DMNJnYItysD";

    private List<Friend> userIdList;

    public static final String TAG = "something";
    private Button mUser1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mUser1= (Button) findViewById(R.id.button);
        mUser1.setOnClickListener(this);

        initUserInfo();
    }



    @Override
    public void onClick(View view) {
        if (view.getId()==R.id.button){
            connectRongServer(token1);
        }
    }

    private void connectRongServer(String token1) {
        RongIM.connect(token1, new RongIMClient.ConnectCallback() {
            //成功回调s为token1当前的userid
            @Override
            public void onSuccess(String s) {
                if (s.equals("wohand1")){
                    mUser1.setText("用户连接服务器成功");
                    startActivity(new Intent(MainActivity.this,HomeActivity.class));
                    Toast.makeText(MainActivity.this,"connect setver success 10010",Toast.LENGTH_SHORT);
                }
                Log.e(TAG, "onSuccess: "+s );
            }

            //错误回调
            @Override
            public void onError(RongIMClient.ErrorCode errorCode) {
                Log.e(TAG, "onError: "+errorCode );
            }

            @Override
            public void onTokenIncorrect() {
                Log.e(TAG, "onTokenIncorrect: ");
            }
        });
    }

    //头像加载相关
    private void initUserInfo() {
        userIdList=new ArrayList<Friend>();
        userIdList.add(new Friend("wohand1","wohand1","http://www.iyingdi.com/pmgocp/img/pm/pmgo/025.png"));
        userIdList.add(new Friend("wohand2","wohand2","http://www.iyingdi.com/pmgocp/img/pm/pmgo/026.png"));
        RongIM.setUserInfoProvider((RongIM.UserInfoProvider) this,true);
    }

    @Override
    public UserInfo getUserInfo(String s) {//当前对应用户信息的userid
        for (Friend i:userIdList){
            if (i.getUserid().equals(s)){
                Log.e(TAG, "getUserInfo: "+i.getPhoto() );
                return new UserInfo(i.getUserid(),i.getName(), Uri.parse(i.getPhoto()));
            }
        }
        Log.e(TAG, "getUserInfo: "+s );
        return null;
    }
}
