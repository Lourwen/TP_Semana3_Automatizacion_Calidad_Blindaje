package tp;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class ValidadorDescuentosTest {

  @Test
  void aceptaPrecioYDescuentoValidos() {
    ValidadorDescuentos validador = new ValidadorDescuentos();

    assertTrue(validador.esValido(1000, 20));
  }

  @Test
  void rechazaPrecioCero() {
    ValidadorDescuentos validador = new ValidadorDescuentos();

    assertFalse(validador.esValido(0, 20));
  }

  @Test
  void rechazaDescuentoNegativo() {
    ValidadorDescuentos validador = new ValidadorDescuentos();

    assertFalse(validador.esValido(1000, -5));
  }

  @Test
  void rechazaDescuentoMayorAlCien() {
    ValidadorDescuentos validador = new ValidadorDescuentos();

    assertFalse(validador.esValido(1000, 120));
  }
}
