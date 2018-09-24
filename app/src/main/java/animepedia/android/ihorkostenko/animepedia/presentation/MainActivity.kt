package animepedia.android.ihorkostenko.animepedia.presentation

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import animepedia.android.ihorkostenko.animepedia.R
import animepedia.android.ihorkostenko.animepedia.presentation.ui.main.MainFragment

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                    .replace(R.id.container, MainFragment.newInstance())
                    .commitNow()
        }
    }

}
