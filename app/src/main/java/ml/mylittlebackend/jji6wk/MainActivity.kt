package ml.mylittlebackend.jji6wk

import android.os.Bundle
import co.zsmb.rainbowcake.navigation.SimpleNavActivity
import ml.mylittlebackend.jji6wk.screens.login.LoginFragment

class MainActivity : SimpleNavActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if (savedInstanceState == null) {
            navigator.add(LoginFragment())
        }
    }
}
