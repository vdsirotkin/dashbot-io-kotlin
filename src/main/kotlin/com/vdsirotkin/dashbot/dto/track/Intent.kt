package com.vdsirotkin.dashbot.dto.track

data class Intent(
    val name: String,
    val inputs: List<Input>?,
    val confidence: Float?
)
