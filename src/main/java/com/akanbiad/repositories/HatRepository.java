package com.akanbiad.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.akanbiad.beans.Hat;

public interface HatRepository extends JpaRepository<Hat, Long> {

}
