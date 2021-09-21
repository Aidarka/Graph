package com.example.graph.generator

import com.jjoe64.graphview.series.DataPoint
import com.jjoe64.graphview.series.LineGraphSeries
import kotlin.math.cos
import kotlin.math.sqrt

class Generator() {
    fun generate(min: Int, max: Int, series: LineGraphSeries<DataPoint>) {
        var x: Double
        var y: Double
        y= 0.0
        for (i in min..max) {
            x = i.toDouble()
            y = x
            y = ((x * x)/4) + ((y * y)/9) - 1
            series.appendData(DataPoint(x, y), true, 500)
        }
    }

    fun generateHyperbola(min: Int, max: Int, series: LineGraphSeries<DataPoint>) {
        var x: Double
        var y: Double
        for (i in min..max) {
            x = i.toDouble()
            y = sqrt((1 + x*x / 36) * 16)
            series.appendData(DataPoint(x, y), true, 500)
        }
    }


}