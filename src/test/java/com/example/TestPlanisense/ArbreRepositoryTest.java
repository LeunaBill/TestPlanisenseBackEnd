package com.example.TestPlanisense;

import com.example.TestPlanisense.Repositories.ArbreRepository;
import com.example.TestPlanisense.dto.ArbresParArrondissementDTO;
import com.example.TestPlanisense.dto.ArbresParGenreDTO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class ArbreRepositoryTest {

    @Autowired
    private ArbreRepository arbreRepository;

    @Test
    public void testFindArbresParArrondissement() {
        List<ArbresParArrondissementDTO> result = arbreRepository.findArbresParArrondissement();
        Assertions.assertEquals(25, result.size());  // Vérifiez que le nombre d'arrondissements est correct
    }

    @Test
    public void testFindArbresParGenre() {
        List<ArbresParGenreDTO> result = arbreRepository.findArbresParGenre();
        Assertions.assertEquals(193, result.size());  // Vérifiez que le nombre de genres d'arbres est correct
    }
}
