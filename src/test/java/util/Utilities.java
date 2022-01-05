package util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import net.minidev.json.JSONValue;
import org.yaml.snakeyaml.Yaml;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Utilities {

    public String entityToJson(Object entity) throws JsonProcessingException {
        ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
        return ow.writeValueAsString(entity);
    }

    public Date strToDate(String dateString) throws ParseException {
        return new SimpleDateFormat("dd/MM/yyyy").parse(dateString);
    }

    private static String yamlToJson(String yamlString) {
        Yaml yaml= new Yaml();
        Object obj = yaml.load(yamlString);
        return JSONValue.toJSONString(obj);
    }

}
