package comtest.api;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class BreedListToExcel {
    public static void main(String[] args) throws IOException {

        // Send a request to the API to retrieve the breed list in JSON format
        OkHttpClient client = new OkHttpClient();
        String url = "https://provetcloudapi.com/api2/vetnology/breeds?format=json";
        Request request = new Request.Builder().url(url).build();
        Response response = client.newCall(request).execute();
        String json = response.body().string();

        // Parse the JSON response and extract the breed data
        JsonArray breedArray = JsonParser.parseString(json).getAsJsonArray();
        List<Breed> breeds = new ArrayList<>();
        for (JsonElement element : breedArray) {
            JsonObject breedObject = element.getAsJsonObject();
            String label = breedObject.get("breed").getAsString();
            String code = breedObject.get("code").getAsString();
            String parentId = breedObject.get("parent_id").isJsonNull() ? null : breedObject.get("parent_id").getAsString();
            Breed breed = new Breed(label, code, parentId);
            breeds.add(breed);
        }

        // Write the breed data to an Excel file
        Workbook workbook = new XSSFWorkbook();
        Sheet sheet = workbook.createSheet("Breeds");
        int rowNumber = 0;
        Row headerRow = sheet.createRow(rowNumber++);
        Cell labelHeader = headerRow.createCell(0);
        labelHeader.setCellValue("Label");
        Cell codeHeader = headerRow.createCell(1);
        codeHeader.setCellValue("Code");
        Cell parentHeader = headerRow.createCell(2);
        parentHeader.setCellValue("Parent ID");
        for (Breed breed : breeds) {
            Row row = sheet.createRow(rowNumber++);
            Cell labelCell = row.createCell(0);
            labelCell.setCellValue(breed.getLabel());
            Cell codeCell = row.createCell(1);
            codeCell.setCellValue(breed.getCode());
            Cell parentCell = row.createCell(2);
            parentCell.setCellValue(breed.getParentId());
        }
        FileOutputStream outputStream = new FileOutputStream("breeds.xlsx");
        workbook.write(outputStream);
        workbook.close();
        outputStream.close();
    }

    private static class Breed {
        private final String label;
        private final String code;
        private final String parentId;

        public Breed(String label, String code, String parentId) {
            this.label = label;
            this.code = code;
            this.parentId = parentId;
        }

        public String getLabel() {
            return label;
        }

        public String getCode() {
            return code;
        }

        public String getParentId() {
            return parentId;
        }
    }

}
