package br.com.barroso.listener.exchange.config

/**
 * Basically they are the elements of the AMQP protocol architecture that receive the messages and forward them to queues
 * according to the bindings and the declared type of the exchange.
 */
class Exchanges {

    // Constants variables
    companion object {
        const val EXCHANGE_ONE: String = "EXCHANGE_ONE"
    }

}
