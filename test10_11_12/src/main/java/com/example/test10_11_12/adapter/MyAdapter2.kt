package com.example.test10_11_12.adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.test10_11_12.databinding.Item2342Binding

// Recycle2Activity -> 연결할 어댑터
// 같은 내용이면, 기존의 만들었던 어댑터를 재사용 가능
// 주석은 MyAdapter를 참고, 지금 전체 구성방식

//뷰홀더 클래스
class MyViewHolder2(val binding: Item2342Binding): RecyclerView.ViewHolder(binding.root)

class MyAdapter2(val datas: MutableList<String>): RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    // 목록의 요소를 자동으로 갯수를 파악해서 출력 해주는 역할
    override fun getItemCount(): Int {
        Log.d("kkang", "init datas size: ${datas.size}")
        return datas.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder =
        MyViewHolder2(Item2342Binding.inflate(LayoutInflater.from(parent.context), parent, false))

    // 데이터와 뷰를 연결하는 역할
    // 데이터가 변경이 될때마다, 여기 함수가 자동으로 호출
    // 받아온 데이터를 해당 뷰에 연결해서 보여주는 역할
    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        Log.d("kkang", "onBindViewHolder : $position")
        val binding = (holder as MyViewHolder2).binding
        //뷰에 데이터 출력
        binding.itemData.text = datas[position]

        binding.itemRoot.setOnClickListener {

            Log.d("kkang", "item root click : $position")
        }
        notifyDataSetChanged()
    }
}