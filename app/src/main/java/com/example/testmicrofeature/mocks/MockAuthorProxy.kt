package com.example.testmicrofeature.mocks

import com.example.modules.authenticate.AuthenticateProxy
import com.example.modules.authenticate.UserModel

class MockAuthorProxy : AuthenticateProxy {
    var loggedIn = false

    override suspend fun getUserLoggedIn(): UserModel = object : UserModel {
        override val userName: String = if (loggedIn) "Mock user" else ""
    }

    override suspend fun logout() {
        loggedIn = false
    }
}