package ml.mylittlebackend.jji6wk.utilities.glide

/*
import android.graphics.drawable.Drawable
import android.widget.ImageView
import androidx.annotation.DrawableRes
import androidx.annotation.RawRes
import com.bumptech.glide.Glide
import com.bumptech.glide.RequestBuilder
import com.bumptech.glide.RequestManager
import com.bumptech.glide.request.RequestOptions

inline fun ImageView.load(imageUrl: String, requestOptions: RequestOptions? = null) {
    loadGlideRequest(
        loadCall = { load(imageUrl) },
        requestOptions = requestOptions
    )
}

inline fun ImageView.load(
    @RawRes @DrawableRes drawableRes: Int,
    requestOptions: RequestOptions? = null
) {
    loadGlideRequest(
        loadCall = { load(drawableRes) },
        requestOptions = requestOptions
    )
}

inline fun ImageView.loadGlideRequest(
    loadCall: RequestManager.() -> RequestBuilder<Drawable>,
    requestOptions: RequestOptions? = null
) {
    Glide.with(this)
        .loadCall()
        .apply {
            if (requestOptions != null) {
                apply(requestOptions)
            }
        }
        .into(this)
}

*/