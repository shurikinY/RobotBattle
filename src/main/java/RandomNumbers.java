
import java.util.Random;

public final class RandomNumbers {
    static int getRandomNumber(int low, int high)  {
        if (high - low <=0 ){
            throw new IllegalArgumentException("bound must be positive");
        }
        Random rand = new Random();
        return rand.nextInt(high - low + 1) + low;
    }
}
