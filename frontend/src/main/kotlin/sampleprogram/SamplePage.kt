package sampleprogram

import kotlinx.html.dom.append
import kotlinx.html.js.p
import org.w3c.dom.HTMLElement
import org.w3c.dom.HTMLTextAreaElement
import org.w3c.dom.events.Event
import org.w3c.xhr.XMLHttpRequest
import kotlin.browser.document

fun samplePageInit() {
    ajaxget("/sample") {
        println(it)
        val users = JSON.parse<Array<User>>(it)

        val textarea = document.getElementById("textarea_id") as HTMLTextAreaElement
        textarea.value = ""
        users.forEach { u ->
            textarea.value += "Name: ${u.name}, Age: ${u.age}\n"
        }
        val root = document.getElementById("root") as HTMLElement

        root.append {
            p {
                +"Sample status: Ok"
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