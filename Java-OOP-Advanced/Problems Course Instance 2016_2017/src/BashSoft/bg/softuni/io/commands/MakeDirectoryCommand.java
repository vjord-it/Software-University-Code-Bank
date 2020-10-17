package BashSoft.bg.softuni.io.commands;

import BashSoft.bg.softuni.exceptions.InvalidInputException;
import BashSoft.bg.softuni.io.IOManager;
import BashSoft.bg.softuni.judge.Tester;
import BashSoft.bg.softuni.network.DownloadManager;
import BashSoft.bg.softuni.repository.StudentsRepository;

public class MakeDirectoryCommand extends Command {

    public MakeDirectoryCommand(String input,
                                String[] data,
                                Tester tester,
                                StudentsRepository repository,
                                DownloadManager downloadManager,
                                IOManager ioManager) {
        super(input, data, tester, repository, downloadManager, ioManager);
    }

    @Override
    public void execute() throws Exception {
        String[] data = this.getData();
        if (data.length != 2) {
            throw new InvalidInputException(this.getInput());
        }

        String folderName = data[1];
        this.getIoManager().createDirectoryInCurrentFolder(folderName);
    }
}
