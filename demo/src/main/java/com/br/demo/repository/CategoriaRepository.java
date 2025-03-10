package repository;

import model.Categoria;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class CategoriaRepository{
    private List<Categoria> categorias = new ArrayList<>();

    public void adicionar(Categoria categoria){
        categorias.add(categoria);
    }
    public Optional<Categoria> buscarPorId(long id){
        return categorias.stream().filter(c -> c.getId() == id).findFirst();
    }
    public List<Categoria> listarTodos(){
        return new ArrayList<>(categorias);
    }
    public boolean atualizar(Categoria categoriaAtualizada){
        Optional<Categoria> categoriaOptional = buscarPorId(categoriaAtualizada.getId());
        if(categoriaOptional.isPresent()){
            Categoria categoria = categoriaOptional.get();
            categoria.setNome(categoriaAtualizada.getNome());
            categoria.setDescricao(categoriaAtualizada.getDescricao());
            return true;
        }
        return false
    }
    public boolean remover(long id){
        return categorias.removeIf(c -> c.getId() == id);
    }
}