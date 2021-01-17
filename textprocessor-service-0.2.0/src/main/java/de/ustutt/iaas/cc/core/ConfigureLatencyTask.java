package de.ustutt.iaas.cc.core;

import java.io.PrintWriter;
import java.util.Collection;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.codahale.metrics.annotation.ExceptionMetered;
import com.codahale.metrics.annotation.Timed;
import com.google.common.collect.ImmutableMultimap;

import io.dropwizard.servlets.tasks.Task;

/**
 * curl -X POST http://dw.example.com:8081/tasks/latency?latencyMs=500
 * 
 * @author hauptfn
 *
 */
public class ConfigureLatencyTask extends Task {

    private final static Logger logger = LoggerFactory.getLogger(ConfigureLatencyTask.class);

    private static final String TAKS_NAME = "latency";
    private static final String LATENCY_PARAM = "latencyMs";

    public ConfigureLatencyTask() {
	super(TAKS_NAME);
    }

    @Timed
    @ExceptionMetered
    @Override
    public void execute(ImmutableMultimap<String, String> parameters, PrintWriter output) throws Exception {
	// get parameter
	Collection<String> params = parameters.get(LATENCY_PARAM);
	// check parameters (we expect exactly one)
	if (!params.isEmpty()) {
	    if (params.size() > 1) {
		logger.warn("Found {} values for '{}', taking the first one, ignoring the rest.", params.size(),
			LATENCY_PARAM);
	    }
	    int oldLatency = Globals.getLatencyMs();
	    String newLatencyString = params.iterator().next();
	    try {
		int newLatency = Integer.parseInt(newLatencyString);
		Globals.setLatencyMs(newLatency);
		logger.info("Changed processing latency from {}ms to {}ms.", oldLatency, Globals.getLatencyMs());
	    } catch (NumberFormatException nfe) {
		logger.error("'{}' is not a number, latency stays unchanged ({}ms).", newLatencyString,
			Globals.getLatencyMs());
	    }
	} else {
	    logger.warn("No value for '{}' given, latency stays unchanged ({}ms).", LATENCY_PARAM,
		    Globals.getLatencyMs());
	}
    }

}
