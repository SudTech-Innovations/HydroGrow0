package vinckier.hydrogrow_back_v2.dao.service;

import java.util.List;

import jakarta.persistence.EntityManager;
import vinckier.hydrogrow_back_v2.bdd.models.Planification;
import vinckier.hydrogrow_back_v2.dao.MainDAO;

/**
 * Cette classe représente la DAO pour l'entité Planification
 */
public class PlanificationDAO implements MainDAO<Planification> {

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
    public PlanificationDAO(EntityManager em) {
        this.em = em;
    }

    /**
     * Trouve une planification en se basant sur son id
     * 
     * @param id L'id de la planification recherchée
     * @return La planification correspondante à l'id spécifié, ou null si elle
     *         n'existe
     *         pas
     */
    public Planification findById(long id) {
        return em.find(Planification.class, id);
    }

    /**
     * Trouve toutes les planifications enregistrées
     * 
     * @return La liste des planifications enregistrées
     */
    public List<Planification> findAll() {
        return em.createQuery("SELECT p FROM Planification p", Planification.class).getResultList();
    }

    /**
     * Enregistre une planification dans la base de données
     * 
     * @param planification La planification à enregistrer
     */
    public void save(Planification planification) {
        em.getTransaction().begin();
        if (planification.getIdPlanif() == null) {
            em.persist(planification);
        } else {
            em.merge(planification);
        }
        em.getTransaction().commit();
    }

    /**
     * Met à jour une planification dans la base de données
     * 
     * @param planification La planification à mettre à jour
     */
    public void update(Planification planification) {
        em.getTransaction().begin();
        em.merge(planification);
        em.getTransaction().commit();
    }

    /**
     * Supprime une planification de la base de données
     * 
     * @param planification La planification à supprimer
     */
    public void delete(Planification planification) {
        em.getTransaction().begin();
        em.remove(planification);
        em.getTransaction().commit();
    }
}
