package olimpiada;

public abstract class MembroComite {
	private String nome;
	private String  genero;
	private int idade;
	
	
	
	
	public MembroComite(String nome, String genero, int idade) {
		this.nome = nome;
		this.genero = genero;
		this.idade = idade;
	}
	
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getGenero() {
		return genero;
	}
	public void setGenero(String genero) {
		this.genero = genero;
	}
	public int getIdade() {
		return idade;
	}
	public void setIdade(int idade) {
		this.idade = idade;
	}


	
	public String exibirDados() {
		return "nome=" + nome + ", genero=" + genero + ", idade=" + idade;
	}
	
	@Override
	public boolean equals(Object membro) {
		return (membro instanceof MembroComite m && 
				m.getNome().equals(this.getNome()) &&
				m.getGenero().equals(this.getGenero()) &&
				m.getIdade() == this.getIdade());
	}
	
	
	
	
	
	
	
}
