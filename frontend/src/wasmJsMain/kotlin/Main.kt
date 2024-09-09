import common.User
import kotlinx.browser.document
import kotlinx.serialization.json.Json
import org.w3c.dom.EventSource

fun main() {
    EventSource("/api/users").onmessage = {
        val user = Json.decodeFromString<User>(it.data as String)
        val li = document.createElement("li").apply {
            innerHTML = "User: ${user.firstName} ${user.lastName}"
        }
        document.getElementById("users")!!.appendChild(li)
    }
}

