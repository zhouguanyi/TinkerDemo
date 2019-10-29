package com.guanyi.tinker;

import android.app.Application;
import android.widget.Toast;

import com.tencent.tinker.entry.ApplicationLike;
import com.tinkerpatch.sdk.TinkerPatch;
import com.tinkerpatch.sdk.loader.TinkerPatchApplicationLike;

public class SampleApplication extends Application {

    private ApplicationLike tinkerApplicationLike;
    @Override
    public void onCreate() {
        super.onCreate();
        Toast.makeText(this,"onCreate",Toast.LENGTH_LONG).show();
        if (BuildConfig.TINKER_ENABLE) {
            Toast.makeText(this,"TINKER_ENABLE",Toast.LENGTH_LONG).show();
            // 我们可以从这里获得Tinker加载过程的信息
            tinkerApplicationLike = TinkerPatchApplicationLike.getTinkerPatchApplicationLike();

            // 初始化TinkerPatch SDK, 更多配置可参照API章节中的,初始化SDK
            TinkerPatch.init(tinkerApplicationLike)
                    .reflectPatchLibrary()
                    .setPatchRollbackOnScreenOff(true)
                    .setPatchRestartOnSrceenOff(true);

            // 每隔3个小时去访问后台时候有更新,通过handler实现轮训的效果
            new FetchPatchHandler().fetchPatchWithInterval(1);
        }
    }
}
