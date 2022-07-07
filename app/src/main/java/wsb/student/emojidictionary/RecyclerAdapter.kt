package wsb.student.emojidictionary

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_main.view.*
import kotlinx.android.synthetic.main.recyclerview_item_row.view.*


class RecyclerAdapter(val emojis : ArrayList<String>) : RecyclerView.Adapter<RecyclerAdapter.TextHolder>() {

    class TextHolder(v: View) : RecyclerView.ViewHolder(v), View.OnClickListener{

        var view : View = v
        var emoji : String = ""

        init {
            v.setOnClickListener(this)
        }

        fun bindEmoji(emoji : String) {
            this.emoji = emoji
            view.itemTextView.text = emoji
        }

        override fun onClick(p0: View?) {
            val detailIntent = Intent(view.context, EmojiDetailActivity::class.java)
            detailIntent.putExtra("emoji", emoji)
            startActivity(view.context, detailIntent, null)
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TextHolder {
        return TextHolder(LayoutInflater.from(parent.context).inflate(R.layout.recyclerview_item_row, parent, false))
    }

    override fun onBindViewHolder(holder: RecyclerAdapter.TextHolder, position: Int) {
        val emoji = emojis[position]
        holder.bindEmoji(emoji)
    }

    override fun getItemCount(): Int {
        return emojis.count()
    }
}