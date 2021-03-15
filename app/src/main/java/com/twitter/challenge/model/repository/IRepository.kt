package com.twitter.challenge.model.repository

import com.twitter.challenge.model.CurrentPresentation
import com.twitter.challenge.model.Forecast
import com.twitter.challenge.model.ForecastPresentation

interface IRepository {
    fun fetchCurrentWeather(): CurrentPresentation
    fun fetchForecast(days: Int = 5): ForecastPresentation
}