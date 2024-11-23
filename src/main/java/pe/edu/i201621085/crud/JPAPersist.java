package pe.edu.i201621085.crud;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import pe.edu.i201621085.entity.City;
import pe.edu.i201621085.entity.Country;
import pe.edu.i201621085.entity.CountryLanguage;

import java.util.Arrays;

public class JPAPersist {
    public static void main(String[] args) {


        // referenciar al EMF y EM
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("world");
        EntityManager em = emf.createEntityManager();

        // crear el país
        Country country = new Country("City", "Bri", "South America", "Asia", 525856.0, 1850, 32150000, 80.00, 700.0, 402513.0, "gadnis", "Republica Federal", "Vizcarra", 5, "GD", null, null);

        // crear las ciudades
        City ciudad1 = new City("Lima", "Los Olivos", 500000, country);
        City ciudad2 = new City("Arequipa", "San Miguel", 400000, country);
        City ciudad3 = new City("Chiclayo", "Comas", 300000, country);

        // agregar ciudades al país
        country.setCity(Arrays.asList(ciudad1, ciudad2, ciudad3));

        // crear las lenguas
        CountryLanguage Leng1 = new CountryLanguage("Español", "E", 81.5, country);
        CountryLanguage Leng2 = new CountryLanguage("Chino", "C", 25.5, country);

        // agregar lenguas al país
        country.setCountryLanguages(Arrays.asList(Leng1, Leng2));

        em.getTransaction().begin();
        em.persist(country);
        em.getTransaction().commit();

        System.out.println("Country,City and Languages persistidos exitosamente.");
    }
}