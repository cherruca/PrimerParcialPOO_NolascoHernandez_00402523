public class Laptop extends Producto {
    protected String procesador;

    public String getProcesador() {
        return procesador;
    }

    public void setProcesador(String procesador) {
        this.procesador = procesador;
    }

    public Laptop() {
        ProductoCodigo nuevo_codigo = new ProductoCodigo();
        setCodigo(ProductoCodigo.nuevo_codigo());
    }

    @Override
    public double obtener_precio(double plan) {
        double precio_total = getPrecio() + plan;
        return precio_total;
    }

    @Override
    public String obtener_descripcion(String anexo) {
        String descripcion_total = "Laptop con las siguientes características: " + anexo;
        return descripcion_total;
    }
}
