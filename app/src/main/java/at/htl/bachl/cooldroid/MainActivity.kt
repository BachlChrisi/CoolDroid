package at.htl.bachl.cooldroid

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private val COUNTER = "counter"
    internal val LOG_TAG = MainActivity::class.java.simpleName
    private var counter = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if(savedInstanceState != null){
            counter = savedInstanceState.getInt(COUNTER)
            tv_message.text = getMessageText()
        }
        iv_droid.setOnClickListener{
            counter++
            Log.d(LOG_TAG,"onCreate(), counter: $counter")
            tv_message.text = getMessageText()
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        outState?.putInt(COUNTER,counter)
        Log.d(LOG_TAG,"onSaveInstanceState(), counter: $counter")
        super.onSaveInstanceState(outState)
    }

    private fun getMessageText() =
        when(counter){
            1 -> getString(R.string.once)
            2 -> getString(R.string.twice)
            else -> getString(R.string.text_view_numbers,counter)
        }
}
