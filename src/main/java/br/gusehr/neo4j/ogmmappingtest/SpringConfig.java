package br.gusehr.neo4j.ogmmappingtest;

import org.neo4j.ogm.config.Configuration.Builder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement(proxyTargetClass = true)
public class SpringConfig {

	@Autowired
	private Environment env;

	@Bean
	public org.neo4j.ogm.config.Configuration getConfiguration() {
		Builder configBuilder = new org.neo4j.ogm.config.Configuration.Builder();
		configBuilder.autoIndex(env.getProperty("neo4j.auto-index"))
				.uri(env.getProperty("neo4j.uri"))
				.credentials(env.getProperty("neo4j.username"), env.getProperty("neo4j.password"));
		return configBuilder.build();
	}

}
