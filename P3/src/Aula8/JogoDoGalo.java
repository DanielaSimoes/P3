package Aula8; 

public class JogoDoGalo {
	
	protected int escolha;
	protected int[][] tabuleiro;
	protected int terminado;
	
	public JogoDoGalo(){
		tabuleiro = new int[3][3];
	}
	
	public int alternar(){
		if(escolha==1){
			//retorna O
			return -1;
		}else{
			//retorna x quer seja 0 ou n tenha ainda valor definido
			return 1;
		}
	}
	
	public boolean posicaoValida(int i, int j){
		return (i >= 1) && (i < 4) && (j >= 1) && (j < 4);
	}
	
	public boolean posicaoVazia(int i, int j){
		if(!posicaoValida(i, j)){
			throw new IllegalArgumentException("Posi‹o inv‡lida!");
		}
	    return this.tabuleiro[(i - 1)][(j - 1)] == 0;
	}
	
	public void set(int i, int j, int escolha){
		if(!posicaoVazia(i, j)){
			throw new IllegalArgumentException("Posi‹o n‹o est‡ vazia!");
		}
		
	    this.tabuleiro[(i - 1)][(j - 1)] = escolha;
	    
	    if(isFinished() || vencedor()==1 || vencedor()==-1){
	    	terminado();
	    }
	}
	
	public boolean isFinished(){
		for(int i=0; i<tabuleiro.length; i++){
			for(int j=0; j<tabuleiro[i].length; j++){
				if(tabuleiro[i][j] == 0){
					return false;
				}
			}
		}
		return true;
	}
	
	public int vencedor(){
		for(int i = 0; i<tabuleiro.length; i++){
			if((tabuleiro[i][0]+tabuleiro[i][1]+tabuleiro[i][2])==3){
				return 1;
			}else if((tabuleiro[i][0]+tabuleiro[i][1]+tabuleiro[i][2])==-3){
				return -1;
			}
		}
		for(int j = 0; j<tabuleiro.length; j++){
			if(tabuleiro[0][j]+tabuleiro[1][j]+tabuleiro[2][j]==3){
				return 1;
			}else if(tabuleiro[0][j]+tabuleiro[1][j]+tabuleiro[2][j]==-3){
				return -1;
			}
		}
		
		if(tabuleiro[0][0]+tabuleiro[1][1]+tabuleiro[2][2]==3){
			return 1;
		}else if(tabuleiro[0][0]+tabuleiro[1][1]+tabuleiro[2][2]==-3){
			return -1;
		}else if(tabuleiro[0][2]+tabuleiro[1][1]+tabuleiro[2][0]==3){
			return 1;
		}else if(tabuleiro[0][2]+tabuleiro[1][1]+tabuleiro[2][0]==-3){
			return -1;
		}
		
		return 0;
	}
	
	public void terminado(){
		terminado = 1;
	}
	
}
