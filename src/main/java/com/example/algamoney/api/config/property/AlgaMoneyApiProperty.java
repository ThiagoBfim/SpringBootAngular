package com.example.algamoney.api.config.property;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties("algamoney")
public class AlgaMoneyApiProperty {

	private final Seguranca seguranca = new Seguranca();

	private final String originPermitida = "http://localhost:8000";

	public Seguranca getSeguranca() {
		return seguranca;
	}

	public String getOriginPermitida() {
		return originPermitida;
	}

	public static class Seguranca {
		private boolean enabledHttps;

		public boolean isEnabledHttps() {
			return enabledHttps;
		}

		public void setEnabledHttps(boolean enabledHttps) {
			this.enabledHttps = enabledHttps;
		}

	}

}
