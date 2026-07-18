public class Chocolate extends CafeDecorator {


    public Chocolate(Cafe cafe) {
        super(cafe);
    }


    public String getDescripcion() {
        return cafe.getDescripcion() + " + Chocolate";
    }


    public double getCosto() {
        return cafe.getCosto() + 0.50;
    }
}