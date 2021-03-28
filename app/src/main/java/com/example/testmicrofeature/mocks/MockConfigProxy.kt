package com.example.testmicrofeature.mocks

import com.example.modules.configure.ConfigModel
import com.example.modules.configure.ConfigProxy
import com.example.modules.configure.ConfigSettings

class MockConfigProxy : ConfigProxy {
    override val settings: ConfigSettings = object : ConfigSettings {
        override val isEnableLogout: Boolean = true
        override val isEnableLoadConfig: Boolean = true
        override val isEnableLogin: Boolean = true
    }

    override suspend fun loadConfig(): ConfigModel {
        return object : ConfigModel {
            override val value: String = "This is mock Config"
        }
    }
}