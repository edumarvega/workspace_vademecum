package ar.com.conexia.service.impl;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.net.URLConnection;
import java.util.ResourceBundle;

import ar.com.conexia.service.DescargaService;
import ar.com.conexia.util.AlfabetaUtil;

public class DescargaServiceImpl implements DescargaService{

	final static int size=1024;

	public void descargarManExtraDiario(String numeroArchivo) {
		
		System.out.println("Descargando ManExtra...");
		
		String direccionDescarga = AlfabetaUtil.obtenerUrlDescargaDiariaManExtra(numeroArchivo);
		System.out.println("Direccion de descarga: "+direccionDescarga);
		
		ResourceBundle rb = ResourceBundle.getBundle("properties.vademecum");
		
		String path = rb.getString("vademecum.path");
		
		String destino = "C:"+File.separator+path;
//		String destino = path;
		
		OutputStream outStream = null;
		URLConnection  urlConnection = null;
		InputStream is = null;

		try {
			URL url;
			byte[] buf;
			int byteLectura,byteEscritura=0;
			url= new URL(direccionDescarga);
								
			String nombreArchivo = AlfabetaUtil.obtenerArchivoDiarioManExtra(numeroArchivo);
			
			System.out.println("Nombre del archivo: " +nombreArchivo);
						
			File file = new File(destino+File.separator+nombreArchivo);
			file.createNewFile();
			
			outStream = new BufferedOutputStream(new FileOutputStream(destino+File.separator+nombreArchivo));
			urlConnection = url.openConnection();
			is = urlConnection.getInputStream();
			buf = new byte[size];
			
			while ((byteLectura = is.read(buf)) != -1) {
				outStream.write(buf, 0, byteLectura);
				byteEscritura += byteLectura;
			}
			System.out.println("Se descargo el archivo!!!");
			System.out.println("Bytes descargados: " +byteEscritura);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			try {
				is.close();
				outStream.close();
			}
			catch (IOException e) {
				e.printStackTrace();
			}
		}

		
	}


	public void descargarManualDatDiario(String numeroArchivo) {
		
		
		System.out.println("Descargando ManualDat...");
		
		String direccionDescarga = AlfabetaUtil.obtenerUrlDescargaDiariaManualDat(numeroArchivo);
		System.out.println("Direccion de descarga: "+direccionDescarga);
		
		ResourceBundle rb = ResourceBundle.getBundle("properties.vademecum");
		
		String path = rb.getString("vademecum.path");
		
		String destino = "C:"+File.separator+path;
//		String destino = path;
		
		OutputStream outStream = null;
		URLConnection  urlConnection = null;
		InputStream is = null;

		try {
			URL url;
			byte[] buf;
			int byteLectura,byteEscritura=0;
			url= new URL(direccionDescarga);
						
			String nombreArchivo = AlfabetaUtil.obtenerArchivoDiarioManualDat(numeroArchivo);
			
			System.out.println("Nombre del archivo: " +nombreArchivo);
						
			File file = new File(destino+File.separator+nombreArchivo);
			file.createNewFile();
			
			outStream = new BufferedOutputStream(new FileOutputStream(destino+File.separator+nombreArchivo));
			urlConnection = url.openConnection();
			is = urlConnection.getInputStream();
			buf = new byte[size];
			
			while ((byteLectura = is.read(buf)) != -1) {
				outStream.write(buf, 0, byteLectura);
				byteEscritura += byteLectura;
			}
			System.out.println("Se descargo el archivo!!!");
			System.out.println("Bytes descargados: " +byteEscritura);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			try {
				is.close();
				outStream.close();
			}
			catch (IOException e) {
				e.printStackTrace();
			}
		}



		
	}






	
		
	

}
