package olimpiada;

public class ProfissionalSaude extends MembroComite {
	private String especialidade;

	public ProfissionalSaude(String nome, String genero, int idade, String especialidade) {
		super(nome, genero, idade);
		this.especialidade = especialidade;
	}

	public String getEspecialidade() {
		return especialidade;
	}

	public void setEspecialidade(String especialidade) {
		this.especialidade = especialidade;
	}
	
	@Override
	public String exibirDados() {
		return "ProfissionalSaude: {" + super.exibirDados() + 
				", especialidade=" + this.getEspecialidade() + "}";
	}
	
	@Override
	public boolean equals(Object membro) {
		return this == membro || 
				(super.equals(membro) && 
				membro instanceof ProfissionalSaude ps && 
				ps.getEspecialidade().equals(this.getEspecialidade()));
	}
	
}
