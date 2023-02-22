package com.marcielbezerra.ApiLivros.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CriarLivroRequest {
    private String titulo;
    private String descricao;
    private String autor;
}
