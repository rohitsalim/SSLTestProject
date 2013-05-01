package com.rtr.infra.SSLTestProject;

import com.rtr.infra.SSLTestProject.resources.SSLTestProjectResource;
import com.yammer.dropwizard.Service;
import com.yammer.dropwizard.config.Bootstrap;
import com.yammer.dropwizard.config.Environment;

/**
 * Hello world!
 *
 */
public class DWService extends Service<TestProjectConfiguration> 
{
    public static void main( String[] args ) throws Exception
    {
       new DWService().run(args);
    }


	@Override
	public void initialize(Bootstrap<TestProjectConfiguration> bootstrap) {
		bootstrap.setName("SSL TEST PROJECT");
	}

	@Override
	public void run(TestProjectConfiguration configuration, Environment environment) throws Exception {
		String template = configuration.getTemplate();
		String defaultName = configuration.getDefaultName();
		environment.addResource(new SSLTestProjectResource(template, defaultName));
	}
}
