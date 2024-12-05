package jobs4u.core.jobapplicationmanagement.domain;

import jobs4u.core.jobapplicationmanagement.application.Services.AnalyseFile;
import jobs4u.core.jobapplicationmanagement.application.Services.MostUsedWordsService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MostUsedWordsServiceTest {

    private MostUsedWordsService mostUsedWordsService;

    @BeforeEach
    public void setUp() {
        mostUsedWordsService = new MostUsedWordsService();
    }

    @Test
    public void testProcessSingleFile() {
        // Cria uma instância real de FileJobApp com o caminho do arquivo
        FileJobApp file1 = new FileJobApp("C:\\Users\\35193\\Desktop\\sem4pi-23-24-2dh2\\forUniTest.txt");

        // Cria uma lista com o objeto FileJobApp
        List<FileJobApp> filePaths = List.of(file1);

        // Cria uma instância real de AnalyseFile e define seu comportamento
        AnalyseFile analyseFile1 = new AnalyseFile(file1.getValue());

        // Executa a análise
        analyseFile1.run();

        // Obtém as frequências de palavras
        Map<String, Integer> freq1 = analyseFile1.getWordFrequency();

        // Define o resultado esperado
        Map<String, Integer> expectedFreq = new HashMap<>();
        expectedFreq.put("This", 2);
        expectedFreq.put("is", 2);
        expectedFreq.put("an", 1);
        expectedFreq.put("exemple", 1);
        expectedFreq.put("a", 1);
        expectedFreq.put("file", 1);

        // Verifica o resultado
        assertEquals(expectedFreq, freq1);
    }
}
