public abstract class CafeDecorator implements Cafe {

    protected Cafe cafe;


    public CafeDecorator(Cafe cafe) {
        this.cafe = cafe;
    }


    public String getDescripcion() {
        return cafe.getDescripcion();
    }


    public double getCosto() {
        return cafe.getCosto();
    }
}