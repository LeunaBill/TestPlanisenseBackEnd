package com.example.TestPlanisense.Services;

import com.example.TestPlanisense.Repositories.ArbreRepository;
import com.example.TestPlanisense.dto.ArbresParArrondissementDTO;
import com.example.TestPlanisense.dto.ArbresParGenreDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArbreServiceImpl implements ArbreService {

    @Autowired
    private ArbreRepository arbreRepository;

    @Override
    public List<ArbresParArrondissementDTO> getArbresParArrondissement() {
        return arbreRepository.findArbresParArrondissement();
    }

    @Override
    public List<ArbresParGenreDTO> getArbresParGenre() {
        return arbreRepository.findArbresParGenre();
    }
}
