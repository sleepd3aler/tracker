package ru.tracker.input;

import java.util.List;
import org.junit.jupiter.api.Test;
import ru.tracker.output.MockOutput;
import ru.tracker.output.Output;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class ValidateInputTest {

   @Test
    void whenInvalidInput() {
       Output output = new MockOutput();
       Input in = new MockInput(
               List.of("One", "1")
       );
       ValidateInput input = new ValidateInput(output, in);
       int selected = input.askInt("Enter menu:");
       assertThat(selected).isEqualTo(1);
   }

    @Test
    void whenValidInput() {
        Output output = new MockOutput();
        Input in = new MockInput(
                List.of("1")
        );
        ValidateInput input = new ValidateInput(output, in);
        int selected = input.askInt("Enter menu:");
        assertThat(selected).isEqualTo(1);
    }

    @Test
    void whenFewInput() {
        Output output = new MockOutput();
        Input in = new MockInput(
                List.of("2", "3", "4", "5")
        );
        ValidateInput input = new ValidateInput(output, in);
        int selected = input.askInt("Enter menu:");
        assertThat(selected).isEqualTo(2);
        selected = input.askInt("Enter menu:");
        assertThat(selected).isEqualTo(3);
        selected = input.askInt("Enter menu:");
        assertThat(selected).isEqualTo(4);
        selected = input.askInt("Enter menu:");
        assertThat(selected).isEqualTo(5);
    }

    @Test
    void whenNegativeInput() {
        Output output = new MockOutput();
        Input in = new MockInput(
                List.of("-1")
        );
        ValidateInput input = new ValidateInput(output, in);
        int selected = input.askInt("Enter menu:");
        assertThat(selected).isEqualTo(-1);
    }
}