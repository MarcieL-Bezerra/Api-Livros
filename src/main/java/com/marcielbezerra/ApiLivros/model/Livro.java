package com.marcielbezerra.ApiLivros.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Livro {
    private int id;
    private String titulo;
    private String descricao;
    private String autor;
}
