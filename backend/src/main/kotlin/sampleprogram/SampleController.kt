package sampleprogram

import com.fasterxml.jackson.databind.ObjectMapper
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController
import kotlin.random.Random

@RestController
open class SampleController {
    private val r = Random(0)

    private val users = listOf(
            "Alyce Sprow",
            "Nathan Croslin",
            "Stacey Jessen",
            "Sherlyn Franson",
            "Maryjane Ponton",
            "Kirstin Remick",
            "Kiley Paskett",
            "Nickole Emert",
            "Lynwood Penton",
            "Tenisha Stratton",
            "Enrique Delorme",
            "Charolette Wuest",
            "Della Fishburn",
            "Marylou Leth",
            "Michele Prather",
            "Raquel Jen",
            "Catheryn Cooley",
            "Mitchel Gremillion",
            "Augustina Belli")


    private val json = ObjectMapper()

    @GetMapping("/sample")
    fun getSample(): String {
        return json.writeValueAsString(users.filter { r.nextBoolean() }.map { User(it, r.nextInt(18, 80)) })
    }
}
