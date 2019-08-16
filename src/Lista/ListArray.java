package Lista;

import java.util.ArrayList;
import java.util.List;

public class ListArray {
	private List<Integer> lista;
	private int[] vetor={90,88,67};//{Z,X,C} 
	public ListArray(){
		this.setLista( new ArrayList<Integer>());
	}
	public List<Integer> getLista() {
		return lista;
	}
	public void setLista(List<Integer> lista) {
		this.lista = lista;
	}
	
	public void Inserir(int elemento){
		if(this.getLista().size()!=3){
			this.getLista().add(elemento);
		}
		else{
			remover3Elementos();
			this.getLista().add(elemento);
		}
		
	}
	public void removerInicio(){
		this.getLista().remove(0);
	}
	public void remover3Elementos(){
		for(int i=0;i<3;i++){
			this.getLista().remove(0);
		}
	}
	public void Imprimir(){
		if(this.getLista().isEmpty()){
			System.out.println("lista vazia");
		}
		else{
			System.out.println("\nImpressao lista:\n");
			for(int i=0;i<lista.size();i++){
				System.out.println("elemento "+i+":"+(int)lista.get(i));
			}
		}
	}
	public boolean Comparar(){
		if(this.getLista().size()==3){
			if((vetor[0]==this.getLista().get(0))&&(vetor[1]==this.getLista().get(1))&&(vetor[2]==this.getLista().get(2))){
				return true;
			}
		}
		return false;
	}
	public int lenght(){
		return this.getLista().size();
	}
	public int CapturarElemento(int index){
		return this.getLista().get(index);
	}
	public boolean isEmpty(){
		return this.getLista().isEmpty();
	}
}
