package com.example.cass.rongapplication.activity;

import android.support.v4.app.FragmentActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.cass.rongapplication.R;

import io.rong.imlib.model.Conversation;

public class ConversationActivity extends FragmentActivity {

    /*
    目标ID
     */
    private String mTargetId;
    /*
    刚创建完头阿伦组后获得讨论组的id为targetIds 需要根据为targetIds获取targetId
     */
    private String mTargetIds;
    /*
    会话类型
     */
    private Conversation.ConversationType mConversationType;
    /*
    title名称
     */
    private TextView mName;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.conversation);
        mName= (TextView) findViewById(R.id.txt1);

        mTargetId=getIntent().getData().getQueryParameter("targetId");//目标ID：单聊为userId,群聊为groupId
        mTargetIds=getIntent().getData().getQueryParameter("title");//获取昵称，需要实现用户信息提供者
        if (!TextUtils.isEmpty(mTargetIds)){
            mName.setText(mTargetIds);
        }else{
            //未获取到昵称,通过mTargetId，去服务器请求用户信息
        }
    }
}
