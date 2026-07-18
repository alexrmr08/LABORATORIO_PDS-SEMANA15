public class Vainilla extends CafeDecorator {


    public Vainilla(Cafe cafe) {
        super(cafe);
    }


    public String getDescripcion() {
        return cafe.getDescripcion() + " + Vainilla";
    }


    public double getCosto() {
        return cafe.getCosto() + 0.40;
    }
}