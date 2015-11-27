package Aula3;

public class ex3 {
	public static void main(String[]args){
        Condutor condutor = new Condutor("Daniela", 12345, new Data(15, 04, 1996), 'B');
        
        Ligeiro ligeiro = new Ligeiro(3,175, 2200, 1100);
        Mercadorias mercadorias = new Mercadorias(2,80, 2400, 1200);
        Motociclo motociclo = new Motociclo(2, 150, 150, 300);
        Passageiros passageiros = new Passageiros(4, 95, 1400, 1190);
        
        System.out.println(condutor.toString());
        System.out.println(ligeiro.toString());
        System.out.println(mercadorias.toString());
        System.out.println(motociclo.toString());
        System.out.println(passageiros.toString());
    }
}
