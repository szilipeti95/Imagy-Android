package ml.mylittlebackend.jji6wk.screens.albumdetail

import androidx.recyclerview.widget.DiffUtil
import ml.mylittlebackend.jji6wk.domain.model.Image

object AlbumDetailComparator : DiffUtil.ItemCallback<Image>() {

    override fun areItemsTheSame(oldItem: Image, newItem: Image): Boolean {
        return oldItem.imageUri == newItem.imageUri
    }

    override fun areContentsTheSame(oldItem: Image, newItem: Image): Boolean {
        return oldItem == newItem
    }

}
