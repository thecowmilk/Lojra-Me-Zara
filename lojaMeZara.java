package gui;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.rmi.activation.ActivationInstantiator;

public class lojaMeZara extends JFrame{
    JFrame frame1 = new JFrame("Loja me Zara");
    public JButton playbutton= new JButton("PLAY");
    public JButton p1= new JButton("1P");
    public JButton p2= new JButton("2P");
    public JButton p3= new JButton("3P");
    public JButton p4= new JButton("4P");
    public JButton instructions= new JButton("INSTRUCTIONS");
    public JButton exit= new JButton("EXIT");
    public JPanel panel1 = new JPanel();
    public static int nrLojtaresh;

    public lojaMeZara() throws Exception{
        int fontSize2 = 40;
        Font f2 = new Font("monospaced", Font.BOLD, fontSize2);
        frame1.setSize(700, 600);
        frame1.setLayout(null);
        frame1.setResizable(false);
        frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        BufferedImage img = ImageIO.read(lojaMeZara.class.getClassLoader().getResourceAsStream("dice.png"));
        panel1 = new JPanel(){
            protected void paintComponent(Graphics g){
                g.drawImage(img, 110, 50, 500, 500, null);
                g.setColor(Color.black);
                g.setFont(f2);
                g.drawString("LOJA ME ZARE",200,150);
                //g.drawString(this.getBounds().toString(),5,15);
            }
        };
        panel1.setLayout(null);
        panel1.setSize(700,600);
        frame1.add(panel1);
        panel1.add(new JLabel(new ImageIcon("D:/dice.png")));
        //Play Button
        playbutton.setBounds(250,200, 170,50);
        playbutton.setEnabled(false);
        panel1.add(playbutton);
        playbutton.addActionListener(new kalofaqe());
        //1P
        p1.setBounds(220,270, 50,50);
        panel1.add(p1);
        p1.addActionListener(new merrnrLojtaresh());
        //2P
        p2.setBounds(280,270, 50,50);
        panel1.add(p2);
        p2.addActionListener(new merrnrLojtaresh());
        //3P
        p3.setBounds(340,270, 50,50);
        panel1.add(p3);
        p3.addActionListener(new merrnrLojtaresh());
        //4P
        p4.setBounds(400,270, 50,50);
        panel1.add(p4);
        p4.addActionListener(new merrnrLojtaresh());
        //Instructions
        instructions.setBounds(250,340, 170,50);
        panel1.add(instructions);
        instructions.addActionListener(new hapinstruksione());
        //Exit
        exit.setBounds(250,410, 170,50);
        panel1.add(exit);
        exit.addActionListener(new mbyll());
        frame1.setVisible(true);
    }


   
private class merrnrLojtaresh implements ActionListener{

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==p1){
            nrLojtaresh=1;
        }else if(e.getSource()==p2){
            nrLojtaresh=2;
        }else if(e.getSource()==p3){
            nrLojtaresh=3;
        }else if(e.getSource()==p4){
            nrLojtaresh=4;
        }
        playbutton.setEnabled(true);
        }
}
private class kalofaqe implements ActionListener{

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==playbutton){
            try {
            	frame1.dispose();
                new infoscreen();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }
}

private class mbyll implements ActionListener{

    @Override
    public void actionPerformed(ActionEvent e) {
        System.exit(0);
    }
}

private class hapinstruksione implements ActionListener{

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==instructions){
            try {
            	frame1.dispose();
                new instruksione();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }
}

}

