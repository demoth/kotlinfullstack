import org.w3c.dom.HTMLTextAreaElement
import org.w3c.dom.events.Event
import org.w3c.xhr.XMLHttpRequest
import kotlin.browser.document
import kotlin.browser.window
import kotlin.js.Json

fun main() {
    window.onload = {
        val url = "/getUsers"
        val req = XMLHttpRequest()
        req.onloadend = fun(event: Event) {
            val text = req.responseText
            println(text)
            val users = JSON.parse<Array<Json>>(text)
            val textarea = document.getElementById("textarea_id") as HTMLTextAreaElement
            textarea.value = ""
            users.forEach {
                val message = it["message"]
                textarea.value += "$message\n"
            }
        }
        req.open("GET", url, true)
        req.send()

        println("Done")
    }
}