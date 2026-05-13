package olimpiada;

public class Atleta extends MembroComite {
	private Modalidade modalidade;

	public Atleta(String nome, String genero, int idade, Modalidade modalidade) {
		super(nome, genero, idade);
		this.modalidade = modalidade;
	}

	public Modalidade getModalidade() {
		return modalidade;
	}

	public void setModalidade(Modalidade modalidade) {
		this.modalidade = modalidade;
	}
	
	
	@Override
	public String exibirDados() {
		
		return "Atleta: {" + super.exibirDados() + 
				", modalidade=" + this.getModalidade().toString() + "}";
	}
}
