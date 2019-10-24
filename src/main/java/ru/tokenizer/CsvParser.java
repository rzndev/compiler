package ru.tokenizer;

import java.io.IOException;
import java.io.Reader;
import java.nio.CharBuffer;

/**
 * Получение токена CSV
 */
public class CsvParser {
    private static final int  DEFAULT_BUFFER_CAPACITY = 65536;

    /**
     * Источник данных
     */
    private Reader reader;
    /**
     * Буфер исходных данных
     */
    private CharBuffer charBuffer;

    /**
     * Позиция последнего символа в буфере
     */
    private int lastPosition;

    /**
     * Емкость буфера
     */
    private int bufferCapacity;

    /**
     * Порядковый номер элемента в строке
     */
    private int sequenceNumber;

    public int getBufferCapacity() {
        return bufferCapacity;
    }

    public void setBufferCapacity(int bufferCapacity) {
        this.bufferCapacity = bufferCapacity;
    }

    public CsvParser() {
        this.bufferCapacity = DEFAULT_BUFFER_CAPACITY;
    }

    /**
     * Инициализация парсера
     */
    public void Init(Reader reader) {
        charBuffer = CharBuffer.allocate(bufferCapacity);
        this.reader = reader;
    }

    private void fetchData() {
        try {
            lastPosition = reader.read(charBuffer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
