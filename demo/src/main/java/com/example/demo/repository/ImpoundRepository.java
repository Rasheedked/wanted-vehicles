package com.example.demo.repository;

import com.example.demo.entity.Impound;
import com.example.demo.payload.request.response.CreateImpoundRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.Optional;

@Repository
public interface ImpoundRepository extends JpaRepository<Impound, Long> {


}
