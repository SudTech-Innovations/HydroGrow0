package vinckier.hydrogrow_back_v2.dao.service;

import java.util.List;

import jakarta.persistence.EntityManager;
import vinckier.hydrogrow_back_v2.bdd.models.Projet;
import vinckier.hydrogrow_back_v2.dao.MainDAO;

/**
 * Cette classe représente la DAO pour l'entité Projet
 */
public class ProjetDAO implements MainDAO<Projet> {

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
    public ProjetDAO(EntityManager em) {
        this.em = em;
    }

    /**
     * Trouve un projet en se basant sur son id
     * 
     * @param id L'id du projet recherché
     * @return Le projet correspondant à l'id spécifié, ou null s'il n'existe pas
     */
    public Projet findById(long id) {
        return em.find(Projet.class, id);
    }

    /**
     * Trouve tous les projets enregistrés
     * 
     * @return La liste des projets enregistrés
     */
    public List<Projet> findAll() {
        return em.createQuery("SELECT p FROM Projet p", Projet.class).getResultList();
    }

    /**
     * Enregistre un projet dans la base de données
     * 
     * @param projet Le projet à enregistrer
     */
    public void save(Projet projet) {
        em.getTransaction().begin();
        if (projet.getIdProjet() == null) {
            em.persist(projet);
        } else {
            em.merge(projet);
        }
        em.getTransaction().commit();
    }

    /**
     * Met à jour un projet dans la base de données
     * 
     * @param projet Le projet à mettre à jour
     */
    public void update(Projet projet) {
        em.getTransaction().begin();
        em.merge(projet);
        em.getTransaction().commit();
    }

    /**
     * Supprime un projet de la base de données
     * 
     * @param projet Le projet à supprimer
     */
    public void delete(Projet projet) {
        em.getTransaction().begin();
        em.remove(projet);
        em.getTransaction().commit();
    }
}
