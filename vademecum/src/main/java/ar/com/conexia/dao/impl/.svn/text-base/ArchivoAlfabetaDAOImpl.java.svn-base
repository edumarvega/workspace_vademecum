package ar.com.conexia.dao.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.dao.DataAccessException;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import ar.com.conexia.dao.ArchivoAlfabetaDAO;
import ar.com.conexia.modelo.ArchivoAlfabeta;
import ar.com.conexia.util.AlfabetaUtil;

public class ArchivoAlfabetaDAOImpl extends HibernateDaoSupport implements ArchivoAlfabetaDAO{
	
	public void grabarArchivoAlfabeta(ArchivoAlfabeta archivoAlfabeta) {
	
		try{
			getHibernateTemplate().save(archivoAlfabeta);
		}
		catch(DataAccessException dae){
			dae.printStackTrace();
		}
		
	}

	
	public String obtenerUltimoArchivoDescargado() {
		
		String numeroArchivo=null;

		try{
			Long fechaArchivoDescargado = AlfabetaUtil.obtenerFechaCriteria();
			
			DetachedCriteria criteria = DetachedCriteria.forClass(ArchivoAlfabeta.class);
		    criteria.add(Restrictions.eq("fecha", fechaArchivoDescargado));
				
					 
			Collection lista = getHibernateTemplate().findByCriteria(criteria);
			List listaArchivos = new ArrayList(lista);
					
			int cantidadRegistros = listaArchivos.size();
			int posicionRegistro = cantidadRegistros-1;
		
			
			ArchivoAlfabeta archivoAlfabeta = (ArchivoAlfabeta) listaArchivos.get(posicionRegistro);
			Long numeroArchivoBd =archivoAlfabeta.getNumero();

			numeroArchivo = String.valueOf(numeroArchivoBd.intValue());

		}
		catch(DataAccessException dae){
			dae.printStackTrace();
		}
						
		
		return numeroArchivo;
		
	}

}
