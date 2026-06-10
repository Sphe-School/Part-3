import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class MessageTest {

    @Test
    public void testRecipientValidation() {

        Message msg =
            new Message("+27821234567",
            "Hello");

        assertEquals(
            "Cell phone number successfully captured.",
            msg.checkRecipientCell()
        );
    }

    @Test
    public void testInvalidRecipient() {

        Message msg =
            new Message("12345",
            "Hello");

        assertTrue(
            msg.checkRecipientCell()
            .contains("Invalid")
        );
    }

    @Test
    public void testHashGeneration() {

        Message msg =
            new Message("+27821234567",
            "Testing");

        assertNotNull(
            msg.getMessageHashValue()
        );
    }
}
