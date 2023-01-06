package Parsing;
import java.io.File;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
public class Catalogue {

    private final String path = "C:\\Users\\modaser\\Downloads\\JSON-Parsing-main\\JSON-Parsing-main\\JSON-Parsing\\src\\java\\Parsing\\Catalogue.json";
     JSONArray buildList;

    public Catalogue() throws IOException {
        this.buildList = new JSONArray();
    }

    public void addbuild() throws IOException, ParseException {
        File file = new File(path);
        FileWriter file2=new FileWriter(file,true);
        if(file.length()!=0)
        {
           JSONParser jsonparser = new JSONParser();
        FileReader reader = new FileReader(file);
        Object obj = jsonparser.parse(reader);	
        buildList= (JSONArray) obj ;
        FileWriter file3=new FileWriter(file);
        file3.write("");
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Number of build: ");
        int iters = sc.nextInt();
        sc.nextLine();
        for (int i = 0; i < iters; i++) {
            System.out.println("build " + (i + 1) + " Information U wants to stored it:- \n");

            JSONObject build = new JSONObject();
            System.out.println("Enter BlName");
            String BlName = sc.nextLine();
            build.put("BlName", BlName); 
            System.out.println("Enter city");
            String city = sc.nextLine();
            build.put("city", city);
            System.out.println("Enter FoundationYear");
            String FoundationYear = sc.nextLine();
            build.put("FoundationYear", FoundationYear);
            int ii = 0;
                ObjectMapper objectMapper = new ObjectMapper();
               buildList.add(build);
        }
        file2.write(buildList.toJSONString());
        file2.flush();
    }
        else
        {file2 = new FileWriter(path);
        
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Number of build: ");
        int iters = sc.nextInt();
        sc.nextLine();
        for (int i = 0; i < iters; i++) {
            System.out.println("build " + (i + 1) + " Information U wants to stored it:- \n");

            JSONObject build = new JSONObject();
            System.out.println("Enter BlName");
            String BlName = sc.nextLine();
            build.put("BlName", BlName); 
            System.out.println("Enter city");
            String city = sc.nextLine();
            build.put("city", city);
            System.out.println("Enter FoundationYear");
            String FoundationYear = sc.nextLine();
            build.put("FoundationYear", FoundationYear);
            int ii = 0;
                ObjectMapper objectMapper = new ObjectMapper();
buildList.add(build);
        }
        file2.write(buildList.toJSONString());
        file2.flush();
    }
    }

    private boolean found(JSONObject build, String key) {

        String City = (String) build.get("city");

        String FoundationYear = (String) build.get("FoundationYear");

        return (key.equals(City)) || (key.equals(FoundationYear));

    }

    public void searchByKey(String key) throws FileNotFoundException, IOException, ParseException {
        int y=0;
        JSONParser jsonParser = new JSONParser();
        FileReader reader = new FileReader(path);
        Object obj = jsonParser.parse(reader);
        JSONArray bs = (JSONArray) obj;
        for (Object bulid1 : bs) {
            if (found((JSONObject) bulid1, key) == true) {
                y++;
                ObjectMapper objectMapper = new ObjectMapper();
                System.out.println(objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(bulid1));
            }
        }
        if(y==0)
        System.out.println("not found");

    }
    public void delete(String key) throws FileNotFoundException, IOException, ParseException {
        int y=0,z=0;
        JSONParser jsonParser = new JSONParser();
        FileReader reader = new FileReader(path);
        Object obj = jsonParser.parse(reader);
        ArrayList<Object>obb=new ArrayList<>();
        JSONArray bs = (JSONArray) obj;
        Object bulid1=new Object();
        for ( Object bulid : bs) {
            y++;
            if (found((JSONObject) bulid, key) == true) {   
                z++;  
                obb.add((JSONObject) bulid);
            }
            
        }
        if(z==0)
        System.out.println("not found"); 
        else{
            for (int i=0;i<obb.size();i++){
            FileWriter file2=new FileWriter(path);
            file2.write("");
            bs.remove(obb.get(i));
            file2.write(bs.toJSONString());
            file2.flush();
        }
    }

    }
    // public void delete(String key) throws FileNotFoundException, IOException, ParseException {
    //     JSONParser jsonparser = new JSONParser();
    //     try( FileReader reader = new FileReader(path))
    //     {
    //         Object obj = jsonparser.parse(reader);
    //         JSONArray list = (JSONArray) obj;
    //         list.forEach(node->{
    //             ((JSONObject) node).remove("UserID");
    //         });
    //         System.out.println(list);
    //         saveAsJsonFile(list.toJSONString(),path);
    //     }
    //     catch (FileNotFoundException e) {
    //         e.printStackTrace();
    //     } catch (IOException e) {
    //         e.printStackTrace();
    //     } catch (ParseException e) {
    //         e.printStackTrace();
    //     }
    // }

    }
