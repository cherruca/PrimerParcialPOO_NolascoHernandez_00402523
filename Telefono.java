public class Telefono extends Producto {
    protected String resolucion;
    protected double plan_cargo;

    public String getResolucion() {
        return resolucion;
    }

    public void setResolucion(String resolucion) {
        this.resolucion = resolucion;
    }

    public double getPlan_cargo() {
        return plan_cargo;
    }

    public void setPlan_cargo(double plan_cargo) {
        this.plan_cargo = plan_cargo;
    }

    public Telefono() {
        ProductoCodigo nuevo_codigo = new ProductoCodigo();
        setCodigo(ProductoCodigo.nuevo_codigo());
    }

    public Telefono(String nombre, String modelo, String descripcion, double precio, String resolucion, double plan_cargo) {
        //this.codigo = codigo;
        ProductoCodigo nuevo_codigo = new ProductoCodigo();
        setCodigo(ProductoCodigo.nuevo_codigo());
        this.nombre = nombre;
        this.modelo = modelo;
        this.descripcion = descripcion;
        this.precio= precio;
        this.resolucion = resolucion;
        this.plan_cargo = plan_cargo;
    }

    @Override
    public double obtener_precio(double plan) {
        double precio_total = getPrecio() + (plan * 12);
        return precio_total;
    }

    @Override
    public String obtener_descripcion(String anexo) {
        String descripcion_total = "Teléfono móvil con las siguientes características: " + anexo;
        return descripcion_total;
    }

    public void mostrar(){

    }
}
