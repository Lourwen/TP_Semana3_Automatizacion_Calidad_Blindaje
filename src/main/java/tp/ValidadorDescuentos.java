package tp;

public class ValidadorDescuentos {

  public boolean esValido(double precio, double descuento) {
    if (precio > 0) {
      if (descuento >= 0) {
        if (descuento <= 100) {
          return true;
        }
      }
    }

    return false;
  }
}
