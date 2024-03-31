import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

public class NumberGenerator {

    public static void generate() {
        String filename = "Sequences.txt";
        Random random = new Random();

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
            int numberOfSequences = 50 + random.nextInt(51);
            writer.write(numberOfSequences + "\n");
            for (int i = 0; i < numberOfSequences; i++) {
                int sequenceLength = 100 + random.nextInt(9901);
                writer.write(sequenceLength + "\n");
                for (int j = 0; j < sequenceLength; j++) {
                    writer.write(random.nextInt() + "\n");
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}