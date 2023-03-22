package org.asaezc.hibernateapp;

import jakarta.persistence.EntityManager;
import org.asaezc.hibernateapp.entity.Cliente;
import org.asaezc.hibernateapp.entity.Factura;
import org.asaezc.hibernateapp.util.JpaUtil;

public class HibernateAsociacionesOneToManyBidireccional {
    public static void main(String[] args) {
        EntityManager em = JpaUtil.getEntityManager();

        try {

            em.getTransaction().begin();
            Cliente cliente = new Cliente("Sara","Gómez");
            cliente.setFormaPago("Crédito");

            Factura f1 = new Factura("Gastos transporte", 568L);
            Factura f2 = new Factura("Gastos oficina", 1525L);

/*            //rel 1:n
            cliente.getFacturas().add(f1);
            cliente.getFacturas().add(f2);
            //rel n:1
            f1.setCliente(cliente);
            f2.setCliente(cliente);
*/
            //lo mismo anterior pero con método implementado en la clase cliente
            cliente.addFactura(f1).addFactura(f2);
            //presistencia
            em.persist(cliente);
            em.getTransaction().commit();
            System.out.println(cliente);
            

        } catch (Exception e) {
            em.getTransaction().rollback();
            e.printStackTrace();
        } finally {
            em.close();
        }
    }
}