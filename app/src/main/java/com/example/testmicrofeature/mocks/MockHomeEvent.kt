package com.example.testmicrofeature.mocks

import androidx.lifecycle.lifecycleScope
import com.example.core.block
import com.example.core.lookup
import com.example.home.HomeFragment
import com.example.home.actions.GotoLoginAction
import com.example.modules.authenticate.AuthenticateProxy
import com.example.modules.module.ModuleAction
import com.example.modules.module.ModuleEvent
import com.example.testmicrofeature.MainActivity

class MockHomeEvent : ModuleEvent {
    companion object {
        const val HOME_FRAGMENT = "com.example.home.HomeFragment"
    }

    override fun onEvent(action: ModuleAction) {
        if (action !is GotoLoginAction) return
        block(action.fragment) {
            lifecycleScope.launchWhenStarted {
                val auth by lookup<AuthenticateProxy>()
                (auth as MockAuthorProxy).loggedIn = true
                (requireActivity() as MainActivity).showFragment(HOME_FRAGMENT)
            }
        }
    }
}