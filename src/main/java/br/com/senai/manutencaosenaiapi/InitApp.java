package br.com.senai.manutencaosenaiapi;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.integration.IntegrationProperties.RSocket.Client;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

import br.com.senai.manutencaosenaiapi.entity.Cliente;
import br.com.senai.manutencaosenaiapi.entity.OrdemDeServico;
import br.com.senai.manutencaosenaiapi.entity.Peca;
import br.com.senai.manutencaosenaiapi.entity.Sexo;
import br.com.senai.manutencaosenaiapi.entity.Tecnico;
import br.com.senai.manutencaosenaiapi.service.ClienteService;
import br.com.senai.manutencaosenaiapi.service.OrdemDeServicoService;
import br.com.senai.manutencaosenaiapi.service.PecaService;
import br.com.senai.manutencaosenaiapi.service.TecnicoService;

@SpringBootApplication
public class InitApp {

	public static void main(String[] args) {
		SpringApplication.run(InitApp.class, args);
		
	}
	
	@Autowired
	private TecnicoService service;
	
	@Autowired
	private ClienteService clienteService;
	
	@Autowired
	private PecaService pecaService;
	
	@Autowired
	private OrdemDeServicoService ordemDeService;
	
	@Bean	
	public CommandLineRunner commandLineRunner(ApplicationContext ac) {
		return args -> {
			try {
				OrdemDeServico novaOrdem = new OrdemDeServico();
				novaOrdem.setDescricaoDoProbelma("problema");
				Cliente cliente = new Cliente();
				cliente.setId(1);
				novaOrdem.setCliente(cliente);
				novaOrdem.setDataDeAbertura(LocalDate.now());
				Tecnico tecnico = new Tecnico();
				tecnico.setId(1);
				novaOrdem.setTecnico(tecnico);
				Peca peca = new Peca();
				//peca.setId(1);
				List<Peca> pecas = new ArrayList<Peca>();
				pecas.add(peca);
				novaOrdem.setPecasDoReparos(pecas);
				this.ordemDeService.inserir(novaOrdem);
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
				this.clienteService.inserir(novoCliente);
				System.out.println("Cliente salvo com sucesso");*/
				
				/*Peca novaPeca = new Peca();
				novaPeca.setDescricao("teclado");
				novaPeca.setEspecificacoes(18);
				System.out.println("fffffff");*/
				
				
			}catch (Exception e) {
				System.out.println(e.getMessage());
			}
			
		};
	}

}
