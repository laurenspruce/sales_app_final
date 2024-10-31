package example.org;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class CustomPromptTest {

    //Going to be using mocking to simulate user input through the Scanner.

    private Scanner mockScanner;
    private CustomPrompt cut;

    @BeforeEach
    public void setUp() {
        mockScanner = Mockito.mock(Scanner.class);
        cut = new CustomPrompt(mockScanner);
    }

    @Test
    public void get_string_should_return_input_string(){

        //Arrange
        String expectedInput = "Hello there";
        when(mockScanner.nextLine()).thenReturn(expectedInput);

        //Act
        String actualInput = cut.getString("Enter a message: ");

        //Assert
        assertEquals(expectedInput, actualInput);
        verify(mockScanner).nextLine(); //Ensuring nextLine was called

    }
}
