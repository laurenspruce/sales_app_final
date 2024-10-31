package example.org;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

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
        String actualValue = cut.getString("Enter a message: ");

        //Assert
        assertEquals(expectedInput, actualValue);
        verify(mockScanner).nextLine(); //Ensuring nextLine was called

    }

    @Test
    public void get_double_should_return_parsed_double(){

        //Arrange
        String expectedInput = "3.14"; //Use the correct input value
        when(mockScanner.nextLine()).thenReturn(expectedInput);

        //Act
        double actualValue = cut.getDouble("Enter a double: ");

        //Assert
        assertEquals(3.14, actualValue);
        verify(mockScanner).nextLine();
    }

    @Test
    public void get_double_should_handle_invalid_input() {

        //Arrange
        when(mockScanner.nextLine()).thenReturn("Not a number", "2.5");

        //Act
        double actualValue = cut.getDouble("Enter a double: ");

        //Assert
        assertEquals(2.5, actualValue);
        verify(mockScanner, times(2)).nextLine(); //Ensuring the next line has been called twice
    }




}
