package guia1.ejercicio13;

public class TarjetaDeCredito {
    private String entidadBancaria;
    private int numeroDeTarjeta;
    private double saldoDisponible;
    private EntidadFinanciera entidadFinanciera;
    private Titular titular;
    

    public TarjetaDeCredito(String entidadBancaria, int numeroDeTarjeta, double saldoDisponible, EntidadFinanciera entidadFinanciera, Titular titular) {
        this.entidadBancaria = entidadBancaria;
        this.numeroDeTarjeta = numeroDeTarjeta;
        this.saldoDisponible = saldoDisponible;
        this.entidadFinanciera = entidadFinanciera;
        this.titular = titular;
    }

    public double getSaldoDisponible() {
        return saldoDisponible;
    }
    
    
    public boolean verificarSaldoTarjeta(TarjetaDeCredito tarjetaDeCredito, double montoAPagar){
        return saldoDisponible >= montoAPagar;
    }
    
    public void descontar (double monto){
        saldoDisponible -= monto;
    }

    public String nombreCompleto(){
        return titular.nombreCompleto();
    }

    @Override
    public String toString() {
        return "TarjetaDeCredito{" + "entidadBancaria=" + entidadBancaria + ", numeroDeTarjeta=" + numeroDeTarjeta + ", saldoDisponible=" + saldoDisponible + ", entidadFinanciera=" + entidadFinanciera + ", titular=" + titular + '}';
    }
    
    
}