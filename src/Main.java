import com.axiosys.bento4.*;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) throws IOException, InvalidFormatException {
        //String path = "C:\\Users\\ttzaf\\Desktop\\Research\\benign\\Plant - 24105.mp4";

        String folderDir = "C:\\Users\\ttzaf\\Desktop\\Research\\benign";
        List<String> listOfDir = getFilesDir(folderDir);
        Map<String, Integer> map = new HashMap<String, Integer>();

        for(String path : listOfDir) {
            AtomList atoms = new AtomList(path);
            ArrayList<StringBuffer> Dir = atoms.getBagOfDir();

            for (StringBuffer s : Dir) {
                String k = s.toString();
                if (map.containsKey(k)) {
                    int v = map.get(k);
                    map.put(k, v + 1);
                } else {
                    map.put(k, 1);
                }
            }
        }
        //System.out.println(map.toString());

/*       Files.walk(Paths.get("C:\\Users\\ttzaf\\Desktop\\Research\\benign"))
                .filter(Files::isRegularFile)
                .collect(Collectors.toList());*/


/*        String eol = System.getProperty("line.separator");

        try (Writer writer = new FileWriter("C:\\Users\\ttzaf\\Desktop\\test.csv")) {
            for (HashMap.Entry<String, Integer> entry : map.entrySet()) {
                writer.append(entry.getKey())
                        .append(',')
                        .append(entry.getValue())
                        .append(eol);
            }
        } catch (IOException ex) {
            ex.printStackTrace(System.err);
        }*/
        //ArrayList<String> bagOfAtomsDir =new ArrayList<>();
        /*
        if (args.length > 1) {
            Atom atom = AtomUtils.findAtom(atoms, path);
            if (atom != null) {
                System.out.println(atom);
                byte[] payload = atom.getPayload();
                System.out.println(new String(payload));
            }
        } else {
            System.out.println(atoms);
        }
        /*
        File file = new File(path);
        Track[] tracks = file.getMovie().getTracks();
        for (int i=0; i<tracks.length; i++) {
            System.out.println("Track " + tracks[i].getId() + ":");
            System.out.println("  Type: " + tracks[i].getType());
        }
        System.out.println(file.getMovie().getMoovAtom());
        System.out.println("to_string");*/
    }

    private static List<String> getFilesDir(String path) {
        try (Stream<Path> walk = Files.walk(Paths.get(path))) {

            List<String> result = walk.filter(Files::isRegularFile)
                    .map(x -> x.toString()).collect(Collectors.toList());

            //result.forEach(System.out::println);
            return result;

        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
