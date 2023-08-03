package hello.hellospring;

import org.junit.jupiter.api.Test;

import java.util.Optional;

public class OptionalTest {

    @Test
    public void orElse_Test() {
        String name = "고푸름";
        Optional<String> op = Optional.ofNullable(name);
        String result = op.orElse(create_name());
        System.out.println(result);
    }

    @Test
    public void orElseGet_Test() {
        String name = "고푸름";
        Optional<String> op = Optional.ofNullable(name);
        String result = op.orElseGet(() -> create_name());
        System.out.println(result);
    }


    private String create_name() {
        System.out.println("푸름짱");
        return "푸름짱";
    }


    @Test
    public void orElseThrow_Test() throws Exception {
        String name = "고푸름";
        Optional<String> op = Optional.ofNullable(name);
        String result = op.orElseThrow( ()-> new Exception("망함") );
        System.out.println(result);
    }
}