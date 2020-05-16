package ml.mylittlebackend.jji6wk.screens.container

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import co.zsmb.rainbowcake.base.RainbowCakeFragment
import co.zsmb.rainbowcake.dagger.getViewModelFromFactory
import com.google.android.material.tabs.TabLayoutMediator
import kotlinx.android.synthetic.main.fragment_container.*

import ml.mylittlebackend.jji6wk.R


class ContainerFragment : RainbowCakeFragment<ContainerViewState, ContainerViewModel>() {

    override fun provideViewModel() = getViewModelFromFactory()
    override fun getViewResource() = R.layout.fragment_container

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewpager.adapter = ContainerPagerAdapter(this)

        TabLayoutMediator(tabs, viewpager,
            TabLayoutMediator.TabConfigurationStrategy { tab, position ->
                tab.text = when (position) {
                    0 -> getString(R.string.tab_album_list)
                    1 -> getString(R.string.tab_user_detail)
                    else -> throw IllegalArgumentException()
                }
            }).attach()
    }

    override fun onStart() {
        super.onStart()

    }

    override fun render(viewState: ContainerViewState) {

    }

}
