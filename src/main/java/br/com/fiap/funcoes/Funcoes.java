package br.com.fiap.funcoes;

import java.util.Date;
import java.util.Scanner;

import br.com.fiap.controller.ClienteController;
import br.com.fiap.controller.PostController;
import br.com.fiap.redeSocial.Cliente;
import br.com.fiap.redeSocial.Post;

public class Funcoes {

	public Funcoes() {
		
	}
	public void funcaoSalvarPost(Scanner teclado, PostController psp, Cliente idCliente, String idSelecaoGerado) {
		String pergunta, mensagem;
		do {
			System.out.println("\n\n----------------------------------------------------------------------------------");
			System.out.println("\n>> O cliente tem post? (S/N)\n ");
			pergunta = teclado.nextLine().toUpperCase();

			if (pergunta.equals("S")) {
				do{
					System.out.println("\n >> Insira a mensagem: ");
					mensagem = teclado.nextLine();
					if(mensagem.length() > 300) {
						System.out.println("\n >> TAMANHO INVÁLIDO!\n");
						System.out.println("\n >> A MENSAGEM DEVE TER NO MÁXIMO 300 CARACTERES\n");
					}
				
				}while(mensagem.length() > 300);
				String tipo = ESG(teclado);
				Date dataPostagem = new Date();

				Post post = new Post(mensagem, tipo, idCliente.getIdCliente(), idSelecaoGerado, dataPostagem);
				psp.salvarPost(post);
				System.out.println("\n >> O post foi salvo com sucesso! ");
			} else if (!pergunta.equals("N")) {
				System.out.println("\n\n >> Resposta inválida. Use S para Sim ou N para Não.");
			}
		} while (!pergunta.equals("N"));
		
	}
	
	public String ESG(Scanner teclado) {
		String tipoESG;
		do {
			
			System.out.println("\n\n >> Informe o tipo ESG do post: ");
			tipoESG = teclado.next().toUpperCase();
			teclado.nextLine();
			if(!tipoESG.equals("E") && !tipoESG.equals("S") && !tipoESG.equals("G")) {
				System.out.println("\n >> TIPO INVÁLIDO!\n");
			}
			if(tipoESG.length() > 1) {
				System.out.println("\n >> TAMANHO INVÁLIDO\n");
				System.out.println("\n>> INSIRA SOMENTE UM CARACTERE! <<\n");
			}
		}while(!(tipoESG.equals("E") || tipoESG.equals("S") || tipoESG.equals("G")) || tipoESG.length() > 1);
		return tipoESG;
	}
	
	public boolean verificarIdade(int idade) {
		if(idade < 18)
			return true;
		return false;
	}
	
	public boolean verificarEmail(String email, ClienteController clienteController) {
		boolean emailExiste = false;
		for(Cliente c: clienteController.listarClientes()) {
			if(c.getEmail().trim().equalsIgnoreCase(email.trim())) {
				emailExiste = true;
				//System.out.println("\n\n >> O EMAIL JÁ ESTÁ CADASTRADO!\n");
			}
		}
		return emailExiste;
	}
	
	public boolean verificarTelefone(String telefone, ClienteController clienteController) {
		boolean telefoneExiste = false;
		for(Cliente c: clienteController.listarClientes()) {
			if(c.getTelefone().trim().equalsIgnoreCase(telefone.trim())) {
				telefoneExiste = true;
				//System.out.println("\n\n >> O TELEFONE JÁ ESTÁ CADASTRADO!\n");
			}
		}
		return telefoneExiste;
	}
	
	public Cliente setandoCliente(Scanner teclado, ClienteController clienteController) {
		String nome,telefone, email;
		int idade;
		boolean existe = false;
		// >>>>>>>>>>>> NOME <<<<<<<<<<<<<<<<<<<<<
		do {	
		System.out.println("\n\nInforme o nome: ");
		//teclado.nextLine();
		nome = teclado.nextLine();
		if(nome.length() > 50) {
			System.out.println("\n >> TAMANHO INVÁLIDO\n");
			System.out.println("\n >> O NOME DEVE TER NO MÁXIMO 50 CARACETERS!\n");
		}
		}while(nome.length() > 50);
		
		// >>>>>>>>>>> FIM NOME <<<<<<<<<<<<<<<<<<

		// >>>>>>>>>> IDADE <<<<<<<<<<<<<<<<
		do {
			System.out.println("\n\n >> Informe a idade >18: ");
			idade = teclado.nextInt();
			teclado.nextLine();
			if (idade < 18) {
				System.out.println(
						"\n >> IDADE INVÁLIDA!" + "\n >> O CLIENTE PRECISA SER MAIOR DE 18 ANOS!\n");
			}
		} while (idade < 18);
		// >>>>>>>>> FIM IDADE <<<<<<<<<<<<<

		// >>>>>>>> EMAIL <<<<<<<<<<<<
		do {
			System.out.println("\n\n >> Informe o email: ");
			email = teclado.nextLine();
			if (email.length() > 50) {
				System.out.println("\n >> TAMANHO INVÁLIDO!\n");
				System.out.println("\n >> O EMAIL DEVE TER NO MÁXIMO 50 CARACTERES!\n");
			} else {
				existe = verificarEmail(email, clienteController);
			}
		} while (existe || email.length() > 50);
		// >>>>>>>> FIM EMAIL <<<<<<<<<<<<<<<<<<<

		// >>>>>>>>>> TELEFONE <<<<<<<<<<<<<<<
		do {
			System.out.println("\n\n >> Informe o telefone: ");
			telefone = teclado.nextLine();
			if (telefone.length() > 15) {
				System.out.println("\n >> TAMANHO INVÁLIDO!\n");
				System.out.println("\n >> O TELEFONE DEVE TER NO MÁXIMO 15 CARACTERES!\n");
			} else {
					existe = verificarTelefone(telefone, clienteController);
			}
		} while (existe || telefone.length() > 15);
		// >>>>>>>>>>> FIM TELEFONE <<<<<<<<<<<<<<
		Date dataCadastro = new Date();
		
		// >>>>>>>>>>> CRIAÇÃO DO CLIENTE <<<<<<<<<<<<<<<<
		Cliente cliente = new Cliente(nome, idade, email, telefone, dataCadastro);
		return cliente;
	}
	
	public Cliente updateCliente(Scanner teclado, ClienteController clienteController, String idCliente) {
		String nome,telefone, email;
		int idade;
		boolean existe = false;
		// >>>>>>>>>>>> NOME <<<<<<<<<<<<<<<<<<<<<
		do {	
		System.out.println("\n\nInforme o nome: ");
		//teclado.nextLine();
		nome = teclado.nextLine();
		if(nome.length() > 50) {
			System.out.println("\n >> TAMANHO INVÁLIDO\n");
			System.out.println("\n >> O NOME DEVE TER NO MÁXIMO 50 CARACETERS!\n");
		}
		}while(nome.length() > 50);
		
		// >>>>>>>>>>> FIM NOME <<<<<<<<<<<<<<<<<<

		// >>>>>>>>>> IDADE <<<<<<<<<<<<<<<<
		do {
			System.out.println("\n\n >> Informe a idade >18: ");
			idade = teclado.nextInt();
			teclado.nextLine();
			if (idade < 18) {
				System.out.println(
						"\n >> IDADE INVÁLIDA!" + "\n >> O CLIENTE PRECISA SER MAIOR DE 18 ANOS!\n");
			}
		} while (idade < 18);
		// >>>>>>>>> FIM IDADE <<<<<<<<<<<<<

		// >>>>>>>> EMAIL <<<<<<<<<<<<
		do {
			System.out.println("\n\n >> Informe o email: ");
			email = teclado.nextLine();
			if (email.length() > 50) {
				System.out.println("\n >> TAMANHO INVÁLIDO!\n");
				System.out.println("\n >> O EMAIL DEVE TER NO MÁXIMO 50 CARACTERES!\n");
			} else {
				if(verificaEmailUpdate(clienteController, idCliente, email)) {
					existe = false;
				}else {
					existe = verificarEmail(email, clienteController);
				}
			}
		} while (existe || email.length() > 50);
		// >>>>>>>> FIM EMAIL <<<<<<<<<<<<<<<<<<<

		// >>>>>>>>>> TELEFONE <<<<<<<<<<<<<<<
		do {
			System.out.println("\n\n >> Informe o telefone: ");
			telefone = teclado.nextLine();
			if (telefone.length() > 15) {
				System.out.println("\n >> TAMANHO INVÁLIDO!\n");
				System.out.println("\n >> O TELEFONE DEVE TER NO MÁXIMO 15 CARACTERES!\n");
			} else {
				if(verificaTelefoneUpdate(clienteController, idCliente, telefone)) {
					existe = false;
				}else {
					existe = verificarTelefone(telefone, clienteController);
				}
			}
		} while (existe || telefone.length() > 15);
		// >>>>>>>>>>> FIM TELEFONE <<<<<<<<<<<<<<
		Date dataCadastro = new Date();
		
		// >>>>>>>>>>> CRIAÇÃO DO CLIENTE <<<<<<<<<<<<<<<<
		Cliente cliente = new Cliente(nome, idade, email, telefone, dataCadastro);
		return cliente;
	}
	
	public boolean verificaTelefoneUpdate(ClienteController clienteController, String idCliente, String telefoneInformado){
		String telefoneJaRegistrado = null;
		for(Cliente c: clienteController.listarClientes()) {
			
			if(c.getIdCliente().trim().equalsIgnoreCase(idCliente.trim())) {
				telefoneJaRegistrado = c.getTelefone();
				break;
			}
		}
		if(telefoneJaRegistrado.equals(telefoneInformado)) {
			return true;
		}
		return false;
	}
	
	public boolean verificaEmailUpdate(ClienteController clienteController, String idCliente, String emailInformado){
		String emailJaRegistrado = null;
		for(Cliente c: clienteController.listarClientes()) {
			
			if(c.getIdCliente().trim().equalsIgnoreCase(idCliente.trim())) {
				emailJaRegistrado = c.getEmail();
				break;
			}
		}
		if(emailJaRegistrado.equals(emailInformado)) {
			return true;
		}
		return false;
	}
	
	
}
