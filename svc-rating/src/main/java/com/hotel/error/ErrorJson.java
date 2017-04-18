package com.hotel.error;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

public class ErrorJson {

    private Integer status;
    private String error;
    private String message;
    @JsonFormat(shape = JsonFormat.Shape.STRING, timezone = "UTC", pattern = "EEE MMM dd HH:mm:ss z yyyy")
    private Date timeStamp;
    private String trace;

    public Integer getStatus() {
        return status;
    }

    public String getError() {
        return error;
    }

    public String getMessage() {
        return message;
    }

    public Date getTimeStamp() {
        return timeStamp;
    }

    public String getTrace() {
        return trace;
    }

    public static ErrorJsonBuilder newBuilder() {
        return new ErrorJsonBuilder();
    }
    
    public static class ErrorJsonBuilder {
        ErrorJson errorJson;

        public ErrorJsonBuilder() {
            errorJson = new ErrorJson();
        }

        public ErrorJsonBuilder setStatus(Integer status) {
            errorJson.status = status;
            return this;
        }

        public ErrorJsonBuilder setError(String errorStr) {
            errorJson.error = errorStr;
            return this;
        }

        public ErrorJsonBuilder setMessage(String message) {
            errorJson.message = message;
            return this;
        }

        public ErrorJsonBuilder setTimeStamp(Date timeStamp) {
            errorJson.timeStamp = timeStamp;
            return this;
        }

        public ErrorJsonBuilder setTrace(String trace) {
            errorJson.trace = trace;
            return this;
        }

        public ErrorJson done() {
            return errorJson;
        }
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("ErrorJson [status=").append(status).append(", error=")
                .append(error).append(", message=").append(message)
                .append(", timeStamp=").append(timeStamp).append(", trace=")
                .append(trace).append("]");
        return builder.toString();
    }
    
}
