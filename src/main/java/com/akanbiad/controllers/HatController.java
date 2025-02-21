package com.akanbiad.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.akanbiad.beans.Hat;
import com.akanbiad.beans.Lawyer;
import com.akanbiad.repositories.HatRepository;
import com.akanbiad.repositories.LawyerRepository;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping("/hats")
public class HatController {
	
	private HatRepository hatRepo;
	private LawyerRepository lawyerRepo;
	
	
	@GetMapping(value={"", "/"})
	public List<Hat> getHats() {
		return hatRepo.findAll();
	}
	
	
	@GetMapping("/{id}")
	public Hat getHat(@PathVariable Long id) {
		Optional<Hat> optionalHat = hatRepo.findById(id);
		
		if (optionalHat.isPresent()) {
			return optionalHat.get();
		} else {
			return null;
		}
	}


	@PostMapping(value={"", "/"}, headers={"Content-Type=application/json"})
	public Hat addHat(@RequestBody Hat hat) {
		hat.setId(null);
		
		Optional<Lawyer> optionalLawyer = lawyerRepo.findByName(hat.getEmployeeName());
		
		if (optionalLawyer.isPresent()) {
			hat.setLawyer(optionalLawyer.get());
			return hatRepo.save(hat);
		} else {
			return null;
		}
		
	}
	
	
	@PutMapping(value={"/{id}"}, headers={"Content-Type=application/json"})
	public Hat editItem(@PathVariable Long id, @RequestBody Hat hat) {
		hat.setId(id);
		Optional<Lawyer> optionalLawyer = lawyerRepo.findByName(hat.getEmployeeName());
				
		if (optionalLawyer.isPresent()) {
			hat.setLawyer(optionalLawyer.get());
			return hatRepo.save(hat);
		} else {
			return null;
		}
	}
	

	@DeleteMapping(value={"/{id}"})
	public void deleteItem(@PathVariable Long id) {
        hatRepo.deleteById(id);
	}
        

}

