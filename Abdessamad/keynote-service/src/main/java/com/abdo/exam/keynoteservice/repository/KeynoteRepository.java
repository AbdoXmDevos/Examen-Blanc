package com.abdo.exam.keynoteservice.repository;

import com.abdo.exam.keynoteservice.entities.Keynote;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface KeynoteRepository extends JpaRepository<Keynote, Long> {
}