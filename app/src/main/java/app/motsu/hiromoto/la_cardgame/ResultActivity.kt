package app.motsu.hiromoto.la_cardgame

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_result.*

class ResultActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        toTitleButton.setOnClickListener {
            val intent: Intent = Intent(this,StartActivity::class.java)
            startActivity(intent)
        }
    }
}