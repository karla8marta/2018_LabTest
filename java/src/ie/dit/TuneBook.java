package ie.dit;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class TuneBook {

    public static void main(String[] args) {
        TuneBook tb = new TuneBook("hnj0.abc");
        System.out.println(tb);

        Tune t = tb.findTune("Scotsman over the Border");
        t.play();
    }

    ArrayList<Tune> tunes = new ArrayList<Tune>();

    public TuneBook(String fileName) {

        BufferedReader inputStream = null;

        try {
            inputStream = new BufferedReader(new FileReader(fileName));

            String l;
            Tune tune = null;
            String notation = "";

            while ((l = inputStream.readLine()) != null) {
                if (l.startsWith("X:")) {
                    tune = new Tune();
                    tunes.add(tune);
                    tune.setX(Integer.parseInt(l.substring(2)));
                }
                if (l.startsWith("T:")) {
                    if (tune.getTitle() == null) {
                        tune.setTitle(l.substring(2));
                    } else if (tune.getaltTitle() == null) {
                        tune.setaltTitle(l.substring(2));
                    }
                }
                if (tune != null) {
                    if (l.equals("")) {
                        tune.setNotation(notation);
                        notation = "";
                    } else {
                        notation += l + "\n";
                    }
                }
                System.out.println(l);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }

    }

    public String toString() {

        StringBuffer sb = new StringBuffer();
        for (Tune t : tunes) {
            sb.append(t + "\n");
        }
        return sb.toString();
    }

    public Tune findTune(String title) {

        for (Tune t : tunes) {
            if (t.getTitle().contains(title)) {
                return t;
            }
        }

        return null;
    }
}
