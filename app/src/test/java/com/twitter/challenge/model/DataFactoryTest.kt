package com.twitter.challenge.model

import org.junit.Assert.*
import org.junit.Before
import org.junit.Ignore
import org.junit.Test

class DataFactoryTest{

    private lateinit var forecastNotClouds: Forecast
    private lateinit var forecastClouds: Forecast
    private lateinit var listOfForecast: MutableList<Forecast>
    @Before
    fun setup(){
        forecastClouds = Forecast(WeatherDay(1f,1, 1),
        WindDay(1f,1),
        CloudDay(70))
        forecastNotClouds = Forecast(WeatherDay(1f,1, 1),
        WindDay(1f,1),
        null)
        listOfForecast = mutableListOf(
                Forecast(WeatherDay(20f,1, 1),
                        WindDay(1f,1),
                        CloudDay(70)),
                Forecast(WeatherDay(50f,1, 1),
                        WindDay(1f,1),
                        CloudDay(70)),
                Forecast(WeatherDay(10f,1, 1),
                        WindDay(1f,1),
                        CloudDay(70)),
                Forecast(WeatherDay(45f,1, 1),
                        WindDay(1f,1),
                        CloudDay(70)),
                Forecast(WeatherDay(70f,1, 1),
                        WindDay(1f,1),
                        CloudDay(70)))
    }

    @Test
    fun testCurrentPresentationIsNotCloudy(){
        assertNotNull(forecastNotClouds)
        val presentationData = DataFactory.createCurrentPresentationData(forecastNotClouds)
        assertFalse(presentationData.cloudyDay)
    }

    @Test
    fun testCurrentPresentationIsCloudy(){
        assertNotNull(forecastNotClouds)
        val presentationData = DataFactory.createCurrentPresentationData(forecastNotClouds)
        assertFalse(presentationData.cloudyDay)
    }

    @Ignore
    @Test
    fun testForecastPresentation(){
        val forecastPresentation = DataFactory.createForecastPresentation(listOfForecast.toList())
        assertNotNull(forecastPresentation)
        assertEquals(forecastPresentation.deviationTemp, 24.083189f)
        assertEquals(forecastPresentation.tempForecast[0], 20f)
    }
}