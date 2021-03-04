package com.viniciusog.heroesapi.controllers;

import com.viniciusog.heroesapi.entities.Hero;
import com.viniciusog.heroesapi.services.HeroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/api/v1/heroes")
public class HeroController {

    @Autowired
    private HeroService service;

    @PostMapping
    public ResponseEntity<Hero> insert(@RequestBody Hero hero) {
        Hero h = service.create(hero);

        URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{id}")
                .buildAndExpand(h.getId()).toUri();
        return ResponseEntity.created(uri).body(h);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Hero> findById(@PathVariable Long id) {
        return ResponseEntity.ok().body(service.findById(id));
    }

    @GetMapping
    public ResponseEntity<List<Hero>> listAll() {
        List<Hero> heroes = service.listAll();
        return ResponseEntity.ok().body(heroes);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.deleteById(id);
        //Retornar uma requisição sem conteúdo - void
        return ResponseEntity.noContent().build();
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Hero> update(@PathVariable Long id, @RequestBody Hero hero) {
        Hero heroUpdatedFromDB = service.update(id, hero);
        return ResponseEntity.ok().body(heroUpdatedFromDB);
    }
}