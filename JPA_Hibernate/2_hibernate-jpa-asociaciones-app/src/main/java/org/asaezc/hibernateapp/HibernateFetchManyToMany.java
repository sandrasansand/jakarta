package org.asaezc.hibernateapp;

import jakarta.persistence.EntityManager;
import org.asaezc.hibernateapp.entity.Alumno;
import org.asaezc.hibernateapp.util.JpaUtil;

import java.util.List;

public class HibernateFetchManyToMany {
    public static void main(String[] args) {

        EntityManager em = JpaUtil.getEntityManager();
	//a.cursos -> es el atributo de la clase Alumno
        List<Alumno> alumnos = em.createQuery("select distinct a from Alumno a left outer join fetch a.cursos", Alumno.class).getResultList();
        alumnos.forEach(a -> System.out.println(a.getNombre() + ", cursos: " + a.getCursos()));
        em.close();
    }
}
