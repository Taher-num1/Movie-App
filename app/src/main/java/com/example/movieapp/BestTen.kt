package com.example.movieapp

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.movieapp.databinding.ActivityBestTenBinding
import com.example.recycler_view.Movies

class BestTen : AppCompatActivity() {
    lateinit var newRecyclarview: RecyclerView
    lateinit var newArrayList: ArrayList<Movies>
    lateinit var imageids: Array<Int>
    lateinit var descriptions: Array<String>
    lateinit var titles: Array<String>
    lateinit var rates: Array<String>
    lateinit var binding : ActivityBestTenBinding
    fun getmovie(){
        for (i in imageids.indices){
            val movies = Movies(imageids[i],titles[i],descriptions[i],rates[i])
            newArrayList.add(movies)

        }
        newRecyclarview.adapter = MyAdapter(newArrayList)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        binding =ActivityBestTenBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        setSupportActionBar(binding.toolbar)
        val username = intent.getStringExtra("US")
        val userTextView = binding.welcomeUser
        userTextView.text="Welcome: $username"
        imageids = arrayOf(
            R.drawable.a,
            R.drawable.b,
            R.drawable.c,
            R.drawable.d,
            R.drawable.e,
            R.drawable.f,
            R.drawable.g,
            R.drawable.hjpg,
            R.drawable.i,
            R.drawable.j
        )
        titles= arrayOf(
            "Challengers",
            "Anora",
            "Wicked",
            "Dune: Part Two",
            "Conclave",
            "Girls Will Be Girls",
            "The Substance",
            "All We Imagine as Light",
            "Stopmotion",
            "The Promised Land"
        )







        descriptions = arrayOf(
            "Paul Atreides and the Fremen battle the Harkonnens for control of Arrakis.",
            "Explores the origins of Furiosa in the Mad Max universe, featuring high-octane action.",
            "A stuntman’s return to the film industry turns into a thrilling adventure.",
            "A quirky, romantic take on the life of an undercover agent posing as a hitman.",
            "A crime drama about arms dealing and the choices it demands.",
            "A sequel that introduces new emotions as Riley navigates her teenage years.",
            "A supernatural horror set during a live 1970s talk show.",
            "A former football star rebuilds his life by coaching a misfit pee-wee team.",
            "A family’s survival instincts are tested in a suspenseful road trip horror.",
            "A historical drama about a soldier’s quest for redemption."
        )
        rates = arrayOf("9.2", "8.9", "8.2", "8.5", "7.8", "8.7", "7.6", "7.2", "7.4", "8.3")

        newRecyclarview = findViewById(R.id.recyclarViewM)
        newRecyclarview.layoutManager = LinearLayoutManager(this)
        newArrayList = arrayListOf<Movies>()
        getmovie()

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return super.onOptionsItemSelected(item)
    }
}