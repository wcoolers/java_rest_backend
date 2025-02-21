package com.akanbiad.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.akanbiad.beans.Lawyer;
import com.akanbiad.repositories.LawyerRepository;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor

@RequestMapping("/lawyers")
public class LawyerController {
	
	private LawyerRepository lawyerRepo;
	
	@GetMapping(value={"", "/"})
	public List<Lawyer> getLawyers() {
		return lawyerRepo.findAll();
	}
	
	
	@GetMapping("/{id}")
	public Lawyer getLawyers(@PathVariable Long id) {
		Optional<Lawyer> optionalLawyer = lawyerRepo.findById(id);
				
				if (optionalLawyer.isPresent()) {
					return optionalLawyer.get();
				} else {
					return null;
				}
	}


	@PostMapping(value={""}, headers={"Content-Type=application/json"})
	public Lawyer addLawyer(@RequestBody Lawyer lawyer) {
		lawyer.setId(null);
		return lawyerRepo.save(lawyer);
	}
	
	
	
	
	

}

