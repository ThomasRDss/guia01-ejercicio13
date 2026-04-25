package guia1.ejercicio13;

import java.time.LocalDate;

public class Principal {

    public static void main(String[] args) {
        
        // 1. Instanciamos el Titular (Datos inventados)
        Titular titular = new Titular("35123456", "Ana", "Gómez", LocalDate.of(1992, 8, 24), "Av. Siempreviva 742");
        
        // 2. Instanciamos la Tarjeta con saldo de $15000
        TarjetaDeCredito miTarjeta = new TarjetaDeCredito("Banco Galicia", 45678912, 15000.0, EntidadFinanciera.VISA, titular);
        
        // 3. Instanciamos el dispositivo PosNet
        PosNet posnet = new PosNet();
        
        // --- MOSTRANDO ESTADO PREVIO ---
        System.out.println("=========================================");
        System.out.println("💳 ESTADO INICIAL DE LA TARJETA");
        System.out.println("Titular: " + miTarjeta.nombreCompleto());
        System.out.println("Saldo Disponible: $" + miTarjeta.getSaldoDisponible());
        System.out.println("=========================================\n");

        // --- PREPARANDO LA TRANSACCIÓN ---
        double montoAbonar = 10000.0;
        int cantidadCuotas = 5;
        
        System.out.println("🛒 INICIANDO TRANSACCIÓN POSNET...");
        System.out.println("Intentando cobrar: $" + montoAbonar + " en " + cantidadCuotas + " cuotas.");
        System.out.println("Procesando...\n");
        
        // --- EFECTUANDO EL PAGO ---
        Ticket ticketGenerado = posnet.efectuarPago(miTarjeta, montoAbonar, cantidadCuotas);
        
        // --- EVALUANDO EL RESULTADO ---
        if (ticketGenerado != null) {
            System.out.println("✅ PAGO APROBADO");
            System.out.println("Imprimiendo Ticket...");
            System.out.println(ticketGenerado.toString()); // Muestra los datos del ticket
        } else {
            System.out.println("❌ PAGO RECHAZADO");
            System.out.println("Motivo: Saldo insuficiente o parámetros inválidos.");
        }
        
        // --- MOSTRANDO ESTADO FINAL ---
        System.out.println("\n=========================================");
        System.out.println("💳 ESTADO FINAL DE LA TARJETA");
        System.out.println("Saldo Restante: $" + miTarjeta.getSaldoDisponible());
        System.out.println("=========================================");
    }
}