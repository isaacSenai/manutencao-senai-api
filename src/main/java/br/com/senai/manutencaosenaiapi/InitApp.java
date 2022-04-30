package br.com.senai.manutencaosenaiapi;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

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
import br.com.senai.manutencaosenaiapi.repository.PecasRepository;
import br.com.senai.manutencaosenaiapi.repository.TecnicosRepository;
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
	
	@Autowired
	private PecasRepository pecasRepository;
	
	@Autowired
	private TecnicosRepository tecnicosRepository;
	
	@Transactional
	@Bean	
	public CommandLineRunner commandLineRunner(ApplicationContext ac) {
		return args -> {
			try {
				/*Peca novaPeca = new Peca();
				novaPeca.setDescricao("Placa Mãe Gigabit");
				novaPeca.setEspecificacoes("Boa placa");
				novaPeca.setQtdeEmEstoque(10);
				Peca pecaSalva = this.pecasRepository.save(novaPeca);
				System.out.println("Id da peça: " + pecaSalva.getId());*/
				
				/*Optional<Peca> pecaEncomtrada = pecasRepository.findById(7);
				
				pecasRepository.delete(pecaEncomtrada.get());
				
				System.out.println("Peça encontrada: " + pecaEncomtrada.get().getId());*/
				
				/*
				pecaEncomtrada.get().setEspecificacoes("Especificação alterada");
				Peca pecaAterada = pecasRepository.save(pecaEncomtrada.get());
				
				System.out.println(pecaAterada);
				
				if (pecaEncomtrada.isPresent()) {
					System.out.println("Peça encontrada: " + pecaEncomtrada);
				}*/
				
				/*List<Peca> pecasEncontradas = pecasRepository.listarPor("%p%");
				
				pecasEncontradas.forEach(peca -> {
					System.out.println("peça encontradas; " + peca);
				});
				
				for (Peca peca : pecasEncontradas) {
					System.out.println("Peça do banco: " + peca);
				}*/
				
				Tecnico novoTecnico = new Tecnico();
				novoTecnico.setNomeCompleto("joilscliudisom");
				novoTecnico.setDataDeAdmissao(LocalDate.of(2021, 4, 29));
				this.tecnicosRepository.save(novoTecnico);
				
			}catch (Exception e) {
				System.out.println(e.getMessage());
			}
			
		};
	}
	
	@Transactional
	public void remover() {
		this.tecnicosRepository.deleTarPor();
	}

}
