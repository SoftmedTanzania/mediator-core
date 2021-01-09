package tz.go.moh.him.mediator.core.adapter;

import com.fasterxml.jackson.databind.MappingIterator;
import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.fasterxml.jackson.dataformat.csv.CsvSchema;
import com.google.gson.Gson;
import org.json.JSONArray;

import java.io.IOException;
import java.util.List;

public class CsvAdapterUtils {
    /**
     * Read CSV string data and return an array of POJO
     *
     * @param value csv string payload
     * @param type  pojo class type
     * @return arraylist of POJO
     * @throws IOException if an I/O exception occurs
     */
    public static List<?> csvToArrayList(String value, Class<?> type) throws IOException {
        MappingIterator<?> csvDataLines = readCsv(value, type);
        return csvDataLines.readAll();
    }


    /**
     * Read CSV string data and return a JSONArray
     *
     * @param value csv string payload
     * @param type  pojo class type
     * @return jsonArray
     * @throws IOException if an I/O exception occurs
     */
    public static JSONArray csvToJson(String value, Class<?> type) throws IOException {
        MappingIterator<?> csvDataLines = readCsv(value, type);
        return new JSONArray(new Gson().toJson(csvDataLines.readAll()));
    }


    /**
     * Reads the CSV.
     *
     * @param value The value.
     * @param type  The type.
     * @return Returns a mapping iterator.
     * @throws IOException if an I/O exception occurs
     */
    private static MappingIterator<?> readCsv(String value, Class<?> type) throws IOException {
        CsvSchema orderLineSchema = CsvSchema.emptySchema().withHeader();
        CsvMapper csvMapper = new CsvMapper();

        return csvMapper.readerFor(type)
                .with(orderLineSchema)
                .readValues(value);
    }

}
