package ExamPreparation02.hell.io;

import ExamPreparation02.hell.interfaces.OutputWriter;

public class ConsoleWriter implements OutputWriter {

    @Override
    public void writeLine(String output) {
        if (output != null) {
            System.out.println(output);
        }
    }

    @Override
    public void writeLine(String format, Object... params) {
        if (format != null) {
            System.out.printf(format, params);
        }
    }
}
