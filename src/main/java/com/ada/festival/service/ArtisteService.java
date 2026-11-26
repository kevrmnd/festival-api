// package com.ada.festival.service;

// import com.ada.festival.repository.ArtisteRepository;

// @Service
// public class ArtisteService {
//     private final ArtisteRepository artisteRepository;


// }

// @Service 
// public class HeroService {
//     private final HeroRepository heroRepository;
//     private final RoleService roleService;

//     public HeroService(HeroRepository heroRepository, RoleService roleService) {
//         this.heroRepository = heroRepository;
//         this.roleService = roleService;
//     }

//     public List<Hero> findAll() {
//         return heroRepository.findAll();
//     }

//     public List<Hero> findByName(String text) {
//         List<Hero> result = new ArrayList<>();
//         for (Hero hero : heroRepository.findAll()) {
//             if (hero.getName().toLowerCase().contains(text.toLowerCase())) {
//                 result.add(hero);
//             }
//         }
//         return result;
//     }