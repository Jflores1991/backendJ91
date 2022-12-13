package com.example.demo.DemoController;


import com.example.demo.DemoEntity.cursosEntity;
import com.example.demo.DemoServices.cursosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cursos")
public class cursosController {

    @Autowired
    private cursosRepository curRepo;

    //****************Select***********************
    //****************Inicio***********************
    @GetMapping
    public  List <cursosEntity> obtenerCurso (){
        return (List<cursosEntity>) curRepo.findAll();
    }
    //****************Final***********************


    //****************Insert***********************
    //****************Inicio***********************
    @PostMapping
    public void agregarCurso (@RequestBody cursosEntity curEn){
        curRepo.save(curEn);
    }
    //****************Final***********************



    //****************Update***********************
    //****************Inicio***********************
    @PutMapping
    public void actualizarCurso (@RequestBody cursosEntity curEn){
        curRepo.save(curEn);
    }
    //****************Final***********************



    //****************Delete***********************
    //****************Inicio***********************
    @DeleteMapping
    public void eliminarCurso(@RequestBody cursosEntity curEn){
        curRepo.deleteById(curEn.getIdcursos());
    }
    //****************Final***********************
}
