
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.File;
import java.lang.reflect.Array;
import java.text.DecimalFormat;

//C:\Users\fatal\Desktop\NGATE 1C (1).rar
public class Main {
    public static void main(String[] args)
            throws IOException{


        String File_name = Return_FileName();
        // Reading data using readLine


        File new_File = new File(File_name);

        
        if (new_File.exists() )
        {

            File Files_[] =  new_File.listFiles();
            for (File File_ : Files_) {
                String Line_Outoput = new String();
                float  file_size_KB = File_.length();
                file_size_KB = (file_size_KB / 1024);
                String formattedDouble = new DecimalFormat("#0.00").format(file_size_KB);
                Line_Outoput = File_.getName() + "/" +  formattedDouble + " kb";
                if ((file_size_KB / 1024) > 1  )
                {
                    Float file_size_MB = file_size_KB / 1024;
                    formattedDouble = new DecimalFormat("#0.00").format(file_size_MB);
                    Line_Outoput = File_.getName() + "/" +  formattedDouble + " mb";
                }
                System.out.println(Line_Outoput);
            }

        }
    }
    public static  String Return_FileName()
            throws IOException
    {
        BufferedReader reader = new BufferedReader(
                new InputStreamReader(System.in));

        String str = new String();
        System.out.println("File name");
        str = reader.readLine();

        return  str;
    }
}

