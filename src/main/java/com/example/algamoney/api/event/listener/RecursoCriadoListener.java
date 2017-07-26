package com.example.algamoney.api.event.listener;

import java.net.URI;

import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.example.algamoney.api.event.RecursoCriadoEvent;

@Component
public class RecursoCriadoListener implements ApplicationListener<RecursoCriadoEvent> {

	@Override
	public void onApplicationEvent(RecursoCriadoEvent recursoEvent) {
		HttpServletResponse response = recursoEvent.getResponse();
		Long codigo = recursoEvent.getCodigo();

		adicionarHeaderLocation(response, codigo);
	}

	/**
	 * Metodo para adicioanr o header location na resposta da requisição rest.
	 * 
	 * @param response
	 * @param codigo
	 */
	private void adicionarHeaderLocation(HttpServletResponse response, Long codigo) {
		URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{codigo}").buildAndExpand(codigo).toUri();
		response.setHeader("location", uri.toASCIIString());
	}

}
