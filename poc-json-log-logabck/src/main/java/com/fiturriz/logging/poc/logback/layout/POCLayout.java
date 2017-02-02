package com.fiturriz.logging.poc.logback.layout;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import ch.qos.logback.classic.spi.ILoggingEvent;
import ch.qos.logback.core.LayoutBase;

/**
 * @author fiturriz
 */
public class POCLayout extends LayoutBase<ILoggingEvent> {

    private ObjectMapper mapper;

    public POCLayout() {
        super();
        mapper = new ObjectMapper();
    }

    @Override
    public String doLayout(final ILoggingEvent iLoggingEvent) {

        StringBuffer sb = new StringBuffer();
        synchronized (mapper) {
            try{
                sb.append(mapper.writerWithDefaultPrettyPrinter().writeValueAsString(iLoggingEvent)).append("\n");
            }catch (JsonProcessingException e) {
                e.printStackTrace();
            }
        }
        return sb.toString();
    }

}
