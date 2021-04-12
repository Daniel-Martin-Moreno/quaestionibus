package es.senda.preguntas.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import es.senda.preguntas.model.Convocatoria;
import es.senda.preguntas.model.Pregunta;
import es.senda.preguntas.model.PreguntaForSaving;
import es.senda.preguntas.model.PreguntaModel;
import es.senda.preguntas.model.Tema;
import es.senda.preguntas.repository.ConvocatoriaRepository;
import es.senda.preguntas.repository.PreguntaRepository;
import es.senda.preguntas.repository.TemaRepository;

@RestController()
public class PreguntaController {


	@Autowired
	PreguntaRepository preguntaRepository;
	
	@Autowired
	TemaRepository temaRepository;
	
	@Autowired
	ConvocatoriaRepository convocatoriaRepository;
	
	@GetMapping("/preguntas")
	public ResponseEntity getPreguntas() {
		List<Pregunta> preguntas = preguntaRepository.findAll();
		return new ResponseEntity(PreguntaModel.toModel(preguntas), HttpStatus.OK);
	}

	@GetMapping("/preguntas/{id}")
	public ResponseEntity getPregunta(@PathVariable(value = "id") Long id) {

		return new ResponseEntity<PreguntaModel>(new PreguntaModel(preguntaRepository.findOne(id)), HttpStatus.OK);
	}
	

	@PutMapping("/preguntas/{idPregunta}/temas/{idTema}/asociar")
	public ResponseEntity asociarTemaAPregunta(@PathVariable(value = "idPregunta") Long idPregunta,
				@PathVariable(value = "idTema") Long idTema) {

		Pregunta pregunta = preguntaRepository.findOne(idPregunta);
		Tema tema = temaRepository.findOne(idTema);
		if (!pregunta.getTemas().contains(tema))
			pregunta.getTemas().add(tema);
		preguntaRepository.save(pregunta);
			
		return new ResponseEntity<PreguntaModel>(new PreguntaModel(pregunta), HttpStatus.OK);
	}
	

	@PutMapping("/preguntas/{idPregunta}/convocatorias/{idConvocatoria}/numero/{numero}/parte/{parte}/asociar")
	public ResponseEntity asociarTemaAPreguntaPorPropiedadesTema(@PathVariable(value = "idPregunta") Long idPregunta,
				@PathVariable(value = "idConvocatoria") Long idConvocatoria,
				@PathVariable(value = "numero") Integer numero,
				@PathVariable(value = "parte") String parte) {

		Pregunta pregunta = preguntaRepository.findOne(idPregunta);
		Convocatoria convocatoria = convocatoriaRepository.findOne(idConvocatoria);
		Tema tema = temaRepository.findByConvocatoriaAndNumeroAndParte(convocatoria, numero, parte);
		if (!pregunta.getTemas().contains(tema))
			pregunta.getTemas().add(tema);
		preguntaRepository.save(pregunta);
			
		return new ResponseEntity<PreguntaModel>(new PreguntaModel(pregunta), HttpStatus.OK);
	}
	

	@PutMapping("/preguntas/{idPregunta}/temas/{idTema}/desasociar")
	public ResponseEntity desasociarTemaAPregunta(@PathVariable(value = "idPregunta") Long idPregunta,
				@PathVariable(value = "idTema") Long idTema) {

		Pregunta pregunta = preguntaRepository.findOne(idPregunta);
		Tema tema = temaRepository.findOne(idTema);
		if (pregunta.getTemas()!=null&&pregunta.getTemas().contains(tema))
			pregunta.getTemas().remove(tema);
		preguntaRepository.save(pregunta);
			
		return new ResponseEntity<PreguntaModel>(
				new PreguntaModel(pregunta), HttpStatus.OK);
	}
	

	@PutMapping("/preguntas/{idPregunta}/comentarios")
	public ResponseEntity actualizarComentarios(@PathVariable(value = "idPregunta") Long idPregunta,
			@RequestBody String comentarios) {

		Pregunta pregunta = preguntaRepository.findOne(idPregunta);
		pregunta.setComentarios(comentarios);
		preguntaRepository.save(pregunta);
			
		return new ResponseEntity<PreguntaModel>(new PreguntaModel(pregunta), HttpStatus.OK);
	}
	

	@PutMapping("/preguntas/{idPregunta}")
	public ResponseEntity actualizarPregunta(@PathVariable(value = "idPregunta") Long idPregunta,
			@RequestBody PreguntaForSaving preguntaFS) {

		Pregunta pregunta = preguntaRepository.findOne(idPregunta);
		pregunta.setRutaImagen(preguntaFS.getRutaImagen());
		pregunta.setComentarios(preguntaFS.getComentarios());
		preguntaRepository.save(pregunta);
			
		return new ResponseEntity<PreguntaModel>(new PreguntaModel(pregunta), HttpStatus.OK);
	}
	
	@PostMapping("/preguntas")
	public ResponseEntity crearPregunta(@RequestBody Pregunta pregunta) {
		preguntaRepository.save(pregunta);
		return new ResponseEntity<PreguntaModel>(new PreguntaModel(pregunta), HttpStatus.OK);
	}
	
}
