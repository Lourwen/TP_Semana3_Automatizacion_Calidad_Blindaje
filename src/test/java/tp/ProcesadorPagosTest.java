package tp;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;

class ProcesadorPagosTest {

  @Test
  void procesarPagoConStub() {
    // Arrange: Stub que devuelve una respuesta fija
    ProcesadorPagos.PasarelaPagos stub = monto -> "APROBADO";

    ProcesadorPagos procesador = new ProcesadorPagos(stub);

    // Act
    String resultado = procesador.procesar(1000);

    // Assert
    assertEquals("APROBADO", resultado);
  }

  @Test
  void verificarInteraccionConMock() {
    // Arrange
    ProcesadorPagos.PasarelaPagos mockPasarela = mock(ProcesadorPagos.PasarelaPagos.class);

    when(mockPasarela.cobrar(2500)).thenReturn("APROBADO");

    ProcesadorPagos procesador = new ProcesadorPagos(mockPasarela);

    // Act
    String resultado = procesador.procesar(2500);

    // Assert
    assertEquals("APROBADO", resultado);
    verify(mockPasarela).cobrar(2500);
  }
}
