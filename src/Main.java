
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.File;

public class Main {
    public static void main(String[] args)
            throws IOException{


        String File_name = Return_FileName();
        // Reading data using readLine


        TakeTreeOfObjects(File_name);
    }

    private static void TakeTreeOfObjects(String file_name) {
        File new_File = new File(file_name);


        if (new_File.exists() && new_File.isDirectory() )
        {

            File[] Files_ =  new_File.listFiles();
            assert Files_ != null;

            for (File File_ : Files_) {
                float  file_size = File_.length();
                file_size = (file_size / 1024);

                TypeOfBitDepth[] types =  TypeOfBitDepth.values();

                short index = 0;
                TypeOfBitDepth bitDepth = types[index];
                while ((file_size / 1024) > 1  )
                {
                     file_size /= 1024;
                     index++;
                     bitDepth = types[index];
                }

                File_OnDisk file_onDisk = new File_OnDisk(File_.getPath(),File_.getName(),file_size,bitDepth);
                file_onDisk.setParentCatalog(File_.getParent());
                System.out.println(file_onDisk.getName() + " " + file_onDisk.getSize() + " " + file_onDisk.getBitDepth());
                String NameOfFile = File_ + ((File_.isDirectory())? "\\" : "" );
                TakeTreeOfObjects(NameOfFile);
            }

        }
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

