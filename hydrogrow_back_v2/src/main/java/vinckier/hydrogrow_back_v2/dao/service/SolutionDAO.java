package vinckier.hydrogrow_back_v2.dao.service;

import java.util.List;

import jakarta.persistence.EntityManager;
import vinckier.hydrogrow_back_v2.bdd.models.Solution;
import vinckier.hydrogrow_back_v2.dao.MainDAO;

/**
 * Cette classe représente la DAO pour l'entité Solution
 */
public class SolutionDAO implements MainDAO<Solution> {

    /**
     * EntityManager pour accéder à la base de données
     */
    private final EntityManager em;

    /**
     * Constructeur pour initialiser l'EntityManager
     * 
     * @param em L'entityManager de l'unité de persistance pour les opérations sur
     *           la base de données
     */
    public SolutionDAO(EntityManager em) {
        this.em = em;
    }

    /**
     * Trouve une solution en se basant sur son id
     * 
     * @param id L'id de la solution recherchée
     * @return La solution correspondante à l'id spécifié, ou null si elle n'existe
     *         pas
     */
    public Solution findById(long id) {
        return em.find(Solution.class, id);
    }

    /**
     * Trouve toutes les solutions enregistrées
     * 
     * @return La liste des solutions enregistrées
     */
    public List<Solution> findAll() {
        return em.createQuery("SELECT s FROM Solution s", Solution.class).getResultList();
    }

    /**
     * Enregistre une solution dans la base de données
     * 
     * @param solution La solution à enregistrer
     */
    public void save(Solution solution) {
        em.getTransaction().begin();
        if (solution.getIdSolution() == null) {
            em.persist(solution);
        } else {
            em.merge(solution);
        }
        em.getTransaction().commit();
    }

    /**
     * Met à jour une solution dans la base de données
     * 
     * @param solution La solution à mettre à jour
     */
    public void update(Solution solution) {
        em.getTransaction().begin();
        em.merge(solution);
        em.getTransaction().commit();
    }

    /**
     * Supprime une solution de la base de données
     * 
     * @param solution La solution à supprimer
     */
    public void delete(Solution solution) {
        em.getTransaction().begin();
        em.remove(solution);
        em.getTransaction().commit();
    }
}
