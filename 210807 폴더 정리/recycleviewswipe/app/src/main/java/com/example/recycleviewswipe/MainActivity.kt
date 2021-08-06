package com.example.recycleviewswipe

import android.graphics.*
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextPaint
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.recycleviewswipe.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    // 다른 곳에서도 쓸 것이기 때문에 전역 변수로 바꿔줌
    private val rvAdapter = RecyclerViewAdapter()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        // binding.recyclerView = with 로 묶어줌. 받아온 객체를 반환해주기 때문에 binding으로 받아 recylerView로 반환
        with(binding) {
            with(recyclerView) {
                layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
                adapter = rvAdapter
                addItemDecoration(DividerItemDecoration(context, DividerItemDecoration.VERTICAL))
            }
        }

        //드래그 조작이 일어날 때 callback 함수를 발생시키는 class가 안드로이드 라이브러리에 준비돼 있음(TouchHelper)
        val itemTouchCallback = object : ItemTouchHelper.SimpleCallback(
            ItemTouchHelper.UP or ItemTouchHelper.DOWN, ItemTouchHelper.LEFT
        ) {
            override fun onMove(
                recyclerView: RecyclerView,
                viewHolder: RecyclerView.ViewHolder,
                target: RecyclerView.ViewHolder
            ): Boolean {
                // 드래그 관련 = 어댑터 포지션의 경우, 드래그할 때 뷰 홀더의 위치가 계속 변경됨
                val fromPos: Int = viewHolder.adapterPosition // 전체 리사이클러뷰의 위치를 참조해 가져오는 것이 adapterposition
                val toPos: Int = target.adapterPosition
                rvAdapter.swapData(fromPos, toPos)
                return true
            }

            override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
                rvAdapter.removeData(viewHolder.layoutPosition) // swipe 할 때 동작, 고정된 위치를 참조해 가져오는 것이 layoutpositon
            }

            // 드래그 할 때 오른쪽에 빨간색 뜨는 것
//            override fun onChildDraw(
//                c: Canvas,
//                recyclerView: RecyclerView,
//                viewHolder: RecyclerView.ViewHolder,
//                dX: Float,
//                dY: Float,
//                actionState: Int,
//                isCurrentlyActive: Boolean
//            ) {
//                val icon: Bitmap
//                if (actionState == ItemTouchHelper.ACTION_STATE_SWIPE) {
//                    val itemView = viewHolder.itemView
//                    val height = (itemView.bottom - itemView.top).toFloat()
//                    val width = height / 4
//                    val paint = Paint()
//                    if (dX < 0) {
//                        paint.color = Color.parseColor("#ff0000")
//                        val background = RectF(
//                            itemView.right.toFloat() + dX,
//                            itemView.top.toFloat(),
//                            itemView.right.toFloat(),
//                            itemView.bottom.toFloat()
//                        )
//                        c.drawRect(background, paint)
//
//                        icon = BitmapFactory.decodeResource(resources, R.drawable.ic_menu_delete)
//                        val iconDst = RectF(
//                            itemView.right.toFloat() - 3 * width,
//                            itemView.top.toFloat() + width,
//                            itemView.right.toFloat() - width,
//                            itemView.bottom.toFloat() - width
//                        )
//                        c.drawBitmap(icon, null, iconDst, null)
//
//                        val text = "Delete"
//                        val textPaint = TextPaint()
//                        textPaint.textSize = 50f
//                        textPaint.color = Color.WHITE
//                        val bounds = Rect()
//                        textPaint.getTextBounds(text, 0, text.length, bounds)
//                        val textHeight = bounds.height()
//                        val textWidth = textPaint.measureText(text)
//                        val textX = itemView.right - 3 * width - itemView.paddingRight - textWidth
//                        val textY = itemView.top + height / 2f + textHeight / 2f
//
//                        c.drawText(text, textX, textY, textPaint)
//                    }
//                }
//                super.onChildDraw(
//                    c,
//                    recyclerView,
//                    viewHolder,
//                    dX,
//                    dY,
//                    actionState,
//                    isCurrentlyActive
//                )
//            }
//
        }
        ItemTouchHelper(itemTouchCallback).attachToRecyclerView(binding.recyclerView)
    }
}