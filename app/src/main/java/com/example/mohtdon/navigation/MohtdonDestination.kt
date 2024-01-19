package com.example.mohtdon.navigation

sealed class NavigationDestination(val route: String) {
    data object ScreenSplash: NavigationDestination("ScreenSplash")
    data object ScreenHome: NavigationDestination("ScreenHome")
    data object ScreenFollowing: NavigationDestination("ScreenFollowing")
    data object ScreenMushaf: NavigationDestination("ScreenMushaf")

    data object ScreenRadio: NavigationDestination("ScreenRadio")

    data object ScreenSettings: NavigationDestination("ScreenSettings")
    data object ScreenMore: NavigationDestination("ScreenMore")
    data object ScreenShahada: NavigationDestination("ScreenShahada")
    data object ScreenHadithTopics: NavigationDestination("ScreenHadithTopics")
    data object ScreenAhadith: NavigationDestination("ScreenAhadith")
    data object ScreenAzkarTopics: NavigationDestination("ScreenAzkarTopics")
    data object ScreenAzkar: NavigationDestination("ScreenAzkar")















}