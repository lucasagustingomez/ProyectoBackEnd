package com.example.v2.Repository;

import com.example.v2.Entity.Odontologo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface OdontologoRepository extends JpaRepository<Odontologo,Long> {
}
