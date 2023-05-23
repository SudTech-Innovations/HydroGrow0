package vinckier.hydrogrow_back_v2.dao.service;

import java.util.List;

import jakarta.persistence.EntityManager;
import vinckier.hydrogrow_back_v2.bdd.models.Plante;
import vinckier.hydrogrow_back_v2.dao.MainDAO;

/**
 * Cette classe représente la DAO pour l'entité Plante
 */
public class PlanteDAO implements MainDAO<Plante> {

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
    public PlanteDAO(EntityManager em) {
        this.em = em;
    }

    /**
     * Trouve une plante en se basant sur son id
     * 
     * @param id L'id de la plante recherchée
     * @return La plante correspondante à l'id spécifié, ou null si elle n'existe
     *         pas
     */
    public Plante findById(long id) {
        return em.find(Plante.class, id);
    }

    /**
     * Trouve toutes les plantes enregistrées
     * 
     * @return La liste des plantes enregistrées
     */
    public List<Plante> findAll() {
        return em.createQuery("SELECT p FROM Plante p", Plante.class).getResultList();
    }

    /**
     * Enregistre une plante dans la base de données
     * 
     * @param plante La plante à enregistrer
     */
    public void save(Plante plante) {
        em.getTransaction().begin();
        if (plante.getIdPlante() == null) {
            em.persist(plante);
        } else {
            em.merge(plante);
        }
        em.getTransaction().commit();
    }

    /**
     * Met à jour une plante dans la base de données
     * 
     * @param plante La plante à mettre à jour
     */
    public void update(Plante plante) {
        em.getTransaction().begin();
        em.merge(plante);
        em.getTransaction().commit();
    }

    /**
     * Supprime une plante de la base de données
     * 
     * @param plante La plante à supprimer
     */
    public void delete(Plante plante) {
        em.getTransaction().begin();
        em.remove(plante);
        em.getTransaction().commit();
    }
    
}