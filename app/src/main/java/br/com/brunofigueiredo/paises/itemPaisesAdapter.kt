package br.com.brunofigueiredo.paises

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import br.com.brunofigueiredo.paises.databinding.ItemLayoutBinding
import br.com.brunofigueiredo.paises.model.ItemPaisesModel

class ItemPaisesAdapter : RecyclerView.Adapter<ItemPaisesAdapter.ItemPaisesHolder>() {
    val lista: MutableList<ItemPaisesModel> = mutableListOf();

    class ItemPaisesHolder(val paisesView: ItemLayoutBinding) : RecyclerView.ViewHolder(paisesView.root) {
        fun bind(item: ItemPaisesModel){
            paisesView.textPaises.text = item.pais;
            paisesView.textContinentes.text = item.continente
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemPaisesHolder {
        return ItemPaisesHolder(
       ItemLayoutBinding.inflate(LayoutInflater.from(parent.context),parent,false));
    }

    override fun onBindViewHolder(holder: ItemPaisesHolder, position: Int) {
      holder.bind(lista[position])
        holder.paisesView.btnDelete.setOnClickListener{
            removePais(lista[position])
        }
    }

    override fun getItemCount(): Int = lista.size;


    fun setLista(listaPaises: MutableList<ItemPaisesModel>){
        lista.clear();
        lista.addAll(listaPaises);
        notifyDataSetChanged();
    }

    fun removePais(removed: ItemPaisesModel){
        val removedIndex = lista.indexOf(removed);
        lista.remove(removed)
        notifyItemRemoved(removedIndex);
        notifyItemChanged(removedIndex,lista.size);
    }
}