package com.vdsirotkin.dashbot.client

import com.vdsirotkin.dashbot.dto.TrackRequest
import org.springframework.web.reactive.function.BodyExtractors
import org.springframework.web.reactive.function.BodyInserters
import org.springframework.web.reactive.function.client.ClientResponse
import org.springframework.web.reactive.function.client.WebClient
import org.springframework.web.reactive.function.client.awaitExchange

class TrackClient(
    private val webClient: WebClient,
    private val apiKey: String
) {

    private val REST_VERSION = "10.1.1-rest"
    private val PLATFORM = "universal"

    suspend fun incoming(trackRequest: TrackRequest): ClientResponse {
        return track(trackRequest, Direction.INCOMING)
    }

    suspend fun outgoing(trackRequest: TrackRequest): ClientResponse {
        return track(trackRequest, Direction.OUTGOING)
    }

    private suspend fun track(trackRequest: TrackRequest, direction: Direction): ClientResponse {
        return webClient
            .post()
            .uri {
                it.path("/track")
                    .queryParam("platform", PLATFORM)
                    .queryParam("v", REST_VERSION)
                    .queryParam("type", direction.type)
                    .queryParam("apiKey", apiKey)
                    .build()
            }
            .body(BodyInserters.fromValue(trackRequest))
            .awaitExchange()
    }

    private enum class Direction(val type: String) {
        INCOMING("incoming"),
        OUTGOING("outgoing"),
    }

}