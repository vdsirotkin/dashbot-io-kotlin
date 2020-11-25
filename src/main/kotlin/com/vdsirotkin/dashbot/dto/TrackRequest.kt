package com.vdsirotkin.dashbot.dto

import com.fasterxml.jackson.annotation.JsonInclude
import com.vdsirotkin.dashbot.dto.track.Button
import com.vdsirotkin.dashbot.dto.track.Image
import com.vdsirotkin.dashbot.dto.track.Intent
import com.vdsirotkin.dashbot.dto.track.Postback

@JsonInclude(JsonInclude.Include.NON_NULL)
data class TrackRequest(
    val text: String,
    val userId: String,
    val intent: Intent?,
    val images: List<Image>?,
    val buttons: List<Button>?,
    val postback: Postback?,
    val platformJson: Map<String, Any>?,
    val platformUserJson: Map<String, Any>?,
    val sessionId: String?
)