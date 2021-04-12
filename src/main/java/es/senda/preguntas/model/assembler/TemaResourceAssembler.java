package es.senda.preguntas.model.assembler;

import org.springframework.hateoas.mvc.ResourceAssemblerSupport;

import es.senda.preguntas.controller.ConvocatoriaController;
import es.senda.preguntas.controller.TemaController;
import es.senda.preguntas.model.Tema;
import es.senda.preguntas.model.TemaResource;


public class TemaResourceAssembler extends ResourceAssemblerSupport<Tema, TemaResource> {

	public TemaResourceAssembler() {
	      super(TemaController.class, TemaResource.class);
	    }

	    @Override
	    protected TemaResource instantiateResource(Tema entity) { return new TemaResource(entity); }

	    @Override
	    public TemaResource toResource(Tema entity) { return createResourceWithId(entity.getIdTema(), entity); }

	
}
