package android.ihorkostenko.animepedia.presentation

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import animepedia.android.ihorkostenko.animepedia.R
import android.ihorkostenko.animepedia.presentation.ui.fragments.CharactersFragment
import android.ihorkostenko.animepedia.presentation.ui.fragments.PicturesFragment
import android.view.View
import com.google.android.material.bottomnavigation.BottomNavigationView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                    .replace(R.id.container, CharactersFragment.newInstance())
                    .commitNow()
        }

        val bottomNavigationView = findViewById<BottomNavigationView>(R.id.bottom_navigation)
        bottomNavigationView.setOnNavigationItemSelectedListener { item ->
            progressBar.visibility = View.VISIBLE
            when (item.itemId) {
                R.id.characters -> {
                    supportFragmentManager.beginTransaction()
                            .replace(R.id.container, CharactersFragment.newInstance())
                            .commitNow()
                }
                R.id.episodes -> {
                    supportFragmentManager.beginTransaction()
                            .replace(R.id.container, CharactersFragment.newInstance())
                            .commitNow()
                }
                R.id.news -> {
                    supportFragmentManager.beginTransaction()
                            .replace(R.id.container, CharactersFragment.newInstance())
                            .commitNow()
                }
                R.id.pictures -> {
                    supportFragmentManager.beginTransaction()
                            .replace(R.id.container, PicturesFragment.newInstance())
                            .commitNow()
                }
                R.id.videos -> {
                    supportFragmentManager.beginTransaction()
                            .replace(R.id.container, CharactersFragment.newInstance())
                            .commitNow()
                }
            }
            return@setOnNavigationItemSelectedListener true
        }
    }
}
