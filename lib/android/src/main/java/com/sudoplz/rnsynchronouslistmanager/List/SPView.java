package com.sudoplz.rnsynchronouslistmanager.List;

import com.facebook.react.ReactNativeHost;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.bridge.ReadableMap;
import com.sudoplz.rnsynchronouslistmanager.Sync.SyncRootView;
import com.sudoplz.rnsynchronouslistmanager.Utils.SPGlobals;

/**
 * Created by idynopia on 15/02/2018.
 */

public class SPView extends SyncRootView {

    public SPView(ReadableMap initialProps) {
        super(SPGlobals.getInstance().getMainViewTemplateName(), initialProps);
    }

    public SPView() {
        super(SPGlobals.getInstance().getMainViewTemplateName());
    }
}
