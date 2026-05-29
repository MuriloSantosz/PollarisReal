package com.senai.Pollaris.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;
import java.util.Map;
import java.util.List;

@Controller
public class EstudanteController {
    @GetMapping("/estudante")
    public String pesquisarGithub(@RequestParam(value = "busca", required = false) String busca, Model model) {
        if (busca != null && !busca.isEmpty()) {
            try {
                RestTemplate restTemplate = new RestTemplate();
                String url = "https://api.github.com/search/repositories?q=" + busca;

                org.springframework.http.HttpHeaders headers = new org.springframework.http.HttpHeaders();
                headers.set("User-Agent", "Java-Spring-App");
                org.springframework.http.HttpEntity<String> entity = new org.springframework.http.HttpEntity<>(headers);

                org.springframework.http.ResponseEntity<Map> responseEntity = restTemplate.exchange(
                        url,
                        org.springframework.http.HttpMethod.GET,
                        entity,
                        Map.class
                );

                Map<String, Object> response = responseEntity.getBody();
                List<Object> repos = (List<Object>) response.get("items");

                System.out.println("DEBUG: Encontrados " + (repos != null ? repos.size() : 0) + " itens.");

                model.addAttribute("repositorios", repos);
                model.addAttribute("status", "Resultados para: " + busca);
            } catch (Exception e) {
                System.err.println("ERRO NA API: " + e.getMessage());
                model.addAttribute("erro", "Erro ao buscar no GitHub.");
            }
        }
        return "estudante";
    }
}
