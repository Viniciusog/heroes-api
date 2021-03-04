package com.viniciusog.heroesapi.repositories;

import com.viniciusog.heroesapi.entities.Hero;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface HeroRepository extends JpaRepository<Hero, Long> {

    Optional<Hero> findByName(String name);
}
