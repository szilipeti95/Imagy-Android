package ml.mylittlebackend.jji6wk.screens.container

import androidx.recyclerview.widget.DiffUtil
import ml.mylittlebackend.jji6wk.domain.model.Album

object AlbumComparator : DiffUtil.ItemCallback<Album>() {

    override fun areItemsTheSame(oldItem: Album, newItem: Album): Boolean {
        return oldItem.name == newItem.name
    }

    override fun areContentsTheSame(oldItem: Album, newItem: Album): Boolean {
        return oldItem == newItem
    }

}
