package ml.mylittlebackend.jji6wk.screens.container

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.album_detail_fragment.view.*
import ml.mylittlebackend.jji6wk.R
import ml.mylittlebackend.jji6wk.domain.model.Album

class AlbumAdapter : ListAdapter<Album, AlbumAdapter.AlbumViewHolder>(AlbumComparator) {
    var listener: Listener? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AlbumViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.row_album, parent, false)
        return AlbumViewHolder(view)
    }

    override fun onBindViewHolder(holder: AlbumViewHolder, position: Int) {
        val album = getItem(position)
        holder.album = album

        holder.albumNameText.text = album.name
    }


    inner class AlbumViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val albumNameText: TextView = itemView.albumNameText
        var album: Album? = null

        init {
            itemView.setOnClickListener {
                album?.let { listener?.onAlbumClicked(it) }
            }
        }
    }

    interface Listener {
        fun onAlbumClicked(album: Album)
    }
}