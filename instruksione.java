package gui;
import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.rmi.activation.ActivationInstantiator;

public class instruksione extends JFrame {
    JFrame frame1 = new JFrame("Loja me Zara");
    JPanel panel1 = new JPanel();
    JButton kthehu = new JButton("Kthehu");



    public instruksione() throws Exception {
        int fontSize = 12;
        Font f = new Font("monospaced", Font.PLAIN, fontSize);

        frame1.setSize(700, 600);
        frame1.setLayout(null);
        frame1.setResizable(false);
        frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        panel1 = new JPanel() {
            protected void paintComponent(Graphics g) {
                g.setColor(Color.black);
                g.setFont(f);
                g.drawString("Qëllimi i lojes:" , 20, 70);
                g.drawString("Në këtë lojë ka 5 zara dhe 1 deri ne 4 lojtare (ky opsion duhet të zgjidhet" , 20, 90);
                g.drawString("nga perdoruesi që në momentin që hapet loja). Sa herë që një lojtar ka rradhen," , 20, 110);
                g.drawString("ai duke shtypur një buton hedh 5 zarat me shpresë që konfigurimi që ka dalë të " , 20, 130);
                g.drawString("bëjë pjesë në një nga 13 kategoritë e lojës (kategoritë shpjegohen më poshtë). " , 20, 150);
                g.drawString("Nëse hedhja e parë nuk shkon sic duhet, lojtari mund të zgjedhë të hedhë sërisht " , 20, 170);
                g.drawString("disa ose të gjithë zarat. Nëse dhe hedhja e dytë nuk është e suksesshme, prapë " , 20, 190);
                g.drawString("lojtari mund të zgjedhë të hedhë sërisht disa ose të gjithë zarat. Në fund të " , 20, 210);
                g.drawString("hedhjes së tretë përdoruesi duhet të vendosi konfigurimin përfundimtar në një " , 20, 230);
                g.drawString("prej 13 kategorive që ndodhen në fushën e lojës. Nëse konfigurimi përputhet me " , 20, 250);
                g.drawString("kriteret për atë kategori, atëherë lojtari merr pikët përkatëse të kategorisë, " , 20, 270);
                g.drawString("ndryshe pikët për këtë kategori janë 0. Një cikël loje është kur secili prej " , 20, 290);
                g.drawString("lojtarëve (1 - 4) ka nga një herë rradhën. Në cdo rradhë një lojtar mund ti " , 20, 310);
                g.drawString("hedhë zarat 1 deri në 3 herë. Duke qenë se ka 13 kategori dhe cdo kategori mund" , 20, 330);
                g.drawString("të përzgjidhet e shumta nje herë, loja ka 13 cikle gjithsej. Pas ciklit të 13-të, " , 20, 350);
                g.drawString("gjithë lojtarët do të marrin shumën e pikëve për secilën kategori. Lojtari që ka shumën" , 20, 370);
                g.drawString("e pikëve më të lartë është fituesi.", 20, 390);
            }
        };
        panel1.setLayout(null);
        panel1.setSize(700,600);
        frame1.add(panel1);

        kthehu.setBounds(20,480,100,40);
        panel1.add(kthehu);
        kthehu.addActionListener(new kthim());
        frame1.setVisible(true);
    }

    public static void main(String[] args) throws Exception {
        new instruksione();
    }

    private class kthim implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            try {
            	frame1.dispose();
                new lojaMeZara();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }
}
