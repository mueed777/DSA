import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Decoder {
    public static String decode(String messageFile) {
        List<String> decodedWords = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(messageFile))) {
            String line;
            int lineNumber = 0;

            while ((line = reader.readLine()) != null) {
                lineNumber++;
                String[] parts = line.split(" ");
                int number = Integer.parseInt(parts[0]);
                String word = parts[1];

                if (number == lineNumber) {
                    decodedWords.add(word);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return String.join(" ", decodedWords);
    }

    public static void main(String[] args) {
        String decodedMessage = decode("coding_qual_input.txt");
        System.out.println(decodedMessage);
    }
}

