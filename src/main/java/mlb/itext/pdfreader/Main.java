package mlb.itext.pdfreader;

import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.AcroFields;
import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.parser.*;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.interactive.form.PDAcroForm;
import technology.tabula.*;
import technology.tabula.extractors.BasicExtractionAlgorithm;
import technology.tabula.extractors.ExtractionAlgorithm;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

/**
 * Created by faisalabdillah on 4/12/15.
 */
public class Main {

    public static void main(String[] args){

        try{
            int page;
            PdfReader reader = new PdfReader("/Users/faisalabdillah/Downloads/planner_fifteen.pdf");

            page = 2;
            //read section 1
            //readByPage(reader, new Rectangle(150, 300, 420, 530), page);

            //read section 2
            //readByPage(reader, new Rectangle(0, 200, 420, 300), page);

            //read section 3
            //readByPage(reader, new Rectangle(0, 160, 420, 210), page);

            page = 3;
            readByPage(reader, new Rectangle(0, 510, 600, 560), page);

            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void readByPage(PdfReader reader, Rectangle rect, int page){

        try {
            RenderFilter filter = new RegionTextRenderFilter(rect);
            TextExtractionStrategy strategy;
            //for (int i = 1; i <= reader.getNumberOfPages(); i++) {
            strategy = new FilteredTextRenderListener(new LocationTextExtractionStrategy(), filter);
            System.out.println(PdfTextExtractor.getTextFromPage(reader, page, strategy));

            //String page = PdfTextExtractor.getTextFromPage(reader, 2);

            //List<String> lines = Arrays.asList(page.split("\n"));

            //System.out.println("Size "+lines.size());

            //}
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
