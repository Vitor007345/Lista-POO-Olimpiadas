package olimpiada;

import java.util.ArrayList;

import java.util.HashMap;

public class DelegacaoOlimpica {
	private ArrayList<MembroComite> delegacao;
	private HashMap<Modalidade, Integer> modalidades;

	public DelegacaoOlimpica() {
		this.delegacao = new ArrayList<>();
		this.modalidades = new HashMap<>();
	}
	
	
	public boolean adicionarMembro(MembroComite membro) {
		
		Modalidade modMembro = null;
		
		if (membro instanceof Tecnico t) {
	        modMembro = t.getModalidade();
	    } else if (membro instanceof Atleta a) {
	        modMembro = a.getModalidade();
	    }
		
		if(modMembro != null) {
		
			Integer contagemAtual = this.modalidades.get(modMembro);
			if(contagemAtual ==  null || contagemAtual >= modMembro.getLimiteMembros()) return false;
			if(!this.delegacao.add(membro))return false;
			this.modalidades.put(modMembro, contagemAtual + 1);
		}else {
			if(!this.delegacao.add(membro))return false;
		}
		
		return true;
	}

	
	
	public boolean adicionarModalidade(Modalidade modalidade) {
		return this.modalidades.putIfAbsent(modalidade, 0) == null;
		
	}
	
	
	
	
	
	
	
}
