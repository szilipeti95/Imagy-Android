package ml.mylittlebackend.jji6wk.screens.container

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.like.LikeButton
import com.like.OnLikeListener
import kotlinx.android.synthetic.main.row_album.view.*
import ml.mylittlebackend.jji6wk.R
import ml.mylittlebackend.jji6wk.domain.model.Album
import ml.mylittlebackend.jji6wk.utilities.glide.load

class AlbumAdapter(
    private val registeredUser: Boolean
) : ListAdapter<Album, AlbumAdapter.AlbumViewHolder>(AlbumComparator) {
    var listener: Listener? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AlbumViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.row_album, parent, false)
        return AlbumViewHolder(view)
    }

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: AlbumViewHolder, position: Int) {
        val album = getItem(position)
        holder.album = album
        holder.albumNameText.text = album.name
        holder.albumAuthor.text = album.author
        val likeString = holder.albumLikeCount.context.getString(R.string.album_likes)
        holder.albumLikeCount.text = "${album.likeCount} $likeString"
        album.thumbnailUri?.let {
            holder.albumImageView.load(it)
        }
        if (registeredUser) {
            holder.heartButton.visibility = View.VISIBLE
            holder.heartButton.isLiked = album.isLiked
        } else {
            holder.heartButton.visibility = View.GONE
        }
    }

    inner class AlbumViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val albumNameText: TextView = itemView.albumNameText
        val albumLikeCount: TextView = itemView.albumLikeCount
        val albumAuthor: TextView = itemView.albumAuthor
        val albumImageView: ImageView = itemView.albumImageView
        val heartButton: LikeButton = itemView.heartButton
        var album: Album? = null

        init {
            itemView.setOnClickListener {
                album?.let { listener?.onAlbumClicked(it) }
            }
            itemView.heartButton.setOnLikeListener(object: OnLikeListener{
                override fun liked(likeButton: LikeButton?) {
                    album?.let { listener?.onHeartClicked(itemView, it) }
                }

                override fun unLiked(likeButton: LikeButton?) {
                    album?.let { listener?.onHeartClicked(itemView, it) }
                }
            })
        }
    }

    interface Listener {
        fun onAlbumClicked(album: Album)
        fun onHeartClicked(itemView: View, album: Album)
    }
}