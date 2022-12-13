package com.example.demo.DemoController;

import com.example.demo.DemoEntity.cursosEntity;
import com.example.demo.DemoEntity.estudianteEntity;
import com.example.demo.DemoServices.estudianteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.lang.module.ResolutionException;
import java.util.List;

@RestController
@RequestMapping("/estudiante")
@CrossOrigin (origins = "http://localhost:4200/")
public class estudianteController {

    @Autowired
    private estudianteRepository estuRepo;

    @GetMapping
    public List<estudianteEntity> obtenerEstudiante (){
        return (List<estudianteEntity>) estuRepo.findAll();
    }

    @PostMapping
    public void agregarEstudiante (@RequestBody estudianteEntity estuEn){
        estuRepo.save(estuEn);
    }

    @PutMapping
    public void modificarEstudiante (@RequestBody estudianteEntity estuEn){
        estuRepo.save(estuEn);
    }

    @GetMapping("/{id}")
    public ResponseEntity<estudianteEntity> obtnerEstudiantePorID (@PathVariable ("id") Integer idEntity){
        estudianteEntity estuEntity = estuRepo.findById(idEntity)
                .orElseThrow( () -> new ResolutionException("No Existe el estudiante"));

        return ResponseEntity.ok(estuEntity);
    }


    @PutMapping("/{id}")
    public void modificarEstudianteUnico (@PathVariable ("id")  Integer id, @RequestBody estudianteEntity estuEn){
        estuEn.setIdestudiante(id);
        estuRepo.save(estuEn);
    }

    @DeleteMapping("/{id}")
    public void eliminarEstudiante (@PathVariable ("id")  Integer id){
        estuRepo.deleteById(id);
    }



}
