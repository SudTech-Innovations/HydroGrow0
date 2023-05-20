package vinckier.hydrogrow_back_v2.dao;

import java.util.List;

/**
 * Interface principale DAO générique pour les opérations CRUD sur une entité de
 * type T.
 * 
 * @param <T> Le type de l'entité sur laquelle s'exécutent les opérations CRUD.
 */
public interface MainDAO<T> {

    /**
     * Recherche une seule entité en utilisant son ID.
     * 
     * @param id L'ID de l'entité à rechercher.
     * @return L'entité correspondant à l'ID fourni, ou null si aucune entité
     *         trouvée.
     */
    T findById(long id);

    /**
     * Recherche toutes les entités de type T dans la base de données.
     * 
     * @return La liste de toutes les entités de type T dans la base de données.
     */
    List<T> findAll();

    /**
     * Enregistre une nouvelle entité de type T dans la base de données.
     * 
     * @param entity L'entité à enregistrer.
     */
    void save(T entity);

    /**
     * Met à jour une entité existante de type T dans la base de données.
     * 
     * @param entity L'entité à mettre à jour.
     */
    void update(T entity);

    /**
     * Supprime une entité existante de type T de la base de données.
     * 
     * @param entity L'entité à supprimer.
     */
    void delete(T entity);
}