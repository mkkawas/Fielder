package com.example.fielder.login.homepage

import android.os.Environment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.net.toUri
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.fielder.R
import com.example.fielder.login.models.Fields
import kotlinx.android.synthetic.main.suggestions_item.view.*
import java.io.File


class SuggestionAdapter(val items: List<Fields>) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    private val TAG: String = "AppDebug"
   // private var items: List<Fields> = ArrayList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return ViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.suggestions_item, parent, false)
        )
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when(holder) {

            is ViewHolder -> {
                holder.bind(items[position])
            }

        }
    }

    override fun getItemCount() =items.size

    class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){


        fun bind(item: Fields){


         //   val file = File("C:\\xampp\\htdocs\\Fielder\\pics\\win.PNG")



            val requestOptions = RequestOptions()
                .placeholder(R.drawable.ic_launcher_background)
                .error(R.drawable.ic_launcher_background)

            Glide.with(itemView.context)
                .load(item.image)
                .into(itemView.txt_field_img)
            itemView.txt_name.text = item.name
            itemView.txt_contact.text = "Contact: "+item.contact
            itemView.txt_size.text = item.size
            itemView.txt_sport.text = item.sport

        }

    }
}
