package com.StockManager.Model.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class UsuarioLoginDTO {
    private String nome;
    private String senha;
    private String email;
    private String permissao;
}
