package model.file_handler;

import java.io.*;

public interface Saveable {
    /**
     * Сохраняет объект в файл
     *
     * @param object объект для сохранения
     */
    void save(Object object) throws IOException;
}
