package logger;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Formatter;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.LogRecord;

/**
 * @author Sergey Potapov
 */
public class HtmlLoggerFormatter extends Formatter {
    private static final String CLOSE_TABLE_CELL_TAG = "</td>\n";
    private static final String CLOSE_TABLE_TAG = "\t<td>";
    private static final String CLOSE_TABLE_ROW = "</tr>\n";

    /**
     * This method is called for every log record
     *
     * @param rec - logger record instance
     * @return formatted log message string
     */
    @Override
    public String format(LogRecord rec) {
        StringBuilder buf = new StringBuilder(1000);
        buf.append(CLOSE_TABLE_ROW);

        if (rec.getLevel().intValue() >= Level.WARNING.intValue()) {
            buf.append("\t<td style=\"color:red\">");
            buf.append("<b>");
            buf.append(rec.getLevel());
            buf.append("</b>");
        } else {
            buf.append(CLOSE_TABLE_TAG);
            buf.append(rec.getLevel());
        }

        buf.append(CLOSE_TABLE_CELL_TAG);
        buf.append(CLOSE_TABLE_TAG);
        buf.append(calcDate(rec.getMillis()));
        buf.append(CLOSE_TABLE_CELL_TAG);
        buf.append(CLOSE_TABLE_TAG);
        buf.append(formatMessage(rec));
        buf.append(CLOSE_TABLE_CELL_TAG);
        buf.append(CLOSE_TABLE_ROW);

        return buf.toString();
    }

    /**
     * Calculate date-time of logging
     *
     * @param milliseconds - time in milliseconds
     * @return - string with formatted date
     */
    private String calcDate(long milliseconds) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("MMM dd,yyyy HH:mm");
        Date resultDate = new Date(milliseconds);
        return dateFormat.format(resultDate);
    }

    /**
     * This method is called just after the handler using this formatter is created
     *
     * @param h - handler
     * @return - html string
     */
    @Override
    public String getHead(Handler h) {
        return "<!DOCTYPE html>\n<head>\n<style>\n"
                + "table { width: 100% }\n"
                + "th { font:bold 10pt Tahoma; }\n"
                + "td { font:normal 10pt Tahoma; }\n"
                + "h1 {font:normal 11pt Tahoma;}\n"
                + "</style>\n"
                + "</head>\n"
                + "<body>\n"
                + "<h1>" + (new Date()) + "</h1>\n"
                + "<table border=\"0\" cellpadding=\"5\" cellspacing=\"3\">\n"
                + "<tr align=\"left\">\n"
                + "\t<th style=\"width:10%\">Loglevel</th>\n"
                + "\t<th style=\"width:15%\">Time</th>\n"
                + "\t<th style=\"width:75%\">Log Message</th>\n"
                + "</tr>\n";
    }

    /**
     * This method is called just after the handler using this formatter is closed
     *
     * @param h - handler
     * @return - html table
     */
    @Override
    public String getTail(Handler h) {
        return "</table>\n</body>\n</html>";
    }
}
