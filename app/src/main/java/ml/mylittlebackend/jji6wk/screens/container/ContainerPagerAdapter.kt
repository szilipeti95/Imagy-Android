package ml.mylittlebackend.jji6wk.screens.container

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import ml.mylittlebackend.jji6wk.screens.container.albumlist.AlbumListFragment
import ml.mylittlebackend.jji6wk.screens.container.userdetail.UserDetailFragment


class ContainerPagerAdapter(fragment: Fragment) : FragmentStateAdapter(fragment) {

    override fun getItemCount(): Int = 2

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> AlbumListFragment()
            1 -> UserDetailFragment()
            else -> throw IllegalArgumentException("Wrong fragment position")
        }
    }
}