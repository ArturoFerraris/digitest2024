package com.example;

import java.util.HashMap;
import java.util.Map;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;

@SpringBootApplication
@RestController
public class RESTAPIServerTask {

    // Simulação de um banco de dados simples
    private Map<Long, String> database = new HashMap<>();

    // Exemplo de endpoint para obter um recurso
    @GetMapping("/resource/{id}")
    public String getResource(@PathVariable Long id) {
        String resource = database.get(id);
        if (resource != null) {
            return "Obtendo recurso com ID " + id + ": " + resource;
        } else {
            return "Recurso com ID " + id + " não encontrado";
        }
    }

    // Exemplo de endpoint para criar um recurso
    @PostMapping("/resource")
    public String createResource(@RequestBody String resource) {
        Long id = generateId();
        database.put(id, resource);
        return "Recurso com ID " + id + " criado com sucesso";
    }

    // Exemplo de endpoint para atualizar um recurso
    @PutMapping("/resource/{id}")
    public String updateResource(@PathVariable Long id, @RequestBody String resource) {
        if (database.containsKey(id)) {
            database.put(id, resource);
            return "Recurso com ID " + id + " atualizado com sucesso";
        } else {
            return "Recurso com ID " + id + " não encontrado";
        }
    }

    // Exemplo de endpoint para excluir um recurso
    @DeleteMapping("/resource/{id}")
    public String deleteResource(@PathVariable Long id) {
        if (database.containsKey(id)) {
            database.remove(id);
            return "Recurso com ID " + id + " excluído com sucesso";
        } else {
            return "Recurso com ID " + id + " não encontrado";
        }
    }

    // Método para gerar IDs únicos
    private Long generateId() {
        // Simples implementação para gerar IDs únicos
        return System.currentTimeMillis();
    }
}
