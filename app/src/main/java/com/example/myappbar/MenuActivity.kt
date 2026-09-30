package com.example.myappbar

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.myappbar.databinding.ActivityMenuBinding
import com.google.android.material.snackbar.Snackbar

class MenuActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMenuBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMenuBinding.inflate(layoutInflater)
        setContentView(binding.root)

        with(binding) {
            searchView.setupWithSearchBar(searchBar)
            searchView.editText.setOnEditorActionListener { _, _, _ ->
                searchBar.setText(searchView.text)
                searchView.hide()
                Snackbar.make(searchView, searchView.text, Snackbar.LENGTH_SHORT).show()
                false
            }
            searchBar.inflateMenu(R.menu.option_menu)
        }
    }
}