package com.tigoune.utils;

import net.thucydides.core.steps.stepdata.CSVTestDataSource;
import net.thucydides.core.steps.stepdata.TestDataSource;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


/**
 * Métodos utilitarios para el manejo de archivos
 *
 */
public class UtilCSV {

    public List<Map<String, String>> getRowsCSV(String nameCSV, String filter) throws IOException {
        TestDataSource testData = new CSVTestDataSource("src/test/resources/data/data_" + nameCSV + ".csv", ';');
        return convertDataCsvList(testData, filter);
    }

    public static List<Map<String, String>> convertDataCsvList(TestDataSource testData, String filter) {
        List<Map<String, String>> loadedData = testData.getData();
        if ("".equals(filter)) {
            return loadedData;
        }
        String[] arrayToFilter = filter.split(","); 
        List<Map<String, String>> dataFiltered = filterDataCSV(arrayToFilter, loadedData);
        return dataFiltered;
    }
    
    public static List<Map<String, String>> filterDataCSV(String[] array, List<Map<String, String>> dataLoaded) {
        List<Map<String, String>> dataWithoutFilter = dataLoaded
                .stream()
                .filter(fila -> inArray(array, fila.get("columnaFiltro")))
                .collect(Collectors.toList());
        return dataWithoutFilter;
    }

    public static boolean inArray(String[] arr, String item) {
        if (arr.length > 0) {
            for (String n : arr) {
                if (item.equals(n)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static void resultDataCSV(String resultData) throws IOException {    
        File folder = new File("src/test/resources/data");
        folder.mkdir();     
        String path = folder + "/data_offerInfo.csv";
        File file = new File(path);
        BufferedWriter bufferedWriter = null;
        bufferedWriter = new BufferedWriter(new FileWriter(file));
        bufferedWriter.write("caso;oferta;pedido;columnaFiltro");
        bufferedWriter.newLine();
        bufferedWriter.write(resultData);
        bufferedWriter.close();
    }
}
