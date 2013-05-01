package com.rtr.infra.SSLTestProject.resources;

import java.util.concurrent.atomic.AtomicLong;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.common.base.Optional;
import com.rtr.infra.SSLTestProject.api.Saying;
import com.yammer.metrics.annotation.Timed;

@Path("/Hello-world")
@Produces(MediaType.APPLICATION_JSON)
public class SSLTestProjectResource {
	
	private final String template;
	private final String defaultName;
	private final AtomicLong counter;
	private final Logger LOG = LoggerFactory.getLogger(SSLTestProjectResource.class);
	
	
	public SSLTestProjectResource(String template, String defaultName) {
		this.template = template;
		this.defaultName = defaultName;
		this.counter = new AtomicLong();
	}
	
	@GET
	@Timed
	@Path("/sayHello")
	public Saying sayHello(@QueryParam("name") Optional<String> name) {
		LOG.info("Hitting Say Hello");
		return new Saying(counter.incrementAndGet(), String.format(template, name.or(defaultName)));
	}
	
	@GET
	@Timed
	@Path("/sayAWESOME")
	public String sayAWESOME() {
		LOG.info("Hitting Say Awesome");
		return "AWESOME";
	}
}
