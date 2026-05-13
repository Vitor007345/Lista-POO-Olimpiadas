package olimpiada;

public class Tecnico extends MembroComite {
	private String atividade;
	private Modalidade modalidade;
	
	public Tecnico(String nome, String genero, int idade, String atividade, Modalidade modalidade) {
		super(nome, genero, idade);
		this.atividade = atividade;
		this.modalidade = modalidade;
	}

	public String getAtividade() {
		return atividade;
	}

	public void setAtividade(String atividade) {
		this.atividade = atividade;
	}

	public Modalidade getModalidade() {
		return modalidade;
	}

	public void setModalidade(Modalidade modalidade) {
		this.modalidade = modalidade;
	}

	@Override
	public String exibirDados() {
		
		return "Técnico: {" + super.exibirDados() + 
				", atividade=" + this.getAtividade() + 
				", modalidade=" + this.getModalidade().toString() + "}";
	}

	@Override
	public boolean equals(Object membro) {
		return this == membro || 
				(super.equals(membro) && 
				membro instanceof Tecnico t && 
				t.getAtividade().equals(this.getAtividade()) &&
				t.getModalidade().equals(this.modalidade));
	}
	
	
	
	
	
	
	
	
	
	
	
}
