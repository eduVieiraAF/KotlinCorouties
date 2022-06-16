import kotlinx.coroutines.runBlocking
import org.junit.Assert
import org.junit.Test

class SimpleTest {

    @Test
    fun myTest() = runBlocking {// runBlocking is best used for testing
        mySuspendingFunction()
        Assert.assertEquals(10,5 + 5)
    }
}