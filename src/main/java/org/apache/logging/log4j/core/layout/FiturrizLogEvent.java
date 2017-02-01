package org.apache.logging.log4j.core.layout;

import static java.nio.charset.StandardCharsets.UTF_8;

import java.io.IOException;
import java.util.Map;
import java.util.stream.Collectors;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fiturriz.logging.model.LogData;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.Marker;
import org.apache.logging.log4j.ThreadContext;
import org.apache.logging.log4j.core.LogEvent;
import org.apache.logging.log4j.core.impl.ThrowableProxy;
import org.apache.logging.log4j.message.Message;

/**
 * Created by frankieic on 1/31/17.
 */
public class FiturrizLogEvent implements LogEvent {

    public static final String LOG_DATA = "logdata";

    private LogData logData;

    private LogEvent logEvent;

    private Map<String,String> contextMap;

    private ObjectMapper mapper;

    public FiturrizLogEvent() {
        mapper = new ObjectMapper();
    }

    public FiturrizLogEvent(final LogEvent logEvent) {
        this();
        this.logEvent = logEvent;
        logData = this.retrieveLogData(logEvent);
    }

    protected LogData retrieveLogData(final LogEvent logEvent){

        LogData logData = null;

        try {
            String strLogData = logEvent.getContextMap().get(LOG_DATA);

            if (strLogData != null && !strLogData.isEmpty()) {

                logData = mapper.readValue(strLogData.getBytes(UTF_8),LogData.class);

                contextMap = this.filterContextMap(logEvent.getContextMap());
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        return logData;

    }

    protected Map<String,String> filterContextMap(final Map<String, String> origin){

        Map<String,String> contextMap = null;

        if(logEvent.getContextMap() != null && !logEvent.getContextMap().isEmpty()) {

            contextMap = logEvent.getContextMap().entrySet().stream()
                .filter(map -> !map.getKey().equals(LOG_DATA))
                .collect(Collectors.toMap(p -> p.getKey(), p -> p.getValue()));
        }

        return contextMap;
    }

    public LogData getLogData() {
        return logData;
    }

    @Override
    public Map<String, String> getContextMap() {
        return contextMap != null ? contextMap : logEvent.getContextMap();
    }

    @Override
    public ThreadContext.ContextStack getContextStack() {
        return logEvent.getContextStack();
    }

    @Override
    public String getLoggerFqcn() {
        return logEvent.getLoggerFqcn();
    }

    @Override
    public Level getLevel() {
        return logEvent.getLevel();
    }

    @Override
    public String getLoggerName() {
        return logEvent.getLoggerName();
    }

    @Override
    public Marker getMarker() {
        return logEvent.getMarker();
    }

    @Override
    public Message getMessage() {
        return logEvent.getMessage();
    }

    @Override
    public long getTimeMillis() {
        return logEvent.getTimeMillis();
    }

    @Override
    public StackTraceElement getSource() {
        return logEvent.getSource();
    }

    @Override
    public String getThreadName() {
        return logEvent.getThreadName();
    }

    @Override
    public long getThreadId() {
        return logEvent.getThreadId();
    }

    @Override
    public int getThreadPriority() {
        return logEvent.getThreadPriority();
    }

    @Override
    public Throwable getThrown() {
        return logEvent.getThrown();
    }

    @Override
    public ThrowableProxy getThrownProxy() {
        return logEvent.getThrownProxy();
    }

    @Override
    public boolean isEndOfBatch() {
        return logEvent.isEndOfBatch();
    }

    @Override
    public boolean isIncludeLocation() {
        return logEvent.isIncludeLocation();
    }

    @Override
    public void setEndOfBatch(boolean endOfBatch) {
        logEvent.setEndOfBatch(endOfBatch);
    }

    @Override
    public void setIncludeLocation(boolean locationRequired) {
        logEvent.setIncludeLocation(locationRequired);
    }

    @Override
    public long getNanoTime() {
        return logEvent.getNanoTime();
    }
}
