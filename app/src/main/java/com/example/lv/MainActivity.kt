package com.example.lv

import android.content.Intent
import android.widget.ListView
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val items = listOf(
            ListItem("Nirvana", "Action1"),
            ListItem("GONE.Fludd", "Action2"),
            ListItem("Кишлак", "Action3")
        )
        val listView: ListView = findViewById(R.id.lvMain)

        val adapter = AdapterList(this, items)
        listView.adapter = adapter

        listView.setOnItemClickListener { parent, view, position, id ->
            val selectedItem = items[position]
            val intent = Intent(this@MainActivity, MainActivity2::class.java)
            intent.putExtra("Action", selectedItem.action)
            startActivity(intent)
        }
    }
}