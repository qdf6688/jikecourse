import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

public class XlassLoader extends ClassLoader {

    public byte[] loadResource()  {
        String fileName = "Hello.xlass";
        ClassLoader classLoader = getClass().getClassLoader();
        File file = new File(classLoader.getResource(fileName).getFile());
        byte[] bytes = new byte[0];
        try {
            bytes = Files.readAllBytes(file.toPath());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return bytes;
    }

    public byte[] decode(byte[] rawBytes) {
        byte[] bytes = new byte[rawBytes.length];
        for (int i = 0; i < rawBytes.length; i++) {
            bytes[i] = (byte) (255 - rawBytes[i]);
        }
        return bytes;
    }

    public byte[] loadClassFile() {
        byte[] rawBytes = loadResource();
        return decode(rawBytes);
    }

    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        byte[] bytes = loadClassFile();
        return defineClass(name, bytes, 0, bytes.length);
    }


    public static void main(String[] args) throws Exception {
        Object helloObj = new XlassLoader().findClass("Hello").newInstance();
        helloObj.getClass().getMethod("hello").invoke(helloObj);
    }


}
