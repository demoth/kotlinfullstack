package sampleprogram

import com.fasterxml.jackson.databind.ObjectMapper
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
open class SampleController {

    private val json = ObjectMapper()

    @GetMapping("/getUsers")
    fun getUsers(): String {
//        return json.writeValueAsString(arrayListOf("Daniil", "Julia", "Timosha", "Katyusha"))
        return json.writeValueAsString(arrayListOf(
                mapOf("message" to "Daniil"),
                mapOf("message" to "Julia")
        ))
    }
}
