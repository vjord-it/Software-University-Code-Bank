package BashSoft.src.bashsoft;

import BashSoft.src.bashsoft.io.CommandInterpreter;
import BashSoft.src.bashsoft.io.IOManager;
import BashSoft.src.bashsoft.io.InputReader;
import BashSoft.src.bashsoft.judge.Tester;
import BashSoft.src.bashsoft.network.DownloadManager;
import BashSoft.src.bashsoft.repository.RepositoryFilter;
import BashSoft.src.bashsoft.repository.RepositorySorter;
import BashSoft.src.bashsoft.repository.StudentsRepository;

public class Main {

    public static void main(String[] args) {
        Tester tester = new Tester();
        DownloadManager downloadManager = new DownloadManager();
        IOManager ioManager = new IOManager();
        RepositorySorter sorter = new RepositorySorter();
        RepositoryFilter filter = new RepositoryFilter();
        StudentsRepository repository = new StudentsRepository(filter, sorter);
        CommandInterpreter currentInterpreter =
                new CommandInterpreter(tester, repository, downloadManager, ioManager);
        InputReader reader = new InputReader(currentInterpreter);

        try {
            reader.readCommands();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
