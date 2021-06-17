package com.notes.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.notes.entity.Note;
import com.notes.repository.NotesRepository;

@RestController
@RequestMapping("/api")
@CrossOrigin("*")
public class NotesController {
	@Autowired
	NotesRepository repo;
	
	@GetMapping("/notes")
	public ResponseEntity<List<Note>> readNotes(){
		return new ResponseEntity<List<Note>>(repo.findAll(), HttpStatus.OK);
	}
	@PostMapping("/notes")
	public ResponseEntity<Note> createNote(@RequestBody Note note){
		return new ResponseEntity<Note>(repo.save(note),HttpStatus.CREATED);
	}
	@GetMapping("/notes/{id}")
	public ResponseEntity<Note> readNote(@PathVariable Long id){
		return new ResponseEntity<Note>(repo.findById(id).get(),HttpStatus.OK);
	}
	@DeleteMapping("/notes/{id}")
	public ResponseEntity<HttpStatus> deleteNote(@PathVariable Long id){
		repo.deleteById(id);
		return new ResponseEntity<HttpStatus>(HttpStatus.NO_CONTENT);
	}
	@PutMapping("/notes")
	public ResponseEntity<Note> updateNote(@RequestBody Note note){
		return new ResponseEntity<Note>(repo.save(note),HttpStatus.OK);
	}
}
