package app.motsu.hiromoto.la_cardgame

import android.media.Image
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.ImageButton
import kotlinx.android.synthetic.main.activity_main.*
import kotlin.random.Random

class MainActivity : AppCompatActivity() {
    var rank = listOf<Int>(0,0,1,1,2,2,3,3,4,4,5,5).shuffled()
    val cardPicts = listOf<Int>(
        R.drawable.cow,
        R.drawable.dog,
        R.drawable.fox,
        R.drawable.fish,
        R.drawable.squid,
        R.drawable.zebra
    )
    val questionPict = R.drawable.question
    // imageButtonsにリストを再代入しなそうならvalでよさそう
    val imageButtons = mutableListOf<ImageButton>()
    // val hoge: Array<Boolean> = Array(5) { false }
    // こんな書き方もできる
    // なぬ！そっちにします〇　もつ
    var checkList: Array<Boolean> = Array(12){false}
    var turncount: Int = 0
    var beforeCard = -1
    var pairCount = 0
    var missCount = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        imageButtons.add(imageButton)
        imageButtons.add(imageButton2)
        imageButtons.add(imageButton3)
        imageButtons.add(imageButton4)
        imageButtons.add(imageButton5)
        imageButtons.add(imageButton6)
        imageButtons.add(imageButton7)
        imageButtons.add(imageButton8)
        imageButtons.add(imageButton9)
        imageButtons.add(imageButton10)
        imageButtons.add(imageButton11)
        imageButtons.add(imageButton12)

    }

    fun open0(view:View){openCard(0)}
    fun open1(view:View){openCard(1)}
    fun open2(view:View){openCard(2)}
    fun open3(view:View){openCard(3)}
    fun open4(view:View){openCard(4)}
    fun open5(view:View){openCard(5)}
    fun open6(view:View){openCard(6)}
    fun open7(view:View){openCard(7)}
    fun open8(view:View){openCard(8)}
    fun open9(view:View){openCard(9)}
    fun open10(view:View){openCard(10)}
    fun open11(view:View){openCard(11)}

    fun openCard(i:Int){
        val btn = imageButtons[i]
        // チェック済みならリターン
        if(!checkList.get(i)) {
            // チェック済みに
            checkList[i] = true
            // カードをめくる
            btn.setImageResource(cardPicts[rank[i]])

            // 偶数手なら1枚目のカード
            if (turncount % 2 == 0) {
                // 先カードに保存
                beforeCard = i

            } else { // 奇数手
                // 絵柄が同じ
                if (rank[beforeCard] == rank[i]) {
                    // ペアカウントを追加
                    pairText.text = (++pairCount).toString() + "ペアGET！"
                } else { // 絵柄が違う
                    missText.text = (++missCount).toString() + "ミス..."
                    missText.text = missText.text as String + pairText.text
                    // ボタンを元に戻す
                    btn.setImageResource(questionPict)
                    imageButtons[beforeCard].setImageResource(questionPict)
                    checkList[i] = false
                    checkList[beforeCard] = false

                    // 先ボタンを削除
                    beforeCard = -1
                }
            }
            // ターン数
            countText.text = (++turncount).toString() + "手目です"
        }
    }

}