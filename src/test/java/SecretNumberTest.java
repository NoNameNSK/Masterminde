import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

@Test
public class SecretNumberTest {
    SecretNumber secretNumber;
    int[] answer;

    @BeforeClass
    public void setUp(){
        secretNumber = new SecretNumber();
    }

    public void cowsTest(){
        secretNumber.setNumber(1122);
        answer = secretNumber.checkAnswer(3344);
        Assert.assertEquals(answer[0], 0);
        secretNumber.setNumber(1122);
        answer = secretNumber.checkAnswer(3341);
        Assert.assertEquals(answer[0], 1);
        secretNumber.setNumber(1122);
        answer = secretNumber.checkAnswer(3311);
        Assert.assertEquals(answer[0], 2);
        secretNumber.setNumber(1122);
        answer = secretNumber.checkAnswer(3213);
        Assert.assertEquals(answer[0], 2);
        secretNumber.setNumber(1122);
        answer = secretNumber.checkAnswer(2213);
        Assert.assertEquals(answer[0], 3);
    }

    public void bullsTest(){
        secretNumber.setNumber(1122);
        answer = secretNumber.checkAnswer(2211);
        Assert.assertEquals(answer[1], 0);
        secretNumber.setNumber(1122);
        answer = secretNumber.checkAnswer(1333);
        Assert.assertEquals(answer[1], 1);
        secretNumber.setNumber(1122);
        answer = secretNumber.checkAnswer(1133);
        Assert.assertEquals(answer[1], 2);
        secretNumber.setNumber(1122);
        answer = secretNumber.checkAnswer(1323);
        Assert.assertEquals(answer[1], 2);
        secretNumber.setNumber(1112);
        answer = secretNumber.checkAnswer(1113);
        Assert.assertEquals(answer[1], 3);
        secretNumber.setNumber(1132);
        answer = secretNumber.checkAnswer(1133);
        Assert.assertEquals(answer[1], 3);
        secretNumber.setNumber(1111);
        answer = secretNumber.checkAnswer(1111);
        Assert.assertEquals(answer[1], 4);
    }

    public void getAnswerTest(){
        secretNumber.setNumber(1111);
        Assert.assertEquals(secretNumber.getAnswer(), 1111);
    }
}
