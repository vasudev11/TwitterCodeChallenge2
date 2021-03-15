package com.twitter.challenge.model.repository

import android.support.annotation.VisibleForTesting
import com.twitter.challenge.model.*

class Repository: IRepository {

    override fun fetchCurrentWeather(): CurrentPresentation {
        return currentFactory()
    }

    private fun currentFactory(): CurrentPresentation {
        val response: Forecast? = networkIsNotCloudyDay()
        response?.let {
            if(dayIsNotCloudy(it.clouds)) {
                response.clouds = null
            }
        }
        return createCurrentForecast(response!!)
    }

    private fun dayIsNotCloudy(cloudDay: CloudDay?): Boolean {
        if(cloudDay != null)
            return cloudDay.cloudiness < 50
        return false
    }

    override fun fetchForecast(days: Int): ForecastPresentation {
        return forecastFactory(days)
    }

    private fun forecastFactory(days: Int): ForecastPresentation{
        val response: List<Forecast>? = null

        return createForecast(response!!)
    }

    private fun createCurrentForecast(response: Forecast): CurrentPresentation =
            DataFactory.createCurrentPresentationData(response)

    private fun createForecast(response: List<Forecast>) =
            DataFactory.createForecastPresentation(response)

    @VisibleForTesting
    fun networkIsNotCloudyDay(): Forecast {
        return Forecast(WeatherDay(1f,1,1),
                WindDay(1f,1), CloudDay(40))
    }
    @VisibleForTesting
    fun networkIsCloudyDay(): Forecast {
        return Forecast(WeatherDay(1f,1,1),
                WindDay(1f,1), CloudDay(70))
    }
}