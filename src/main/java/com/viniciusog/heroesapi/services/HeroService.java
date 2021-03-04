package com.viniciusog.heroesapi.services;

import com.viniciusog.heroesapi.entities.Hero;
import com.viniciusog.heroesapi.services.exceptions.DatabaseException;
import com.viniciusog.heroesapi.services.exceptions.ResourceNotFoundException;
import com.viniciusog.heroesapi.repositories.HeroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;

@Service
public class HeroService {

    @Autowired
    private HeroRepository repository;

    public Hero create(Hero hero) {
        try {
            return repository.save(hero);
        } catch (RuntimeException e) {
            throw new DatabaseException(e.getMessage());
        }
    }

    public Hero findById(Long id) {
        Optional<Hero> opt = repository.findById(id);
        //Faz opt.get() caso tenha, se não, gera exceção
        return opt.orElseThrow(() -> new ResourceNotFoundException(id));
    }

    public List<Hero> listAll() {
        return repository.findAll();
    }

    public void deleteById(Long id) {
        try {
            repository.deleteById(id);
        } catch (EmptyResultDataAccessException e) {
            //Id não existente
            throw new ResourceNotFoundException(id);
        } catch (DataIntegrityViolationException ex) {
            //Herói tem relação no banco de dados
            throw new DatabaseException(ex.getMessage());
        }
    }

    public Hero update(Long id, Hero hero) {
        try {
            //Hero in database
            Hero heroEntiy = repository.getOne(id);
            updateData(heroEntiy, hero);
            return repository.save(heroEntiy);
        } catch (EntityNotFoundException e) {
            //Caso não encontre por Id, retorne uma exceção
           throw new ResourceNotFoundException(id);
        }
    }

    // Atualizar entity do banco de dados com o novo Herói passado em parâmetro
    private void updateData(Hero heroDatabase, Hero updatedHero) {

            heroDatabase.setName(updatedHero.getName());
            heroDatabase.setDescription(updatedHero.getDescription());
            heroDatabase.setImageUrl(updatedHero.getImageUrl());
            heroDatabase.setLink(updatedHero.getLink());
            heroDatabase.setUniverse(updatedHero.getUniverse());
            heroDatabase.setMovies(updatedHero.getMovies());

    }
}