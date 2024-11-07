package com.example.TestPlanisense;

import com.example.TestPlanisense.Controllers.ArbreController;
import com.example.TestPlanisense.Services.ArbreService;
import com.example.TestPlanisense.dto.ArbresParArrondissementDTO;
import com.example.TestPlanisense.dto.ArbresParGenreDTO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.Arrays;
import java.util.List;

@SpringBootTest
public class ArbreControllerTest {

    private MockMvc mockMvc;

    @Mock
    private ArbreService arbreService;

    @InjectMocks
    private ArbreController arbreController;

    @BeforeEach
    public void setUp() {
        mockMvc = MockMvcBuilders.standaloneSetup(arbreController).build();
    }

    @Test
    public void testGetArbresParArrondissement() throws Exception {
        List<ArbresParArrondissementDTO> mockResult = Arrays.asList(
                new ArbresParArrondissementDTO("BOIS DE VINCENNES", 100),
                new ArbresParArrondissementDTO("PARIS 11E ARRDT", 150)
        );

        Mockito.when(arbreService.getArbresParArrondissement()).thenReturn(mockResult);

        mockMvc.perform(MockMvcRequestBuilders.get("/arbres/arrondissements/get"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].arrondissement").value("BOIS DE VINCENNES"))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].nombreArbres").value(100));
    }

    @Test
    public void testGetArbresParGenre() throws Exception {
        List<ArbresParGenreDTO> mockResult = Arrays.asList(
                new ArbresParGenreDTO("Malus", 200),
                new ArbresParGenreDTO("Platanus", 100)
        );

        Mockito.when(arbreService.getArbresParGenre()).thenReturn(mockResult);

        mockMvc.perform(MockMvcRequestBuilders.get("/arbres/genres/get"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].genre").value("Malus"))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].nombreArbres").value(200));
    }
}
