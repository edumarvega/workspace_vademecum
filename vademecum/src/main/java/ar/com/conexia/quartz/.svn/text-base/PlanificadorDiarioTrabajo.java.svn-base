package ar.com.conexia.quartz;
 
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.scheduling.quartz.QuartzJobBean;
 
public class PlanificadorDiarioTrabajo extends QuartzJobBean
{
	private PlanificadorDiarioTarea planificadorDiarioTarea;

	public void setPlanificadorDiarioTarea(PlanificadorDiarioTarea planificadorDiarioTarea) {
		this.planificadorDiarioTarea = planificadorDiarioTarea;
	}

	protected void executeInternal(JobExecutionContext context)	throws JobExecutionException {
 
		planificadorDiarioTarea.descargarArchivos();
 
	}
}