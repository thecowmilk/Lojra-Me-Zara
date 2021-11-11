package gui;
import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class DritareKryesore extends JFrame{
//zaret e lojes dhe butoni qe i hedh ato
	public int nrLojetaresh=lojaMeZara.nrLojtaresh;
	public static Lojetar[] lojtaret=infoscreen.lojtaret;
	public static int lojtariAktual=0;
	public static int raundi=0;
	public Zari zari=new Zari();
	public JLabel mesazh1;
	public JButton btnZgjidh;
	public JPanel panelZaresh;
	public JButton hidhZaret;
	public JToggleButton[] zaret;
	public static final String[] emraFotosh= {"pp.png", "1.png", "2.png", "3.png", "4.png", "5.png", "6.png", 
			"01.png", "02.png", "03.png", "04.png", "05.png", "06.png"};//fotot ne indekset 1-6 dhe inverted 7-12
	public final Icon[] zaretIcon= {
			new ImageIcon(getClass().getResource(emraFotosh[0])),
			new ImageIcon(getClass().getResource(emraFotosh[1])),
			new ImageIcon(getClass().getResource(emraFotosh[2])),
			new ImageIcon(getClass().getResource(emraFotosh[3])),
			new ImageIcon(getClass().getResource(emraFotosh[4])),
			new ImageIcon(getClass().getResource(emraFotosh[5])),
			new ImageIcon(getClass().getResource(emraFotosh[6])),
			new ImageIcon(getClass().getResource(emraFotosh[7])),
			new ImageIcon(getClass().getResource(emraFotosh[8])),
			new ImageIcon(getClass().getResource(emraFotosh[9])),
			new ImageIcon(getClass().getResource(emraFotosh[10])),
			new ImageIcon(getClass().getResource(emraFotosh[11])),
			new ImageIcon(getClass().getResource(emraFotosh[12])),
	};
	//tabela
	public JPanel panelPikesh;
	public JTable table;
	public JPanel paneliKategorive;
	JRadioButton[] radio;
	ButtonGroup grup;
	JLabel lblpikeSiper;
	JLabel lblBonus;
	JLabel lblpikePoshte;
	JLabel lblTotal;
	private final BorderLayout layout;//se di ca ben
	
	public DritareKryesore() {
		super("Loja me zare");
		setBackground(Color.white);	
		this.layout = new BorderLayout();
		setBounds(0, 0, 700, 600);
		//setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		getContentPane().setLayout(null);
	
		//krijoj panelin e zarave
		panelZaresh = new JPanel();
		panelZaresh.setBounds(28, 30, 84, 460);
		getContentPane().add(panelZaresh);
		
		hidhZaret=new JButton("Hidh Zaret");
		hidhZaret.setFont(new Font("Stencil", Font.PLAIN, 13));
		hidhZaret.setBackground(new Color(165, 42, 42));
		hidhZaret.addActionListener(new Hedhja());
		panelZaresh.add(hidhZaret);
				
		zaret=new JToggleButton[5];
		for(int i=0; i<5; i++) {
		zaret[i]= new JToggleButton(zaretIcon[0]);
		zaret[i].setBorderPainted(false);
		zaret[i].setBorder(null);
		zaret[i].setMargin(new Insets(0,0,0,0));
		zaret[i].setContentAreaFilled(false);
		zaret[i].addActionListener(new SelektoZar());
		}
		
		
		for(int i=0; i<5; i++) {
			panelZaresh.add(zaret[i]);
		}
		mesazh1 = new JLabel(lojtaret[lojtariAktual].emri+ " Hidh Zaret dhe luaj lojen. Ju keni 3 gjuajtje.");
		mesazh1.setBounds(205, 20, 444, 24);
		getContentPane().add(mesazh1);
	
		
		btnZgjidh = new JButton("Zgjidh Kategori");
		btnZgjidh.setFont(new Font("Stencil", Font.PLAIN, 13));
		btnZgjidh.setEnabled(false);
		btnZgjidh.setBackground(new Color(165, 42, 42));
		btnZgjidh.setBounds(120, 510, 174, 25);
		getContentPane().add(btnZgjidh);
		btnZgjidh.addActionListener(new Kategorizo());
		
		
		panelPikesh= new JPanel();
		panelPikesh.setBounds(320, 80, 300, 411);
		getContentPane().add(panelPikesh);
		panelPikesh.setLayout(new BorderLayout(0, 0));
		
		table = new JTable();
		table = new JTable();
		table.setBounds(0, 0, 400, 490);
		table.setBackground(new Color(240, 125, 108));
		table.setBorder(new LineBorder(new Color(0, 0, 0)));
		table.setRowHeight(23);
		table.setCellSelectionEnabled(false);
		// table.setCellSelectionEnabled(true);
		table.setPreferredSize(new Dimension(400, 480));
		table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
		
		
		
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
			},new String[] {lojtaret[0].emri, lojtaret.length>1?lojtaret[1].emri:"-" , 
					lojtaret.length>2? lojtaret[2].emri:"-", lojtaret.length>3?lojtaret[3].emri:"-"}
		));
		panelPikesh.add(table, BorderLayout.CENTER);
		panelPikesh.setBackground(new Color(0,0,0,0));
		getContentPane().add(panelPikesh);
		table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);//keto instruksione vendosin madhesine maksimale te kolonave ne 100 
		for(int i = 0; i < 3; i++)
			table.getColumnModel().getColumn(i).setMaxWidth(100);
		panelPikesh.setLayout(new BorderLayout());//per orientimin e tabeles
		panelPikesh.add(table.getTableHeader(), BorderLayout.PAGE_START);
		panelPikesh.add(table, BorderLayout.CENTER);
		
		
		
		
//krijimi i panelit per vendosjen e kategorive

		paneliKategorive = new JPanel();
		paneliKategorive.setAlignmentX(Component.LEFT_ALIGNMENT);
		paneliKategorive.setBounds(140, 103, 170, 400);
		getContentPane().add(paneliKategorive);
		paneliKategorive.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		paneliKategorive.setLayout(new BoxLayout(paneliKategorive, BoxLayout.Y_AXIS));
		
		radio=new JRadioButton[13];
		radio[0] = new JRadioButton("Njesha");
		radio[1] = new JRadioButton("Dysha");
		radio[2] = new JRadioButton("Tresha");
		radio[3] = new JRadioButton("Katra");
		radio[4] = new JRadioButton("Pesa");
		radio[5] = new JRadioButton("Gjashta");
		radio[6] = new JRadioButton("Tre me nje vlere");
		radio[7] = new JRadioButton("Kater me nje vlere");
		radio[8] = new JRadioButton("Tre dhe dy");
		radio[9] = new JRadioButton("Kater te njepasnjeshme");
		radio[10]= new JRadioButton("Pese te njepasnjeshme");
		radio[11]= new JRadioButton("E njejta vlere");
		radio[12]= new JRadioButton("Cdo rast");

		grup=new ButtonGroup();
		for(int i=0; i<13; i++) {
			if(i==6) {
				lblpikeSiper = new JLabel("Piket e Siperme");
				lblpikeSiper.setMaximumSize(new Dimension(100, 23));
				lblpikeSiper.setMinimumSize(new Dimension(48, 23));
				lblpikeSiper.setPreferredSize(new Dimension(100, 23));
				paneliKategorive.add(lblpikeSiper);
				
				lblBonus = new JLabel("Bonus");
				lblBonus.setMaximumSize(new Dimension(60, 23));
				lblBonus.setMinimumSize(new Dimension(48, 23));
				lblBonus.setPreferredSize(new Dimension(100, 23));
				paneliKategorive.add(lblBonus);
			}
			radio[i].setSize(new Dimension(100, 25));
			radio[i].setPreferredSize(new Dimension(130, 23));
			paneliKategorive.add(radio[i]);
			grup.add(radio[i]);
		}
		lblpikePoshte = new JLabel("Piket e Poshtme");
		lblpikePoshte.setMaximumSize(new Dimension(100, 23));
		lblpikePoshte.setMinimumSize(new Dimension(48, 23));
		lblpikePoshte.setPreferredSize(new Dimension(48, 23));
		lblpikePoshte.setBounds(new Rectangle(0, 0, 0, 23));
		paneliKategorive.add(lblpikePoshte);
		
		lblTotal = new JLabel("Total");
		lblTotal.setMaximumSize(new Dimension(100, 23));
		lblTotal.setMinimumSize(new Dimension(48, 23));
		lblTotal.setPreferredSize(new Dimension(48, 23));
		lblTotal.setBounds(new Rectangle(0, 0, 0, 23));
		paneliKategorive.add(lblTotal);	
			
		

	}	
	
	private void shfaqMesazhin(String str) {
		// TODO Auto-generated method stub
		mesazh1.setText(str);
		System.out.println(str);
	}
	

	public void shfaqVleratEZareve(int[] vleraZari) {
		for(int i=0; i<5; i++) {
			if(zari.boolZari[i]==false) {
			int vl=vleraZari[i];
			zaret[i].setIcon(zaretIcon[vl]);
			}
		}	
	}
	
	
		
//	public static void main(String[] args) throws Exception {\
//		// TODO Auto-generated method stub
//		DritareKryesore dritare=new DritareKryesore();
//	}
//	
	
	
	
	//klasa private te perdorura
	
	private class SelektoZar implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			for(int i=0; i<5; i++) {			
				if(e.getSource()==zaret[i]) {//meqe zari fillon nga 0-5 atehere duhet te shtojme +1
					for(int j=1; j<13; j++) {
						if(zaret[i].getIcon()==zaretIcon[j]) {
						if(j<7) {
							zaret[i].setIcon(zaretIcon[j+6]);
							zari.boolZari[i]=true; //ruaj vleren e atij zarit
						}
						else {zaret[i].setIcon(zaretIcon[j-6]);
							zari.boolZari[i]=false;
						}
						break;
						}						
					}
				}			
			}
		}
		
	}
	
	private class Hedhja implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			zari.hedhja++;
			zari.gjenero();
			shfaqVleratEZareve(zari.vleraZari);
			if(zari.hedhja==3) {
				btnZgjidh.setEnabled(true);
				hidhZaret.setEnabled(false);
			}
			shfaqMesazhin(lojtaret[lojtariAktual].emri+ " keni edhe "+(3-zari.hedhja)+ " gjuajtje.");
		}

	}
	
	
	private class Kategorizo implements ActionListener{
		//klasa qe kontrollon kur shtypet butoni "ZgjidhKategorine" 
		//nese eshte e lire kategoria e zgjedhur dhe pastaj llogarit piket
		//mbase edhe i vendos

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			boolean uKrye=false; //behet tru nese eshte selektuar nje kategori
			int piket=0;
			int kategori=-1;
			for(int i=0; i<radio.length; i++) {
				if(radio[i].isSelected()==true) {
					if(i==0) {
						piket=Kategorite.kategori1(zari.vleraZari);
						lojtaret[lojtariAktual].setPikeKategorie(0, piket);
						uKrye=true;
						kategori=i;
					}
					else if(i==1)  {
						piket=Kategorite.kategori2(zari.vleraZari);
						lojtaret[lojtariAktual].setPikeKategorie(1, piket);
						kategori=i;
						uKrye=true;
					}
					else if(i==2)  {
						piket=Kategorite.kategori3(zari.vleraZari);
						lojtaret[lojtariAktual].setPikeKategorie(2, piket);
						kategori=i;
						uKrye=true;
					}
					else if(i==3)  {
						piket=Kategorite.kategori4(zari.vleraZari);
						lojtaret[lojtariAktual].setPikeKategorie(3, piket);
						kategori=i;
						uKrye=true;
					}
					else if(i==4)  {
						piket=Kategorite.kategori5(zari.vleraZari);
						lojtaret[lojtariAktual].setPikeKategorie(4, piket);
						kategori=i;
						uKrye=true;
					}
					else if(i==5)  {
						piket=Kategorite.kategori6(zari.vleraZari);
						lojtaret[lojtariAktual].setPikeKategorie(5, piket);
						uKrye=true;
						kategori=i;
					}
					else if(i==6)  {
						piket=Kategorite.kategori7(zari.vleraZari);
						lojtaret[lojtariAktual].setPikeKategorie(6, piket);
						uKrye=true;
						kategori=i;
					}
					else if(i==7)  {
						piket=Kategorite.kategori8(zari.vleraZari);
						lojtaret[lojtariAktual].setPikeKategorie(7, piket);
						uKrye=true;
						kategori=i;
					}
					else if(i==8) {
						piket=Kategorite.kategori9(zari.vleraZari);
						lojtaret[lojtariAktual].setPikeKategorie(8, piket);
						uKrye=true;
						kategori=i;
					}
					else if(i==9)  {
						piket=Kategorite.kategori10(zari.vleraZari);
						lojtaret[lojtariAktual].setPikeKategorie(9, piket);
						uKrye=true;
						kategori=i;
					}
					else if(i==10)  {
						piket=Kategorite.kategori11(zari.vleraZari);
						lojtaret[lojtariAktual].setPikeKategorie(10, piket);
						uKrye=true;
						kategori=i;
					}
					else if(i==11) {
						piket=Kategorite.kategori12(zari.vleraZari);
						lojtaret[lojtariAktual].setPikeKategorie(11, piket);
						uKrye=true;
						kategori=i;
					}
					else if(i==12)  {
						piket=Kategorite.kategori13(zari.vleraZari);
						lojtaret[lojtariAktual].setPikeKategorie(12, piket);
						uKrye=true;
						kategori=i;
					}
				} 
			}
			if(uKrye==false) 
					JOptionPane.showMessageDialog(btnZgjidh, "Me pare duhet te zgjedhesh njeren nga kategorite e vlefshme!");
				else {
					//vendos vleren ne tabele
					updatoTabelen(piket, kategori, lojtariAktual);
					//inkremento lojetarin dhe raundin
					//shiko nese raundi ishte i fundit
					lojtariAktual++;
					if(lojtariAktual==nrLojetaresh) raundi++;
					if(raundi==13) {mbyllLojen();}
					else {
					lojtariAktual=lojtariAktual%nrLojetaresh;
					//shfaq mesazhin e pare me emrin lart
					shfaqMesazhin(lojtaret[lojtariAktual].emri+ " Hidh Zaret dhe luaj lojen. Ti ke 3 gjuajtje.");
					//hedhja e zarit behet 0
					resetoLojenPerNextPlayer();
					//disable butoni zgjidh kategorine
					btnZgjidh.setEnabled(false);
					//disable radiot me vlere
					validoRadioButtons();	
				}
			}
		}

		
		private void updatoTabelen(int piket, int kategori, int lojtariAktual ) {
			// vendosja epikeve ne tabele
			if(kategori<6)
				table.setValueAt(piket, kategori, lojtariAktual);
			else {
				table.setValueAt(piket, kategori+2, lojtariAktual);
			}
		}


		private void resetoLojenPerNextPlayer() {
			zari.resetZarin();
			for(int i=0; i<5; i++)
				zaret[i].setIcon(zaretIcon[0]);
			hidhZaret.setEnabled(true);
		}
		

		//rdbtnNewRadioButton.setSelected(true);   rdbtnNewRadioButton.setEnabled(false);
		private void validoRadioButtons() {
			// per secilen rradhe te lojetareve do beje unselectable radiot e zgjedhura me pare
			grup.clearSelection();
			for(int i=0; i<radio.length; i++) {
				if(!lojtaret[lojtariAktual].kategoriELire(i)) {//kur nuk eshte e lire kategoria, pra eshte zgjedhur
					radio[i].setSelected(false);
					radio[i].setEnabled(false);
				} else {
					radio[i].setEnabled(true);
				}
			}
			
		}


		private void mbyllLojen() {
			// momenti kur eshte mbyllur raundi i fundit
			//llogarit piket e siperme poshtme bonuset totalin e cdo lojtari. shfaqi ne tabele
			//shfaq mesazhin me emrin e fituesit
			int max=0;
			int fituesi=-1;
			for(int i=0; i<lojtaret.length; i++) {
				lojtaret[i].llogaritPiketSiperme();
				table.setValueAt(lojtaret[i].getPiketSiperme(), 6, i);
				lojtaret[i].llogaritPiketPoshtme();
				lojtaret[i].llogaritPiketPoshtme();
				table.setValueAt(lojtaret[i].getPiketPoshtme(), 15, i);
				lojtaret[i].llogaritBonus();
				table.setValueAt(lojtaret[i].getBonus(), 7, i);
				lojtaret[i].llogaritTotalin();
				table.setValueAt(lojtaret[i].getTotali(), 16, i);
				
				if(lojtaret[i].getTotali()>max) {
					max=lojtaret[i].getTotali();
					fituesi=i;
				}
				
			shfaqMesazhin(lojtaret[fituesi].emri+ " fitoi Lojen Me Zara me "+max+" pike!");
			}
		}
		
	}
}
	
		
		
		
