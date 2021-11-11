public class Item {
    int value;
    int weight;

    public Item(int minValue, int maxValue, int minWeight, int maxWeight) {
        /*
        Produces a randomized Item depending on parameters
        */
        this.value = minValue + (int)(Math.random() * ((maxValue - minValue) + 1));
        this.weight = minWeight + (int)(Math.random() * ((maxWeight - minWeight) + 1));
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "Item{" +
                "value=" + value +
                ", weight=" + weight +
                '}';
    }
}