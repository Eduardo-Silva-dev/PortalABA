package com.portalaba.apirest.service;

import java.text.ParseException;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.portalaba.apirest.domain.Acompanhante;
import com.portalaba.apirest.domain.Analista;
import com.portalaba.apirest.domain.Endereco;
import com.portalaba.apirest.domain.Paciente;

import com.portalaba.apirest.repository.AcompanhanteRepository;
import com.portalaba.apirest.repository.AnalistaRepository;
import com.portalaba.apirest.repository.PacienteRepository;

@Service
public class DBService {
	
	@Autowired
	private PacienteRepository pacienteRepository;
	
	@Autowired
	private AnalistaRepository analistaRepository;
	
	@Autowired
	private AcompanhanteRepository acompanhanteRepository;
	
	public void instantiateTestDatabase() throws ParseException{
		
		
//		Analista analista1 = new Analista("senha1","analista1",new Date(System.currentTimeMillis()),"Analista1","analista1@gmail.com","75763196236","83988881234","1324","52111407000190");
//		
//		Analista analista2 = new Analista("senha2","analista2",new Date(System.currentTimeMillis()),"Analista2","analista2@gmail.com","46387229111","83988880000","4564","44779594000156");
//		
//		Analista analista3 = new Analista("senha3","analista3",new Date(System.currentTimeMillis()),"Analista3","analista3@gmail.com","16413361530","83988889876","9874","12133534000175");
//		
//		Analista analista4 = new Analista("senha4","analista4",new Date(System.currentTimeMillis()),"Analista4","analista4@gmail.com","78254723818","83988887894","2130","62348757000128");
//		
//		Analista analista5 = new Analista("senha5","analista5",new Date(System.currentTimeMillis()),"Analista5","analista5@gmail.com","87495131683","83988880123","4060","40876082000157");
//		
//		Endereco e1 = new Endereco("Avenida Cabo Branco", "Apto 300", "Cabo Branco", "58045010", "300", "Joao Pessoa","PB",analista1);
//		Endereco e2 = new Endereco("Rua São Domingos", "", "Bom Jesus", "91420270", "50", "Porto Alegre","RS",analista2);
//		Endereco e3 = new Endereco("Acesso Olavo Domingos de Oliveira", "proximo ao colegio X", "Jardim Carvalho", "91540650", "85", "Porto Alegre","RS",analista3);
//		Endereco e4 = new Endereco("Praça Domingos Fernandes de Souza", "Sem numero", "Cavalhada", "91740650", "", "Porto Alegre","RS",analista4);
//		Endereco e5 = new Endereco("Rua Irene Alvez P. Celani", "", "Mangabeira", "58058340", "80", "Joao Pessoa","PB",analista5);
//		
//		analista1.setEnderecos(e1);
//		analista2.setEnderecos(e2);
//		analista3.setEnderecos(e3);
//		analista4.setEnderecos(e4);
//		analista5.setEnderecos(e5);
//		
//		analistaRepository.save(analista1);
//		analistaRepository.save(analista2);
//		analistaRepository.save(analista3);
//		analistaRepository.save(analista4);
//		analistaRepository.save(analista5);
//
//		Acompanhante acompanhante1 = new Acompanhante("senha1","acompanhante1",new Date(System.currentTimeMillis()),"Acompanhante1","acompanhante1@gmail.com","75763196236","83988881234","1324");
//		
//		Acompanhante acompanhante2 = new Acompanhante("senha2","acompanhante2",new Date(System.currentTimeMillis()),"Acompanhante2","acompanhante2@gmail.com","46387229111","83988880000","4564");
//		
//		Acompanhante acompanhante3 = new Acompanhante("senha3","acompanhante3",new Date(System.currentTimeMillis()),"Acompanhante3","acompanhante3@gmail.com","16413361530","83988889876","9874");
//		
//		Acompanhante acompanhante4 = new Acompanhante("senha4","acompanhante4",new Date(System.currentTimeMillis()),"Acompanhante4","acompanhante4@gmail.com","78254723818","83988887894","2130");
//		
//		Acompanhante acompanhante5 = new Acompanhante("senha5","acompanhante5",new Date(System.currentTimeMillis()),"Acompanhante5","acompanhante5@gmail.com","87495131683","83988880123","4060");
//		
//		Endereco e6 = new Endereco("Avenida Cabo Branco", "Apto 300", "Cabo Branco", "58045010", "300", "Joao Pessoa","PB",acompanhante1);
//		Endereco e7 = new Endereco("Rua São Domingos", "", "Bom Jesus", "91420270", "50", "Porto Alegre","RS",acompanhante2);
//		Endereco e8 = new Endereco("Acesso Olavo Domingos de Oliveira", "proximo ao colegio X", "Jardim Carvalho", "91540650", "85", "Porto Alegre","RS",acompanhante3);
//		Endereco e9 = new Endereco("Praça Domingos Fernandes de Souza", "Sem numero", "Cavalhada", "91740650", "", "Porto Alegre","RS",acompanhante4);
//		Endereco e10 = new Endereco("Rua Irene Alvez P. Celani", "", "Mangabeira", "58058340", "80", "Joao Pessoa","PB",acompanhante5);
//		
//		acompanhante1.setEnderecos(e6);
//		acompanhante2.setEnderecos(e7);
//		acompanhante3.setEnderecos(e8);
//		acompanhante4.setEnderecos(e9);
//		acompanhante5.setEnderecos(e10);
//		
//		acompanhanteRepository.save(acompanhante1);
//		acompanhanteRepository.save(acompanhante2);
//		acompanhanteRepository.save(acompanhante3);
//		acompanhanteRepository.save(acompanhante4);
//		acompanhanteRepository.save(acompanhante5);
//
//		Paciente paciente1 = new Paciente("senha1","paciente1",new Date(System.currentTimeMillis()),"responsavel1",new Date(System.currentTimeMillis()),"Responsavel1@gmail.com","75763196236","83988888888","83988888888","leve");
//		
//		Paciente paciente2 = new Paciente("senha2","paciente2",new Date(System.currentTimeMillis()),"responsavel2",new Date(System.currentTimeMillis()),"Responsavel2@gmail.com","46387229111","83911110000","83911110000","medio");
//		
//		Paciente paciente3 = new Paciente("senha3","paciente3",new Date(System.currentTimeMillis()),"responsavel3",new Date(System.currentTimeMillis()),"Responsavel3@gmail.com","16413361530","98998235540","98998235540","alto");
//		
//		Paciente paciente4 = new Paciente("senha4","paciente4",new Date(System.currentTimeMillis()),"responsavel4",new Date(System.currentTimeMillis()),"Responsavel4@gmail.com","78254723818","1132405235","1132405235","alto");
//		
//		Paciente paciente5 = new Paciente("senha5","paciente5",new Date(System.currentTimeMillis()),"responsavel5",new Date(System.currentTimeMillis()),"Responsavel5@gmail.com","87495131683","2132105412","2132105412","leve");
//		
//		Endereco e11 = new Endereco("Avenida Cabo Branco", "Apto 300", "Cabo Branco", "58045010", "300",paciente1, "Joao Pessoa","PB");
//		Endereco e12 = new Endereco("Rua São Domingos", "", "Bom Jesus", "91420270", "50",paciente1,"Porto Alegre","RS");
//		Endereco e13 = new Endereco("Acesso Olavo Domingos de Oliveira", "proximo ao colegio X", "Jardim Carvalho", "91540650", "85",paciente1, "Porto Alegre","RS");
//		Endereco e14 = new Endereco("Praça Domingos Fernandes de Souza", "Sem numero", "Cavalhada", "91740650", "",paciente1, "Porto Alegre","RS");
//		Endereco e15 = new Endereco("Rua Irene Alvez P. Celani", "", "Mangabeira", "58058340", "80",paciente1, "Joao Pessoa","PB");
//		
//		paciente1.setEnderecos(e11);
//		paciente2.setEnderecos(e12);
//		paciente3.setEnderecos(e13);
//		paciente4.setEnderecos(e14);
//		paciente5.setEnderecos(e15);
//		
//		pacienteRepository.save(paciente1);
//		pacienteRepository.save(paciente2);
//		pacienteRepository.save(paciente3);
//		pacienteRepository.save(paciente4);
//		pacienteRepository.save(paciente5);
	}
	
}
