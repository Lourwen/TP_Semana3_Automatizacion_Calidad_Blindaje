package tp;

public class CalculadoraPrecios {

  public double calcularPrecioFinal(double precio, double descuento) {
    return precio - (precio * descuento / 100);
  }
}
