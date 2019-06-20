package common

import kotlin.test.Test
import kotlin.test.assertEquals

class UserTest {
    @Test
    fun test() {
        assertEquals(
                "User(firstName=John, lastName=Doe)",
                User("John", "Doe").toString()
        )
    }
}