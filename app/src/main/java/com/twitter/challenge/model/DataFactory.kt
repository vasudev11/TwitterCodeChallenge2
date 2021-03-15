package com.twitter.challenge.model

import com.twitter.challenge.util.TemperatureConverter
import com.twitter.challenge.util.TemperatureDeviation

object DataFactory {
    /**
     * Create Current Weather and cloudy Data
     */
    fun createCurrentPresentationData(current: Forecast): CurrentPresentation{
        return CurrentPresentation(
                current.weather.temp,
                TemperatureConverter.celsiusToFahrenheit(current.weather.temp),
                current.wind.speed,
                current.clouds != null
        )
    }

    /**
     * Create List of Weather and standard deviation
     */
    fun createForecastPresentation(forecast: List<Forecast>): ForecastPresentation{
        val listOfTemps = forecast.map { it.weather.temp }.toList()
        return ForecastPresentation(listOfTemps,
            TemperatureDeviation.calculateStandardDeviation(listOfTemps))
    }
}