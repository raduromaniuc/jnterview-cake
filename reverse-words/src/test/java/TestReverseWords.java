import org.junit.Assert;
import org.junit.Test;

public class TestReverseWords {

    @Test
    public void testBasicWords() {
        String[][] messages = {
                { "hello world", "world hello" },
                { "this is a test", "test a is this" },
                { "yet another one", "one another yet" },
                { "a b c d e", "e d c b a" },
                { "abc", "abc" },
                { "", "" }
        };

        for(int i = 0; i < messages.length - 1; i++) {
            Assert.assertArrayEquals(
                    ReverseWords.reverseWords(messages[i][0].toCharArray()),
                    messages[i][1].toCharArray()
            );
        }

    }
}
