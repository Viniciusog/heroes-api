package com.viniciusog.heroesapi.entities.DTO;

import com.viniciusog.heroesapi.entities.Hero;

import java.io.Serializable;
import java.util.Objects;

public class HeroDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;
    private String name;
    private String description;
    private String universe;
    private String imageUrl;
    private String link;
    private Integer movies;

    public HeroDTO () {

    }

    public HeroDTO(Hero hero) {
        this.id = hero.getId();
        this.name = hero.getName();
        this.description = hero.getDescription();
        this.universe = hero.getUniverse();
        this.imageUrl = hero.getImageUrl();
        this.link = hero.getLink();
        this.movies = hero.getMovies();
    }

    /*public HeroDTO(Long id, String name, String description, String universe, String imageUrl, String link, Integer movies) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.universe = universe;
        this.imageUrl = imageUrl;
        this.link = link;
        this.movies = movies;
    }*/

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

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public Integer getMovies() {
        return movies;
    }

    public void setMovies(Integer movies) {
        this.movies = movies;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        HeroDTO heroDTO = (HeroDTO) o;
        return Objects.equals(id, heroDTO.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}