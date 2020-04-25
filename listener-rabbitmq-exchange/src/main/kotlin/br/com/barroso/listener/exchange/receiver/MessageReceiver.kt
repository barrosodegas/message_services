package br.com.barroso.listener.exchange.receiver

import mu.KotlinLogging
import org.springframework.stereotype.Component

@Component
class MessageReceiver {

    private val log = KotlinLogging.logger { }

    fun receiveMessage(message: String) {
        log.info("Message received: $message")
    }

}
