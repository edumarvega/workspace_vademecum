package ar.com.conexia.service.impl;

import ar.com.conexia.dao.ArchivoAlfabetaDAO;
import ar.com.conexia.modelo.ArchivoAlfabeta;
import ar.com.conexia.service.ArchivoAlfabetaService;

public class ArchivoAlfabetaServiceImpl implements ArchivoAlfabetaService{

	private ArchivoAlfabetaDAO archivoAlfabetaDAO;
		
	public ArchivoAlfabetaDAO getArchivoAlfabetaDAO() {
		return archivoAlfabetaDAO;
	}

	public void setArchivoAlfabetaDAO(ArchivoAlfabetaDAO archivoAlfabetaDAO) {
		this.archivoAlfabetaDAO = archivoAlfabetaDAO;
	}

	public void grabarArchivoAlfabeta(ArchivoAlfabeta archivoAlfabeta) {
		
		archivoAlfabetaDAO.grabarArchivoAlfabeta(archivoAlfabeta);
			
	}
	
	public String obtenerUltimoArchivoDescargado() {
	
		String numeroArchivo = archivoAlfabetaDAO.obtenerUltimoArchivoDescargado();
		
		return numeroArchivo;
		
	}

}
