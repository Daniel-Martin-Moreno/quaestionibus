package es.senda.preguntas.model;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

import org.springframework.hateoas.ResourceSupport;
import org.springframework.hateoas.Resources;
import org.springframework.hateoas.core.EmbeddedWrapper;
import org.springframework.hateoas.core.EmbeddedWrappers;

import com.fasterxml.jackson.annotation.JsonUnwrapped;

import es.senda.preguntas.controller.PreguntaController;
import es.senda.preguntas.model.assembler.ConvocatoriaResourceAssembler;

public class PreguntaResource extends ResourceSupport {

	ConvocatoriaResourceAssembler convocatoriaResourceAssembler = new ConvocatoriaResourceAssembler();

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
	
    @JsonUnwrapped
    private Resources<EmbeddedWrapper> embeddeds;
    //Fuente para embebidos: https://stackoverflow.com/questions/25858698/spring-hateoas-embedded-resource-support
    
    
    public Resources<EmbeddedWrapper> getEmbeddeds() {
                return embeddeds;
        }
	

	public PreguntaResource (final Pregunta pregunta) {
		
		EmbeddedWrappers wrappers = new EmbeddedWrappers(true);
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
		
		List<EmbeddedWrapper> embeddeds = new ArrayList<EmbeddedWrapper>();
		
		if (pregunta.isEmbed())
			embeddeds.add(wrappers.wrap(convocatoriaResourceAssembler.toResource(pregunta.getConvocatoria())));
		
		if (embeddeds.size()>0) {
            this.embeddeds=new Resources(embeddeds, linkTo(methodOn(PreguntaController.class).getPregunta(pregunta.getIdPregunta())).withRel("pregunta"));
         }
	}

}
