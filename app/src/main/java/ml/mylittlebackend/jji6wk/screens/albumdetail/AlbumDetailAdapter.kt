package ml.mylittlebackend.jji6wk.screens.albumdetail

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.GridLayout
import android.widget.GridView
import android.widget.ImageView
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.grid_image.view.*
import ml.mylittlebackend.jji6wk.R
import ml.mylittlebackend.jji6wk.screens.container.AlbumComparator

class AlbumDetailAdapter : ListAdapter<String, AlbumDetailAdapter.ImageViewHolder>(AlbumDetailComparator) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ImageViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.grid_image, parent, false)
        return ImageViewHolder(view)
    }

    override fun onBindViewHolder(holder: ImageViewHolder, position: Int) {
        val imageUri = getItem(position)
        val uri = imageUri
        // load image from URI
    }

    inner class ImageViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imageView: ImageView = itemView.imageView
        var uri: String? = null

    }
}