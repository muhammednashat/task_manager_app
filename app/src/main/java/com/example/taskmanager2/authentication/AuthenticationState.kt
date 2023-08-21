package com.example.taskmanager2.authentication

import androidx.lifecycle.map


enum class AuthenticationState {
    AUTHENTICATED, UNAUTHENTICATED
}


val authenticationStatee = FirebaseUserLiveData().map { user ->
    if (user != null) {
        AuthenticationState.AUTHENTICATED
    } else {
        AuthenticationState.UNAUTHENTICATED
    }
}
