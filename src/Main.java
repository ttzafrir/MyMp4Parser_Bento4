import com.axiosys.bento4.*;

import java.io.IOException;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) throws IOException, InvalidFormatException {
        String path = "C:\\Users\\ttzafrir\\Desktop\\test_b_vid.mp4";
        AtomList atoms = new AtomList(path);
        AtomParent test = atoms;
        Atom atom = AtomUtils.findAtom(test, "");
        System.out.println(atom);
        //ArrayList<String> bagOfAtomsDir =new ArrayList<>();
        //System.out.println(atoms.getBagOfDir());
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
}
