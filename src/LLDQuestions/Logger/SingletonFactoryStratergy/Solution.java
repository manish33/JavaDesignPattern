package LLDQuestions.Logger.SingletonFactoryStratergy;

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
        // Implement file logging logic using PrintWriter or FileWriter here
    }
}

interface LogLevelStrategy {
    boolean shouldLog(LogLevel messageLogLevel, LogLevel loggerLogLevel);

    LogLevel getLogLevel();
}

class LogAllStrategy implements LogLevelStrategy {
    @Override
    public boolean shouldLog(LogLevel messageLogLevel, LogLevel loggerLogLevel) {
        return messageLogLevel.ordinal() >= loggerLogLevel.ordinal();
    }

    @Override
    public LogLevel getLogLevel() {
        return LogLevel.INFO;
    }

}

class LogWarningAndErrorStrategy implements LogLevelStrategy {
    @Override
    public boolean shouldLog(LogLevel messageLogLevel, LogLevel loggerLogLevel) {
        return messageLogLevel.ordinal() >= LogLevel.WARNING.ordinal();
    }

    @Override
    public LogLevel getLogLevel() {
        return LogLevel.WARNING;
    }
}

interface LoggerFactory {
    Logger createLogger();
}

class ConsoleLoggerFactory implements LoggerFactory {
    @Override
    public Logger createLogger() {
        return new Logger(new LogAllStrategy(), new ConsoleSink());
    }
}

class FileLoggerFactory implements LoggerFactory {
    private String filename;

    public FileLoggerFactory(String filename) {
        this.filename = filename;
    }

    @Override
    public Logger createLogger() {
        return new Logger(new LogWarningAndErrorStrategy(), new FileSink(filename));
    }
}

class Logger {
    private LogLevelStrategy logLevelStrategy;
    private LogSink logSink;

    public Logger(LogLevelStrategy logLevelStrategy, LogSink logSink) {
        this.logLevelStrategy = logLevelStrategy;
        this.logSink = logSink;
    }

    public void setLogLevelStrategy(LogLevelStrategy logLevelStrategy) {
        this.logLevelStrategy = logLevelStrategy;
    }

    public void setLogSink(LogSink logSink) {
        this.logSink = logSink;
    }

    public void log(LogLevel level, String message) {
        if (logLevelStrategy.shouldLog(level, logLevelStrategy.getLogLevel())) {
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
        Logger fileLogger = fileLoggerFactory.createLogger();
        consoleLogger.log(LogLevel.INFO, "This is an info message");
        fileLogger.log(LogLevel.ERROR, "This is an error message");
    }
}
