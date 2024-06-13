package com.example.demo.repository;

import com.example.demo.entity.Impound;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ImpoundRepository extends JpaRepository<Impound, Long> {

}
