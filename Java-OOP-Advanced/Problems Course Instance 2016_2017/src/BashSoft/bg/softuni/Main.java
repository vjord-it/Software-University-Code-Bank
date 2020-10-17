package BashSoft.bg.softuni;

import BashSoft.bg.softuni.io.CommandInterpreter;
import BashSoft.bg.softuni.io.IOManager;
import BashSoft.bg.softuni.io.InputReader;
import BashSoft.bg.softuni.io.OutputWriter;
import BashSoft.bg.softuni.judge.Tester;
import BashSoft.bg.softuni.network.DownloadManager;
import BashSoft.bg.softuni.repository.RepositoryFilter;
import BashSoft.bg.softuni.repository.RepositorySorter;
import BashSoft.bg.softuni.repository.StudentsRepository;

public class Main {

    public static void main(String[] args) {
        Tester tester = new Tester();
        DownloadManager downloadManager = new DownloadManager();
        IOManager ioManager = new IOManager();
        RepositorySorter sorter = new RepositorySorter();
        RepositoryFilter filter = new RepositoryFilter();
        StudentsRepository repository = new StudentsRepository(filter, sorter);
        CommandInterpreter currentInterpreter = new CommandInterpreter(
                tester, repository, downloadManager, ioManager);
        InputReader reader = new InputReader(currentInterpreter);

        try {
            reader.readCommands();
        } catch (Exception e) {
            OutputWriter.displayException(e.getMessage());
        }
    }
}