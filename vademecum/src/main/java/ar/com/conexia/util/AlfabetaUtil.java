package ar.com.conexia.util;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.ResourceBundle;

import ar.com.conexia.modelo.ArchivoAlfabeta;

public class AlfabetaUtil {

	public static String obtenerUrlDescargaDiariaManExtra(String numeroArchivo){
				
		ResourceBundle rb = ResourceBundle.getBundle("properties.vademecum");
		
		String url = rb.getString("vademecum.alfabeta.url");
		String parametroUsuario = rb.getString("vademecum.alfabeta.parametro.usuario");
		String parametroPassword = rb.getString("vademecum.alfabeta.parametro.password");
		String usuarioAlfabeta = rb.getString("vademecum.alfabeta.usuario.alfabeta");
		String passwordAlfabeta = rb.getString("vademecum.alfabeta.password.alfabeta");
		String tipoArchivo = rb.getString("vademecum.alfabeta.parametro.src");
		String tipoManExtra = rb.getString("vademecum.archivo.tipo.manualextra");
		
		StringBuilder sb = new StringBuilder();
		
		sb.append(url);
		sb.append(parametroUsuario+"=");
		sb.append(usuarioAlfabeta+"&");
		sb.append(parametroPassword+"=");
		sb.append(passwordAlfabeta+"&");
		sb.append(tipoArchivo+"=");
		sb.append(tipoManExtra+"&");
		sb.append("id="+numeroArchivo);
				
		return sb.toString();
		
	}
	
	public static String obtenerUrlDescargaDiariaManualDat(String numeroArchivo){
		
		ResourceBundle rb = ResourceBundle.getBundle("properties.vademecum");
		
		String url = rb.getString("vademecum.alfabeta.url");
		String parametroUsuario = rb.getString("vademecum.alfabeta.parametro.usuario");
		String parametroPassword = rb.getString("vademecum.alfabeta.parametro.password");
		String usuarioAlfabeta = rb.getString("vademecum.alfabeta.usuario.alfabeta");
		String passwordAlfabeta = rb.getString("vademecum.alfabeta.password.alfabeta");
		String tipoArchivo = rb.getString("vademecum.alfabeta.parametro.src");
		String tipoManualDat = rb.getString("vademecum.archivo.tipo.manualdat");
		
		StringBuilder sb = new StringBuilder();
		
		sb.append(url);
		sb.append(parametroUsuario+"=");
		sb.append(usuarioAlfabeta+"&");
		sb.append(parametroPassword+"=");
		sb.append(passwordAlfabeta+"&");
		sb.append(tipoArchivo+"=");
		sb.append(tipoManualDat+"&");
		sb.append("id="+numeroArchivo);
				
		return sb.toString();
		
	}
	
	public static String obtenerArchivoDiarioManExtra(String numeroArchivo){
		
		int numero = Integer.parseInt(numeroArchivo);
		int numeroArchivoHoy =++numero;
				
		ResourceBundle rb = ResourceBundle.getBundle("properties.vademecum");
		
		String tipo = rb.getString("vademecum.archivo.tipo.manualextra");
		String actualizacionDiaria = rb.getString("vademecum.archivo.tipo.actualizacion.diaria"); 
		String extension = rb.getString("vademecum.archivo.extension");
				
		StringBuilder sb = new StringBuilder();
		
		sb.append(obtenerFechaFormateada());
		sb.append("_");
		sb.append(String.valueOf(numeroArchivoHoy));
		sb.append("_");
		sb.append(tipo);
		sb.append("_");
		sb.append(actualizacionDiaria);
		sb.append(extension);

		return sb.toString();
	}
	
	public static String obtenerArchivoDiarioManualDat(String numeroArchivo){
		
		int numero = Integer.parseInt(numeroArchivo);
		int numeroArchivoHoy =++numero;
				
		ResourceBundle rb = ResourceBundle.getBundle("properties.vademecum");
		
		String tipo = rb.getString("vademecum.archivo.tipo.manualdat");
		String actualizacionDiaria = rb.getString("vademecum.archivo.tipo.actualizacion.diaria"); 
		String extension = rb.getString("vademecum.archivo.extension");
				
		StringBuilder sb = new StringBuilder();
		
		sb.append(obtenerFechaFormateada());
		sb.append("_");
		sb.append(String.valueOf(numeroArchivoHoy));
		sb.append("_");
		sb.append(tipo);
		sb.append("_");
		sb.append(actualizacionDiaria);
		sb.append(extension);

		return sb.toString();
	}
	
		
	public static ArchivoAlfabeta prepararManExtra(String numeroArchivo){
		
		int numero = Integer.parseInt(numeroArchivo);
		int numeroArchivoHoy =++numero;
		
		ResourceBundle rb = ResourceBundle.getBundle("properties.vademecum");
		
		String tipo = rb.getString("vademecum.archivo.tipo.manualextra");
		String actualizacionDiaria = rb.getString("vademecum.archivo.tipo.actualizacion.diaria"); 
		String extension = rb.getString("vademecum.archivo.extension");
		long fecha = obtenerFechaFormateada();	
		
		ArchivoAlfabeta archivo = new ArchivoAlfabeta();
		
		archivo.setNumero(new Long(numeroArchivoHoy));
		archivo.setTipo(tipo);
		archivo.setTipoActualizacion(actualizacionDiaria);
		archivo.setFecha(new Long(fecha));
		archivo.setExtension(extension);
		archivo.setFechaInsert(obtenerFechaHoy());
		
		return archivo;
	}
	
	public static ArchivoAlfabeta prepararManualDat(String numeroArchivo){
		
		int numero = Integer.parseInt(numeroArchivo);
		int numeroArchivoHoy =++numero;
		
		ResourceBundle rb = ResourceBundle.getBundle("properties.vademecum");
		
		String tipo = rb.getString("vademecum.archivo.tipo.manualdat");
		String actualizacionDiaria = rb.getString("vademecum.archivo.tipo.actualizacion.diaria"); 
		String extension = rb.getString("vademecum.archivo.extension");
		long fecha = obtenerFechaFormateada();
		
		ArchivoAlfabeta archivo = new ArchivoAlfabeta();
		
		
		archivo.setNumero(new Long(numeroArchivoHoy));
		archivo.setTipo(tipo);
		archivo.setTipoActualizacion(actualizacionDiaria);
		archivo.setFecha(new Long(fecha));
		archivo.setExtension(extension);
		archivo.setFechaInsert(obtenerFechaHoy());
		
		return archivo;
	}
	
	public static java.sql.Timestamp obtenerFechaHoy(){
		
		java.util.Date date = new java.util.Date();
		long time= date.getTime();
		java.sql.Timestamp sqlTimestamp = new java.sql.Timestamp(time);
		
		return sqlTimestamp;
	}
	
	public static long obtenerFechaFormateada(){
		
		Date fechaActual = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
		
		String fechaFormateada = sdf.format(fechaActual);
		
		long fecha = Long.parseLong(fechaFormateada);
				
		return fecha;
	}
	
	public static Long obtenerFechaCriteria(){
    	
		int diferenciaEnDias = 0;
		
		Calendar calendar = Calendar.getInstance();
    	int diaSemana = calendar.get(Calendar.DAY_OF_WEEK);
		
		if(diaSemana==2){
			diferenciaEnDias = 3;
		}
		else{
			diferenciaEnDias = 1;
		}
					
		Date fechaActual = Calendar.getInstance().getTime();
		
		long tiempoActual = fechaActual.getTime();
		
		long dias = diferenciaEnDias * 24 * 60 * 60 * 1000;
		
		Date fechaDesde = new Date(tiempoActual - dias);
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
		
		String fechaFormateada = sdf.format(fechaDesde);
		
		long fecha = Long.parseLong(fechaFormateada);
		
		Long fechaCriteria = new Long(fecha);
		        	
    	System.out.println(fechaFormateada);
    	
    	return fechaCriteria;
    }
	
	public static Integer obtenerDiaDeSemana(){
		
		Calendar calendar = Calendar.getInstance();
    	int dia = calendar.get(Calendar.DAY_OF_WEEK);
    	
    	Integer diaSemana = new Integer(dia);
    	
    	return diaSemana;
		
	}
}
