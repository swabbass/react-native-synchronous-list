package com.rnexample

import android.content.Context
import android.net.Uri
import com.facebook.drawee.backends.pipeline.Fresco
import com.facebook.drawee.drawable.ScalingUtils
import com.facebook.drawee.generic.GenericDraweeHierarchyBuilder
import com.facebook.drawee.view.SimpleDraweeView
import com.facebook.imagepipeline.common.ResizeOptions
import com.facebook.imagepipeline.request.ImageRequestBuilder

class FrescoImageView(context: Context) : SimpleDraweeView(context) {


    companion object {
        const val TAG = "FrescoImageView"
    }

    private val draweeHierarchy = GenericDraweeHierarchyBuilder.newInstance(resources)
            .setActualImageScaleType(ScalingUtils.ScaleType.FOCUS_CROP)
            .setDesiredAspectRatio(1f)
            .build()

    val resizeOptions = ResizeOptions(200, 200)

    init {
        this.hierarchy = draweeHierarchy

    }

    override fun setImageURI(uriString: String?) {
        uriString?.let {
            val request = ImageRequestBuilder.newBuilderWithSource(Uri.parse(it))
                    .setResizeOptions(resizeOptions)
                    .setLocalThumbnailPreviewsEnabled(true)
                    .build()
            val build = Fresco.newDraweeControllerBuilder()
                    .setImageRequest(request)
                    .setOldController(this.controller).build()
            this@FrescoImageView.controller = build
        }


    }

}