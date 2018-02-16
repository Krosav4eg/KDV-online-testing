package logger;

import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.io.Writer;
import java.util.logging.*;

import static utils.Constants.*;

/**
 * @author Sergey Potapov
 */
public class MagDvLogger extends Handler {
    private static final MagDvLogger MAG_DV_LOGGER = new MagDvLogger();
    private Logger logger;
    private OutputStream output;
    private boolean doneHeader;
    private volatile Writer writer;
    public static boolean doneFooter = true;

    private MagDvLogger() {
        setup();
    }

    @Override
    public void publish(LogRecord record) {
        if (!isLoggable(record)) {
            return;
        }
        String msg;
        try {
            msg = getFormatter().format(record);
        } catch (Exception ex) {
            // We don't want to throw an exception here, but we
            // report the exception to any registered ErrorManager.
            reportError(null, ex, ErrorManager.FORMAT_FAILURE);
            return;
        }
        try {
            if (!doneHeader) {
                writer.write(getFormatter().getHead(this));
                doneHeader = true;
            }
            if (!doneFooter) {
                writer.write("TEST");
            }
            writer.write(msg);
        } catch (Exception ex) {
            // We don't want to throw an exception here, but we
            // report the exception to any registered ErrorManager.
            reportError(null, ex, ErrorManager.WRITE_FAILURE);
        }
    }

    @Override
    public void flush() {

    }

    @Override
    public void close() throws SecurityException {

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
            folder.mkdirs();
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
