package yoppie.darts.Entity

import android.annotation.SuppressLint
import com.github.gfx.android.orma.annotation.Column
import com.github.gfx.android.orma.annotation.PrimaryKey
import com.github.gfx.android.orma.annotation.Setter
import com.github.gfx.android.orma.annotation.Table
import java.io.Serializable
import java.text.SimpleDateFormat
import java.util.*

@Table
class DartScore : Serializable{
    @PrimaryKey(autoincrement = true)
    var id: Int = 0

    @Column
    var throwCount: Int = 0

    @Column
    var bullCount: Int = 0

    @Column
    var t20Count: Int = 0

    @Column
    var t19Count: Int = 0

    @Column
    var t18Count: Int = 0

    @Column
    var t17Count: Int = 0

    @Column
    var t16Count: Int = 0

    @Column
    var t15Count: Int = 0

    @Column
    var createdAt: String = ""

    @Setter
    fun countUp(scorePoint: Int){
        if (scorePoint == 11) this.t15Count++
        if (scorePoint == 42) this.t16Count++
        if (scorePoint == 51) this.t17Count++
        if (scorePoint == 44) this.t18Count++
        if (scorePoint == 76) this.t19Count++
        if (scorePoint == 38) this.t20Count++
        if (scorePoint == 32) this.bullCount++
        if (scorePoint == 54) this.bullCount++
    }

    @Setter
    fun throwCountUP(){
        this.throwCount++
    }

    @SuppressLint("SimpleDateFormat")
    @Setter
    fun putCreatedAt(date: Date){
        val dateFormat = SimpleDateFormat("yyyy/MM/dd HH:mm:ss")
        this.createdAt = dateFormat.format(date)
    }
}