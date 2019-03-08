package sampleprogram

import kotlinx.html.ButtonType
import kotlinx.html.dom.append
import kotlinx.html.js.button
import kotlinx.html.js.div
import kotlinx.html.js.onClickFunction
import kotlinx.html.js.p
import kotlinx.html.span
import org.w3c.dom.events.Event
import org.w3c.xhr.XMLHttpRequest
import kotlin.browser.document
import kotlin.dom.clear

fun samplePageInit() {

    // create header
    document.getElementById("header")?.append {
        button(classes = "btn btn-primary", type = ButtonType.button) {
            +"Home"
        }
        button(classes = "btn btn-secondary", type = ButtonType.button) {
            +"Screen1"
        }
        button(classes = "btn btn-secondary", type = ButtonType.button) {
            +"About"
        }
    }

    document.getElementById("content")?.append {
        div("card-body") {
            p("card-text") {
                +"""Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut
                    labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco
                    laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit
                    in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat
                    cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum"""
            }
            p("card-text") {
                +"This is example of a fullstack kotlin application."
            }
            button(classes = "btn btn-primary active", type = ButtonType.button) {
                +"Get list of users"
                onClickFunction = {
                    ajaxget("/sample") {
                        val users = JSON.parse<Array<User>>(it)
                        val userlist = document.getElementById("userlist") ?: return@ajaxget {}
                        userlist.clear()
                        userlist.append {
                            users.forEach { u ->
                                div("alert alert-secondary") {
                                    +u.name
                                    span { +" " }
                                    span("badge badge-primary") { +"${u.age}" }
                                }
                            }
                        }
                    }
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
}