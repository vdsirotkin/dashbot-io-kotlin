package com.vdsirotkin.dashbot.config

import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.boot.context.properties.ConstructorBinding
import org.springframework.boot.context.properties.bind.DefaultValue
import java.time.Duration

@ConstructorBinding
@ConfigurationProperties("dashbot")
data class DashbotProperties(
    @DefaultValue("https://tracker.dashbot.io")
    val baseUrl: String,
    val apiKey: String,
    @DefaultValue("30s")
    val connectionTimeout: Duration,
    @DefaultValue("30s")
    val readTimeout: Duration
)