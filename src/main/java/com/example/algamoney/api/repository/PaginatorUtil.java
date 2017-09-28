package com.example.algamoney.api.repository;

import javax.persistence.TypedQuery;

import org.springframework.data.domain.Pageable;

public class PaginatorUtil {

	public static void adicionarRestricoesDePaginacao(TypedQuery<?> query, Pageable pageable) {
		int paginaAtual = pageable.getPageNumber();
		int totalRegistrosPagina = pageable.getPageSize();
		int primeiroRegistro = paginaAtual * totalRegistrosPagina;

		query.setFirstResult(primeiroRegistro);
		query.setMaxResults(totalRegistrosPagina);

	}
}
