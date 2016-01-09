package ar.com.conexia.quartz;

import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;

import ar.com.conexia.modelo.ArchivoAlfabeta;
import ar.com.conexia.service.ArchivoAlfabetaService;
import ar.com.conexia.service.DescargaService;
import ar.com.conexia.service.UnZipService;
import ar.com.conexia.util.AlfabetaUtil;
 
public class PlanificadorDiarioTarea{
	
	private MailSender mailSender;
	private DescargaService descargaService;
	private ArchivoAlfabetaService archivoAlfabetaService;
	private UnZipService unZipService;
	
	
	public void setMailSender(MailSender mailSender) {
		this.mailSender = mailSender;
	}
			
	public DescargaService getDescargaService() {
		return descargaService;
	}
	public void setDescargaService(DescargaService descargaService) {
		this.descargaService = descargaService;
	}
			
	public ArchivoAlfabetaService getArchivoAlfabetaService() {
		return archivoAlfabetaService;
	}

	public void setArchivoAlfabetaService(
			ArchivoAlfabetaService archivoAlfabetaService) {
		this.archivoAlfabetaService = archivoAlfabetaService;
	}
		

	public UnZipService getUnZipService() {
		return unZipService;
	}

	public void setUnZipService(UnZipService unZipService) {
		this.unZipService = unZipService;
	}

	public void sendMail(String from, String to, String subject, String msg) {
		 
		SimpleMailMessage message = new SimpleMailMessage();
 
		message.setFrom(from);
		message.setTo(to);
		message.setSubject(subject);
		message.setText(msg);
		
		mailSender.send(message);
	}	
	
	public void descargarArchivos() {
		
		System.out.println("Iniciando descarga de archivos de alfabeta....");
	
		try{
			
			ArchivoAlfabeta manExtra = null;
			ArchivoAlfabeta manualDat = null;
			
			String numeroArchivo = archivoAlfabetaService.obtenerUltimoArchivoDescargado();
//			String numeroArchivo = "15275";
			descargaService.descargarManExtraDiario(numeroArchivo);
			descargaService.descargarManualDatDiario(numeroArchivo);
			
			unZipService.descomprimirManExtra(numeroArchivo);
			unZipService.descomprimirManualDat(numeroArchivo);
			
			manExtra = AlfabetaUtil.prepararManExtra(numeroArchivo);
			archivoAlfabetaService.grabarArchivoAlfabeta(manExtra);
			
			manualDat = AlfabetaUtil.prepararManualDat(numeroArchivo);
			archivoAlfabetaService.grabarArchivoAlfabeta(manualDat);
			
			
			this.sendMail("vademecumconexia@gmail.com", "mvega@conexia.com.ar", 
				"Descarga exitosa - Seros-Vedemecum Conexia", "Haciendo pruebas desde vademecum-conexia, http://192.168.150.83:8080/vademecum/home.do");
				
		}
		catch(Exception e){
			e.printStackTrace();
			this.sendMail("vademecumconexia@gmail.com", "mvega@conexia.com.ar", 
				"[ERROR] - Seros-Vademecum Conexia", "Se produjo un error al descargar los archivos: "+e.toString());
		}
	}
}