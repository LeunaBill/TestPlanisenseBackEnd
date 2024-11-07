package com.example.TestPlanisense.Controllers;

import com.example.TestPlanisense.Services.ArbreService;
import com.example.TestPlanisense.dto.ArbresParArrondissementDTO;
import com.example.TestPlanisense.dto.ArbresParGenreDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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

    /**
     * Récupère la liste des arbres par arrondissement.
     *
     * @return ResponseEntity contenant la liste des arbres par arrondissement.
     */
    @GetMapping("/arrondissements/get")
    public ResponseEntity<List<ArbresParArrondissementDTO>> getArbresParArrondissement() {
        List<ArbresParArrondissementDTO> arbres = arbreService.getArbresParArrondissement();
        return ResponseEntity.ok(arbres);
    }

    /**
     * Récupère la liste des arbres par genre.
     *
     * @return ResponseEntity contenant la liste des arbres par genre.
     */
    @GetMapping("/genres/get")
    public ResponseEntity<List<ArbresParGenreDTO>> getArbresParGenre() {
        List<ArbresParGenreDTO> genres = arbreService.getArbresParGenre();
        return ResponseEntity.ok(genres);
    }

}
