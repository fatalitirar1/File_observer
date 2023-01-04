import java.io.File;
import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;

public class TreeOfFiles   {
    public TreeMap<String,ArrayList<File_OnDisk>> TreeOfFiles = new TreeMap();

    public void CreateTreeOfObjects(String file_name) {
        File new_File = new File(file_name);

        if (new_File.exists() && new_File.isDirectory() )
        {
            File[] Files_ =  new_File.listFiles();
            assert Files_ != null;

            for (File File_ : Files_) {

                File_OnDisk file_onDisk = new File_OnDisk(File_.getPath(),File_.getName(),File_);
                file_onDisk.setParentCatalog(File_.getParent());
                ArrayList<File_OnDisk> arrayFiles = TreeOfFiles.get(file_name);
                if (arrayFiles == null) {
                    arrayFiles = new ArrayList<File_OnDisk>();
                }
                arrayFiles.add(file_onDisk);
                TreeOfFiles.put(file_name, arrayFiles);
                 String NameOfFile = File_ + ((File_.isDirectory())? "\\" : "" );
                 if (File_.isDirectory()) {
                     CreateTreeOfObjects(NameOfFile);
                 }
            }

        }
    }

    public void ShowTheTree() {
        String fod = new String();
        for (Map.Entry<String, ArrayList<File_OnDisk>> entry : TreeOfFiles.entrySet()) {
            if (!fod.equals(entry.getKey())) {
                fod = entry.getKey();
                System.out.println("Key: " + entry.getKey());

            }
            ArrayList<File_OnDisk> innerArray = entry.getValue();
            for(int i=0; i!=innerArray.size();i++){
                System.out.println(" Value: " + innerArray.get(i).getName());
            }

        }
    }
}