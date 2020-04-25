package br.com.barroso.listener.exchange.config

/**
 * The routing key is a message attribute the exchange looks at when deciding how to route the message to queues (depending on exchange type).
 */
class RouteKeys {

    // Constants variables
    companion object {
        const val ROUTE_KEY_ONE: String = "ROUTE_KEY_ONE.#"
    }

}
