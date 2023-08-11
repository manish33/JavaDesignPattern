package LLDQuestions.Logger.LoggerWithSingletonWithFactoryMethod;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

enum LogLevel {
    INFO, WARNING, ERROR
}
interface LogSink {
    void log(String message);
}
class ConsoleSink implements LogSink {
    @Override
    public void log(String message) {
        System.out.println(message);
    }
}
class FileSink implements LogSink {
    private String filename;
    public FileSink(String filename) {
        this.filename = filename;
    }
    @Override
    public void log(String message) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(filename,true))) {
            writer.println(message);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
interface LoggerFactory {
    Logger createLogger();
}
class ConsoleLoggerFactory implements LoggerFactory {
    @Override
    public Logger createLogger() {
        Logger instance = Logger.getInstance(LogLevel.INFO,new ConsoleSink());
        instance.setLogLevel(LogLevel.INFO);
        instance.setLogSink(new ConsoleSink());
        return instance;
    }
}
class FileLoggerFactory implements LoggerFactory {
    private String filename;
    public FileLoggerFactory(String filename) {
        this.filename = filename;
    }
    @Override
    public Logger createLogger() {
        Logger instance = Logger.getInstance(LogLevel.WARNING, new FileSink(filename));
        instance.setLogLevel(LogLevel.INFO);
        instance.setLogSink(new FileSink(filename));
        return instance;
    }
}
class Logger {
    private LogLevel logLevel;
    private LogSink logSink;
    private static Logger instance;
    private Logger(LogLevel logLevel, LogSink logSink) {
        this.logLevel = logLevel;
        this.logSink = logSink;
    }
    public static Logger getInstance(LogLevel logLevel, LogSink logSink) {
        if (instance == null) {
            instance = new Logger(logLevel, logSink);
        }
        return instance;
    }
    public void setLogSink(LogSink logSink) {
        this.logSink = logSink;
    }
    public void setLogLevel(LogLevel logLevel) {
        this.logLevel = logLevel;
    }
    public void log(LogLevel level, String message) {
        if (level.ordinal() >= logLevel.ordinal()) {
            String logMessage = "[" + level + "] " + message;
            logSink.log(logMessage);
        }
    }
}
public class Solution {
    public static void main(String[] args) {
        LoggerFactory consoleLoggerFactory = new ConsoleLoggerFactory();
        LoggerFactory fileLoggerFactory = new FileLoggerFactory("log.txt");

        Logger consoleLogger = consoleLoggerFactory.createLogger();
        consoleLogger.log(LogLevel.INFO, "This is an info message");

        Logger fileLogger = fileLoggerFactory.createLogger();
        fileLogger.log(LogLevel.WARNING, "This is a warning message");
    }
}










