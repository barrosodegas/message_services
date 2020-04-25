package br.com.barroso.publisher.exchange.config

/**
 * The routing key is a message attribute the exchange looks at when deciding how to route the message to queues (depending on exchange type).
 */
class RouteKeys {

    companion object {
        const val ROUTE_KEY_ONE: String = "ROUTE_KEY_ONE."
        const val ROUTE_KEY_ONE_TEST: String = "${ROUTE_KEY_ONE}TEST"
    }

}