package com.rnexample

import com.facebook.react.uimanager.SimpleViewManager
import com.facebook.react.uimanager.ThemedReactContext
import com.facebook.react.uimanager.annotations.ReactProp

class ReactFrescoImage : SimpleViewManager<FrescoImageView>() {
    companion object {
        private const val REACT_CLASS="FrescoImageView"
    }
    override fun getName(): String {
        return REACT_CLASS
    }

    override fun createViewInstance(reactContext: ThemedReactContext): FrescoImageView {
            return FrescoImageView(context = reactContext)
    }

    @ReactProp(name="src")
    fun setImageUri(view: FrescoImageView, uriString:String?){
        uriString?.let {
            view.setImageURI(uriString)
        }
    }


}