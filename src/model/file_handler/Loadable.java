package model.file_handler;

import java.io.*;

public interface Loadable {
    /**
     * Загружает объект из файла
     *
     * @return загруженный объект
     */
    Object load() throws IOException, ClassNotFoundException;
}
