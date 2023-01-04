
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Main {


    public static void main(String[] args)
            throws IOException{


        String File_name = Return_FileName();
        TreeOfFiles tree_obj = new TreeOfFiles();
        tree_obj.CreateTreeOfObjects(File_name);
        tree_obj.ShowTheTree();
    }



    public static  String Return_FileName()
            throws IOException
    {
        BufferedReader reader = new BufferedReader(
                new InputStreamReader(System.in));

        String str;
        System.out.println("File name");
        str = reader.readLine();

        return  str;
    }
}

