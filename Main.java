import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        NumberGenerator.generate();
        Map<Integer, Long> points = new HashMap<>();
        File file = new File("Sequences.txt");
        Scanner reader = new Scanner(file);
        int numberOfSequences = reader.nextInt();
        for (int i = 0; i < numberOfSequences; i++) {
            int sequenceLength = reader.nextInt();
            List<Integer> array = new ArrayList<>();
            for (int j = 0; j < sequenceLength; j++) {
                array.add(reader.nextInt());
            }
            points.put(array.size(), PatienceSort.sort(array));
        }
        reader.close();

        try (BufferedWriter writer = new BufferedWriter(new FileWriter("Values.txt"))) {
            writer.write(numberOfSequences + "\n");
            for (int element : points.keySet()) {
                writer.write(element + "\n");
            }
            writer.write("\n");
            for (int element : points.keySet()) {
                writer.write(points.get(element) + "\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
