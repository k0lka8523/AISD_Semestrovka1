import java.util.ArrayList;
import java.util.List;

public class PatienceSort {
    public static long sort(List<Integer> array) {
        List<List<Integer>> piles = new ArrayList<>();
        long startTime = System.nanoTime();
        // Размещение каждого элемента в подходящую стопку
        for (int number : array) {
            boolean placed = false;
            for (List<Integer> pile : piles) {
                if (pile.get(pile.size() - 1) >= number) {
                    pile.add(number);
                    placed = true;
                    break;
                }
            }
            if (!placed) {
                List<Integer> newPile = new ArrayList<>();
                newPile.add(number);
                piles.add(newPile);
            }
        }

        // Объединение стопок в одну отсортированную последовательность.
        array.clear();
        while (!piles.isEmpty()) {
            List<Integer> minPile = piles.get(0);
            for (List<Integer> pile : piles) {
                if (pile.get(pile.size() - 1) < minPile.get(minPile.size() - 1)) {
                    minPile = pile;
                }
            }
            array.add(minPile.remove(minPile.size() - 1));
            if (minPile.isEmpty()) {
                piles.remove(minPile);
            }
        }
        long endTime = System.nanoTime();
        return endTime - startTime;
    }
}
