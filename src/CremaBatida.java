public class CremaBatida extends CafeDecorator {


    public CremaBatida(Cafe cafe) {
        super(cafe);
    }


    public String getDescripcion() {
        return cafe.getDescripcion() + " + Crema Batida";
    }


    public double getCosto() {
        return cafe.getCosto() + 0.70;
    }
}