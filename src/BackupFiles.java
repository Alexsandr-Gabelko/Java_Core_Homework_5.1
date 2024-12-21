import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;

public class BackupFiles {

    public static void createBackup(String sourceDirPath) {
        File sourceDir = new File(sourceDirPath);
        File backupDir = new File("./backup");

        // Создаем директорию backup, если она не существует
        if (!backupDir.exists()) {
            if (backupDir.mkdir()) {
                System.out.println("Директория backup создана.");
            } else {
                System.out.println("Не удалось создать директорию backup.");
                return;
            }
        }

        // Проверяем, что sourceDir существует и является директорией
        if (!sourceDir.exists() || !sourceDir.isDirectory()) {
            System.out.println("Указанный путь не существует или не является директорией.");
            return;
        }

        // Получаем список файлов в sourceDir
        File[] files = sourceDir.listFiles();

        if (files != null) {
            for (File file : files) {
                // Копируем только файлы (игнорируем поддиректории)
                if (file.isFile()) {
                    File backupFile = new File(backupDir, file.getName());
                    try {
                        Files.copy(file.toPath(), backupFile.toPath(), StandardCopyOption.REPLACE_EXISTING);
                        System.out.println("Файл " + file.getName() + " скопирован в backup.");
                    } catch (IOException e) {
                        System.out.println("Ошибка при копировании файла " + file.getName() + ": " + e.getMessage());
                    }
                }
            }
        } else {
            System.out.println("В указанной директории нет файлов для резервного копирования.");
        }
    }
}
