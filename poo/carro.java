import java.util.*; //importa as classes

public class carro { //classe principal(carro)
    public static void main(String[] args) { //define o metodo main (ponto de entrada)
        // Nomes e números dos pilotos
        String[] nomes = { //atribui nomes aos pilotos
            "Pietra", "Hadassa", "Aaron", "Samuel", "Mary",
            "Heloisa", "Kauany", "Leticia", "Rodrigo", "Grbariel"
        };
        int[] numeros = {11, 22, 33, 44, 55, 66, 77, 88, 99, 100}; //atribui numeros aos pilotos

        //lista de pilotos
        List<Piloto> pilotos = new ArrayList<Piloto>(); //interface( list) implementação completa da lista qu esta vazia(aray)
        for (int i = 0; i < nomes.length; i++) {
            pilotos.add(new Piloto(nomes[i], numeros[i]));
        }

        // Embaralha os pilotos 
        Collections.shuffle(pilotos);

        //  pontuação automatica pela posição
        for (int i = 0; i < pilotos.size(); i++) {
            int posicao = i + 1;
            int pontos = Pontuacao.getPontosPorPosicao(posicao);
            pilotos.get(i).adicionarPontos(pontos);
        }

        // pilotos e suas pontuações
        System.out.println("== Resultado da Corrida ==");
        for (int i = 0; i < pilotos.size(); i++) {
            Piloto p = pilotos.get(i);
            System.out.println(p.getNome() + " (nº " + p.getNumero() + ") - " + p.getPontos() + " pontos");
        }

        // ordem total de pontos por piloto (maior para menor)
        for (int i = 0; i < pilotos.size() - 1; i++) {
            for (int j = i + 1; j < pilotos.size(); j++) {
                if (pilotos.get(j).getPontos() > pilotos.get(i).getPontos()) {
                    Piloto temp = pilotos.get(i);
                    pilotos.set(i, pilotos.get(j));
                    pilotos.set(j, temp);
                }
            }
        }

        //  ranking
        System.out.println("\n== Ranking Geral ==");
        for (int i = 0; i < pilotos.size(); i++) {
            Piloto p = pilotos.get(i);
            System.out.println((i + 1) + "º lugar: " + p.getNome() + " (nº " + p.getNumero() + ") - " + p.getPontos() + " pontos");
        }
    }
}

//  Piloto 
class Piloto {
    private String nome;
    private int numero;
    private int pontos;

    public Piloto(String nome, int numero) {
        this.nome = nome;
        this.numero = numero;
        this.pontos = 0;
    }

    public void adicionarPontos(int pontos) {
        this.pontos += pontos;
    }

    public int getPontos() {
        return pontos;
    }

    public String getNome() {
        return nome;
    }

    public int getNumero() {
        return numero;
    }
}

//pontuação 
class Pontuacao {
    public static int getPontosPorPosicao(int posicao) {
        if (posicao == 1) return 10;
        else if (posicao == 2) return 6;
        else if (posicao == 3) return 4;
        else if (posicao == 4) return 3;
        else if (posicao == 5) return 2;
        else if (posicao == 6) return 1;
        else return 0;
    }
}