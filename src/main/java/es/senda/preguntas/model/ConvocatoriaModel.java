package es.senda.preguntas.model;

import java.util.ArrayList;
import java.util.List;

public class ConvocatoriaModel {

	public final Long idConvocatoria;
	public final String tipo;
	public final int anyoOep;
	public final int anyoExamen;
	public final String origen;
	public final int numPlazas;
	public final String url;
	public final String modalidad;
    
    public ConvocatoriaModel (final Convocatoria convocatoria) {
    	this.idConvocatoria = convocatoria.getIdConvocatoria();
    	this.tipo = convocatoria.getTipo();
    	this.anyoOep = convocatoria.getAnyoOep();
    	this.anyoExamen = convocatoria.getAnyoExamen();
    	this.origen = convocatoria.getOrigen();
    	this.numPlazas = convocatoria.getNumPlazas();
    	this.url = convocatoria.getUrl();
    	this.modalidad = convocatoria.getModalidad();
    }
    
	
	public static List<ConvocatoriaModel> toModel(List<Convocatoria> convocatorias){
		List<ConvocatoriaModel> convocatoriasModel = new ArrayList<ConvocatoriaModel>();
		for (Convocatoria convocatoria:convocatorias) {
			convocatoriasModel.add(new ConvocatoriaModel(convocatoria));
		}
		return convocatoriasModel;
	}

}
