package br.com.senai.manutencaosenaiapi;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.integration.IntegrationProperties.RSocket.Client;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

import br.com.senai.manutencaosenaiapi.entity.Cliente;
import br.com.senai.manutencaosenaiapi.entity.Peca;
import br.com.senai.manutencaosenaiapi.entity.Sexo;
import br.com.senai.manutencaosenaiapi.entity.Tecnico;
import br.com.senai.manutencaosenaiapi.service.ClienteService;
import br.com.senai.manutencaosenaiapi.service.TecnicoService;

@SpringBootApplication
public class InitApp {

	public static void main(String[] args) {
		SpringApplication.run(InitApp.class, args);
		
	}
	
	@Autowired
	private TecnicoService service;
	
	@Autowired
	private ClienteService ClienteService;
	
	@Bean	
	public CommandLineRunner commandLineRunner(ApplicationContext ac) {
		return args -> {
			try {
				/*Tecnico novoTecnico = new Tecnico();
				novoTecnico.setNomeCompleto("Josevildo Soares");
				LocalDate dataDeAdmissao = LocalDate.of(2022, 4, 7);
				novoTecnico.setDataDeAdmissao(dataDeAdmissao);
				this.service.inserir(novoTecnico);*/
				/*Tecnico tecnicoSalvo = new Tecnico();
				tecnicoSalvo.setId(1);
				tecnicoSalvo.setNomeCompleto("Joanecleidson");
				tecnicoSalvo.setDataDeAdmissao(LocalDate.now());
				this.service.alterar(tecnicoSalvo);
				System.out.println("Técnico salvo com sucesso");*/
				/*this.service.listarPro("josé");
				this.service.remoVerPor(0);*/
				/*Cliente novoCliente = new Cliente();
				novoCliente.setNome("joão");
				novoCliente.setSobrenome("da silva");
				novoCliente.setCpf("005.900.257-10");
				novoCliente.setSexo(Sexo.MASCULINO);
				novoCliente.setDataDeNacimento(LocalDate.of(2018, 9, 14));
				novoCliente.setEndereco("Rua sei la oq");
				this.ClienteService.inserir(novoCliente);
				System.out.println("Cliente salvo com sucesso");*/
				Peca novaPeca = new Peca();
				novaPeca.setDescricao("teclado");
				novaPeca.setEspecificacoes(1);
				System.out.println("fffffff");
			}catch (Exception e) {
				System.out.println(e.getMessage());
			}
			
		};
	}

}
