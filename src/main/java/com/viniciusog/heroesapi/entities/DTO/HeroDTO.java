package com.viniciusog.heroesapi.entities.DTO;

import java.util.Objects;

public class HeroDTO {

    private Long id;
    private String name;
    private String description;
    private String universe;
    private String imageUrl;
    private String link;
    private Integer movies;

    public HeroDTO () {

    }

    public HeroDTO(Long id, String name, String description, String universe, String imageUrl, String link, Integer movies) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.universe = universe;
        this.imageUrl = imageUrl;
        this.link = link;
        this.movies = movies;
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