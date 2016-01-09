package ar.com.conexia.service.impl;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ResourceBundle;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

import ar.com.conexia.service.UnZipService;
import ar.com.conexia.util.AlfabetaUtil;

public class UnZipServiceImpl implements UnZipService{
		    
	public void descomprimirManExtra(String numeroArchivo) {
		
		ResourceBundle rb = ResourceBundle.getBundle("properties.vademecum");
		
		String path = rb.getString("vademecum.path");
		
		String zipManExtra = AlfabetaUtil.obtenerArchivoDiarioManExtra(numeroArchivo);
		String outPutZip = "C:"+File.separator+path;
//		String outPutZip = path;
		
		String inputZipFile = "C:"+File.separator+path+File.separator+zipManExtra;
//		String inputZipFile = path+File.separator+zipManExtra;
				
		byte[] buffer = new byte[1024];
		 
	     try{
	 
	    	//create output directory is not exists
	    	File folder = new File(outPutZip);
	    	if(!folder.exists()){
	    		folder.mkdir();
	    	}
	 
	    	//get the zip file content
	    	ZipInputStream zis = 
	    		new ZipInputStream(new FileInputStream(inputZipFile));
	    	//get the zipped file list entry
	    	ZipEntry ze = zis.getNextEntry();
	 
	    	while(ze!=null){
	 
	    	   String fileName = ze.getName();
	           File newFile = new File(outPutZip + File.separator + fileName);
	 
	           System.out.println("file unzip : "+ newFile.getAbsoluteFile());
	 
	            //create all non exists folders
	            //else you will hit FileNotFoundException for compressed folder
	            new File(newFile.getParent()).mkdirs();
	 
	            FileOutputStream fos = new FileOutputStream(newFile);             
	 
	            int len;
	            while ((len = zis.read(buffer)) > 0) {
	       		fos.write(buffer, 0, len);
	            }
	 
	            fos.close();   
	            ze = zis.getNextEntry();
	    	}
	 
	        zis.closeEntry();
	    	zis.close();
	 
	    	System.out.println("Se descomprimo ManExtra");
	    	
	    	File file = new File(inputZipFile);
            if(file.delete()){
            	System.out.println("Se borro el archivo descargado: "+file.getName());
            }
            else{
            	System.out.println("Error al borrar archivo descargado....");
            }
	 
	    }catch(IOException ex){
	       ex.printStackTrace(); 
	    }
		
	}

	public void descomprimirManualDat(String numeroArchivo) {
		
		ResourceBundle rb = ResourceBundle.getBundle("properties.vademecum");
		
		String path = rb.getString("vademecum.path");
		
		String zipManualDat = AlfabetaUtil.obtenerArchivoDiarioManualDat(numeroArchivo);
		String outPutZip = "C:"+File.separator+path;
//		String outPutZip = path;
		
		String inputZipFile = "C:"+File.separator+path+File.separator+zipManualDat;
//		String inputZipFile = path+File.separator+zipManualDat;
				
		byte[] buffer = new byte[1024];
		 
	     try{
	 
	    	//create output directory is not exists
	    	File folder = new File(outPutZip);
	    	if(!folder.exists()){
	    		folder.mkdir();
	    	}
	 
	    	//get the zip file content
	    	ZipInputStream zis = 
	    		new ZipInputStream(new FileInputStream(inputZipFile));
	    	//get the zipped file list entry
	    	ZipEntry ze = zis.getNextEntry();
	 
	    	while(ze!=null){
	 
	    	   String fileName = ze.getName();
	           File newFile = new File(outPutZip + File.separator + fileName);
	 
	           System.out.println("file unzip : "+ newFile.getAbsoluteFile());
	 
	            //create all non exists folders
	            //else you will hit FileNotFoundException for compressed folder
	            new File(newFile.getParent()).mkdirs();
	 
	            FileOutputStream fos = new FileOutputStream(newFile);             
	 
	            int len;
	            while ((len = zis.read(buffer)) > 0) {
	       		fos.write(buffer, 0, len);
	            }
	 
	            fos.close();   
	            ze = zis.getNextEntry();
	    	}
	 
	        zis.closeEntry();
	    	zis.close();
	 
	    	System.out.println("Se descomprimo ManualDat");
	    	
	    	File file = new File(inputZipFile);
            if(file.delete()){
            	System.out.println("Se borro el archivo descargado:" +file.getName());
            }
            else{
            	System.out.println("Error al borrar archivo descargado....");
            }
	 
	    }catch(IOException ex){
	       ex.printStackTrace(); 
	    }

		
	}

}
