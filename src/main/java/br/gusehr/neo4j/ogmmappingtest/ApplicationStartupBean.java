package br.gusehr.neo4j.ogmmappingtest;

import org.neo4j.ogm.session.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Component
public class ApplicationStartupBean implements ApplicationListener<ApplicationReadyEvent> {

	@Autowired
	private PersonRepository personRepository;

	private static Logger LOGGER = LoggerFactory.getLogger(ApplicationStartupBean.class);

	@Override
	public void onApplicationEvent(ApplicationReadyEvent event) {
		long personCount = personRepository.count();
		LOGGER.info("Load test of {} entities", personCount);

		testSingleUseEntityMapper();
		testGraphEntityMapper();
	}

	private void testGraphEntityMapper() {
		LOGGER.info("Entity Mapper - loading entities");
		Iterable<Person> persons = personRepository.findAll();
		LOGGER.info("Entity Mapper - loaded entities");
	}

	private void testSingleUseEntityMapper() {
		LOGGER.info("Result Mapper - loading entities");
		Iterable<PersonQueryResult> persons = personRepository.findAllByQuery();
		LOGGER.info("Result Mapper - loaded entities");
	}

}
