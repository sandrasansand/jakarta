package org.asaezc.apiservlet.webapp.jpa.repositories;

import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import org.asaezc.apiservlet.webapp.jpa.configs.Repository;
import org.asaezc.apiservlet.webapp.jpa.models.entities.Categoria;

import java.util.List;

@RepositoryJpa
@Repository
public class CategoriaRepositoryJpaImpl implements CrudRepository<Categoria>{
    @Inject
    private EntityManager em;

    @Override
    public List<Categoria> listar() throws Exception {
        return em.createQuery("from Categoria", Categoria.class).getResultList();
    }

    @Override
    public Categoria porId(Long id) throws Exception {
        return em.find(Categoria.class, id);
    }

    @Override
    public void guardar(Categoria categoria) throws Exception {
        if (categoria.getId() != null && categoria.getId() > 0) {
            em.merge(categoria);
        } else {
            em.persist(categoria);
        }
    }

    @Override
    public void eliminar(Long id) throws Exception {
        em.remove(porId(id));
    }
}
