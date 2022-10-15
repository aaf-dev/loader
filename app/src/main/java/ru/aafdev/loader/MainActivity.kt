package ru.aafdev.loader

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import ru.aafdev.feature_main.presentation.MainFragment
import ru.aafdev.loader.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private var binding: ActivityMainBinding? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding?.root)

        goToMainFragment()
    }

    private fun goToMainFragment() {
        val containerId = binding?.root?.id ?: return

        supportFragmentManager
            .beginTransaction()
            .replace(containerId, MainFragment())
            .commit()
    }
}
