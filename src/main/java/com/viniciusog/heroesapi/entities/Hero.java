package com.viniciusog.heroesapi.entities;



import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
public class Hero implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;
    private String universe;

    @Column(name = "image_url", length = 2000)
    private String imageUrl;

    private Integer movies;

    @Column(length = 2000)
    private String link;

    public Hero() {

    }

    public Hero(Long id, String name, String description, String universe, String imageUrl, Integer movies, String link) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.universe = universe;
        this.imageUrl = imageUrl;
        this.movies = movies;
        this.link = link;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getUniverse() {
        return universe;
    }

    public void setUniverse(String universe) {
        this.universe = universe;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public Integer getMovies() {
        return movies;
    }

    public void setMovies(Integer movies) {
        this.movies = movies;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public void increaseMovieNumber(int quantity) {
        this.movies += quantity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Hero hero = (Hero) o;
        return Objects.equals(id, hero.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}