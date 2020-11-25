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
    val intent: Intent? = null,
    val images: List<Image>? = null,
    val buttons: List<Button>? = null,
    val postback: Postback? = null,
    val platformJson: Map<String, Any>? = null,
    val platformUserJson: Map<String, Any>? = null,
    val sessionId: String? = null
)