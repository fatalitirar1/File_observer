import java.io.File;

public class File_OnDisk implements  fileCapability{
    private String path,name, parentCatalog;
    TypeOfBitDepth bitDepth;
    private  double size;

    public  File_OnDisk(String path, String name, File File_){
        this.path = path;
        this.name = name;

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

        this.size = file_size;
        this.bitDepth = bitDepth;
    }

    public void setParentCatalog(String parentCatalog) {
        this.parentCatalog = parentCatalog;
    }

    public void setBitDepth(TypeOfBitDepth bitDepth) {
        this.bitDepth = bitDepth;
    }

    public void setSize(double size) {
        this.size = size;
    }

    public double getSize() {
        return size;
    }

    public TypeOfBitDepth getBitDepth() {
        return bitDepth;
    }

    public String getName() {
        return name;
    }
}
