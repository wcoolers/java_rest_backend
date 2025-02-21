package com.akanbiad.bootstrap;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.akanbiad.beans.Hat;
import com.akanbiad.beans.Lawyer;
import com.akanbiad.repositories.HatRepository;
import com.akanbiad.repositories.LawyerRepository;

import lombok.AllArgsConstructor;

@Component
@AllArgsConstructor
public class BootstrapData implements CommandLineRunner {

	private final LawyerRepository lawyerRepository;
	private final HatRepository hatRepository;

	@Override
	public void run(String... args) throws Exception {
	
		//add Lawyers
		Lawyer l1= Lawyer.builder().name("Adegoke").build();
		Lawyer l2= Lawyer.builder().name("Philip").build();
		Lawyer l3= Lawyer.builder().name("Oluwakemi").build();
		
		//add Hats
		Hat h1 = Hat.builder().name("Hat 1").price(30.0).quantity(34).employeeName(l1.getName()).build();
		Hat h2 = Hat.builder().name("Hat 2").price(10.0).quantity(50).employeeName(l1.getName()).build();
		Hat h3 = Hat.builder().name("Hat 3").price(99.0).quantity(45).employeeName(l2.getName()).build();
		Hat h4 = Hat.builder().name("Hat 4").price(23.0).quantity(60).employeeName(l2.getName()).build();
		Hat h5 = Hat.builder().name("Hat 5").price(45.0).quantity(90).employeeName(l3.getName()).build();
		Hat h6 = Hat.builder().name("Hat 6").price(29.0).quantity(10).employeeName(l3.getName()).build();
		Hat h7 = Hat.builder().name("Hat 7").price(34.0).quantity(340).employeeName(l1.getName()).build();
		Hat h8 = Hat.builder().name("Hat 8").price(19.0).quantity(45).employeeName(l2.getName()).build();
		Hat h9 = Hat.builder().name("Hat 9").price(10.0).quantity(45).employeeName(l3.getName()).build();
		Hat h10 = Hat.builder().name("Hat 10").price(80.0).quantity(50).employeeName(l1.getName()).build();
		
		//save all Lawyers 
		lawyerRepository.save(l1);
		lawyerRepository.save(l2);
		lawyerRepository.save(l3);
		
		
		//added in part 9
		h1.setLawyer(l1);
		h2.setLawyer(l2);
		h3.setLawyer(l3);
		h4.setLawyer(l1);
		h5.setLawyer(l2);
		h6.setLawyer(l3);
		h7.setLawyer(l1);
		h8.setLawyer(l3);
		h9.setLawyer(l2);
		h1.setLawyer(l2);

		//save all Hats
		hatRepository.save(h1);
		hatRepository.save(h2);
		hatRepository.save(h3);
		hatRepository.save(h4);
		hatRepository.save(h5);
		hatRepository.save(h6);
		hatRepository.save(h7);
		hatRepository.save(h8);
		hatRepository.save(h9);
		hatRepository.save(h10);
		

	}

}

