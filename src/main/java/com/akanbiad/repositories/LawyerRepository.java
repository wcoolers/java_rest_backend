package com.akanbiad.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.akanbiad.beans.Lawyer;

public interface LawyerRepository extends JpaRepository<Lawyer, Long> {
	Optional<Lawyer> findByName(String name);

}
