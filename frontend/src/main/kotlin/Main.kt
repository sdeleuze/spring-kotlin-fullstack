import common.User
import org.w3c.dom.EventSource

import kotlin.browser.document
import kotlin.browser.window

fun main() {
    window.onload = {
        EventSource("/api/users").onmessage = {
            val user = JSON.parse<User>(it.data as String)
            val li = document.createElement("li").apply {
                innerHTML = "User: ${user.firstName} ${user.lastName}"
            }
            document.getElementById("users")!!.appendChild(li)
        }
        Unit // Ugly workaround for https://youtrack.jetbrains.com/issue/KT-22635
    }
}

