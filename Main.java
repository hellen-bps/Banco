public class Main {
    public static void main(String[] args) {
    	
        ContaBancaria conta1 = new ContaBancaria();
        ContaBancaria conta2 = new ContaBancaria("Hellen Xavier", "5334-9");
        ContaBancaria conta3 = new ContaBancaria("5678-9", 5000.0, "John Snow", 0.03);
        
		
        conta1.depositar(3500, "Depósito inicial");
        conta2.depositar(10000);
        conta3.sacar(4020);
        conta2.sacar(30000, 1000);
        conta1.transferir(conta3, 5000);
        conta2.transferir(conta3, 10000);
        System.out.println("---------------------------------");

        
        conta1.exibirExtrato();
        conta2.exibirExtrato();
        conta3.exibirExtrato();
    }
}
