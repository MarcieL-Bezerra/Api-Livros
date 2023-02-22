package com.marcielbezerra.ApiLivros.controller;

import com.marcielbezerra.ApiLivros.model.CriarLivroRequest;
import com.marcielbezerra.ApiLivros.model.Livro;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/livros")
public class LivrosController {
    private final List<Livro> livros = new ArrayList<>();

    @GetMapping
    public List<Livro> buscaLivros(){
        return livros;
    }

    @PostMapping
    public Livro criarLivro(@RequestBody CriarLivroRequest request){
        int randomNum = livros.size() + 1;

        Livro livro = new Livro(
                randomNum,
                request.getTitulo(),
                request.getDescricao(),
                request.getAutor()
        );
        livros.add(livro);
        return livro;
    }
    @PutMapping("/{id}")
    public ResponseEntity<Object> editaLivro(@PathVariable int id, @RequestBody CriarLivroRequest request){

        Optional<Livro> existeLivro = livros.stream()
                .filter(livro -> livro.getId() == id)
                .findFirst();

        if (existeLivro.isPresent()) {
            Livro livroEditado = existeLivro.get();

            livroEditado.setTitulo(request.getTitulo());
            livroEditado.setDescricao(request.getDescricao());
            livroEditado.setAutor(request.getAutor());

            return ResponseEntity.ok(livroEditado);
        }
        return ResponseEntity.notFound().build();
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Object> excluiLivro(@PathVariable int id){

        boolean existeLivro = livros.removeIf(livro -> livro.getId() == id);

        if (existeLivro) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}
