package com.rnexample;

import android.app.Application;
import android.content.Context;

import com.facebook.cache.disk.DiskCacheConfig;
import com.facebook.common.internal.Supplier;
import com.facebook.imagepipeline.cache.MemoryCacheParams;
import com.facebook.imagepipeline.core.ImagePipelineConfig;
import com.facebook.react.ReactApplication;
import com.facebook.react.shell.MainPackageConfig;
import com.sudoplz.rnsynchronouslistmanager.SynchronousListPackage;
import com.facebook.react.ReactNativeHost;
import com.facebook.react.ReactPackage;
import com.facebook.react.shell.MainReactPackage;
import com.facebook.soloader.SoLoader;

import java.util.Arrays;
import java.util.List;

import static com.facebook.common.util.ByteConstants.MB;

public class MainApplication extends Application implements ReactApplication {

    private final ReactNativeHost mReactNativeHost = new ReactNativeHost(this) {
        @Override
        public boolean getUseDeveloperSupport() {
            return BuildConfig.DEBUG;
        }

        @Override
        protected List<ReactPackage> getPackages() {


            Context context = getApplicationContext();
            // This is the Fresco config, do anything custom you want here
            ImagePipelineConfig frescoConfig = ImagePipelineConfig
                    .newBuilder(context)
                    .setDownsampleEnabled(true)
                    .setMainDiskCacheConfig(DiskCacheConfig.newBuilder(context).setMaxCacheSize(300*MB).setMaxCacheSizeOnLowDiskSpace(10*MB).build())
                    .setBitmapMemoryCacheParamsSupplier(new Supplier<MemoryCacheParams>() {
                        @Override
                        public MemoryCacheParams get() {
                            return new MemoryCacheParams(100 * MB, 1000, 10 * MB, 20, 5 * MB);
                        }
                    })

                    .build();

            MainPackageConfig appConfig = new MainPackageConfig
                    .Builder()
                    .setFrescoConfig(frescoConfig)
                    .build();
            return Arrays.<ReactPackage>asList(
                    new MainReactPackage(appConfig),
                    new SynchronousListPackage(getReactNativeHost()),
                    new FrescoImagePackager()
            );
        }

        @Override
        protected String getJSMainModuleName() {
            return "index";
        }
    };

    @Override
    public ReactNativeHost getReactNativeHost() {
        return mReactNativeHost;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        SoLoader.init(this, /* native exopackage */ false);
    }
}
