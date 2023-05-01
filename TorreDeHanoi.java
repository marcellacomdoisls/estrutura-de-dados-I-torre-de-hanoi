import java.util.concurrent.TimeUnit;

public class TorreDeHanoi {
  public static void main(String[] args) {
    long numeroDeDiscos = 1;
    long inicio = System.nanoTime();
    long movimentos = resolverTorreDeHanoi(numeroDeDiscos, "A", "C", "B");
    long fim = System.nanoTime();
    long duracaoNanoSegundos = fim - inicio;

    String duracaoFormatada = String.format("%02d:%02d:%02d:%03d",
      TimeUnit.NANOSECONDS.toHours(duracaoNanoSegundos),
        TimeUnit.NANOSECONDS.toMinutes(duracaoNanoSegundos) % TimeUnit.HOURS.toMinutes(1),
          TimeUnit.NANOSECONDS.toSeconds(duracaoNanoSegundos) % TimeUnit.MINUTES.toSeconds(1),
            duracaoNanoSegundos / 1000000);

    System.out.println("Número de discos: " + numeroDeDiscos);
    System.out.println("Tempo gasto: " + duracaoFormatada);
    System.out.println("Movimentos realizados: " + movimentos);
  }

  public static long resolverTorreDeHanoi(long numeroDeDiscos, String hasteOrigem, String hasteDestino,
      String hasteAuxiliar) {
    if (numeroDeDiscos == 1) {
      return 1;
    } else {
      long movimentos = resolverTorreDeHanoi(numeroDeDiscos - 1, hasteOrigem, hasteAuxiliar, hasteDestino);
      movimentos++;
      movimentos += resolverTorreDeHanoi(numeroDeDiscos - 1, hasteAuxiliar, hasteDestino, hasteOrigem);
      return movimentos;
    }
  }
}
