import org.junit.Assert;

import java.util.ArrayList;

import static org.apache.commons.lang3.math.NumberUtils.isNumber;

public class Assertions {
    public static void shouldHaveNumbers(ArrayList<String> list) {
        for (String s : list) {
            isNumber(s);
        }
    }
    public static void startsWithString(ArrayList<String> list) {
        for (String i : list) {
            Assert.assertTrue(i.matches("prod(.*)"));
        }
    }
}
