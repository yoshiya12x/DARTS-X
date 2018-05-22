package yoppie.darts.Game

import android.view.View

class ManageImage {
    private var imageNumber = 0
    private var image1State = View.GONE
    private var image2State = View.GONE
    private var image3State = View.GONE

    fun changeImageNumber() {
        when (this.imageNumber) {
            1 -> this.imageNumber = 2
            2 -> this.imageNumber = 3
            3 -> this.imageNumber = 1
            else -> this.imageNumber = 1
        }
    }

    fun changeImageState(){
        when {
            this.imageNumber == 1 -> {
                this.image1State = View.VISIBLE
                this.image2State = View.GONE
                this.image3State = View.GONE
            }
            this.imageNumber == 2 -> {
                this.image1State = View.GONE
                this.image2State = View.VISIBLE
                this.image3State = View.GONE
            }
            this.imageNumber == 3 -> {
                this.image1State = View.GONE
                this.image2State = View.GONE
                this.image3State = View.VISIBLE
            }
        }
    }

    fun getShowImageNumber() = this.imageNumber

    fun getImage1State() = this.image1State

    fun getImage2State() = this.image2State

    fun getImage3State() = this.image3State
}
