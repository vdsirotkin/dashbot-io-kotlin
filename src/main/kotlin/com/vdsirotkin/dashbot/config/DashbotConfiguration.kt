package com.vdsirotkin.dashbot.config

import com.vdsirotkin.dashbot.client.TrackClient
import io.netty.channel.ChannelOption.CONNECT_TIMEOUT_MILLIS
import io.netty.handler.timeout.ReadTimeoutHandler
import org.springframework.boot.context.properties.EnableConfigurationProperties
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.http.client.reactive.ReactorClientHttpConnector
import org.springframework.web.reactive.function.client.WebClient
import reactor.netty.http.client.HttpClient

@Configuration
@EnableConfigurationProperties(DashbotProperties::class)
class DashbotConfiguration(
    private val props: DashbotProperties
) {

    @Bean
    fun dashbotWebClient(): WebClient {
        return WebClient.builder()
            .baseUrl(props.baseUrl)
            .clientConnector(ReactorClientHttpConnector(
                HttpClient.create().tcpConfiguration { client ->
                    client
                        .option(CONNECT_TIMEOUT_MILLIS, props.connectionTimeout.toMillis().toInt())
                        .doOnConnected { conn -> conn.addHandlerFirst(ReadTimeoutHandler(props.readTimeout.seconds.toInt())) }
                }
            ))
            .build()
    }

    @Bean
    fun trackClient(): TrackClient {
        return TrackClient(dashbotWebClient(), props.apiKey)
    }

}