package com.example.TestPlanisense.Services;

import com.example.TestPlanisense.dto.ArbresParArrondissementDTO;
import com.example.TestPlanisense.dto.ArbresParGenreDTO;

import java.util.List;

public interface ArbreService {

    List<ArbresParArrondissementDTO> getArbresParArrondissement();
    List<ArbresParGenreDTO> getArbresParGenre();

}
