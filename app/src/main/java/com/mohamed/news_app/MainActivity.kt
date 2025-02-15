package com.mohamed.news_app

import android.graphics.PorterDuff
import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.mohamed.news_app.databinding.ActivityMainBinding
import com.mohamed.news_app.databinding.ItemProductBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity()
{
    lateinit var binding: ActivityMainBinding
    private lateinit var navController: NavController
    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var listener: NavController.OnDestinationChangedListener
    override fun onCreate(savedInstanceState: Bundle?) {
//        installSplashScreen()
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        navController = findNavController(R.id.navHost)

        setSupportActionBar(binding.appBarMain.toolbar)
        appBarConfiguration = AppBarConfiguration(navController.graph, binding.drawerLayout)
        binding.drawerMenu.setupWithNavController(navController)

        setupActionBarWithNavController(navController, appBarConfiguration)

        // Change the color of the hamburger button
        binding.appBarMain.toolbar.navigationIcon?.colorFilter =
                android.graphics.PorterDuffColorFilter(
                    ContextCompat.getColor(this, R.color.white),
                    PorterDuff.Mode.SRC_IN
                )
    }

    override fun onSupportNavigateUp(): Boolean {

        return navController.navigateUp(appBarConfiguration) or super.onSupportNavigateUp()
    }

    fun setCustomToolbarTitle(title: String) {
        val toolbarTitle = findViewById<TextView>(R.id.toolbarTitle)
        toolbarTitle?.text = title
    }
}
