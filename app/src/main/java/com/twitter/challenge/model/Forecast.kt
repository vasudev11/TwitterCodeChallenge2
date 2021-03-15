package com.twitter.challenge.model

data class Forecast(
        val weather: WeatherDay,
        val wind: WindDay,
        var clouds: CloudDay? = null
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

data class CurrentPresentation(
        val tempCelsius: Float,
        val tempFh: Float,
        val windSpeed: Float,
        val cloudyDay: Boolean
)

data class ForecastPresentation(
        val tempForecast: List<Float>,
        val deviationTemp: Float
)