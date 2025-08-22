public class Elevador {
    private int andarAtual;
    private int totalAndares;
    private int capacidadeMax;
    private int qtdPessoas;

    
    public void inicializa(int totalAndares, int capacidadeMax) {
        this.totalAndares = totalAndares;
        this.capacidadeMax = capacidadeMax;
        this.andarAtual = 0; // andar térreo
        this.qtdPessoas = 0; 
    }

    
    public boolean entrarPessoas() {
        if (qtdPessoas < capacidadeMax) {
            qtdPessoas++;
            return true;
        }
        return false;
    }

    
    public boolean sairPessoas() {
        if (qtdPessoas > 0) {
            qtdPessoas--;
            return true;
        }
        return false;
    }

    
    public boolean subir() {
        if (andarAtual < totalAndares) {
            andarAtual++;
            return true;
        }
        return false;
    }

    
    public boolean descer() {
        if (andarAtual > 0) {
            andarAtual--;
            return true;
        }
        return false;
    }

    
    public void deslocar(int andar) {
        if (andar < 0 || andar > totalAndares) {
            System.out.println("Esse andar não existe. O prédio tem apenas " + totalAndares + ".");
            return;
        }

        try {
            while (andarAtual != andar) {
                if (andarAtual < andar) {
                    if (subir()) {
                        System.out.println("Subindo... " + andarAtual);
                    } else {
                        System.out.println("Não é possível subir mais.");
                        break;
                    }
                } else {
                    if (descer()) {
                        System.out.println("Descendo... " + andarAtual);
                    } else {
                        System.out.println("Não é possível descer mais.");
                        break;
                    }
                }
                Thread.sleep(1000);
            }
            System.out.println("Elevador chegou no andar " + andarAtual);
        } catch (InterruptedException e) {
            System.out.println("O deslocamento foi interrompido.");
        }
    }

    
    public int getAndarAtual() {
        return andarAtual;
    }

    
    public int getQtdPessoas() {
        return qtdPessoas;
    }
}