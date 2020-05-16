package ml.mylittlebackend.jji6wk.screens.albumdetail

import androidx.recyclerview.widget.DiffUtil

object AlbumDetailComparator : DiffUtil.ItemCallback<String>() {

    override fun areItemsTheSame(oldItem: String, newItem: String): Boolean {
        return oldItem == newItem
    }

    override fun areContentsTheSame(oldItem: String, newItem: String): Boolean {
        return oldItem == newItem
    }

}
