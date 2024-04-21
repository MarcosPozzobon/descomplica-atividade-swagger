package com.marcos.desenvolvimento.backendkanbanagile.request;

import java.util.Date;

public record TaskRequest(
        String titulo,
        String descricao,
        String estado,
        Date previsaoEntrega,
        Date dataCriacao,
        Date dataUltimaAtualizacao,
        String responsavel
) {
}
