public abstract class Producto {
    protected int codigo;
    protected String nombre;
    protected String modelo;
    protected String descripcion;
    protected double precio;

    protected String tipo;

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    //    public void agregar_producto(Producto nuevo_producto) {
//        ProductoCodigo nuevo_codigo = new ProductoCodigo();
//        nuevo_producto.setCodigo(nuevo_codigo.nuevo_codigo());
//
//    }

    public abstract double obtener_precio(double plan);

    public abstract String obtener_descripcion(String anexo);
}
