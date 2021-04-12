package es.senda.preguntas.model;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

import java.util.ArrayList;
import java.util.List;

import org.springframework.hateoas.ResourceSupport;
import org.springframework.hateoas.Resources;
import org.springframework.hateoas.core.EmbeddedWrapper;
import org.springframework.hateoas.core.EmbeddedWrappers;

import com.fasterxml.jackson.annotation.JsonUnwrapped;

import es.senda.preguntas.controller.PreguntaController;
import es.senda.preguntas.model.assembler.ConvocatoriaResourceAssembler;

public class TemaResource extends ResourceSupport {

	ConvocatoriaResourceAssembler convocatoriaResourceAssembler = new ConvocatoriaResourceAssembler();

	public final Long idTema;
	public final String enunciado;
	public final int numero;
	public final String parte;

    @JsonUnwrapped
    private Resources<EmbeddedWrapper> embeddeds;
    //Fuente para embebidos: https://stackoverflow.com/questions/25858698/spring-hateoas-embedded-resource-support
    
    
    public Resources<EmbeddedWrapper> getEmbeddeds() {
                return embeddeds;
        }

	public TemaResource (final Tema tema) {
		
		EmbeddedWrappers wrappers = new EmbeddedWrappers(true);
		this.idTema = tema.getIdTema();
		this.enunciado = tema.getEnunciado();
		this.numero = tema.getNumero();
		this.parte = tema.getParte();
		
		List<EmbeddedWrapper> embeddeds = new ArrayList<EmbeddedWrapper>();
		
		if (tema.isEmbed())
			embeddeds.add(wrappers.wrap(convocatoriaResourceAssembler.toResource(tema.getConvocatoria())));
		
		if (embeddeds.size()>0) {
            this.embeddeds=new Resources(embeddeds, linkTo(methodOn(PreguntaController.class).getPregunta(tema.getIdTema())).withRel("tema"));
         }
	}

}
