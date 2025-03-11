package controller;

import model.Categoria;
import service.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController

@RequestMapping("/categorias")

public class CategoriaController {

    @Autowired
    private CategoriaService categoriaService;

    @PostMapping
    public ResponseEntity<Categoria> criarCategoria(@RequestBody Categoria categoria){
        categoriaService.criarCategoria(categoria);
        return ResponseEntity.ok(categoria);
    }
    @GetMapping
    public ResponseEntity<List<Categoria>> listarTodos(){
        List<Categoria> categorias = categoriaService.listarTodos();
        return ResponseEntity.ok(categorias);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Categoria> buscarPorId(@PathVariable long id){
        Optional<Categoira> categoria  = categoriaService.buscarPorId(id);
        return categoria.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }
    @PutMapping("/{id}")
    public ResponseEntity<Categoria> atualizar(@PathVariable long id, @RequestBody Categoria categoriaAtualizada){
        categoriaAtualizada.setId(id);
        boolean atualizado = categoriaService.atualizar(categoriaAtualizada);
        if(atualizado){
            return ResponseEntity.ok(categoriaAtualizada);
        }else {
            return ResponseEntity.notFound().build();
        }
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarCategoria(@PathVariable long id){
        boolean deletado = categoriaService.deletarCategoria(id);
        if(deletado){
            return ResponseEntity.noContent().build();
        }else {
            return ResponseEntity.notFound().build();
        }
    }
}