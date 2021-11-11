import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Earth {
    private List<Human> population = new ArrayList<>();

    public Earth() {
        /*
        Produces a pure population
        */
        for (int i = 0; i < 100; i++) {
            int[] chromosome = new int[100];
            chromosome[i] = 1;
            population.add(new Human(chromosome));
        }
    }

    public List<Human> getPopulation() {
        return population;
    }

    public void setPopulation(List<Human> population) {
        this.population = population;
    }

    public void updatePopulation() {
        /*
        Takes old population and produces children
        then chooses better of them all and store the same quantity of human
        */
        List<Human> oldPopulation = getPopulation();
        int len = oldPopulation.size();
        if (len % 2 == 1) {
            oldPopulation.remove(len - 1);
        }
        // oldPopulation should be even
        List<Human> newPopulation = new ArrayList<>();
        for (int i = 0; i < oldPopulation.size(); i += 2) {
            Human newHuman = Human.produceChild(oldPopulation.get(i), oldPopulation.get(i + 1));
            newPopulation.add(newHuman);
        }
        // merges both populations together and chooses more profitable of human
        oldPopulation.addAll(newPopulation);
        Collections.sort(oldPopulation);
        setPopulation(oldPopulation.subList(0, 100));
    }

    @Override
    public String toString() {
        return "Earth{" +
                "population=" + population +
                '}';
    }
}
