package org.asaezc.hibernateapp;

import jakarta.persistence.EntityManager;
import org.asaezc.hibernateapp.entity.Cliente;
import org.asaezc.hibernateapp.util.JpaUtil;

import javax.swing.*;

public class HibernateEditar {
    public static void main(String[] args) {

        EntityManager em = JpaUtil.getEntityManager();
        try {

            Long id = Long.valueOf(JOptionPane.showInputDialog("Introduzca el id del cliente a modificar:"));
            Cliente c = em.find(Cliente.class, id);

            String nombre = JOptionPane.showInputDialog("Introduzca el nombre:", c.getNombre());
            String apellido = JOptionPane.showInputDialog("Introduzca el apellido:", c.getApellido());
            String pago = JOptionPane.showInputDialog("Introduzca la forma de pago:", c.getFormaPago());
            em.getTransaction().begin();
            c.setNombre(nombre);
            c.setApellido(apellido);
            c.setFormaPago(pago);
            //actualizamos los datos con el método merge de la clase eManager en el contexto de persistencia
            em.merge(c);
            //en la bd
            em.getTransaction().commit();

            System.out.println(c);
        } catch (Exception e) {
            em.getTransaction().rollback();
            e.printStackTrace();
        } finally {
            em.close();
        }
    }
}
