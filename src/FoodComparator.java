import java.util.Comparator;

public class FoodComparator implements Comparator<Food> {

    @Override
    public int compare(Food f1, Food f2) {
        int typeComparison = getTypeOrder(f1) - getTypeOrder(f2);
        if (typeComparison != 0) {
            return typeComparison;
        }

        if (f1 instanceof Lemonade && f2 instanceof Lemonade) {
            return ((Lemonade) f2).getParameter().compareTo(((Lemonade) f1).getParameter());
        }  else if (f1 instanceof Apple && f2 instanceof Apple) {
            return ((Apple) f2).getSize().compareTo(((Apple) f1).getSize());
        } else {
            return 0;
        }
    }


    private int getTypeOrder(Food food) {
        if (food instanceof Cheese) {
            return 1;
        } else if (food instanceof Apple) {
            return 2;
        } else if (food instanceof Lemonade) {
            return 3;
        } else {
            return 4;
        }
    }
}

