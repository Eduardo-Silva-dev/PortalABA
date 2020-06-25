package com.portalaba.apirest.service;

import java.text.ParseException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.portalaba.apirest.domain.Acompanhante;
import com.portalaba.apirest.domain.Analista;
import com.portalaba.apirest.domain.Empresa;
import com.portalaba.apirest.domain.Paciente;
import com.portalaba.apirest.dto.AcompanhanteNewDTO;
import com.portalaba.apirest.dto.AnalistaNewDTO;
import com.portalaba.apirest.dto.EmpresaNewDTO;
import com.portalaba.apirest.dto.PacienteNewDTO;
import com.portalaba.apirest.repository.AcompanhanteRepository;
import com.portalaba.apirest.repository.AnalistaRepository;
import com.portalaba.apirest.repository.EmpresaRepository;
import com.portalaba.apirest.repository.PacienteRepository;

@Service
public class DBService {
	
	@Autowired
	private EmpresaService empresaService;	
	
	@Autowired
	private AnalistaService analistaService;	
	
	@Autowired
	private AcompanhanteService acompanhanteService;
	
	@Autowired
	private PacienteService pacienteService;
	
	@Autowired
	private EmpresaRepository repoE;	
	
	@Autowired
	private AnalistaRepository repoA;	
	
	@Autowired
	private AcompanhanteRepository repoAm;
	
	@Autowired
	private PacienteRepository repoP;
	
	public void instantiateTestDatabase() throws ParseException{
		
			try {
				
				EmpresaNewDTO objDto = new EmpresaNewDTO("administrador","53284124000102","Eduardo,Alex","corporação capsula","Backend Eduardo",
						"8332144021","83998232040","suporte.portalaba@gmail.com","Av. teste","",
						"mangabeira","58058340","90","joão pessoa","pb");
				Empresa obj = empresaService.fromDTO(objDto);
				obj.setPerfil("ADMIN");
				obj = empresaService.insert(obj);
				
				AnalistaNewDTO objDto1 = new AnalistaNewDTO("administrador", "Nicolas Mário Cauê Sales","18-03-1985", "Analista",
						"nnicolasmariocauesales@gmail.com","73012668470","83993612620","8975","68283632000143",
						"Praça Esperança","","Ernani Sátiro","58080815","783","joão pessoa","pb");
				Analista obj1 = analistaService.fromDTO(objDto1);
				analistaService.insert(obj1);
				
				AnalistaNewDTO objDto2 = new AnalistaNewDTO("administrador", "Yuri Calebe Silva","27-05-1985", "Analista",
						"yuricalebesilva_@gmail.com","63143011491","83984955586","1234","89718803000190",
						"Rua José Francisco dos Santos","","Indústrias","58083005","633","joão pessoa","pb");
				Analista obj2 = analistaService.fromDTO(objDto2);
				analistaService.insert(obj2);
				
				AnalistaNewDTO objDto3 = new AnalistaNewDTO("administrador", "Luna Sabrina Fogaça","08-01-1985", "Analista",
						"llunasabrinafogaca@gmail.com","71507633408","83981760231","6505","51376946000198",
						"Conjunto Residencial Citex","","Ernesto Geisel","58075005","189","joão pessoa","pb");
				Analista obj3 = analistaService.fromDTO(objDto3);
				analistaService.insert(obj3);
				
				AnalistaNewDTO objDto4 = new AnalistaNewDTO("administrador", "Marcos Carlos Renato Fernandes","20-11-1985", "Analista",
						"marcoscarlosrenatofernandes@gmail.com","78486188466","83996097795","7460","32814759000102",
						"Rua Procurador José Domingos Gabriel Filho","","Aeroclube","58036449","561","joão pessoa","pb");
				Analista obj4 = analistaService.fromDTO(objDto4);
				analistaService.insert(obj4);
				
				AnalistaNewDTO objDto5 = new AnalistaNewDTO("administrador", "Yuri Yago da Costa","12-11-1985", "Analista",
						"yuriyagodacosta-80@gmail.com","35034704412","83995416723","3574","12882986000150",
						"Rua Telegrafista Sá Leitão","","Treze de Maio","58025260","257","joão pessoa","pb");
				Analista obj5 = analistaService.fromDTO(objDto5);
				analistaService.insert(obj5);
				
				AcompanhanteNewDTO objDto6 = new AcompanhanteNewDTO("administrador", "Benedito Arthur Marcelo Peixoto", "11-08-1995", "Terapeuta",
					"beneditoarthurmarcelopeixoto-78@hotmail.com","25728424406", "83988618979", "0654","Rua dos Potiguaras","","Paratibe",
					"58062076","476","joão pessoa","pb");
				Acompanhante obj6 = acompanhanteService.fromDTO(objDto6);
				acompanhanteService.insert(obj6);

				AcompanhanteNewDTO objDto7 = new AcompanhanteNewDTO("administrador", "Hugo Fábio de Paula", "10-03-1995", "Terapeuta",
					"hugofabiodepaula@hotmail.com","51837026408", "83986079123", "6704","Rua Doutor Milcíades Leal","","Tambiá",
					"58020690","428","joão pessoa","pb");
				Acompanhante obj7 = acompanhanteService.fromDTO(objDto7);
				acompanhanteService.insert(obj7);

				AcompanhanteNewDTO objDto8 = new AcompanhanteNewDTO("administrador", "Silvana Luna Cláudia Moraes", "27-07-1995", "Terapeuta",
					"silvanalunaclaudiamoraes@hotmail.com","86957648427", "83982167515", "9840","Rua João Américo de Carvalho","","Alto do Mateus",
					"58090835","343","joão pessoa","pb");
				Acompanhante obj8 = acompanhanteService.fromDTO(objDto8);
				acompanhanteService.insert(obj8);

				AcompanhanteNewDTO objDto9 = new AcompanhanteNewDTO("administrador", "Erick Antonio Nogueira", "27-12-1995", "Terapeuta",
					"erickantonionogueira@hotmail.com","49660335431", "83989010493", "0354","Rua Sargento Miguel Moreno","","mangabeira",
					"58055490","575","joão pessoa","pb");
				Acompanhante obj9 = acompanhanteService.fromDTO(objDto9);
				acompanhanteService.insert(obj9);

				AcompanhanteNewDTO objDto10 = new AcompanhanteNewDTO("administrador", "Bianca Elza Silveira", "03-10-1995", "Terapeuta",
					"biancaelzasilveira-82@hotmail.com","49351400468", "83987130014", "6574","Rua Sebastião Marcondes Ramalho Travassos","","Cidade dos Colibris",
					"58073316","198","joão pessoa","pb");
				Acompanhante obj10 = acompanhanteService.fromDTO(objDto10);
				acompanhanteService.insert(obj10);
				
				PacienteNewDTO objDto11 = new PacienteNewDTO("administrador","Bárbara Patrícia Moraes","26-12-2002","Igor Yago Moraes","30-05-1972",
					"76859018461","83983705799","8327111378","Yago_Moraes@yahoo.com","Leve","Avenida Frei Agostinho","",
					"Mandacaru","58027029","607","joão pessoa","pb");
				Paciente obj11 = pacienteService.fromDTO(objDto11);
				pacienteService.insert(obj11);

				PacienteNewDTO objDto12 = new PacienteNewDTO("administrador","Ruan Sebastião Igor das Neves","01-10-2010","Ricardo Osvaldo das Neves","29-04-1971",
					"13330498463","83983388515","8338059133","RicardoOsvaldo_@yahoo.com","Medio","Alameda Faraco","",
					"Centro","58011005","880","joão pessoa","pb");
				Paciente obj12 = pacienteService.fromDTO(objDto12);
				pacienteService.insert(obj12);

				PacienteNewDTO objDto13 = new PacienteNewDTO("administrador","Heitor Márcio João Mendes","26-09-2011","Emilly Beatriz Isabelly","28-03-1970",
					"76859018461","83987873090","8337359294","Emilly_Beatriz@yahoo.com","Alta","Rua Doutor Maurílio de Almeida","",
					"João Paulo II","58076658","512","joão pessoa","pb");
				Paciente obj13 = pacienteService.fromDTO(objDto13);
				pacienteService.insert(obj13);

				PacienteNewDTO objDto14 = new PacienteNewDTO("administrador","Helena Evelyn Caldeira","03-02-2009","Vicente Nicolas João Caldeira","27-02-1969",
					"09578209410","83985976031","8337215054","Vicente.Nicolas@yahoo.com","Leve","Rua José Minervino","",
					"Oitizeiro","58027029","898","joão pessoa","pb");
				Paciente obj14 = pacienteService.fromDTO(objDto14);
				pacienteService.insert(obj14);

				PacienteNewDTO objDto15 = new PacienteNewDTO("administrador","Vinicius Juan Fernando Moraes","24-07-2008","Elias Paulo Murilo Moraes","26-01-1968",
					"39837430486","83999035303","8327204402","elias_paulo1@yahoo.com","Medio","Rua Francisco Cosme do Nascimento","",
					"Ernesto Geisel","58075431","365","joão pessoa","pb");
				Paciente obj15 = pacienteService.fromDTO(objDto15);
				pacienteService.insert(obj15);
				
				obj.getAnalistas().add(obj1);
				obj.getAnalistas().add(obj2);
				obj.getAnalistas().add(obj3);
				obj.getAnalistas().add(obj4);
				obj.getAnalistas().add(obj5);
				obj.getAcompanhantes().add(obj6);
				obj.getAcompanhantes().add(obj7);
				obj.getAcompanhantes().add(obj8);
				obj.getAcompanhantes().add(obj9);
				obj.getAcompanhantes().add(obj10);
				obj.getPacientes().add(obj11);
				obj.getPacientes().add(obj12);
				obj.getPacientes().add(obj13);
				obj.getPacientes().add(obj14);
				obj.getPacientes().add(obj15);
				
				obj1.getEmpresas().add(obj);
				obj2.getEmpresas().add(obj);
				obj3.getEmpresas().add(obj);
				obj4.getEmpresas().add(obj);
				obj5.getEmpresas().add(obj);
				obj6.getEmpresas().add(obj);
				obj7.getEmpresas().add(obj);
				obj8.getEmpresas().add(obj);
				obj9.getEmpresas().add(obj);
				obj10.getEmpresas().add(obj);
				obj11.setEmpresa(obj);
				obj12.setEmpresa(obj);
				obj13.setEmpresa(obj);
				obj14.setEmpresa(obj);
				obj15.setEmpresa(obj);
				
				repoE.save(obj);
				repoA.save(obj1);
				repoA.save(obj2);
				repoA.save(obj3);
				repoA.save(obj4);
				repoA.save(obj5);
				repoAm.save(obj6);
				repoAm.save(obj7);
				repoAm.save(obj8);
				repoAm.save(obj9);
				repoAm.save(obj10);
				repoP.save(obj11);
				repoP.save(obj12);
				repoP.save(obj13);
				repoP.save(obj14);
				repoP.save(obj15);
				
			}catch (Exception e) {

			}
	
  }
}
