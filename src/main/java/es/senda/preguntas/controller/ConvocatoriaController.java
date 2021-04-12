package es.senda.preguntas.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import es.senda.preguntas.model.Convocatoria;
import es.senda.preguntas.model.ConvocatoriaModel;
import es.senda.preguntas.model.Pregunta;
import es.senda.preguntas.model.PreguntaModel;
import es.senda.preguntas.model.Tema;
import es.senda.preguntas.model.TemaModel;
import es.senda.preguntas.repository.ConvocatoriaRepository;
import es.senda.preguntas.repository.PreguntaRepository;
import es.senda.preguntas.repository.TemaRepository;

@RestController()
public class ConvocatoriaController {

	@Autowired
	ConvocatoriaRepository convocatoriaRepository;

	@Autowired
	PreguntaRepository preguntaRepository;

	@Autowired
	TemaRepository temaRepository;

	@GetMapping("/convocatorias")
	public ResponseEntity getConvocatorias() {
		List<Convocatoria> convocatorias = convocatoriaRepository.findAll();
		return new ResponseEntity(ConvocatoriaModel.toModel(convocatorias), HttpStatus.OK);
	}

	@GetMapping("/convocatorias/{id}")
	public ResponseEntity getConvocatoria(@PathVariable(value = "id") Long id) {

		return new ResponseEntity<ConvocatoriaModel>(new ConvocatoriaModel(convocatoriaRepository.findOne(id)), HttpStatus.OK);
	}
	
	@GetMapping("/convocatorias/{id}/preguntas")
	public ResponseEntity getPreguntasDeConvocatoria(@PathVariable(value = "id") Long id) {
		List<Pregunta> preguntas = preguntaRepository.findByConvocatoria(convocatoriaRepository.getOne(id));
		return new ResponseEntity(PreguntaModel.toModel(preguntas), HttpStatus.OK);
	}
	
	@GetMapping("/convocatorias/{idConvocatoria}/preguntas/{numero}")
	public ResponseEntity getPreguntaDeConvocatoria(@PathVariable(value = "idConvocatoria") Long idConvocatoria,@PathVariable(value = "numero") Integer numero) {
		Convocatoria convocatoria = convocatoriaRepository.findOne(idConvocatoria);
		Pregunta pregunta = preguntaRepository.findByConvocatoriaAndNumero(convocatoria, numero);
		
		return new ResponseEntity(new PreguntaModel(pregunta), HttpStatus.OK);
	}
	
	@GetMapping("/convocatorias/{idConvocatoria}/temas/{numero}/parte/{parte}/preguntas")
	public ResponseEntity getPreguntasDeTemaDeConvocatoria(@PathVariable(value = "idConvocatoria") Long idConvocatoria,@PathVariable(value = "numero") Integer numero,@PathVariable(value = "parte") String parte) {
		
		List<Pregunta> preguntas = preguntaRepository.findByIdConvocatoriaAndNumeroTemaAndParte(idConvocatoria, numero, parte);
		System.out.println("ConvocatoriaController.getPreguntasDeTemaDeConvocatoria "+idConvocatoria+"|"+numero+"|"+parte+"|"+preguntas.size());
		return new ResponseEntity(PreguntaModel.toModel(preguntas), HttpStatus.OK);
	}
	

	@GetMapping("/convocatorias/{idConvocatoria}/temas/{numero}/parte/{parte}")
	public ResponseEntity getTemaDeConvocatoria(@PathVariable(value = "idConvocatoria") Long idConvocatoria,@PathVariable(value = "numero") Integer numero,
			@PathVariable(value = "parte") String parte) {
		Convocatoria convocatoria = convocatoriaRepository.findOne(idConvocatoria);
		Tema tema = temaRepository.findByConvocatoriaAndNumeroAndParte(convocatoria, numero, parte);
		if (tema==null)
			return new ResponseEntity("Tema no encontrado", HttpStatus.NOT_FOUND);
		else
			return new ResponseEntity(new TemaModel(tema), HttpStatus.OK);
	}
	
}
