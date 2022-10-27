import java.io.File;
import java.util.ArrayList;

import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import javax.xml.parsers.DocumentBuilderFactory;

public class Main{

    private static ArrayList<Emploee> emploees = new ArrayList<>();
    public static void main(String[] args) {
        File file = new File("/Users/kovlya/Desktop/Java_IP/resource/test.xml");
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();

        Document doc = null;
        try{
            doc = dbf.newDocumentBuilder().parse(file);
        }catch(Exception ex){
            System.out.println("fail");
            return;
        }

        NodeList nList = doc.getDocumentElement().getElementsByTagName("employee");

        for(int i = 0; i < nList.getLength(); i++){
            Node emploee = nList.item(i);

            NamedNodeMap attributes = emploee.getAttributes();
            emploees.add(new Emploee(attributes.getNamedItem("name").getNodeValue(), attributes.getNamedItem("job").getNodeValue()));
        }
        
        for(Emploee emploee : emploees){
            System.out.println(emploee.toString());
        }
    }
}