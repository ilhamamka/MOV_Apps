//package com.bagicode.bwamov.home
package com.ilham.movapps.home

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
//import com.bagicode.bwamov.home.TiketAdapter
import com.ilham.movapps.home.TiketAdapter
import com.bumptech.glide.Glide
import com.ilham.movapps.R
import com.ilham.movapps.checkout.model.Checkout
import com.ilham.movapps.home.model.Film
import kotlinx.android.synthetic.main.activity_detail.*
import kotlinx.android.synthetic.main.activity_tiket.*
import kotlinx.android.synthetic.main.activity_detail.tv_genre as tv_genre1
import kotlinx.android.synthetic.main.activity_tiket.tv_rate as tv_rate1

class TiketActivity : AppCompatActivity() {

    private var dataList = ArrayList<Checkout>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tiket)

        val data = intent.getParcelableExtra<Film>("data")

        tv_title.text = data.judul
        tv_genre.text = data.genre
        tv_rate.text = data.rating

        Glide.with(this)
            .load(data.poster)
            .into(iv_poster_image)

        rc_checkout.layoutManager = LinearLayoutManager(this)
        dataList.add(Checkout("C1",""))
        dataList.add(Checkout("C2",""))

        rc_checkout.adapter = TiketAdapter(dataList) {
        }

    }
}
