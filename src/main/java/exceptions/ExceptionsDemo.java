package exceptions;

public class ExceptionsDemo {
    public static void main(String[] args) {
        LoggerFacade.log(" ");
    }
}

class LoggerFacade {
    private static LoggerController controller = new LoggerController();
    public static void log(String message) {
        controller.log(message);
    }
}

class LoggerController {
    private ConsoleSaver saver = new ConsoleSaver();
    public void log(String message) {
        //region t-c
        try {
            saver.save(message);
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        } catch (RuntimeException e) {
            e.printStackTrace();
            throw new LogOperationException("!!!", e);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {

        }
        //endregion
        //
    }
}

class ConsoleSaver {
    public void save(String message) {
        if (message == null || "".equals(message)) {
            throw new IllegalArgumentException("Input message is crap.");
        }
        throw new RuntimeException("IO Exception: ini.sys");
    }
}

class LogOperationException extends RuntimeException {
    public LogOperationException(String message) {
        super(message);
    }

    public LogOperationException(Throwable cause) {
        super(cause);
    }

    public LogOperationException(String message, Throwable cause) {
        super(message, cause);
    }
}