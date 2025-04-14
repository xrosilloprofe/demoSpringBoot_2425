package es.ieslavereda.demospringboot_2425.repositoy.model;

import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Articulo {
     private int id;
     private String descArticulo;
     private int existencias;
     private double pvp;
     private int categoriaId;
}
