package olimpiada;

import java.util.ArrayList;

import java.util.HashMap;
import java.util.Map;

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
	
	public boolean removerMembro(MembroComite membro) {
		Modalidade modMembro = null;
		
		if (membro instanceof Tecnico t) {
	        modMembro = t.getModalidade();
	    } else if (membro instanceof Atleta a) {
	        modMembro = a.getModalidade();
	    }
		
		if(modMembro != null) {
			Integer contagemAtual = this.modalidades.get(modMembro);
			if(contagemAtual ==  null || contagemAtual < 1) return false;
			if(!this.delegacao.remove(membro))return false;
			this.modalidades.put(modMembro, contagemAtual - 1);
		}else {
			if(!this.delegacao.remove(membro))return false;
		}
		
		return true;
	}
	
	public String listarMembros() {
		String str = "";
		for(MembroComite membro : this.delegacao) {
			str += membro.exibirDados() + "\n";
		}
		return str;
	}

	
	
	public boolean adicionarModalidade(Modalidade modalidade) {
		return this.modalidades.putIfAbsent(modalidade, 0) == null;
	}
	
	public boolean removerModalidade(Modalidade modalidade) {
		if(this.modalidades.remove(modalidade) == null) return false;
		this.delegacao.removeIf((membro)-> {
			Modalidade modMembro = null;
			if (membro instanceof Tecnico t) {
		        modMembro = t.getModalidade();
		    } else if (membro instanceof Atleta a) {
		        modMembro = a.getModalidade();
		    }
			
			return modMembro != null && modMembro.equals(modalidade);
		});
		return true;
	}
	
	public Modalidade getModalidade(String descricao) {
		for(Modalidade m : this.modalidades.keySet()) {
			if(m.getDescricao().equals(descricao)) {
				return m;
			}
		}
		return null;
	}
	
	public String listarModalidades() {
		String str = "";
		for(Map.Entry<Modalidade, Integer> entry : this.modalidades.entrySet()) {
			Modalidade m = entry.getKey();
			Integer qnt = entry.getValue();
			str += m.toString() + ", Quantidade membros: " + qnt + "\n";
		}
		return str;
	}
	
	
	
	
	
	
	
}
