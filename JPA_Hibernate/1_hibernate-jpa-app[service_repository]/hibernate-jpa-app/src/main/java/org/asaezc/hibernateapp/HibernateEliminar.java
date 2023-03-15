package org.asaezc.hibernateapp;

import jakarta.persistence.EntityManager;
import org.asaezc.hibernateapp.entity.Cliente;
import org.asaezc.hibernateapp.util.JpaUtil;

import java.util.Scanner;

public class HibernateEliminar {
    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);
        System.out.println("Ingrese el id del cliente a eliminar:");
        Long id = s.nextLong();
        EntityManager em = JpaUtil.getEntityManager();
        try {

            Cliente cliente = em.find(Cliente.class, id);
            em.getTransaction().begin();
            em.remove(cliente);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            e.printStackTrace();
        } finally {
            em.close();
        }
    }
}
