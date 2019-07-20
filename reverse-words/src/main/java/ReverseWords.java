public class ReverseWords {

    public static void main(String[] args) {
        char[] message = {
                'c', 'a', 'k', 'e', ' ',
                'p', 'o', 'u', 'n', 'd', ' ',
                's', 't', 'e', 'a', 'l'
        };

        System.out.println(reverseWords(message));
    }

    /**
     * Roughly O(2n) execution time
     * O(1) memory consumption
     *
     * First reverses the whole message, going from "cake pound steal"
     * to "laets dnuop ekac", having the words in the correct reversed order,
     * but also the words themselves reversed. It then re-reverses each word.
     * */
    public static char[] reverseWords(char[] message) {
        reversePartOf(message, 0, message.length - 1);

        int start, end;
        for(start = 0, end = 0; end < message.length; end++) {
            if(message[end] == (int) ' ') {
                reversePartOf(message, start, end - 1);
                start = end + 1;
            }
        }
        reversePartOf(message, start, end - 1);

        return message;
    }

    private static void reversePartOf(char[] message, int start, int end) {

        char aux;
        int length = end - start + 1;

        for(int it = 0; start <= end - length/2 - length%2; start++, it++) {
            aux = message[start];
            message[start] = message[end - it];
            message[end - it] = aux;
        }
    }
}
