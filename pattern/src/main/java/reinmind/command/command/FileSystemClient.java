package reinmind.command.command;

import reinmind.command.receiver.FileSystemReceiver;

public class FileSystemClient {
    public static void main(String[] args) {
        FileSystemReceiver fs = FileSystemReceiverUtil.getUnderlylingFileSystem();
        OpenFileCommand openFileCommand = new OpenFileCommand(fs);
        CommandInvoker commandInvoker = new CommandInvoker(openFileCommand);
        commandInvoker.execute();

        //组合写文件命令
        WritingFileCommand writingFileCommand = new WritingFileCommand(fs);
        commandInvoker = new CommandInvoker(writingFileCommand);
        commandInvoker.execute();

        //组合关文件命令
        CloseFileCommand closeFileCommand = new CloseFileCommand(fs);
        commandInvoker = new CommandInvoker(closeFileCommand);
        commandInvoker.execute();
    }
}
