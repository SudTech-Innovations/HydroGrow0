package vinckier.hydrogrow_back_v2.dao.service;

import java.util.List;

import jakarta.persistence.EntityManager;
import vinckier.hydrogrow_back_v2.bdd.models.Environnement;
import vinckier.hydrogrow_back_v2.dao.MainDAO;

/**
 * Cette classe représente la DAO pour l'entité Environnement
 */
public class EnvironnementDAO implements MainDAO<Environnement> {

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
    public EnvironnementDAO(EntityManager em) {
        this.em = em;
    }

    /**
     * Trouve un environnement en se basant sur son id
     * 
     * @param id L'id de l'environnement recherché
     * @return L'environnement correspondant à l'id spécifié, ou null s'il n'existe
     *         pas
     */
    public Environnement findById(long id) {
        return em.find(Environnement.class, id);
    }

    /**
     * Trouve tous les environnements enregistrés
     * 
     * @return La liste des environnements enregistrés
     */
    public List<Environnement> findAll() {
        return em.createQuery("SELECT e FROM Environnement e", Environnement.class).getResultList();
    }

    /**
     * Enregistre un environnement dans la base de données
     * 
     * @param environnement L'environnement à enregistrer
     */
    public void save(Environnement environnement) {
        em.getTransaction().begin();
        if (environnement.getIdEnvironnement() == null) {
            em.persist(environnement);
        } else {
            em.merge(environnement);
        }
        em.getTransaction().commit();
    }

    /**
     * Met à jour un environnement dans la base de données
     * 
     * @param environnement L'environnement à mettre à jour
     */
    public void update(Environnement environnement) {
        em.getTransaction().begin();
        em.merge(environnement);
        em.getTransaction().commit();
    }

    /**
     * Supprime un environnement de la base de données
     * 
     * @param environnement L'environnement à supprimer
     */
    public void delete(Environnement environnement) {
        em.getTransaction().begin();
        em.remove(environnement);
        em.getTransaction().commit();
    }
}
