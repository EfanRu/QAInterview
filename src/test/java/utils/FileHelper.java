package utils;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;

public class FileHelper {
    public static JsonNode getJsonFromFile(String path) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        File from = new File(path);
        return mapper.readTree(from);
    }
}
