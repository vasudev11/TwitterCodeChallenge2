package com.twitter.challenge.util;

import android.util.Log;

import java.util.List;


public class TemperatureDeviation {
    /**
     * Xi [f1,f2,f3,f4,f5]
     * N 5
     * Calculate average Summatory of ( (xi - AverageX)^2 / n - 1 ) squart2
     * @param dataForecast
     * @return
     */
    public static float calculateStandardDeviation(List<Float> dataForecast){
        Double summatory = 0d;
        Double averageData;
        for(int index = 0; index < dataForecast.size(); index++){
            summatory += dataForecast.get(index);
        }
        averageData = summatory / dataForecast.size();
        summatory = 0d;
        for(int j = 0; j< dataForecast.size(); j++){
            summatory +=
                    Math.pow(dataForecast.get(j) - averageData, 2);
        }
        double variance = summatory / (dataForecast.size() - 1);
        return (float)Math.sqrt(variance);
    }
}
