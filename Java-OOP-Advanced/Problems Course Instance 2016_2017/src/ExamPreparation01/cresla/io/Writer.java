package ExamPreparation01.cresla.io;

import ExamPreparation01.cresla.interfaces.OutputWriter;

public class Writer implements OutputWriter {
    @Override
    public void write(String output) {
        if (output != null) {
            System.out.print(output);
        }
    }

    @Override
    public void writeLine(String output) {
        if (output != null) {
            System.out.println(output);
        }
    }
}
