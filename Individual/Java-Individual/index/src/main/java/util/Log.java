package util;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Log {
    private static final int MAX_FILE_SIZE = 1000000;
    private final String LOG_DIRECTORY = "/home/ubuntu/Desktop/Logs/RegistrosAntigos";
    private final String LOG_FILE_PREFIX = "logs";
    private final String LOG_FILE_EXTENSION = ".txt";
    private final String dataAtual = new SimpleDateFormat("yyyyMMdd").format(new Date());

    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    private String getLogFileName() {
        return LOG_DIRECTORY + LOG_FILE_PREFIX + dataAtual + LOG_FILE_EXTENSION;
    }

    private String getLogLine(LogLevel level, String message) {
        String timestamp = dateFormat.format(new Date());
        return "[" + timestamp + "] [" + level + "] " + message;
    }

    public void makeLog(LogLevel level, String message) {
        String logLine = getLogLine(level, message);

        String currentLogFileName = getLogFileName();
        File currentLogFile = new File(currentLogFileName);
        if (currentLogFile.exists() && currentLogFile.length() > MAX_FILE_SIZE) {
            currentLogFileName = getLogFileName();
            currentLogFile = new File(currentLogFileName);
        }

        try (PrintWriter out = new PrintWriter(new FileWriter(currentLogFile, true))) {
            out.println(logLine);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
