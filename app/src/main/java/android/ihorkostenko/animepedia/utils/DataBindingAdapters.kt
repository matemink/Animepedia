package android.ihorkostenko.animepedia.utils

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.squareup.picasso.Picasso

class DataBindingAdapters {
    companion object {
        @JvmStatic
        @BindingAdapter("imageUrl")
        fun ImageView.setImageUrl(url: String) {
            Picasso.get().load(url)
                    .fit()
                    .centerCrop()
                    .into(this)
        }
    }
}