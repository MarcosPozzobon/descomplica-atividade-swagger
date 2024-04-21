package com.marcos.desenvolvimento.backendkanbanagile.response;

import java.util.Date;
import java.util.List;

public record TaskResponse (
        Long id,
        String titulo,
        String descricao,
        String estado,
        Date previsaoEntrega,
        Date dataCriacao,
        Date dataUltimaAtualizacao,
        String responsavel
) {
}
