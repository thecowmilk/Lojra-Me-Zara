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
                g.drawString("Q�llimi i lojes:" , 20, 70);
                g.drawString("N� k�t� loj� ka 5 zara dhe 1 deri ne 4 lojtare (ky opsion duhet t� zgjidhet" , 20, 90);
                g.drawString("nga perdoruesi q� n� momentin q� hapet loja). Sa her� q� nj� lojtar ka rradhen," , 20, 110);
                g.drawString("ai duke shtypur nj� buton hedh 5 zarat me shpres� q� konfigurimi q� ka dal� t� " , 20, 130);
                g.drawString("b�j� pjes� n� nj� nga 13 kategorit� e loj�s (kategorit� shpjegohen m� posht�). " , 20, 150);
                g.drawString("N�se hedhja e par� nuk shkon sic duhet, lojtari mund t� zgjedh� t� hedh� s�risht " , 20, 170);
                g.drawString("disa ose t� gjith� zarat. N�se dhe hedhja e dyt� nuk �sht� e suksesshme, prap� " , 20, 190);
                g.drawString("lojtari mund t� zgjedh� t� hedh� s�risht disa ose t� gjith� zarat. N� fund t� " , 20, 210);
                g.drawString("hedhjes s� tret� p�rdoruesi duhet t� vendosi konfigurimin p�rfundimtar n� nj� " , 20, 230);
                g.drawString("prej 13 kategorive q� ndodhen n� fush�n e loj�s. N�se konfigurimi p�rputhet me " , 20, 250);
                g.drawString("kriteret p�r at� kategori, at�her� lojtari merr pik�t p�rkat�se t� kategoris�, " , 20, 270);
                g.drawString("ndryshe pik�t p�r k�t� kategori jan� 0. Nj� cik�l loje �sht� kur secili prej " , 20, 290);
                g.drawString("lojtar�ve (1 - 4) ka nga nj� her� rradh�n. N� cdo rradh� nj� lojtar mund ti " , 20, 310);
                g.drawString("hedh� zarat 1 deri n� 3 her�. Duke qen� se ka 13 kategori dhe cdo kategori mund" , 20, 330);
                g.drawString("t� p�rzgjidhet e shumta nje her�, loja ka 13 cikle gjithsej. Pas ciklit t� 13-t�, " , 20, 350);
                g.drawString("gjith� lojtar�t do t� marrin shum�n e pik�ve p�r secil�n kategori. Lojtari q� ka shum�n" , 20, 370);
                g.drawString("e pik�ve m� t� lart� �sht� fituesi.", 20, 390);
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
