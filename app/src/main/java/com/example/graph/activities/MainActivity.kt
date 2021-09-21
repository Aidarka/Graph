package com.example.graph.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.SeekBar
import com.example.graph.generator.Generator
import com.example.graph.R
import com.jjoe64.graphview.series.DataPoint
import com.jjoe64.graphview.series.LineGraphSeries
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        fun onProgressChanged() {

            var oldMin = seek_min.progress
            var oldMax = seek_max.progress
            if (seek_min.progress < seek_max.progress) {

                tv_min.text = seek_min.progress.toString()
                tv_max.text = seek_max.progress.toString()

                graph.series.clear()

                var series = LineGraphSeries<DataPoint>();
                if (switch1.isChecked) {
                    Generator()
                        .generateCos(seek_min.progress, seek_max.progress, series)
                } else {
                    Generator()
                        .generateHyperbola(seek_min.progress, seek_max.progress, series)
                }
                graph.addSeries(series)
            } else {
                seek_min.progress = oldMin
                seek_max.progress = oldMax
            }

        }

        switch1.setOnCheckedChangeListener { buttonView, isChecked ->
            (
                    if (isChecked) {
                        switch1.text = "function"
                        onProgressChanged()
                    } else {
                        switch1.text = "Hyperbola function"
                        onProgressChanged()
                    }
                    )
        }



        seek_max?.setOnSeekBarChangeListener(object :
            SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(
                seek: SeekBar,
                progress: Int, fromUser: Boolean
            ) {
                onProgressChanged()
            }

            override fun onStartTrackingTouch(seek: SeekBar) {
            }

            override fun onStopTrackingTouch(seek: SeekBar) {
            }

        })

        seek_min?.setOnSeekBarChangeListener(object :
            SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(
                seek: SeekBar,
                progress: Int, fromUser: Boolean
            ) {
                onProgressChanged()

            }

            override fun onStartTrackingTouch(seekBar: SeekBar?) {
            }

            override fun onStopTrackingTouch(seekBar: SeekBar?) {
            }
        })

    }
}
