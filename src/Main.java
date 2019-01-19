import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;
import javafx.scene.Scene;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;


public class Main {

    private JPanel panel1;
    private JButton button1;
    private JTextField textField1;
    private WebView browser;
    private WebEngine webEngine;
    private JFXPanel jfxPanel;
    private HtmlHandler htmlHandler;

    public Main() {

        Marker markers[] = new Marker[77];
        File html = new File("/home/pawel/IdeaProjects/Rowery1/src/map.html");
        htmlHandler = new HtmlHandler(html);

        markers[0] = new Marker("Saperow",51.0863, 17.0002,1402,6,3.35);
        markers[1] = new Marker("Lutynska",51.14662, 16.82889,199,1,14.5);
        markers[2] = new Marker("Traugutta",51.10299, 17.05054,20617,4,1.7);
        markers[3] = new Marker("Kleczkowska",51.12714, 17.0244,6223,5,2.05);
        markers[4] = new Marker("Plac Swietego Macieja",51.11976, 17.03535,44090,7,1.32);
        markers[5] = new Marker("Borowska-Poludnie",51.09033, 17.03386,2663,7,3.98);
        markers[6] = new Marker("Opatowice",51.08877, 17.12245,805,3,6.63);
        markers[7] = new Marker("Strachocin - Wojnow",51.11491, 17.12781,4861,3,8.06);
        markers[8] = new Marker("Park Szczytnicki", 51.11476, 17.08105,593,10,3.55);
        markers[9] = new Marker("Lesnica",51.15218, 16.8521,8724,2,12.39);
        markers[10] = new Marker("Poswietna",51.15754, 17.0369,3010,3,5.41);
        markers[11] = new Marker("Borowska - Polnoc", 51.10027, 17.04449,24,6,2.61);
        markers[12] = new Marker("Mielecka", 51.09127, 17.00223,6815,5,2.88);
        markers[13] = new Marker("Marszowice",51.16984, 16.8855,1493,3,12.2);
        markers[14] = new Marker("Lipa Piotrowska",51.17569, 16.9932,3982,2,7.74);
        markers[15] = new Marker("Pilczyce", 51.14208, 16.95634,5582,7,6.27);
        markers[16] = new Marker("Kosmonautow",51.14162, 16.90812,19048,6,9.37);
        markers[17] = new Marker("Kozanow",51.13885, 16.97802,15901,6,5.04);
        markers[18] = new Marker("Nowe Zerniki",51.13696, 16.92392,822,5,8.1);
        markers[19] = new Marker("Zlotniki",51.13918, 16.88502,5373,4,10.75);
        markers[20] = new Marker("Plac Grunwaldzki",51.111549, 17.060334,27030,8,2.06);
        markers[21] = new Marker("Zerniki",51.12408, 16.92575,3823,5,7.77);
        markers[22] = new Marker("Zacisze",51.12275, 17.07665,1773,5,3.57);
        markers[23] = new Marker("Kuzniki",51.12449, 16.94866,5837,4,5.94);
        markers[24] = new Marker("Sepolno",51.11062, 17.09473,7224,6,4.56);
        markers[25] = new Marker("Biskupin",51.10063, 17.0998,11292,6,5.03);
        markers[26] = new Marker("Grabiszynek",51.09111, 16.99162,11145,7,3.65);
        markers[27] = new Marker("Tarnogaj",51.0833, 17.06175,2093,5,3.85);
        markers[28] = new Marker("Gaj",51.07564, 17.04114,19297,7,3.66);
        markers[29] = new Marker("Pracze Odrzanskie",51.18623, 16.90761,1178,1,12.23);
        markers[30] = new Marker("Redzin",51.17077, 16.96239,315,1,8.6);
        markers[31] = new Marker("Swiniary",51.19171, 16.97638,716,1,10.08);
        markers[32] = new Marker("Mokra",51.13593, 17.09389,436,2,14.69);
        markers[33] = new Marker("Zakrzow",51.16661, 17.13398,10737,2,9.48);
        markers[34] = new Marker("Maslice Male",51.15293, 16.94011,6602,2,7.83);
        markers[35] = new Marker("Psie pole - Polnoc",51.152106, 17.036308,593,2,11.17);
        markers[36] = new Marker("Psie pole - Poludnie - Kielczow", 51.1423, 17.1708,5263,4,8.15);
        markers[37] = new Marker("Karlowice",51.13896, 17.04926,12651,6,3.44);
        markers[38] = new Marker("Muchobor Wielki",51.09757, 16.94831,11765,3,6.26);
        markers[39] = new Marker("Stablowice",51.15955, 16.90038,14099,3,11.17);
        markers[40] = new Marker("Maslice Wielkie",51.16386, 16.92743,3469,2,9.5);
        markers[41] = new Marker("Osobowice",51.13736, 16.99407,2662,6,5.32);
        markers[42] = new Marker("Zgorzelisko",51.13788, 17.12999,11967,3,7.72);
        markers[43] = new Marker("Kowale-Popiele",51.12165, 17.10451,2254,2,5.47);
        markers[44] = new Marker("Kromera",51.13287, 17.0644,4421,5,3.6);
        markers[45] = new Marker("Popowice",51.12685, 16.98633,11009,6,3.45);
        markers[46] = new Marker("Jarnoltów - Jerzmanowo",51.12156, 16.84446,1357,1,12.09);
        markers[47] = new Marker("Szczepin",51.11762, 17.01215,19683,5,1.72);
        markers[48] = new Marker("Swojczyce",51.11493, 17.12835,1215,1,6.99);
        markers[49] = new Marker("Ksieze Male - Ksieze Wielkie",51.0731, 17.09201,5541,2,5.53);
        markers[50] = new Marker("Krzyki",51.07855, 17.05319,12993,6,4.89);
        markers[51] = new Marker("Jagodno",51.05166, 17.05768,5017,1,6.78);
        markers[52] = new Marker("Przedmiescie Swidnickie",51.10232, 17.03325,13883,6,0.77);
        markers[53] = new Marker("Gajowice",51.09861, 17.01369,17224,1,2.67);
        markers[54] = new Marker("Grabiszyn", 51.09111, 16.99162,2175,7,3.54);
        markers[55] = new Marker("Pawlowice - Klokoczyce",51.15103, 17.10987,2568,8,7.88);
        markers[56] = new Marker("Zalesie",51.117235, 17.082973,1301,3,4.6);
        markers[57] = new Marker("Gadów Maly",51.12409, 16.9688,7042,3,5.17);
        markers[58] = new Marker("Strachowice - Osiniec",51.12064, 16.90015,693,3,9.4);
        markers[59] = new Marker("Nowy Dwor",51.11534, 16.95833,16142,3,5.46);
        markers[60] = new Marker("Muchobor Maly",51.10825, 16.96681,8193,4,4.5);
        markers[61] = new Marker("Stare Miasto",51.10874, 17.01433,8839,3,1.18);
        markers[62] = new Marker("Dabie",51.10283, 17.0839,1191,5,3.64);
        markers[63] = new Marker("Soltysowice",51.1515, 17.07492,4109,2,5.48);
        markers[64] = new Marker("Rozanka - Polanka",51.13853, 17.03179,15746,5,3.67);
        markers[65] = new Marker("Brochow",51.06531, 17.07415,7699,2,5.66);
        markers[66] = new Marker("Powstancow Slaskich - Zachod",51.09688, 17.02113,12077,3,2.57);
        markers[67] = new Marker("Powstancow Slaskich - Wschod",51.08932, 17.01599,11456,5,2.69);
        markers[68] = new Marker("Huby",51.091646, 17.040694,19299,3,1.92);
        markers[69] = new Marker("Osiedle Henrykowskie",51.08838, 17.04971,5384,2,2.7);
        markers[70] = new Marker("Krakowska",51.08989, 17.06305,246,3,3.32);
        markers[71] = new Marker("Oporow",51.07731, 16.96336,6764,5,6.1);
        markers[72] = new Marker("Borek",51.07996, 17.01227,12119,5,3.47);
        markers[73] = new Marker("Klecina",51.06354, 16.97833,6199,4,6.48);
        markers[74] = new Marker("Partynice",51.0603, 16.99997,6991,3,5.89);
        markers[75] = new Marker("Wojszyce",51.0625, 17.03222,5338,3,5.52);
        markers[76] = new Marker("Oltaszyn",51.05335, 17.02003,10799,2,5.86);

        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                int markersNumber = Integer.parseInt(textField1.getText());

                if (markersNumber <= 77) {

                    htmlHandler.erase();
                    htmlHandler.insert(markers, markersNumber);

                    Platform.runLater(new Runnable() {
                        @Override
                        public void run() {
                            webEngine.reload();
                        }
                    });
                }
            }
        });

    }

    public static void main(String[] args)
    {
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run()
            {
                Main app = new Main();
                app.createGUI();
            }
        });
    }

    private void createGUI() {
        jfxPanel = new JFXPanel();
        JFrame frame = new JFrame();
        frame.setSize(800,600);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());
        frame.add(panel1,BorderLayout.PAGE_START);
        frame.add(jfxPanel,BorderLayout.CENTER);
        frame.setVisible(true);

        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                browser = new WebView();
                jfxPanel.setScene(new Scene(browser));
                webEngine = browser.getEngine();
                webEngine.load("file:///home/pawel/IdeaProjects/Rowery1/src/map.html");
            }
        });

        frame.addWindowListener(new WindowAdapter()
        {
            public void windowClosing(WindowEvent e)
            {
                htmlHandler.erase();
            }
        });
    }

}
