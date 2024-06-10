package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;

@SpringBootApplication
@RestController
public class RESTAPIServerTask {

    // Exemplo de endpoint para obter um recurso
    @GetMapping("/resource/{id}")
    public String getResource(@PathVariable Long id) {
        // Implemente a l�gica para obter o recurso com o ID fornecido do banco de dados
        return "Obtendo recurso com ID " + id;
    }

    // Exemplo de endpoint para criar um recurso
    @PostMapping("/resource")
    public String createResource(@RequestBody String resource) {
        // Implemente a l�gica para criar um novo recurso com base nos dados fornecidos
        return "Recurso criado com sucesso";
    }

    // Exemplo de endpoint para atualizar um recurso
    @PutMapping("/resource/{id}")
    public String updateResource(@PathVariable Long id, @RequestBody String resource) {
        // Implemente a l�gica para atualizar o recurso com o ID fornecido com base nos dados fornecidos
        return "Recurso com ID " + id + " atualizado com sucesso";
    }

    // Exemplo de endpoint para excluir um recurso
    @DeleteMapping("/resource/{id}")
    public String deleteResource(@PathVariable Long id) {
        // Implemente a l�gica para excluir o recurso com o ID fornecido
        return "Recurso com ID " + id + " exclu�do com sucesso";
    }

    public static void main(String[] args) {
        SpringApplication.run(RESTAPIServerTask.class, args);
    }
}