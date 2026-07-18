public class LecheAlmendra extends CafeDecorator {


    public LecheAlmendra(Cafe cafe) {
        super(cafe);
    }


    public String getDescripcion() {
        return cafe.getDescripcion() + " + Leche de Almendra";
    }


    public double getCosto() {
        return cafe.getCosto() + 0.80;
    }
}