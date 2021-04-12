package es.senda.preguntas.model;

import javax.persistence.Column;

import org.springframework.hateoas.ResourceSupport;

public class ConvocatoriaResource extends ResourceSupport {

	public final Long idConvocatoria;
	public final String tipo;
	public final int anyoOep;
	public final int anyoExamen;
	public final String origen;
	public final int numPlazas;
	public final String url;
	public final String modalidad;
    
    public ConvocatoriaResource (final Convocatoria convocatoria) {
    	this.idConvocatoria = convocatoria.getIdConvocatoria();
    	this.tipo = convocatoria.getTipo();
    	this.anyoOep = convocatoria.getAnyoOep();
    	this.anyoExamen = convocatoria.getAnyoExamen();
    	this.origen = convocatoria.getOrigen();
    	this.numPlazas = convocatoria.getNumPlazas();
    	this.url = convocatoria.getUrl();
    	this.modalidad = convocatoria.getModalidad();
    }
    

}
