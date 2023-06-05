package com.example.v2.Repository;

import com.example.v2.Entity.Turno;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface TurnoRepository extends JpaRepository<Turno,Long> {

}
