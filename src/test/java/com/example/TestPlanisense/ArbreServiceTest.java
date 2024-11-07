package com.example.TestPlanisense;

import com.example.TestPlanisense.Repositories.ArbreRepository;
import com.example.TestPlanisense.Services.ArbreServiceImpl;
import com.example.TestPlanisense.dto.ArbresParArrondissementDTO;
import com.example.TestPlanisense.dto.ArbresParGenreDTO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;

public class ArbreServiceTest {

    @Mock
    private ArbreRepository arbreRepository;

    @InjectMocks
    private ArbreServiceImpl arbreService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testGetArbresParArrondissement() {
        List<ArbresParArrondissementDTO> mockResult = Arrays.asList(
                new ArbresParArrondissementDTO("1", 100),
                new ArbresParArrondissementDTO("2", 150)
        );

        Mockito.when(arbreRepository.findArbresParArrondissement()).thenReturn(mockResult);

        List<ArbresParArrondissementDTO> result = arbreService.getArbresParArrondissement();

        Assertions.assertEquals(2, result.size());
        Assertions.assertEquals("1", result.get(0).getArrondissement());
        Assertions.assertEquals(100, result.get(0).getNombreArbres());
    }

    @Test
    public void testGetArbresParGenre() {
        List<ArbresParGenreDTO> mockResult = Arrays.asList(
                new ArbresParGenreDTO("Malus", 200),
                new ArbresParGenreDTO("Platanus", 100)
        );

        Mockito.when(arbreRepository.findArbresParGenre()).thenReturn(mockResult);

        List<ArbresParGenreDTO> result = arbreService.getArbresParGenre();

        Assertions.assertEquals(2, result.size());
        Assertions.assertEquals("Malus", result.get(0).getGenre());
        Assertions.assertEquals(200, result.get(0).getNombreArbres());
    }
}
