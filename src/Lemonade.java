public class Lemonade extends Food{
    private String parameter;

    public Lemonade(String taste) {
        super("Лимонад");
        if (isValidTaste(taste)) {
            this.parameter = taste;
        } else {
            throw new IllegalArgumentException("Недопустимый вкус лимонада: " + taste);
        }
    }

    private boolean isValidTaste(String taste) {
        return taste.equals("лимон") || taste.equals("апельсин") || taste.equals("клубника");
    }

    public String toString() {
        return super.toString() + " со вкусом " + parameter;
    }

    public String getParameter(){
        return parameter;
    }


    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        if (!super.equals(obj)) return false;

        Lemonade lemonade = (Lemonade) obj;
        return this.parameter.equals(lemonade.parameter);
    }

    @Override
    public void consume() {
        System.out.println(this + " выпит");
    }

    @Override
    public double calculateCalories() {
        switch (parameter.toLowerCase()){
            case "лимон":
                return 30;
            case "клубника":
                return 35;
            case "апельсин":
                return 40;
            default:
                return 0;
        }
    }
}
