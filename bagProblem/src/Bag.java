import java.util.*;

public class Bag {
    private List<Item> items = new ArrayList<>();
    private int capacity;

    public static void main(String[] args) {
        // generates a stack of items
        List<Item> stack = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            stack.add(new Item(2, 10, 1, 5));
        }

        Earth earth = new Earth();
        for (int i = 0; i < 90; i++) {
            earth.updatePopulation();
        }

        earth.getPopulation().stream()
                .map(h -> h.equipBag(stack))
                .filter(b -> b.getSize() <= b.getCapacity())
                .sorted(Comparator.comparingInt(Bag::getValue)
                        .thenComparing(Comparator.comparingInt(Bag::getSize).reversed()))
                .forEach(System.out::println);
    }

    public int getSize() {
        return getItems().stream()
                .map(Item::getWeight)
                .reduce(Integer::sum)
                .orElse(0);
    }

    public int getValue() {
        return getItems().stream()
                .map(Item::getValue)
                .reduce(Integer::sum)
                .orElse(0);
    }

    public Bag(int capacity) {
        this.capacity = capacity;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    @Override
    public String toString() {
        return "Bag{" +
                "size=" + getSize() +
                ", value=" + getValue() +
                ", items=" + items +
                '}';
    }
}
