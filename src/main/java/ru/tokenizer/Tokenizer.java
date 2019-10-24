package ru.tokenizer;

import java.io.Reader;
import java.nio.CharBuffer;
import java.util.Hashtable;
import java.util.Map;

public class Tokenizer {
    private static final String[] DEFAULT_LINE_DELIMITERS = {"\r\n", "\r", "\n"};
    private static final char DEFAULT_ITEMS_DELIMITER = ',';
    private static final char DEFAULT_QUOTE = '\"';
    /**
     * Источник данных
     */
    private Reader reader;
    /**
     * Исходные данные
     */
    private CharSequence source;

    private Map<String, Tokens> tokensMap;

    /**
     * Разделитель строк
     */
    private String[] lineDelimiters;

    /**
     * Разделитель элементов
     */
    private char itemDelimiter;

    /**
     * Кавычка строки
     */
    private char quote;

    public String[] getLineDelimiters() {
        return lineDelimiters;
    }

    public void setLineDelimiters(String[] lineDelimiters) {
        this.lineDelimiters = lineDelimiters;
    }

    public char getItemDelimiter() {
        return itemDelimiter;
    }

    public void setItemDelimiter(char itemDelimiter) {
        this.itemDelimiter = itemDelimiter;
    }

    public char getQuote() {
        return quote;
    }

    public void setQuote(char quote) {
        this.quote = quote;
    }

    Tokenizer() {
        tokensMap = new Hashtable<>();
        lineDelimiters = DEFAULT_LINE_DELIMITERS;
        quote = DEFAULT_QUOTE;
        itemDelimiter = DEFAULT_ITEMS_DELIMITER;
    }


    public void InitTokenizer(CharSequence source) {
        buildTokensMap();
        this.source = source;
    }

    private void buildTokensMap() {
        tokensMap = new Hashtable<>();
        for(String lineDelimiter : lineDelimiters) {
            tokensMap.put(lineDelimiter, Tokens.LINE_DELIMITER);
        }
        tokensMap.put(String.valueOf(itemDelimiter), Tokens.ITEM_DELIMITER);
        tokensMap.put(String.valueOf(quote), Tokens.STRING_DELIMITER);
    }
}
