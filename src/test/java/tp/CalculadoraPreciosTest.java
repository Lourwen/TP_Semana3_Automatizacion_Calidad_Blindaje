package tp;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class CalculadoraPreciosTest {

  @Test
  void calcularPrecioConDescuento() {
    // Arrange
    CalculadoraPrecios calculadora = new CalculadoraPrecios();
    double precio = 10000;
    double descuento = 20;

    // Act
    double resultado = calculadora.calcularPrecioFinal(precio, descuento);

    // Assert
    assertEquals(8000, resultado, 0.001);
  }

  @Test
  void calcularPrecioSinDescuento() {
    // Arrange
    CalculadoraPrecios calculadora = new CalculadoraPrecios();
    double precio = 5000;
    double descuento = 0;

    // Act
    double resultado = calculadora.calcularPrecioFinal(precio, descuento);

    // Assert
    assertEquals(5000, resultado, 0.001);
  }

  @Test
  void calcularPrecioConDescuentoTotal() {
    // Arrange
    CalculadoraPrecios calculadora = new CalculadoraPrecios();
    double precio = 3000;
    double descuento = 100;

    // Act
    double resultado = calculadora.calcularPrecioFinal(precio, descuento);

    // Assert
    assertEquals(0, resultado, 0.001);
  }
}
