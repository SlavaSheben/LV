package com.example.lv

import android.os.Bundle
import android.widget.ListView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main2)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val intent = this.intent
        val action = intent.getStringExtra("Action")
        var items = listOf<ListItem>()
        when(action)
        {
            "Action1" ->{
                items = listOf(
                    ListItem("Smells like teen spirit", "m1"),
                    ListItem("Come As You Are","m2"),
                    ListItem("Rape Me", "m3"),
                    ListItem("Something In The Way", "m4"),
                    ListItem("Lithium","m5")
                )
            }
            "Action2" ->{
                items = listOf(
                    ListItem("Кровь и Пот", "m1"),
                    ListItem("Рапсодия Конца Света", "m2"),
                    ListItem("Интеллект", "m3"),
                    ListItem("UFO LUV", "m4"),
                    ListItem("Дело", "m5")
                )
            }
            "Action3" ->{
                items = listOf(
                    ListItem("Болею тобой", "m1"),
                    ListItem("Бесит Бумага", "m2"),
                    ListItem("Я У####аю в джак", "m3"),
                    ListItem("Самый лучший день", "m4"),
                    ListItem("Тень", "m5")
                )
            }
        }
        val listView: ListView = findViewById(R.id.lvPl)
        val adapter = AdapterList(this, items)
        listView.adapter = adapter
    }
}