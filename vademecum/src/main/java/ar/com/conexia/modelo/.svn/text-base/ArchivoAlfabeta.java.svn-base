package ar.com.conexia.modelo;

import java.io.Serializable;
import java.sql.Timestamp;

public class ArchivoAlfabeta implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 5847198018735149523L;
	
	private Long id;
	private Long numero;
	private String tipo;
	private String tipoActualizacion;
	private Long fecha;
	private String extension;
	private Timestamp fechaInsert;
	
	public ArchivoAlfabeta(){
		
	}
	
	public ArchivoAlfabeta(Long numero,String tipo,
					String tipoActualizacion, Long fecha,String extension,Timestamp fechaInsert){
		
		this.numero = numero;
		this.tipo = tipo;
		this.tipoActualizacion = tipoActualizacion;
		this.fecha = fecha;
		this.extension= extension;
		this.fechaInsert = fechaInsert;
		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getNumero() {
		return numero;
	}

	public void setNumero(Long numero) {
		this.numero = numero;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getTipoActualizacion() {
		return tipoActualizacion;
	}

	public void setTipoActualizacion(String tipoActualizacion) {
		this.tipoActualizacion = tipoActualizacion;
	}
	
	
	public Long getFecha() {
		return fecha;
	}

	public void setFecha(Long fecha) {
		this.fecha = fecha;
	}

	public String getExtension() {
		return extension;
	}

	public void setExtension(String extension) {
		this.extension = extension;
	}

	
	public Timestamp getFechaInsert() {
		return fechaInsert;
	}

	public void setFechaInsert(Timestamp fechaInsert) {
		this.fechaInsert = fechaInsert;
	}

	public String toString(){
				
		return this.fecha+"_"+this.numero+"_"+this.tipo+"_"+this.tipoActualizacion+"."+this.extension;
		
	}

}
