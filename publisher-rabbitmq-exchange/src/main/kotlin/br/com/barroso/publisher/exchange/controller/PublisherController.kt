package br.com.barroso.publisher.exchange.controller

import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import br.com.barroso.publisher.exchange.service.PublisherService
import org.springframework.web.bind.annotation.RestController

@RequestMapping("pub")
@RestController
class PublisherController(val publisherService: PublisherService) {

    @PostMapping
    fun sendMessage(@RequestBody message: String): String {

        publisherService.sendMessage(message)
        return "Message: ${message} sended!"
    }

}
