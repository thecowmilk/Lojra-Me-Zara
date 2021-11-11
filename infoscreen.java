package gui;
import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.text.JTextComponent;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;

public class infoscreen extends JFrame {
	static int nrLojtaresh=lojaMeZara.nrLojtaresh;
	public static int merrTeDhenat=0;
	public static Lojetar[] lojtaret=new Lojetar[nrLojtaresh];
    JFrame frame2 = new JFrame("Loja me Zara");
    JTextField emri = new JTextField("Emri", 40);
    JTextField mbiemri = new JTextField("Mbiemri", 40);
    JTextField mosha = new JTextField("Mosha", 10);

    JPanel panel = new JPanel();
    JButton fillo;
    JButton kthehu = new JButton("Kthehu");


    public infoscreen() throws Exception {
        frame2.setSize(700, 600);
        frame2.setLayout(null);
        frame2.setResizable(false);
        frame2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        panel.setLayout(null);
        panel.setBackground(new Color(240, 125, 108));
        panel.setSize(700, 600);
        frame2.add(panel);
        
        emri.setBounds(250, 180, 200, 40);
        panel.add(emri);
        mbiemri.setBounds(250, 230, 200, 40);
        panel.add(mbiemri);
        mosha.setBounds(250, 280, 200, 40);
        panel.add(mosha);
       
        fillo= new JButton("Regjistrohu");
        fillo.setBounds(250, 330, 200, 50);
        panel.add(fillo);
        fillo.addActionListener(new kalofaqe());
        kthehu.setBounds(50,50,100,40);
        panel.add(kthehu);
        kthehu.addActionListener(new kthim());

        frame2.setVisible(true);

    }

//    public static void main(String[] args) throws Exception {
//        new infoscreen();
//    }

    private class kalofaqe implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
        	if(e.getActionCommand()=="Regjistrohu") {
        		String em=emri.getText();
        		emri.setText("");
        		String mb=mbiemri.getText();
        		mbiemri.setText("");
        		String mo=mosha.getText();
        		mosha.setText("");
        		lojtaret[merrTeDhenat]=new Lojetar(em, mb, mo);
        		merrTeDhenat++;
        		if(merrTeDhenat==nrLojtaresh) {
        			emri.setEnabled(false);
        			emri.setEditable(false);
        			mbiemri.setEnabled(false);
        			emri.setEditable(false);
        			mosha.setEnabled(false);
        			fillo.setText("Fillo");
        			emri.setEditable(false);
        		}
        	} else {
                try {
                	frame2.dispose();
                    new DritareKryesore();//KETU VENDOS ATE new DritareKryesore();
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
        	}
        }
    }


    private class kthim implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            try {
            	frame2.dispose();
                new lojaMeZara();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }
}
