package com.praktycznajava.entitymanager.entity;

import org.springframework.orm.hibernate5.HibernateOperations;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import java.util.List;

@Service
public class MovieService {

    public EntityManager getEntityManager() {

        EntityManagerFactory emf = Persistence.
                createEntityManagerFactory("com.praktycznajava.movie_catalog");

        return emf.createEntityManager();
    }

    public void saveMovie() {
        EntityManager em = getEntityManager();

        em.getTransaction().begin();

        Movie movie = new Movie();
        movie.setId(1L);
        movie.setMovieName("The Godfather");
        movie.setReleaseYear(1972);
        movie.setLanguage("English");

        em.persist(movie);
        em.getTransaction().commit();
    }

    public Movie getMovie(Long movieId) {
        EntityManager em = getEntityManager();
        Movie movie = em.find(Movie.class, movieId);
        em.detach(movie);
        return movie;
    }

    public void detach(Movie movie) {
        EntityManager em = getEntityManager();
        em.detach(movie);
    }

    public void removeMovie() {
        EntityManager em = getEntityManager();
        em.getTransaction().begin();
        Movie movie = em.find(Movie.class, 1L);
        em.remove(movie);
        em.getTransaction().commit();
    }

    public List<?> queryForMovies() {
        EntityManager em = getEntityManager();
        List<?> movies = em.createQuery("SELECT movie from Movie movie where movie.language = ?1")
                .setParameter(1, "English")
                .getResultList();
        return movies;
    }
}


