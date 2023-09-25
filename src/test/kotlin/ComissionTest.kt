import org.junit.Test

import org.junit.Assert.*

class ComissionTest {

    @Test
    fun testMastercardComission() {
        assertEquals(0.0, comission(75000, TYPE_MASTERCARD), 0.001)
        assertEquals(500.0, comission(80000, TYPE_MASTERCARD), 0.001)
        assertEquals(ERROR_LIMIT_EXCEEDED, comission(150000, TYPE_MASTERCARD, 500000), 0.001)
    }

    @Test
    fun testMaestroComission() {
        assertEquals(0.0, comission(75000, TYPE_MAESTRO), 0.001)
        assertEquals(ERROR_LIMIT_EXCEEDED, comission(150000, TYPE_MAESTRO, 500000), 0.001)
        assertEquals(500.0, comission(80000, TYPE_MAESTRO), 0.001)
    }

    @Test
    fun testVisaComission() {
        assertEquals(37.5, comission(5000, TYPE_VISA), 0.001)
        assertEquals(35.0, comission(4000, TYPE_VISA), 0.001)
        assertEquals(ERROR_LIMIT_EXCEEDED, comission(150000, TYPE_VISA, 500000), 0.001)
    }

    @Test
    fun testMirComission() {
        assertEquals(37.5, comission(5000, TYPE_MIR), 0.001)
        assertEquals(35.0, comission(4000, TYPE_MIR), 0.001)
        assertEquals(ERROR_LIMIT_EXCEEDED, comission(150000, TYPE_MIR, 500000), 0.001)
    }

    @Test
    fun testVKPayComission() {
        assertEquals(0.0, comission(15000, TYPE_VKPAY), 0.001)
        assertEquals(ERROR_LIMIT_EXCEEDED, comission(15000, TYPE_VKPAY, 40000), 0.001)
    }

    @Test
    fun testWrongType() {
        assertEquals(ERROR_WRONG_TYPE, comission(5000, "UnknownType"), 0.001)
    }
}