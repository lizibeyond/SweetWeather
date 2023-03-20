package com.example.sweetweather.dao

data class Citys(val status:String,val places: List<Place>)

data class Place(val name:String,val location: Location)

data class Location(val lng:String,val lat:String)