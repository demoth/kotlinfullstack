package sampleprogram

import com.fasterxml.jackson.databind.ObjectMapper
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
open class SampleController {

    private val json = ObjectMapper()

    @GetMapping("/sample")
    fun getSample(): String {
        return json.writeValueAsString(arrayListOf(
                User("Alpha", 10),
                User("Omega", 20)
        ))
    }
}
