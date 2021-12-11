/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package po_2;
import javax.swing.JFrame;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import po_2.swiat;
import java.io.FileWriter;
import java.io.File;
import java.io.IOException;
/**
 *
 * @author lukin
 */

public class Ekran extends JPanel implements ActionListener, KeyListener{
    private final swiat planeta;
    private String zapisznazwa;
    //Timer t = new Timer(5, this);
    public Ekran(swiat Swiat)
    {   
        this.planeta = Swiat;
        addKeyListener(this);
        setFocusable(true);
        setFocusTraversalKeysEnabled(false);
       // t.start();
    }
    public void paintComponent (Graphics g){
        super.paintComponent(g);
        for (int i=0;i<20;i++)
        {
            for(int j=0;j<20;j++)
            {
                if(planeta.plansza[i][j] != null)
                {
                    g.setColor(planeta.plansza[i][j].Kolor());
                    g.fillRect(j*45+3, i*45+3, 30, 30);
                }
                else
                {
                    g.setColor(Color.BLACK);
                    g.fillRect(j*45+3, i*45+3, 30, 30);
                }
            }
        }
        repaint();
    }
    @Override
    public void actionPerformed(ActionEvent e) {
    }
    @Override
    public void keyPressed(KeyEvent e) {
    if(planeta.GetRuch() != 0)
    {
     switch(e.getKeyCode()){
            case KeyEvent.VK_UP:
                if(planeta.cx > planeta.szybkosc - 1)
                {
                    planeta.cx-=planeta.szybkosc;
                    planeta.SetRuch(0);
                }
                break;
            case KeyEvent.VK_DOWN:
                if(planeta.cx < planeta.wysokosc - planeta.szybkosc)
                {
                    planeta.cx+=planeta.szybkosc;
                    planeta.SetRuch(0);
                }
                break;
            case KeyEvent.VK_RIGHT:
                if(planeta.cy < planeta.szerokosc - planeta.szybkosc)
                {
                    planeta.cy+=planeta.szybkosc;
                    planeta.SetRuch(0);
                }
                break;
            case KeyEvent.VK_LEFT:
                if(planeta.cy > planeta.szybkosc - 1)
                {
                    planeta.cy-=planeta.szybkosc;
                    planeta.SetRuch(0);
                }
                break;
            case KeyEvent.VK_Q:
                if (planeta.cooldown < 6)
                        System.out.println("ULT NIE GOTOWY");
			if (planeta.wlacz == false && planeta.cooldown > 5)
			{
                            System.out.println("ULT wlaczony");
                            planeta.wlacz = true;
                            planeta.szybkosc = 2;
			}
                break;
            case KeyEvent.VK_S:
                JFrame f=new JFrame("Farma");  
                final JTextField tf=new JTextField();  
                tf.setBounds(210,100, 150,30);  
                JButton b1=new JButton("Zapisz gre");   
                b1.setBounds(40,150,320,30); 
                f.setVisible(true);
                b1.addActionListener(new ActionListener(){  
                public void actionPerformed(ActionEvent e){  
                zapisznazwa = tf.getText();
                    Zapisz();
                    f.setVisible(false);
                    f.dispose();
                }  
                }); 
                f.add(b1);
                f.add(tf);  
                f.setSize(400,250);
                f.setLocation(1000, 200);
                f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                f.setResizable(false);
                f.setLayout(null);
                break;
        }   
    }
    }
    @Override
    public void keyReleased(KeyEvent e) {
    }
    @Override
    public void keyTyped(KeyEvent arg0) {

}
private void Zapisz()
{
    int iloscorganizmow = 0;
    try {
      File myObj = new File(zapisznazwa+".txt");
      if (myObj.createNewFile()) {
        System.out.println("Zapisano świat:" + myObj.getName());
       try {
      FileWriter myWriter = new FileWriter(zapisznazwa+".txt");
      for (int i = 0; i < planeta.wysokosc; i++)
      {
		for (int j = 0; j < planeta.szerokosc; j++)
		{
			if (planeta.plansza[i][j] instanceof organizm)
				iloscorganizmow++;
		}
      }
      myWriter.write(iloscorganizmow+" ");
      myWriter.write("\n");
                for (int j = 0; j < planeta.wysokosc; j++)
                {
		for (int i = 0; i < planeta.szerokosc; i++) {
			if (planeta.plansza[i][j] != null)
			{
				myWriter.write(planeta.plansza[i][j].GetID()+" ");
                                myWriter.write(planeta.plansza[i][j].GetX()+" "+planeta.plansza[i][j].GetY()+" ");
                                myWriter.write(planeta.plansza[i][j].GetSila()+" ");
                                myWriter.write(planeta.plansza[i][j].GetWiek()+" ");
				if (planeta.plansza[i][j].GetID() == 'C') {
                                    myWriter.write(planeta.cooldown+" ");
                                    myWriter.write(planeta.licznik+" ");
                                    myWriter.write(planeta.szybkosc+" ");
                                    myWriter.write(planeta.wlacz+" ");
				}
				myWriter.write("\n");
			}
                }
                }
      myWriter.close();
      System.out.println("Pomyślnie zapisano do pliku");
    } catch (IOException e) {
      System.out.println("Wystąpił błąd");
      e.printStackTrace();
    }
      } else {
        System.out.println("Plik już istnieje");
      }
    } catch (IOException e) {
      System.out.println("Wystąpił błąd");
      e.printStackTrace();
    }
}
}
