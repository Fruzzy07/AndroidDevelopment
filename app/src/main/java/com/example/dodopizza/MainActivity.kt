package com.example.dodopizza

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.SearchView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    private lateinit var itemsList: RecyclerView
    private lateinit var adapter: ItemsAdapter
    private lateinit var items: ArrayList<Item>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        itemsList = findViewById(R.id.itemsList)

        items = arrayListOf(
            Item(1, "bavaryan", "Баварская", "Острые колбаски чоризо, маринованные огурчики, красный лук, томаты, горчичный соус, моцарелла, фирменный томатный соус", 3800),
            Item(2, "pepperoni_heart", "Пепперони-сердце", "Пикантная пепперони из цыпленка, моцарелла, томатный соус", 3400),
            Item(3, "naruto", "Наруто Пицца", "Куриные кусочки, моцарелла, ананасы, фирменный соус альфредо, соус терияки", 3800),
            Item(4, "kebab", "Вау! Кебаб", "Кебаб из говядины, соус ранч, моцарелла, сладкий перец, томаты, красный лук, фирменный томатный соус", 4300),
            Item(5, "mushroom", "Пепперони с грибами", "Пикантная пепперони из цыпленка, моцарелла, шампиньоны, фирменный соус альфредо", 3000),
            Item(6, "ham_cucumber", "Ветчина и огурчики", "Соус ранч, ветчина из цыпленка, моцарелла, маринованные огурчики, красный лук", 3000),
            Item(7, "zhulen", "Пицца Жюльен", "Цыпленок, шампиньоны, соус сливочный с грибами, красный лук, чеснок, моцарелла, смесь сыров чеддер и пармезан, фирменный соус альфредо", 3800),
            Item(8, "cheese", "Сырная", "Моцарелла, сыры чеддер и пармезан, соус альфредо", 2900),
        )
        adapter = ItemsAdapter(items, this)
        itemsList.layoutManager = LinearLayoutManager(this)
        itemsList.adapter = adapter

        val searchView: SearchView = findViewById(R.id.searchView)
        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                return false
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                filterItems(newText)
                return true
            }
        })
    }

    private fun filterItems(query: String?) {
        val filteredItems = ArrayList<Item>()

        if (query.isNullOrEmpty()) {
            filteredItems.addAll(items)
        } else {
            val searchText = query.toLowerCase().trim()
            for (item in items) {
                if (item.title.toLowerCase().contains(searchText) || item.description.toLowerCase().contains(searchText)) {
                    filteredItems.add(item)
                }
            }
        }

        adapter.items = filteredItems
        adapter.notifyDataSetChanged()
    }
}