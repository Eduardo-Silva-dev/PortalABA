package com.portalaba.apirest.service;

import java.text.ParseException;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.portalaba.apirest.domain.Empresa;
import com.portalaba.apirest.dto.EmpresaNewDTO;

@Service
public class DBService {
	
	@Autowired
	private EmpresaService empresaService;
	
	public void instantiateTestDatabase() throws ParseException{
		
		EmpresaNewDTO objDto = new EmpresaNewDTO("administrador","53284124000102","Eduardo,Alex","corporação capsula","Backend Eduardo",
				"8332144021","83998232040","suporte.portalaba@gmail.com","Av. teste","",
				"mangabeira","58058340","90","joão pessoa","pb");
		Empresa obj = empresaService.fromDTO(objDto);
		obj.setPerfil("ADMIN");
		obj = empresaService.insert(obj);
	}
	
}
