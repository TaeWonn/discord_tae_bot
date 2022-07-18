package kr.tae.discord_tae_bot.config

import net.dv8tion.jda.api.JDA
import net.dv8tion.jda.api.JDABuilder
import net.dv8tion.jda.api.OnlineStatus
import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class JDAConfig (
    @Value("\${discord.token}")
    private val token: String
) {

    @Bean
    fun jda(): JDA {
        val jda = JDABuilder
            .createDefault(token)
            .build()

        jda.presence.setStatus(OnlineStatus.ONLINE)
        jda.addEventListener(JDAMessageAdapter())

        jda.awaitReady()
        return jda
    }
}