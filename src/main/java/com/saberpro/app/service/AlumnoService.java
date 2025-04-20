package com.saberpro.app.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.saberpro.app.model.Alumno;
import com.saberpro.app.repository.AlumnoRepository;

@Service
public class AlumnoService {

    @Autowired
    private AlumnoRepository repo;

    public List<Alumno> listar() {
        return repo.findAll();
    }

    public void guardar(Alumno alumno) {
        repo.save(alumno);
    }

    public Alumno obtenerPorId(String id) {
        return repo.findById(id).orElse(null);
    }

    public void eliminar(String id) {
        repo.deleteById(id);
    }
}
