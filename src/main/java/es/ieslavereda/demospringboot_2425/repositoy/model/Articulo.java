package es.ieslavereda.demospringboot_2425.repositoy.model;

public class Articulo {
     private int id;
     private String descArticulo;
     private int existencias;
     private double pvp;
     private int categoriaId;

     public Articulo(int id, String descArticulo, int existencias, double pvp, int categoriaId) {
          this.id = id;
          this.descArticulo = descArticulo;
          this.existencias = existencias;
          this.pvp = pvp;
          this.categoriaId = categoriaId;
     }

     public int getId() {
          return id;
     }

     public void setId(int id) {
          this.id = id;
     }

     public String getDescArticulo() {
          return descArticulo;
     }

     public void setDescArticulo(String descArticulo) {
          this.descArticulo = descArticulo;
     }

     public int getExistencias() {
          return existencias;
     }

     public void setExistencias(int existencias) {
          this.existencias = existencias;
     }

     public double getPvp() {
          return pvp;
     }

     public void setPvp(double pvp) {
          this.pvp = pvp;
     }

     public int getCategoriaId() {
          return categoriaId;
     }

     public void setCategoriaId(int categoriaId) {
          this.categoriaId = categoriaId;
     }
}
