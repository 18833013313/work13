package bw.com.work13.apploction;

import android.app.Application;

import com.umeng.commonsdk.UMConfigure;



public class Apploction extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        UMConfigure.init(this, "5c441189b465f5128c0005fa", "Umeng", UMConfigure.DEVICE_TYPE_PHONE,"");
        //5c441189b465f5128c0005fa
        UMConfigure.setLogEnabled(true);
    }
}
