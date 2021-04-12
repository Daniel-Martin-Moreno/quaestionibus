package es.senda.preguntas.model.assembler;

import org.springframework.hateoas.mvc.ResourceAssemblerSupport;

import es.senda.preguntas.controller.PreguntaController;
import es.senda.preguntas.model.Pregunta;
import es.senda.preguntas.model.PreguntaResource;


public class PreguntaResourceAssembler extends ResourceAssemblerSupport<Pregunta, PreguntaResource> {

	public PreguntaResourceAssembler() {
	      super(PreguntaController.class, PreguntaResource.class);
	    }

	    @Override
	    protected PreguntaResource instantiateResource(Pregunta entity) { return new PreguntaResource(entity); }

	    @Override
	    public PreguntaResource toResource(Pregunta entity) { return createResourceWithId(entity.getIdPregunta(), entity); }

	
}
