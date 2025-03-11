package service;

import model.Categoria;
import repository.CategoriaRepository;

import java.util.List;
import java.util.Optional;

public class CategoriaService{

    private CategoriaService categoriaService = new CategoriaService();

    public void criarCategoria(Categoria categoria){
        categoriaRepository.adicionar(categoria);
    }
    public Optional<Categoria> buscarPorId(long id){
        return categoriaRepository.buscarPorId(id);
    }
    public List<Categoria> listarTodos(){
        return categoriaRepository.listarTodos();
    }
    public boolean atualizar(Categoria categoriaAtualizada){
        return categoriaRepository.atualizar(categoriaAtualizada);
    }
    public boolean deletarCategoria(Long id){
        return categoriaRepository.remover(id);
    }
}