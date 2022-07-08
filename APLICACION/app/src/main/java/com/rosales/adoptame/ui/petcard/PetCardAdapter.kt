package com.rosales.adoptame.ui.petcard

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.rosales.adoptame.R
import com.rosales.adoptame.data.model.Pet
import com.rosales.adoptame.databinding.ItemPetcardBinding

class PetCardAdapter : RecyclerView.Adapter<PetCardAdapter.PetViewHolder>() {

    inner class PetViewHolder(private val binding: ItemPetcardBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(pet: Pet) {
            binding.pet = pet
            binding.executePendingBindings()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        PetViewHolder(
            DataBindingUtil.inflate(
                LayoutInflater.from(parent.context),
                R.layout.item_petcard,
                parent,
                false
            )
        )

    override fun onBindViewHolder(holder: PetViewHolder, position: Int) {
        pets?.let {
            holder.bind(it[position])
        }

        holder.itemView.setOnClickListener(object : View.OnClickListener{

            override fun onClick(v: View?) {
                val activity = v!!.context as AppCompatActivity
                val petProfile = PetProfileFragment( pets !! [position])
                activity.supportFragmentManager.beginTransaction().replace(R.id.nav_host_fragment_real,petProfile).addToBackStack(null).commit()
            }
        })

    }




    override fun getItemCount() = pets?.size ?: 0

    private var pets: List<Pet>? = null

    fun setData(data: List<Pet>) {
        pets = data
        println(pets)
        notifyDataSetChanged()

    }

}