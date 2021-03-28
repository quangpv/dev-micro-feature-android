package com.example.testmicrofeature

import android.app.Application
import com.example.core.provides
import com.example.core.proxyModule
import com.example.core.proxyOf
import com.example.home.HomeGateway
import com.example.home.homeModules
import com.example.modules.authenticate.AuthenticateProxy
import com.example.modules.configure.ConfigProxy
import com.example.modules.home.HomeProxy
import com.example.modules.module.ModuleProxy
import com.example.testmicrofeature.mocks.MockAuthorProxy
import com.example.testmicrofeature.mocks.MockConfigProxy
import com.example.testmicrofeature.mocks.MockHomeEvent

@Suppress("unused")
class MyApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        provides {
            proxyOf<ModuleProxy>(
                proxyModule<HomeProxy>(homeModules) { HomeGateway(MockHomeEvent()) },
                proxyModule<ConfigProxy> { MockConfigProxy() },
                proxyModule<AuthenticateProxy> { MockAuthorProxy() }
            )
        }
    }
}
