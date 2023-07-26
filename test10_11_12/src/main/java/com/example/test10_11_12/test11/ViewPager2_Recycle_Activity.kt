package com.example.test10_11_12.test11

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.test10_11_12.databinding.ActivityViewPager2RecycleBinding
import com.example.test10_11_12.databinding.Item354Binding

class ViewPager2_Recycle_Activity : AppCompatActivity() {

    lateinit var binding: ActivityViewPager2RecycleBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_view_pager2_recycle)

        // 구조는 어댑터 따로 분리,
        binding= ActivityViewPager2RecycleBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val datas = mutableListOf<String>()
        for(i in 1..3){
            datas.add("Item $i")
        }

        // 액티비티에 뷰페이져 태크부분 가져와서 사용
        binding.viewpager.adapter= MyPagerAdapter(datas)
    }

    // 리사이클러 뷰 구성 방식, 1) 뷰홀더 2) 어댑터
    // res -> layout ->
    class MyPagerViewHolder(val binding: Item354Binding): RecyclerView.ViewHolder(binding.root)

    class MyPagerAdapter(val datas: MutableList<String>): RecyclerView.Adapter<RecyclerView.ViewHolder>(){
        override fun getItemCount(): Int{
            return datas.size
        }
        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder
                = MyPagerViewHolder(Item354Binding.inflate(LayoutInflater.from(parent.context), parent, false))

        override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
            val binding=(holder as MyPagerViewHolder).binding
            //뷰에 데이터 출력
            binding.itemPagerTextView.text=datas[position]
            when(position % 3){
                0 -> binding.itemPagerTextView.setBackgroundColor(Color.RED)
                1 -> binding.itemPagerTextView.setBackgroundColor(Color.BLUE)
                2 -> binding.itemPagerTextView.setBackgroundColor(Color.GREEN)
            }
        }
    }
}