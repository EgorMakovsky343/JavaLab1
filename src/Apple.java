public class Apple extends Food{
    private String size;

    public Apple(String size) {
        super("Яблоко");
        if(isValidSize(size)){
            this.size = size;
        } else
            throw new IllegalArgumentException("Недопустимый вкус лимонада: " + size);
    }

    private boolean isValidSize(String size){
        return size.equals("большое") || size.equals("среднее") || size.equals("маленькое");
    }


    public void consume() {
        System.out.println(this + " съедено");
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    @Override
    public double calculateCalories() {
        switch (size.toLowerCase()) {
            case "маленькое":
                return 52;
            case "среднее":
                return 72;
            case "большое":
                return 92;
            default:
                return 72;
        }
    }

    public boolean equals(Object arg0) {
        if (super.equals(arg0)) {
            if (!(arg0 instanceof Apple)) return false;
            return size.equals(((Apple) arg0).size);
        } else
            return false;
    }

    public String toString() {
        return super.toString() + " размера '" + size.toUpperCase() + "'";
    }
}
