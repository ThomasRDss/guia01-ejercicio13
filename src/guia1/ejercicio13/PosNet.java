package guia1.ejercicio13;

public class PosNet {
    public static double RECARGO_POR_CUOTAS = 0.03;
    public static int MINIMA_CANTIDAD_CUOTAS = 1;
    public static int MAXIMA_CANTIDAD_CUOTAS = 6;
    
    public Ticket efectuarPago(TarjetaDeCredito tarjetaDeCredito, double montoAPagar, int cantidadDeCuotas) {
        Ticket pagoFinalizado = null;
        if(tarjetaDeCredito != null && montoAPagar > 0 && cantidadDeCuotas > 0 || cantidadDeCuotas < 7){
            montoAPagar += calculoXCuotas(cantidadDeCuotas, montoAPagar);
            if(tarjetaDeCredito.verificarSaldoTarjeta(tarjetaDeCredito, montoAPagar)){
                tarjetaDeCredito.descontar(montoAPagar);
                String nombreApellido = tarjetaDeCredito.nombreCompleto();
                double montoPorCuota = montoAPagar / cantidadDeCuotas;
                pagoFinalizado = new Ticket(nombreApellido, montoAPagar, montoPorCuota);
            }
        }
        return pagoFinalizado;
    }

    private double calculoXCuotas(int cantidadDeCuotas, double montoAPagar){
    if (cantidadDeCuotas == 1) return 0;
    // Solo aplica recargo a las cuotas que superen la primera
    double recargoTotal = (cantidadDeCuotas - 1) * RECARGO_POR_CUOTAS; 
    return recargoTotal * montoAPagar;
    }

    @Override
    public String toString() {
        return "PosNet{" + '}';
    }

 
}