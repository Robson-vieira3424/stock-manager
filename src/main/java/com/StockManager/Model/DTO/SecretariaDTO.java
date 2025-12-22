package com.StockManager.Model.DTO;

import lombok.Getter;
import lombok.Setter;


import java.util.List;
@Getter
@Setter
public class SecretariaDTO {

    private String nome;

    private List<String> departamentos;
}
