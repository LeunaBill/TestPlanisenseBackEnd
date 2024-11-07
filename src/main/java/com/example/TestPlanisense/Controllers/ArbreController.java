package com.example.TestPlanisense.Controllers;

import com.example.TestPlanisense.Services.ArbreService;
import com.example.TestPlanisense.dto.ArbresParArrondissementDTO;
import com.example.TestPlanisense.dto.ArbresParGenreDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/arbres")
@CrossOrigin(origins = "http://localhost:4200")
public class ArbreController {

    @Autowired
    private ArbreService arbreService;

    @GetMapping("/arrondissements")
    public List<ArbresParArrondissementDTO> getArbresParArrondissement() {
        return arbreService.getArbresParArrondissement();
    }

    @GetMapping("/genres")
    public List<ArbresParGenreDTO> getArbresParGenre() {
        return arbreService.getArbresParGenre();
    }

}
