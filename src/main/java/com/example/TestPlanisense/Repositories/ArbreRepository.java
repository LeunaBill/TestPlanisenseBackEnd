package com.example.TestPlanisense.Repositories;

import com.example.TestPlanisense.dto.ArbresParArrondissementDTO;
import com.example.TestPlanisense.dto.ArbresParGenreDTO;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@NoArgsConstructor
@Repository
public class ArbreRepository {

    @PersistenceContext
    EntityManager entityManager;

    /**
     * Récupère la liste des arbres groupés par arrondissement.
     * Chaque entrée de la liste contient le nom de l'arrondissement et le nombre d'arbres associés.
     *
     * @return une liste de {@link ArbresParArrondissementDTO} contenant les arrondissements et le nombre d'arbres.
     */
    public List<ArbresParArrondissementDTO> findArbresParArrondissement() {
        String sql = "SELECT arrondissement, COUNT(*) AS nombreArbres " +
                "FROM Arbre " +
                "GROUP BY arrondissement " +
                "ORDER BY arrondissement";

        Query query = entityManager.createQuery(sql, Object[].class);

        List<Object[]> results = query.getResultList();

        return results.stream()
                .map(result -> ArbresParArrondissementDTO.builder()
                        .arrondissement((String) result[0])
                        .nombreArbres(((Long) result[1]).intValue())
                        .build())
                .collect(Collectors.toList());
    }

    /**
     * Récupère la liste des arbres groupés par genre.
     * Chaque entrée de la liste contient le genre de l'arbre et le nombre d'arbres de ce genre.
     *
     * @return une liste de {@link ArbresParGenreDTO} contenant les genres d'arbres et le nombre d'arbres associés.
     */
    public List<ArbresParGenreDTO> findArbresParGenre() {
        String sql = "SELECT genre, COUNT(*) AS nombreArbres " +
                "FROM Arbre " +
                "GROUP BY genre " +
                "ORDER BY genre";

        Query query = entityManager.createQuery(sql, Object[].class);

        List<Object[]> results = query.getResultList();

        return results.stream()
                .map(result -> ArbresParGenreDTO.builder()
                        .genre((String) result[0])
                        .nombreArbres(((Long) result[1]).intValue())
                        .build())
                .collect(Collectors.toList());
    }
}
