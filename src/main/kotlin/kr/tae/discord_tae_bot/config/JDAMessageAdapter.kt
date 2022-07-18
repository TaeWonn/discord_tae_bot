package kr.tae.discord_tae_bot.config

import mu.KotlinLogging
import net.dv8tion.jda.api.events.message.MessageReceivedEvent
import net.dv8tion.jda.api.hooks.ListenerAdapter

class JDAMessageAdapter: ListenerAdapter() {

    private val log = KotlinLogging.logger { }

    override fun onMessageReceived(event: MessageReceivedEvent) {
        log.info { "::: ${event.author.name}: ${event.message.contentDisplay}" }
        super.onMessageReceived(event)
    }
}