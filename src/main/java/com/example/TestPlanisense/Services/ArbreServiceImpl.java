package com.example.TestPlanisense.Services;

import com.example.TestPlanisense.Exceptions.ResourceNotFoundException;
import com.example.TestPlanisense.Repositories.ArbreRepository;
import com.example.TestPlanisense.dto.ArbresParArrondissementDTO;
import com.example.TestPlanisense.dto.ArbresParGenreDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArbreServiceImpl implements ArbreService {

    @Autowired
    private ArbreRepository arbreRepository;

    private static final Logger logger = LoggerFactory.getLogger(ArbreServiceImpl.class);

    @Override
    public List<ArbresParArrondissementDTO> getArbresParArrondissement() {
        List<ArbresParArrondissementDTO> arbres = arbreRepository.findArbresParArrondissement();

        if (arbres.isEmpty()) {
            logger.warn("Aucun arbre trouvé par arrondissement.");
            throw new ResourceNotFoundException("Aucun arbre trouvé par arrondissement.");
        }

        return arbres;
    }

    @Override
    public List<ArbresParGenreDTO> getArbresParGenre() {
        List<ArbresParGenreDTO> genres = arbreRepository.findArbresParGenre();

        if (genres.isEmpty()) {
            logger.warn("Aucun arbre trouvé par genre.");
            throw new ResourceNotFoundException("Aucun arbre trouvé par genre.");
        }

        return genres;
    }
}
