package tp;

public class ProcesadorPagos {

  public interface PasarelaPagos {
    String cobrar(double monto);
  }

  private final PasarelaPagos pasarela;

  public ProcesadorPagos(PasarelaPagos pasarela) {
    this.pasarela = pasarela;
  }

  public String procesar(double monto) {
    return pasarela.cobrar(monto);
  }
}
