import kotlinx.html.dom.append
import kotlinx.html.js.p
import org.w3c.dom.HTMLElement
import org.w3c.dom.HTMLTextAreaElement
import org.w3c.dom.events.Event
import org.w3c.xhr.XMLHttpRequest
import kotlin.browser.document
import kotlin.browser.window
import kotlin.js.Json

fun main() {
    window.onload = {
        ajaxget("/sample") {
            println(it)
            val users = JSON.parse<Array<Json>>(it)

            val textarea = document.getElementById("textarea_id") as HTMLTextAreaElement
            textarea.value = ""
            users.forEach {
                val message = it["message"]
                textarea.value += "$message\n"
            }
            val root = document.getElementById("root") as HTMLElement

            root.append {
                p {
                    +"Sample status: Ok"
                }
            }
        }

    }
}

fun ajaxget(url: String, onloadend: (String) -> dynamic) {
    val req = XMLHttpRequest()
    req.onloadend = fun(event: Event) { onloadend(req.responseText) }
    req.open("GET", url, true)
    req.send()

    println("Done")
}