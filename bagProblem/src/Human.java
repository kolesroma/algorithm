import java.util.*;

public class Human implements Comparable<Human>{
    private int[] chromosome;

    public Human(int[] chromosome) {
        this.chromosome = chromosome;
    }

    public static Human produceChild(Human h1, Human h2) {
        /*
        Takes first human's chromosome with chance 50%
        and second human's chromosome with chance 50%
        */
        int[] final_chromosome = new int[100];
        for (int i = 0; i < 100; i++) {
            if (Math.random() > 0.5) {
                final_chromosome[i] = h1.getChromosome()[i];
            } else {
                final_chromosome[i] = h2.getChromosome()[i];
            }
        }
        // mutation
        if (Math.random() < 0.1) {
            int c1 = (int)(Math.random() * 100);
            int c2 = (int)(Math.random() * 100);
            int c3 = final_chromosome[c2];
            final_chromosome[c2] = final_chromosome[c1];
            final_chromosome[c1] = c3;
        }

        return new Human(final_chromosome);
    }

    public int[] getChromosome() {
        return chromosome;
    }

    public void setChromosome(int[] chromosome) {
        this.chromosome = chromosome;
    }

    public Bag equipBag(List<Item> stack) {
        Bag bag = new Bag(150);
        int[] cr = getChromosome();
        for (int i = 0; i < 100; i++) {
            if (cr[i] == 1) {
                bag.getItems().add(stack.get(i));
            }
        }
        return bag;
    }

    @Override
    public String toString() {
        return "Human{" +
                "chromosome=" + Arrays.toString(chromosome) +
                '}';
    }

    @Override
    public int compareTo(Human otherHuman) {
        /*
        Sorting criterion : quantity of items
        */
        int[] cr1 = getChromosome();
        int c1 = 0;
        for (int i : cr1){
            if (i == 1) {c1++; }
        }

        int[] cr2 = otherHuman.getChromosome();
        int c2 = 0;
        for (int i : cr2){
            if (i == 1) {c2++; }
        }

        return c2 - c1;
    }
}
