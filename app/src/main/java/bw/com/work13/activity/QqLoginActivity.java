package bw.com.work13.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.umeng.commonsdk.UMConfigure;
import com.umeng.socialize.UMAuthListener;
import com.umeng.socialize.UMShareAPI;
import com.umeng.socialize.bean.SHARE_MEDIA;

import java.util.Map;

import bw.com.work13.R;

public class QqLoginActivity extends AppCompatActivity {
    UMShareAPI umShareAPI;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_qq_login);
        Button produck = findViewById(R.id.produck);
        Button qq = findViewById(R.id.qq);
        umShareAPI = UMShareAPI.get(this);
        produck.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(QqLoginActivity.this,ProduckActivity.class);
                startActivity(intent);
            }
        });
        qq.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {






       umShareAPI.getPlatformInfo(QqLoginActivity.this, SHARE_MEDIA.QQ, new UMAuthListener() {
           @Override
           public void onStart(SHARE_MEDIA share_media) {
               Toast.makeText(QqLoginActivity.this,"开始",Toast.LENGTH_LONG).show();
           }

           @Override
           public void onComplete(SHARE_MEDIA share_media, int i, Map<String, String> map) {

           }

           @Override
           public void onError(SHARE_MEDIA share_media, int i, Throwable throwable) {

           }

           @Override
           public void onCancel(SHARE_MEDIA share_media, int i) {

           }
       });
            }
        });
    }


}
