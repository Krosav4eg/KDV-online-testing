package logger;

import java.io.File;
import java.io.IOException;
import java.util.logging.*;
import java.util.logging.Level;
import java.util.logging.Logger;

import static utils.Constants.LOGGING_FOLDER;
import static utils.Constants.LOGGING_HTML_FILE;
import static utils.Constants.LOGGING_TXT_FILE;

/**
 * @author Sergey Potapov
 */
public class MagDvLogger {
    private static final MagDvLogger MAG_DV_LOGGER = new MagDvLogger();
    private Logger logger;

    private MagDvLogger() {
        setup();
    }

    public static MagDvLogger getMagDvLogger() {
        return MAG_DV_LOGGER;
    }

    public Logger getLogger() {
        return logger;
    }

    /**
     * Get the global logger to configure it
     * Suppress the logging output to the console
     * Create a TXT formatter
     * Create an HTML formatter
     */
    private void setup() {

        File folder = new File(LOGGING_FOLDER +
                File.separator + "test-output");
        if (!folder.exists()) {
            folder.mkdir();
        }

        logger = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);
        Formatter formatterHTML = new HtmlLoggerFormatter();
        SimpleFormatter formatterTxt = new SimpleFormatter();
        FileHandler fileTxt;
        FileHandler fileHTML;

        Logger rootLogger = Logger.getLogger("");
        Handler[] handlers = rootLogger.getHandlers();
        if (handlers.length != 0) {
            if (handlers[0] instanceof ConsoleHandler) {
                rootLogger.removeHandler(handlers[0]);
            }
        }
        logger.setUseParentHandlers(false);
        logger.setLevel(Level.ALL);
        try {
            fileTxt = new FileHandler(LOGGING_TXT_FILE, true);
            fileHTML = new FileHandler(LOGGING_HTML_FILE, true);
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException("Unable to create log files!");
        }
        fileTxt.setFormatter(formatterTxt);
        logger.addHandler(fileTxt);

        fileHTML.setFormatter(formatterHTML);
        logger.addHandler(fileHTML);
    }
}
