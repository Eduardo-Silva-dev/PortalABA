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
	
	public void instantiateTestDatabase() throws ParseException{
		try {
		EmpresaNewDTO objDto = new EmpresaNewDTO("administrador","53284124000102","Eduardo,Alex","corporação capsula","Backend Eduardo",
				"8332144021","83998232040","suporte.portalaba@gmail.com","Av. teste","",
				"mangabeira","58058340","90","joão pessoa","pb");
		Empresa obj = empresaService.fromDTO(objDto);
		obj.setPerfil("ADMIN");
		obj = empresaService.insert(obj);
		
		/*AnalistaNewDTO objDto1 = new AnalistaNewDTO("administrador","53284124000102","Eduardo,Alex","corporação capsula","Backend Eduardo",
				"8332144021","83998232040","suporte.portalaba@gmail.com","Av. teste","",
				"mangabeira","58058340","90","joão pessoa","pb");
		Analista obj1 = analistaService.fromDTO(objDto1);
		analistaService.insert(obj1);
		
		AcompanhanteNewDTO objDto = new AcompanhanteNewDTO("administrador","53284124000102","Eduardo,Alex","corporação capsula","Backend Eduardo",
				"8332144021","83998232040","suporte.portalaba@gmail.com","Av. teste","",
				"mangabeira","58058340","90","joão pessoa","pb");
		Acompanhante obj = acompanhanteService.fromDTO(objDto);
		acompanhanteService.insert(obj);
		
		PacienteNewDTO objDto3 = new PacienteNewDTO("administrador","53284124000102","Eduardo,Alex","corporação capsula","Backend Eduardo",
				"8332144021","83998232040","suporte.portalaba@gmail.com","Av. teste","",
				"mangabeira","58058340","90","joão pessoa","pb");
		Paciente obj3 = pacienteService.fromDTO(objDto3);
		pacienteService.insert(obj3);*/
		}catch (Exception e) {

		}
	}
	
}
