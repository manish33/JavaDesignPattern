package LLDQuestions.Logger.LoggerWithSingleTon;



import java.io.PrintWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;

enum LogLevel {
    TRACE(1),
    DEBUG(2),
    INFO(3),
    WARNING(4),
    ERROR(5);
    // must be in sync with JVM levels.

    final int level;

    LogLevel(int level) {
        this.level = level;
    }
}

// LogSink interface
interface LogSink {
    void log(String message);
}

// ConsoleLogSink implementation
class ConsoleLogSink implements LogSink {
    @Override
    public void log(String message) {
        System.out.println(message);
    }
}

// FileLogSink implementation
class FileLogSink implements LogSink {
    private String filename;

    public FileLogSink(String filename) {
        this.filename = filename;
    }

    @Override
    public void log(String message) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(filename, true))) {
            writer.println(message);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

// Logger class
class Logger {
    private static Logger instance;
    private LogLevel logLevel;
    private LogSink logSink;

    private Logger() {
        logLevel = LogLevel.INFO; // Default log level
        logSink = new ConsoleLogSink(); // Default log sink
    }

    public static Logger getInstance() {
        if (instance == null) {
            instance = new Logger();
        }
        return instance;
    }

    public void setLogLevel(LogLevel level) {
        logLevel = level;
    }

    public void setLogSink(LogSink sink) {
        logSink = sink;
    }

    public void log(LogLevel level, String message) {
        if (logLevel.ordinal() <= level.ordinal()) {
            String logMessage = "[" + new Date() + "] [" + level + "] " + message;
            logSink.log(logMessage);
        }
    }
}

// Main class
public class Solution {
    public static void main(String[] args) {
        Logger logger = Logger.getInstance();

        // Using ConsoleLogSink
        logger.setLogSink(new ConsoleLogSink());

        logger.setLogLevel(LogLevel.INFO);

        logger.log(LogLevel.INFO, "This is an info message");
        logger.log(LogLevel.WARNING, "This is a warning message");
        logger.log(LogLevel.ERROR, "This is an error message");

        // Using FileLogSink
        logger.setLogSink(new FileLogSink("log.txt"));

        logger.log(LogLevel.INFO, "Logging to a file");
    }
}