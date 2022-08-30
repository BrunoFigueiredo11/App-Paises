package br.com.brunofigueiredo.paises

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import br.com.brunofigueiredo.paises.databinding.ActivityMainBinding
import br.com.brunofigueiredo.paises.model.ItemPaisesModel

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding;
    val lAdapter = ItemPaisesAdapter()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        binding = ActivityMainBinding.inflate(layoutInflater);
        setContentView(binding.root);

        setupRecycler()
    }

    private fun setupRecycler() {
        binding.listaRecicavelRv.layoutManager = StaggeredGridLayoutManager(2 ,StaggeredGridLayoutManager.VERTICAL)
        val l = mutableListOf<ItemPaisesModel>();
        l.add(ItemPaisesModel("Brasil", "América do Sul"));
        l.add(ItemPaisesModel("EUA", "América"));
        l.add(ItemPaisesModel("Africa", "América do Sul"));
        lAdapter.setLista(l);
        binding.listaRecicavelRv.adapter = lAdapter;
    }
}