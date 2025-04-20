package com.saberpro.app.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import com.saberpro.app.model.Alumno;

public interface AlumnoRepository extends MongoRepository<Alumno, String> {

}
