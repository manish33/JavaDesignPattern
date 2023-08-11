package LLDQuestions.Logger.LoggerBasic;
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
        try (PrintWriter writer = new PrintWriter(filename)) {
            writer.println(message);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
class Logger {
    private LogLevel logLevel;
    private LogSink logSink;
    public Logger(LogLevel logLevel, LogSink logSink) {
        this.logLevel = logLevel;
        this.logSink = logSink;
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
        LogSink consoleSink = new ConsoleSink();
        LogSink fileSink = new FileSink("log.txt");

        Logger consoleLogger = new Logger(LogLevel.INFO, consoleSink);
        Logger fileLogger = new Logger(LogLevel.WARNING, fileSink);

        consoleLogger.log(LogLevel.INFO, "This is an info message");
        consoleLogger.log(LogLevel.WARNING, "This is a warning message");
        fileLogger.log(LogLevel.ERROR, "This is an error message");
    }
}