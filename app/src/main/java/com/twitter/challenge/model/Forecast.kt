package com.twitter.challenge.model

data class Forecast(
        val weather: WeatherDay,
        val wind: WindDay,
        val clouds: CloudDay
)

data class WeatherDay(
        val temp: Float,
        val pressure: Int,
        val humidity: Int
)

data class WindDay(
        val speed: Float,
        val deg: Int
)

data class CloudDay(
        val cloudiness: Int
)