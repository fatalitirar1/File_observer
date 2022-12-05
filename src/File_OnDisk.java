public class File_OnDisk implements  fileCapability{
    private String path,name, parentCatalog;
    TypeOfBitDepth bitDepth;
    private  double size;

    public  File_OnDisk(String path, String name, double size,TypeOfBitDepth bitDepth){
        this.path = path;
        this.name = name;
        this.size = size;
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
