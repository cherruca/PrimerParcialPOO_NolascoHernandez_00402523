public class ProductoCodigo {
    private static int codigo = 1000;

    public static int nuevo_codigo() {
        codigo++;
        return codigo;
    }
}
