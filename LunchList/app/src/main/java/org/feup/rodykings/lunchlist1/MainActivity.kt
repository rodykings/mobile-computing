package org.feup.rodykings.lunchlist1

import android.app.Activity
import android.content.Context
import android.os.Bundle
import android.os.Parcel
import android.os.Parcelable
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.InputMethodManager
import android.widget.*
import android.widget.AdapterView.OnItemClickListener
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {

    val rests = ArrayList<Restaurant>()

    inner class RestaurantAdapter(context: Context, resource: Int, objects: ArrayList<Restaurant>): ArrayAdapter<Restaurant>(context, resource, objects){

        override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
            val row = convertView ?: layoutInflater.inflate(R.layout.list_row, parent, false)
            val r = rests[position]
            row.findViewById<TextView>(R.id.restaurantName).text = r.name
            row.findViewById<TextView>(R.id.restaurantAddress).text = r.address
            val symbol = row.findViewById<ImageView>(R.id.symbol)
            when (r.type) {
                "sit" -> symbol.setImageResource(R.drawable.ball_red)
                "take" -> symbol.setImageResource(R.drawable.ball_yellow)
                "delivery" -> symbol.setImageResource(R.drawable.ball_green)
            }
            return row
        }
    }

    private fun clearKeyboard(act: Activity) {
        val view = act.findViewById<View>(android.R.id.content)
        val imm = getSystemService(INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(view.windowToken, 0)
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar?.setIcon(R.drawable.rest_icon)
        supportActionBar?.setDisplayShowHomeEnabled(true)
        setContentView(R.layout.activity_main)

        val saveButton = findViewById<Button>(R.id.saveButton)
        val editName = findViewById<EditText>(R.id.editName)
        val editAddress = findViewById<EditText>(R.id.editAddress)
        val listView = findViewById<ListView>(R.id.listView)
        val radioType = findViewById<RadioGroup>(R.id.radioGroup)



        val adapter by lazy { RestaurantAdapter(this, android.R.layout.simple_list_item_1, rests) }


        saveButton.setOnClickListener{

            var type:String = ""
            when(radioType.checkedRadioButtonId){
                R.id.take -> type = "take"
                R.id.delivery -> type = "delivery"
                R.id.sit -> type = "sit"
            }

            val restaurant = Restaurant(editName.text.toString(), editAddress.text.toString(), type)
            adapter.add(restaurant)
            listView.adapter = adapter
            editName.setText("")
            editAddress.setText("")
            radioType.clearCheck()
            clearKeyboard(this)

        }

        listView.onItemClickListener = OnItemClickListener { parent, view, position, id ->
            val selectedRestaurant = rests[id.toInt()]
            editName.setText(selectedRestaurant.name)
            editAddress.setText(selectedRestaurant.address)
        }
    }
}



