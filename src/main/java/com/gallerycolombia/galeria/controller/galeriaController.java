package com.gallerycolombia.galeria.controller;

import com.gallerycolombia.galeria.data.GalleryData;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import javax.annotation.PostConstruct;

public class galeriaController {

    static List<GalleryData> lista = new ArrayList<>();
    static {
        lista.add(new GalleryData(0, "Armani Blue Shirt", 0, "Blue", "Awesome T-Shirt"));
        lista.add(new GalleryData(0, "Armani Blue Shirt", 0, "Blue", "Awesome T-Shirt"));
        lista.add(new GalleryData(0, "Armani Blue Shirt", 0, "Blue", "Awesome T-Shirt"));
        lista.add(new GalleryData(0, "Armani Blue Shirt", 0, "Blue", "Awesome T-Shirt"));
    }

    @GetMapping("/hello")
    public String greeting() {
        return "Hola Mundo";
    }

    @GetMapping(value = "/data")
    public GalleryData dataUser() {
        return new GalleryData(0, "Armani Blue Shirt", 0, "Blue", "Awesome T-Shirt");
    }

    @GetMapping(value = "/data/{variable}/{otroDato}")
    public GalleryData dataUserWithPathVarible(@PathVariable String variable,
            @PathVariable String otroDato) {
        return new GalleryData(0, "Armani Blue Shirt", 0, "Blue", "Awesome T-Shirt");
    }

    @GetMapping("/search")
    public List<GalleryData> datos(@RequestParam String q) {

        List<GalleryData> resultados = new ArrayList<>();
        lista.forEach(dato -> {
            if (dato.getName().contains(q)) {
                resultados.add(dato);
            }
        });
        return resultados;
    }

    @RequestMapping (value = "/GalleryData", params = "orden")
    public List<GalleryData>  buscarTodos(@RequestParam (defaultValue = "id" ) String orden) {
        if (orden.equals("id")) {
        
          return lista.stream().sorted(Comparator.comparing(GalleryData::getId)).collect(Collectors.toList());
        }else if (orden.equals("name")) {
          
          return lista.stream().sorted(Comparator.comparing(GalleryData::getName)).collect(Collectors.toList());
        }else if (orden.equals("type")) {
          
            return lista.stream().sorted(Comparator.comparing(GalleryData::getType)).collect(Collectors.toList());
        }else if (orden.equals("colors")) {
          
            return lista.stream().sorted(Comparator.comparing(GalleryData::getColors)).collect(Collectors.toList());
        }else {
          
          return lista.stream().sorted(Comparator.comparing(GalleryData::getDefinition)).collect(Collectors.toList());
        }

    @PostMapping

    @DeleteMapping

    @GetMapping

}
}
