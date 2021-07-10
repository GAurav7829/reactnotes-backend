package com.notes.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.notes.entity.Note;
import com.notes.repository.NotesRepository;

@Service
public class NotesService {
	@Autowired
	NotesRepository repo;
	
	public List<Note> findAll() {
		return repo.findAll();
	}
	public Note save(Note note) {
		return repo.save(note);
	}
	
	public Note findById(Long id) {
		return repo.findById(id).get();
	}
	public void deleteById(Long id) {
		repo.deleteById(id);
	}
}
