package org.asaezc.hibernateapp;

import jakarta.persistence.EntityManager;
import org.asaezc.hibernateapp.entity.Cliente;
import org.asaezc.hibernateapp.util.JpaUtil;

public class HibernateFetchLazyOneToMany {
    public static void main(String[] args) {
        EntityManager em = JpaUtil.getEntityManager();

        Cliente cliente = em.find(Cliente.class, 1L);
        System.out.println(cliente.getNombre() + ", direcciones: " + cliente.getDirecciones());
        em.close();
    }
}
