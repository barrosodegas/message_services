package br.com.barroso.listener.exchange.config

import br.com.barroso.listener.exchange.receiver.MessageReceiver
import org.springframework.amqp.core.Binding
import org.springframework.amqp.core.BindingBuilder
import org.springframework.amqp.core.Queue
import org.springframework.amqp.core.TopicExchange
import org.springframework.amqp.rabbit.connection.ConnectionFactory
import org.springframework.amqp.rabbit.listener.SimpleMessageListenerContainer
import org.springframework.amqp.rabbit.listener.adapter.MessageListenerAdapter
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class AmqpConfig {

    // Constants variables
    private companion object {
        const val DURABLE = true
        const val AUTO_DELETE = false
    }

    @Bean
    fun queue(): Queue {
        return Queue(Queues.QUEUE_ONE, DURABLE)
    }

    /**
     * This exchange forwards messages according to the route defined in the message and the pattern defined in the association of the queue to the exchange.
     */
    @Bean
    fun exchange(): TopicExchange {
        return TopicExchange(Exchanges.EXCHANGE_ONE, DURABLE, AUTO_DELETE)
    }

    /**
     * Links the queue to the exchange with the specified route.
     */
    @Bean
    fun binding(queue: Queue, exchange: TopicExchange): Binding {
        return BindingBuilder.bind(queue).to(exchange).with(RouteKeys.ROUTE_KEY_ONE)
    }

    /**
     * Defines the listener of the linked queue to exchange for all routes that are below: "ROUTE_KEY_ONE." and that will process the messages.
     * receiveMessage: is the method to be triggered on the object that processes the received messages.
     */
    @Bean
    fun listenerAdapter(receiver: MessageReceiver): MessageListenerAdapter {
        return MessageListenerAdapter(receiver, "receiveMessage")
    }

    /**
     * Defines the connection with the messaging service, which queue will be linked to the listener and who will process the message.
     */
    @Bean
    fun container(connectionFactory: ConnectionFactory, listenerAdapter: MessageListenerAdapter): SimpleMessageListenerContainer {

        val container = SimpleMessageListenerContainer(connectionFactory)
        container.setQueueNames(Queues.QUEUE_ONE)
        container.setMessageListener(listenerAdapter)

        return container
    }

}
