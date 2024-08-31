package br.com.fiap.Kraft;

public class Empresa {

	private String nome;
	private String setorAtuacao;
	private String email;
	private String telefone;

	public Empresa() {
		this.nome = "KRAFT HEINZ BRASIL COMERCIO, DISTRIBUICAO E IMPORTACAO LTDA.";
		this.setorAtuacao = "Alimentício";
		this.email = "Contato@kraftheinz.com";
		this.telefone = "0800 773 7737";

	}

	public String getNome() {
		return nome;
	}

	public String getSetorAtuacao() {
		return setorAtuacao;
	}

	public String getEmail() {
		return email;
	}

	public String getTelefone() {
		return telefone;
	}

	public String toString() {

		return String.format(
				"\n\n\t\t\t>> EMPRESA <<\n\tNome.....: %s\n\tSetor de Atuação.....: %s\n\tEmail.....: %s\n\tTelefone.....: %s",
				this.getNome(), this.getSetorAtuacao(), this.getEmail(), this.getTelefone());
	}

}
