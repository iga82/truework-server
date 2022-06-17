package com.brodie.kotlin.trueworkserver

import com.github.kittinunf.fuel.httpGet
import com.github.kittinunf.result.Result
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class HtmlController {
    @GetMapping
    fun index(): String {
        val (request, response, result) = "https://catfact.ninja/fact"
            .httpGet()
            .responseString()

        val returnVal = when(result) {
            is Result.Failure -> {
                result.error.toString()
            }
            is Result.Success -> {
               result.get()
            }
        }

        return returnVal
    }
}

//package com.example.restservice;
//
//import java.util.concurrent.atomic.AtomicLong;
//
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.RestController;
//
//@RestController
//public class GreetingController {
//
//    private static final String template = "Hello, %s!";
//    private final AtomicLong counter = new AtomicLong();
//
//    @GetMapping("/greeting")
//    public Greeting greeting(@RequestParam(value = "name", defaultValue = "World") String name) {
//        return new Greeting(counter.incrementAndGet(), String.format(template, name));
//    }
//}