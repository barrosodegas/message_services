package br.com.barroso.publisher.exchange.service

import br.com.barroso.publisher.exchange.config.Exchanges
import br.com.barroso.publisher.exchange.config.RouteKeys
import mu.KotlinLogging
import org.springframework.amqp.rabbit.core.RabbitMessagingTemplate
import org.springframework.stereotype.Service

@Service
class PublisherService(val messagingTemplate: RabbitMessagingTemplate) {

    private val log = KotlinLogging.logger { }

    /**
     * Send any text message to a exchange with a specific route that can be consumed by listeners who are listening to this route.
     */
    fun sendMessage(message: String) {

        messagingTemplate.convertAndSend(Exchanges.EXCHANGE_ONE, RouteKeys.ROUTE_KEY_ONE_TEST, message)
        log.info("Message sended: $message")
    }

}
