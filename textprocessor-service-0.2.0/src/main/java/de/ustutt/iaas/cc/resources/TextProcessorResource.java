package de.ustutt.iaas.cc.resources;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.codahale.metrics.annotation.ExceptionMetered;
import com.codahale.metrics.annotation.Timed;

import de.ustutt.iaas.cc.core.Globals;
import io.swagger.annotations.Api;

/**
 * The resource class providing all methods offered by the REST API.
 * 
 * @author hauptfn
 *
 */
@Path("")
@Api(value = "TextProcessor")
public class TextProcessorResource {

    private final static Logger logger = LoggerFactory.getLogger(TextProcessorResource.class);

    private final String id;

    public TextProcessorResource(String id) {
	super();
	this.id = id;
    }

    @POST
    @Consumes({ MediaType.TEXT_PLAIN })
    @Produces({ MediaType.TEXT_PLAIN })
    @Timed
    @ExceptionMetered
    public String processText(String text) {
	if (Globals.getLatencyMs() > 0) {
	    try {
		logger.debug("Processing latency, sleeping for {}ms.", Globals.getLatencyMs());
		Thread.sleep(Globals.getLatencyMs());
	    } catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	    }
	}
	return "[processed by " + id + "] - " + text;
    }

}
