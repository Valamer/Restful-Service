import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class MainTest {

    @Test
    public void numJewelsInStonesTest() {
        String jewels = "gKl";
        String stones = "GGKKiosjl";

        int result = 3;

        int actual = Main.numJewelsInStones(jewels,stones);

        Assertions.assertEquals(result,actual);
    }     @Test
    public void numJewelsInStonesTest2() {
        String jewels = "HELLO";
        String stones = "hello";

        int result = 0;

        int actual = Main.numJewelsInStones(jewels,stones);

        Assertions.assertEquals(result,actual);
    }

    @Test
    public void numIdenticalPairsTest() {
        int[] nums = new int[]{1,2,3,4,2,7,7,4,2};

        int result = 5;

        int actual = Main.numIdenticalPairs(nums);
        Assertions.assertEquals(result,actual);
    }     @Test
    public void numIdenticalPairsTest2() {
        int[] nums = new int[]{1,2,3,4,5,6,7,8,9};

        int result = 0;

        int actual = Main.numIdenticalPairs(nums);
        Assertions.assertEquals(result,actual);
    }

    @Test
    public void maxNumberOfBalloonsTest() {
        String text = "baoonballlloon";

        int result = 2;

        int actual = Main.maxNumberOfBalloons(text);
        Assertions.assertEquals(result,actual);
    }     @Test
    public void maxNumberOfBalloonsTest2() {
        String text = "aoonballlloosgfh";

        int result = 1;

        int actual = Main.maxNumberOfBalloons(text);
        Assertions.assertEquals(result,actual);
    }     @Test
    public void maxNumberOfBalloonsTest3() {
        String text = "ballon";

        int result = 0;

        int actual = Main.maxNumberOfBalloons(text);
        Assertions.assertEquals(result,actual);
    }
}
