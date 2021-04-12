package es.senda.preguntas.model.assembler;

import org.springframework.hateoas.mvc.ResourceAssemblerSupport;

import es.senda.preguntas.controller.ConvocatoriaController;
import es.senda.preguntas.model.Convocatoria;
import es.senda.preguntas.model.ConvocatoriaResource;


public class ConvocatoriaResourceAssembler extends ResourceAssemblerSupport<Convocatoria, ConvocatoriaResource> {

	public ConvocatoriaResourceAssembler() {
	      super(ConvocatoriaController.class, ConvocatoriaResource.class);
	    }

	    @Override
	    protected ConvocatoriaResource instantiateResource(Convocatoria entity) { return new ConvocatoriaResource(entity); }

	    @Override
	    public ConvocatoriaResource toResource(Convocatoria entity) { return createResourceWithId(entity.getIdConvocatoria(), entity); }

	
}
