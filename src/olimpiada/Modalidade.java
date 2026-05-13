package olimpiada;

import java.util.Objects;

//fiz a classe imutável pra funcionar no HashMap
public class Modalidade {
	private final int limiteMembros;
	private final String descricao;
	
	public Modalidade(int limiteMembros, String descricao) {
		this.limiteMembros = limiteMembros;
		this.descricao = descricao;
	}

	public int getLimiteMembros() {
		return limiteMembros;
	}

	public String getDescricao() {
		return descricao;
	}
	
	
	@Override
	public boolean equals(Object outraModalidade) {
		if(outraModalidade instanceof Modalidade m) {
			return this == m || (this.getLimiteMembros() == m.getLimiteMembros() && this.getDescricao().equals(m.getDescricao()));
		}
		return false;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(this.limiteMembros, this.descricao);
	}

	@Override
	public String toString() {
		return "Modalidade: {limiteMembros=" + limiteMembros + ", descricao=" + descricao + "}";
	}
	
	
	
	
}
