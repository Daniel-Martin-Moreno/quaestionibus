package es.senda.preguntas.model;

import java.util.ArrayList;
import java.util.List;

public class PreguntaModel {

	public final Long idConvocatoria;
	public final Long idPregunta;
	public final String enunciado;
	public final String respuesta1;
	public final String respuesta2;
	public final String respuesta3;
	public final String respuesta4;
	public final String comentarios;
	public final int solucion;
	public final boolean anulada;
	public final long idPreguntaRef;
	public final int numero;
	public final String parte;
	public final String rutaImagen;
	public final TemaModel temas[];
	

	public PreguntaModel (final Pregunta pregunta) {
		
		this.idConvocatoria = pregunta.getConvocatoria().getIdConvocatoria();
		this.idPregunta = pregunta.getIdPregunta();
		this.enunciado = pregunta.getEnunciado();
		this.respuesta1 = pregunta.getRespuesta1();
		this.respuesta2 = pregunta.getRespuesta2();
		this.respuesta3 = pregunta.getRespuesta3();
		this.respuesta4 = pregunta.getRespuesta4();
		this.comentarios = pregunta.getComentarios();
		this.solucion = pregunta.getSolucion();
		this.anulada = pregunta.isAnulada();
		if (pregunta.getPreguntaRef()!=null)
			this.idPreguntaRef = pregunta.getPreguntaRef().getIdPregunta();
		else
			this.idPreguntaRef = 0;
		this.numero = pregunta.getNumero();
		this.parte = pregunta.getParte();
		this.rutaImagen = pregunta.getRutaImagen();
		if (pregunta.getTemas()==null)
			temas = new TemaModel[0];
		else {
			temas = new TemaModel[pregunta.getTemas().size()];
			for (int i=0;i<pregunta.getTemas().size();i++)
				temas[i]=new TemaModel(pregunta.getTemas().get(i));
		}
	}
	
	public static List<PreguntaModel> toModel(List<Pregunta> preguntas){
		List<PreguntaModel> preguntasModel = new ArrayList<PreguntaModel>();
		for (Pregunta pregunta:preguntas) {
			preguntasModel.add(new PreguntaModel(pregunta));
		}
		return preguntasModel;
	}

}
