// 1.Написать функцию, создающую резервную копию всех файлов в директории(без поддиректорий)
// 2. во вновь созданную папку ./backup
//Предположить, что числа в исходном массиве из 9 элементов имеют диапазон[0, 3], и
// представляют собой, например, состояния ячеек поля для игры в крестикинолики,
// где 0 – это пустое поле, 1 – это поле с крестиком, 2 – это поле с ноликом,
// 3 – резервное значение. Такое предположение позволит хранить в одном числе
// типа int всё поле 3х3. Записать в файл 9 значений так, чтобы они заняли три байта.
//

import java.io.File;
import java.io.IOException;

public class Main {
    private static Object Arrays;

    public static void main(String[] args) throws IOException {

        File file = new File("./source/text.txt");
        try {
            file.createNewFile();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        // Путь к директории, которую хотите скопировать
        String sourceDirPath = "./source";
        BackupFiles.createBackup(sourceDirPath);

    }
}

