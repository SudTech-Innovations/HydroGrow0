package vinckier.hydrogrow_back_v2.dao.service;

import java.util.List;

import jakarta.persistence.EntityManager;
import vinckier.hydrogrow_back_v2.bdd.models.User;
import vinckier.hydrogrow_back_v2.dao.MainDAO;

/**
 * Cette classe représente la DAO pour l'entité User
 */
public class UserDAO implements MainDAO<User> {

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
    public UserDAO(EntityManager em) {
        this.em = em;
    }

    /**
     * Trouve un utilisateur en se basant sur son id
     * 
     * @param id L'id de l'utilisateur recherché
     * @return L'utilisateur correspondant à l'id spécifié, ou null s'il n'existe
     *         pas
     */
    public User findById(long id) {
        String idString = String.valueOf(id);
        return em.find(User.class, idString);
    }

    /**
     * Trouve tous les utilisateurs enregistrés
     * 
     * @return La liste des utilisateurs enregistrés
     */
    public List<User> findAll() {
        return em.createQuery("SELECT u FROM User u", User.class).getResultList();
    }

    /**
     * Enregistre un utilisateur dans la base de données
     * 
     * @param user L'utilisateur à enregistrer
     */
    public void save(User user) {
        em.getTransaction().begin();
        if (user.getIdUser() == null) {
            em.persist(user);
        } else {
            em.merge(user);
        }
        em.getTransaction().commit();
    }

    /**
     * Met à jour un utilisateur dans la base de données
     * 
     * @param user L'utilisateur à mettre à jour
     */
    public void update(User user) {
        em.getTransaction().begin();
        em.merge(user);
        em.getTransaction().commit();
    }

    /**
     * Supprime un utilisateur de la base de données
     * 
     * @param user L'utilisateur à supprimer
     */
    public void delete(User user) {
        em.getTransaction().begin();
        em.remove(user);
        em.getTransaction().commit();
    }
}
