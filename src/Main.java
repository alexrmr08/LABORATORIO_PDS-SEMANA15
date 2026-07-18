public class Main {


    public static void main(String[] args) {


        Cliente cliente = new Cliente(
                "Carlos",
                12345678,
                20
        );


        Cafe cafe = new EspressoMacchiato();


        cafe = new Chocolate(cafe);

        cafe = new CremaBatida(cafe);


        System.out.println("Cliente: " 
                + cliente.getNombre());


        System.out.println("Pedido: "
                + cafe.getDescripcion());


        System.out.println("Precio: $"
                + cafe.getCosto());

    }
}