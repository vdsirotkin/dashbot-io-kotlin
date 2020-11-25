package com.vdsirotkin.dashbot.dto.track

data class Postback(
    val buttonClick: ButtonClick
) {
    data class ButtonClick(
        val buttonId: String
    )

    companion object {
        @JvmStatic
        fun create(buttonId: String) = Postback(ButtonClick(buttonId))
    }

}
