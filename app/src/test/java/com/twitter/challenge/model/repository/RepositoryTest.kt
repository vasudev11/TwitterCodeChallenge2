package com.twitter.challenge.model.repository

import com.twitter.challenge.model.CloudDay
import com.twitter.challenge.model.Forecast
import com.twitter.challenge.model.WeatherDay
import com.twitter.challenge.model.WindDay
import org.junit.Assert.*
import org.junit.Before
import org.junit.Test


class RepositoryTest{

    private val forecastCloudy : Forecast = Forecast(WeatherDay(1f,1,1),
    WindDay(1f,1), CloudDay(70))

    private val forecastNotCloudy : Forecast = Forecast(WeatherDay(1f,1,1),
    WindDay(1f,1), CloudDay(40))

    private lateinit var classUnderTest: Repository

    @Before
    fun setup(){
        classUnderTest = Repository()
    }

    @Test
    fun testForecastIsCloudy(){
        assertNotNull(classUnderTest)
        assertNotNull(forecastCloudy)
        val actualForecast = classUnderTest.fetchCurrentWeather()
        assertTrue(actualForecast.cloudyDay)
    }
    @Test
    fun testForecastIsNotCloudy(){
        assertNotNull(classUnderTest)
        assertNotNull(forecastCloudy)
        val actualForecast = classUnderTest.fetchCurrentWeather()
        assertFalse(actualForecast.cloudyDay)
    }
}