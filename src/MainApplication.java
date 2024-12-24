import java.util.Arrays;

public class MainApplication {
    @SuppressWarnings("unchecked")
    public static void main(String[] args) {
        Food[] breakfast = new Food[20];
        int itemsSoFar = 0;
        Apple needFood = new Apple("большое"); //нужная еда
        int X = 0;
        boolean calculateCalories = false;
        boolean sortItems = false;
        for (String arg : args) {
            if (arg.startsWith("-")) {
                if (arg.equals("-calories")) {
                    calculateCalories = true;
                } else if (arg.equals("-sort")) {
                    sortItems = true;
                }
            } else {
                String[] parts = arg.split("/");
                if (parts[0].equals("Cheese")) {
                    breakfast[itemsSoFar] = new Cheese();
                } else if (parts[0].equals("Apple")) {
                    breakfast[itemsSoFar] = new Apple(parts[1]);
                } else if (parts[0].equals("Lemonade")) {
                    breakfast[itemsSoFar] = new Lemonade(parts[1]);
                }

                if (breakfast[itemsSoFar] != null && breakfast[itemsSoFar].equals(needFood)) {
                    X++;
                }

                itemsSoFar++;
            }
        }
        if (sortItems) {
            Arrays.sort(breakfast, 0, itemsSoFar, new FoodComparator());
        }
        double totalCalories = 0;
        for (Food item : breakfast) {
            if (item != null) {
                item.consume();
                if (calculateCalories) {
                    System.out.println("Калорийность продукта " + item.name + ": " + item.calculateCalories());
                    totalCalories += item.calculateCalories();
                }
            } else {
                break;
            }
        }
        System.out.println("Нужный тип еды " + X);
        if (calculateCalories) {
            System.out.println("Калории в завтраке: " + totalCalories);
        }
        System.out.println("Всего хорошего!");
    }
}

