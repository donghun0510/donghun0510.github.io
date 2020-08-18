package com.acaroom.listview

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView

class MainListAdapter (val context: Context, val dogList: ArrayList<Dog>) : BaseAdapter() {
    val view: View = LayoutInflater.from(context).inflate(R.layout.main_lv_item, null)

    /* 위에서 생성된 view를 res-layout-main_lv_item.xml 파일의 각 View와 연결하는 과정이다. */
    val dogPhoto = view.findViewById<ImageView>(R.id.dogPhotoImg)
    val dogBreed = view.findViewById<TextView>(R.id.dogBreedTv)
    val dogAge = view.findViewById<TextView>(R.id.dogAgeTv)
    val dogGender = view.findViewById<TextView>(R.id.dogGenderTv)

    /* ArrayList<Dog>의 변수 dog의 이미지와 데이터를 ImageView와 TextView에 담는다. */
    val dog = dogList[position]
    val resourceId = context.resources.getIdentifier(dog.photo, "drawable", context.packageName)
    dogPhoto.setImageResource(resourceId)
    dogBreed.text = dog.breed
    dogAge.text = dog.age
    dogGender.text = dog.gender

    return view
    }

    fun getItem(position: Int): Any {
        return dogList[position]
    }

    fun getItemId(position: Int): Long {
        return 0
    }

    fun getCount(): Int {
        return dogList.size
    }
}