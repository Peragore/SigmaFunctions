package peragore.Gui;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 * User: Philip
 * Date: 7/27/13
 * Time: 8:58 PM
 * To change this template use File | Settings | File Templates.
 */
public class RelaySolverXMLEngine {
    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy_MM_dd-HH_mm_ss-a");
    Date date = new Date();

    public void writeXML(String one, String oneBack, String oneBreast, String oneBF, String oneFree, String two, String twoBack, String twoBreast, String twoBF, String twoFree, String three, String threeBack, String threeBreast, String threeBF, String threeFree, String four, String fourBack, String fourBreast, String fourBF, String fourFree) {

        try {
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder documentBuilder = dbFactory.newDocumentBuilder();

            //root elements
            Document doc = documentBuilder.newDocument();
            Element presets = doc.createElement("Preset");
            doc.appendChild(presets);

            //swimmer one
            Element swimmer1 = doc.createElement("Swimmer");
            presets.appendChild(swimmer1);
            swimmer1.setAttribute("id", "1");

            Element name1 = doc.createElement("Name");
            name1.appendChild(doc.createTextNode(one));
            swimmer1.appendChild(name1);

            Element back1 = doc.createElement("Backstroke");
            back1.appendChild(doc.createTextNode(oneBack));
            swimmer1.appendChild(back1);

            Element breast1 = doc.createElement("Breast_Stroke");
            breast1.appendChild(doc.createTextNode(oneBreast));
            swimmer1.appendChild(breast1);

            Element butter1 = doc.createElement("Butterfly");
            butter1.appendChild(doc.createTextNode(oneBF));
            swimmer1.appendChild(butter1);

            Element free1 = doc.createElement("Freestyle");
            free1.appendChild(doc.createTextNode(oneFree));
            swimmer1.appendChild(free1);

            //swimmer two

            Element swimmer2 = doc.createElement("Swimmer");
            presets.appendChild(swimmer2);
            swimmer2.setAttribute("id", "2");

            Element name2 = doc.createElement("Name");
            name2.appendChild(doc.createTextNode(two));
            swimmer2.appendChild(name2);

            Element back2 = doc.createElement("Backstroke");
            back2.appendChild(doc.createTextNode(twoBack));
            swimmer2.appendChild(back2);

            Element breast2 = doc.createElement("Breast_Stroke");
            breast2.appendChild(doc.createTextNode(twoBreast));
            swimmer2.appendChild(breast2);

            Element butter2 = doc.createElement("Butterfly");
            butter2.appendChild(doc.createTextNode(twoBF));
            swimmer2.appendChild(butter2);

            Element free2 = doc.createElement("Freestyle");
            free2.appendChild(doc.createTextNode(twoFree));
            swimmer2.appendChild(free2);

            //swimmer three

            Element swimmer3 = doc.createElement("Swimmer");
            presets.appendChild(swimmer3);
            swimmer3.setAttribute("id", "3");

            Element name3 = doc.createElement("Name");
            name3.appendChild(doc.createTextNode(three));
            swimmer3.appendChild(name3);

            Element back3 = doc.createElement("Backstroke");
            back3.appendChild(doc.createTextNode(threeBack));
            swimmer3.appendChild(back3);

            Element breast3 = doc.createElement("Breast_Stroke");
            breast3.appendChild(doc.createTextNode(threeBreast));
            swimmer3.appendChild(breast3);

            Element butter3 = doc.createElement("Butterfly");
            butter3.appendChild(doc.createTextNode(threeBF));
            swimmer3.appendChild(butter3);

            Element free3 = doc.createElement("Freestyle");
            free3.appendChild(doc.createTextNode(threeFree));
            swimmer3.appendChild(free3);

            //swimmer four

            Element swimmer4 = doc.createElement("Swimmer");
            presets.appendChild(swimmer4);
            swimmer4.setAttribute("id", "4");

            Element name4 = doc.createElement("Name");
            name4.appendChild(doc.createTextNode(four));
            swimmer4.appendChild(name4);

            Element back4 = doc.createElement("Backstroke");
            back4.appendChild(doc.createTextNode(fourBack));
            swimmer4.appendChild(back4);

            Element breast4 = doc.createElement("Breast_Stroke");
            breast4.appendChild(doc.createTextNode(fourBreast));
            swimmer4.appendChild(breast4);

            Element butter4 = doc.createElement("Butterfly");
            butter4.appendChild(doc.createTextNode(fourBF));
            swimmer4.appendChild(butter4);

            Element free4 = doc.createElement("Freestyle");
            free4.appendChild(doc.createTextNode(fourFree));
            swimmer4.appendChild(free4);

            //actually write the file
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            DOMSource source = new DOMSource(doc);
            transformerFactory.setAttribute("indent-number", new Integer(2));
            StreamResult result = new StreamResult(new File(one + "_" + two + "_" + three + "_" + four + "_" + dateFormat.format(date) + ".xml").getPath());
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
            transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "4");
            transformer.transform(source, result);

        } catch (Exception ex) {
            System.out.println(ex);
        }
    }

}
