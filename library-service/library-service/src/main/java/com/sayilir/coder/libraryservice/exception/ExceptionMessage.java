package com.sayilir.coder.libraryservice.exception;

import java.util.Objects;

public final  class ExceptionMessage {
    private final String timestamp;
    private final int status;
    private final String error;
    private final String message;
    private final String path;

    public ExceptionMessage(String timestamp,
                            int status,
                            String error,
                            String message,
                            String path) {
        this.timestamp = timestamp;
        this.status = status;
        this.error = error;
        this.message = message;
        this.path = path;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public int getStatus() {
        return status;
    }

    public String getError() {
        return error;
    }

    public String getMessage() {
        return message;
    }

    public String getPath() {
        return path;
    }

   /* public String timestamp() {
        return timestamp;
    }

    public int status() {
        return status;
    }

    public String error() {
        return error;
    }

    public String message() {
        return message;
    }

    public String path() {
        return path;
    }
*/
    @Override
    public boolean equals(Object obj) {
        if (obj == this) return true;
        if (obj == null || obj.getClass() != this.getClass()) return false;
        var that = (ExceptionMessage) obj;
        return Objects.equals(this.timestamp, that.timestamp) &&
                this.status == that.status &&
                Objects.equals(this.error, that.error) &&
                Objects.equals(this.message, that.message) &&
                Objects.equals(this.path, that.path);
    }

    @Override
    public int hashCode() {
        return Objects.hash(timestamp, status, error, message, path);
    }

    @Override
    public String toString() {
        return "ExceptionMessage[" +
                "timestamp=" + timestamp + ", " +
                "status=" + status + ", " +
                "error=" + error + ", " +
                "message=" + message + ", " +
                "path=" + path + ']';
    }

}
