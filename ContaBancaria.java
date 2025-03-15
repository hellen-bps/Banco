class ContaBancaria {
    private String numeroConta;
    private double saldo;
    private String titular;
    private double taxaJuros;

    public ContaBancaria() {
        this.numeroConta = "0000-0";
        this.saldo = 0.0;
        this.titular = "Desconhecido";
        this.taxaJuros = 0.02;
    }

    public ContaBancaria(String titular, String numeroConta) {
        this.numeroConta = numeroConta;
        this.saldo = 0.0;
        this.titular = titular;
        this.taxaJuros = 0.02;
    }


    public ContaBancaria(String numeroConta, double saldo, String titular, double taxaJuros) {
        this.numeroConta = numeroConta;
        this.saldo = saldo;
        this.titular = titular;
        this.taxaJuros = taxaJuros;
    }

    public void depositar(double valor) {
        if (valor > 0) {
            this.saldo += valor;
        }
    }

    public void depositar(double valor, String descricao) {
        if (valor > 0) {
            this.saldo += valor;
            System.out.println(titular + " depositou R$" + valor + descricao);
        }
    }

    public boolean sacar(double valor) {
        if (valor > 0 && valor <= this.saldo) {
            this.saldo -= valor;
            System.out.println(titular + " sacou R$" + valor);
            return true;
        } else {
            System.out.println(titular + " tem o saldo insuficiente");
            return false;
        }
    }

    public boolean sacar(double valor, double limiteChequeEspecial) {
        if (valor > 0 && valor <= (this.saldo + limiteChequeEspecial)) {
            this.saldo -= valor;
            System.out.println(titular + " sacou R$" + valor + " com cheque especial se necessário.");
            return true;
        } else {
            System.out.println(titular + " tem salaldo e limite insuficientes");
            return false;
        }
    }

    public double calcularJuros() {
        return this.saldo * this.taxaJuros;
    }

    public double calcularJuros(int meses) {
        return this.saldo * this.taxaJuros * (meses / 12.0);
    }

    public boolean transferir(ContaBancaria destino, double valor) {
        if (this.sacar(valor)) {
            destino.depositar(valor);
            System.out.println(titular + " transferiu de R$" + valor + " para " + destino.titular);
            return true;
        }
        return false;
    }

    public void exibirExtrato() {
        System.out.println("Conta: " + this.numeroConta);
        System.out.println("Titular: " + this.titular);
        System.out.println("Saldo: R$" + this.saldo);
        System.out.println("Juros anuais projetados: R$" + calcularJuros());
        System.out.println("---------------------------------");
    }
}