package com.example.ladakh.model

data class HomeScreenDatas(
    val id: Int,
    val name: String,
    val ImageId: Int
)

data class ExtendedScreenDatas(
    val id: Int,
    val name: String,
    val ImageId: Int
)

data class DetialedScreenData(
    val name: String,
    val location: String,
    val detials: String,
    val ImageId: Int
)

sealed class ScreenDatas{
    data class Home(val data: List<HomeScreenDatas>): ScreenDatas()
    data class Extended(val data: List<ExtendedScreenDatas>): ScreenDatas()
    data class Detailed(val data: List<DetialedScreenData>): ScreenDatas()
}