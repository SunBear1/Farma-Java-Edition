/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package po_2;
import java.util.concurrent.ThreadLocalRandom;
import java.util.*;
import javax.swing.*;
import java.awt.event.*; 
import java.awt.*;
import zwierzeta.owca;
import zwierzeta.antylopa;
import zwierzeta.wilk;
import zwierzeta.lis;
import zwierzeta.zolw;
import zwierzeta.cyberowca;
import zwierzeta.czlowiek;
import rosliny.trawa;
import rosliny.mlecz;
import rosliny.guarana;
import rosliny.barszcz;
import rosliny.wilczejagody;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 *
 * @author lukin
 */

public class swiat extends Canvas{
Vector<organizm> Gra = new Vector<organizm>(2);
public int cooldown = 6, licznik = 0, szybkosc = 1,kierunek,cx,cy,wysokosc,szerokosc,ruch = 1;
public boolean wlacz = false,czlowiekzyje = true, zolwodparlatak,startgry=false,jestplik=true;
public String wczytajnazwa;
public organizm [][]plansza;
swiat (int szerokosc,int wysokosc)
{
	this.szerokosc = szerokosc;
	this.wysokosc = wysokosc;
	plansza = new organizm[wysokosc][szerokosc];
	for (int i = 0; i < wysokosc; i++)
	{
            for (int j = 0; j < szerokosc; j++)
            {
		plansza[i][j] = null;
            }	
	}
}
public void SetRuch(int ruch)
{
    this.ruch = ruch;
}
public int GetRuch()
{
    return ruch;
}
public void paint(Graphics g){
        super.paint(g);
        
        for (int i=0;i<20;i++)
        {
            for(int j=0;j<20;j++)
            {
                g.setColor(plansza[i][j].Kolor());
                g.fillRect(j*45+3, i*45+3, 30, 30);
            }
        } 
}
private organizm DodajOrganizm(int x, int y,char id)
{
	if (id == 'A')
	{
		organizm New = new antylopa();
		New.SetX(x);
		New.SetY(y);
		return New;
	}
	else if (id == 'O')
	{
		organizm New = new owca();
		New.SetX(x);
		New.SetY(y);
		return New;
	}
	else if (id == 'W')
	{
		organizm New = new wilk();
		New.SetX(x);
		New.SetY(y);
		return New;
	}	
	else if (id == 'L')
	{
		organizm New = new lis();
		New.SetX(x);
		New.SetY(y);
		return New;
	}
	else if (id == 'Z')
	{
		organizm New = new zolw();
		New.SetX(x);
		New.SetY(y);
		return New;
	}
	else if (id == 'T')
	{
		organizm New = new trawa();
		New.SetX(x);
		New.SetY(y);
		return New;
	}
	else if (id == 'M')
	{
		organizm New = new mlecz();
		New.SetX(x);
		New.SetY(y);
		return New;
	}
	else if (id == 'J')
	{
		organizm New = new wilczejagody();
		New.SetX(x);
		New.SetY(y);
		return New;
	}
	else if (id == 'G')
	{
		organizm New = new guarana();
		New.SetX(x);
		New.SetY(y);
		return New;
	}
	else if (id == 'B')
	{
		organizm New = new barszcz();
		New.SetX(x);
		New.SetY(y);
		return New;
	}
        else if (id == 'R')
	{
		organizm New = new cyberowca();
		New.SetX(x);
		New.SetY(y);
		return New;
	}
	else
	{
		organizm New = new czlowiek();
		New.SetX(x);
		New.SetY(y);
                cx = x;
                cy = y;
		return New;
	}
}
private void Wczytaj()
{
    int wiek, sila, x, y ,iloscorganizmow;
    char id;
    File myObj = new File(wczytajnazwa+".txt");
    if (!myObj.exists())
    {
         System.out.println("Plik nie isntieje");
         jestplik=false;
         return;
    }  
    try 
    {
        Scanner myReader = new Scanner(myObj);
        for (int i = 0; i < wysokosc; i++)
	{
            for (int j = 0; j < szerokosc; j++)
            {
                plansza[i][j] = null;
            }
	}
	iloscorganizmow = myReader.nextInt();
	for (int i = 0; i < iloscorganizmow; i++)
	{
            id = myReader.next().charAt(0);
            x = myReader.nextInt();
            y = myReader.nextInt();
            wiek = myReader.nextInt();
            sila = myReader.nextInt();
		if (id == 'C')
		{
                    cooldown = myReader.nextInt();
                    licznik = myReader.nextInt();
                    szybkosc = myReader.nextInt();
                    wlacz = myReader.nextBoolean();
                    plansza[x][y] = DodajOrganizm(x, y, id);
                    plansza[x][y].SetWiek(wiek);
                    plansza[x][y].SetSila(sila);
		}
		else
		{
			plansza[x][y] = DodajOrganizm(x, y, id);
			plansza[x][y].SetWiek(wiek);
			plansza[x][y].SetSila(sila);
		}
        }
        myReader.close();
    }
    catch (FileNotFoundException e) 
    {
      System.out.println("Wystąpił błąd");
      e.printStackTrace();
    }
}
private void Generuj()
{
	int randx, randy,i = 0;
	while(i < 16)
	{
                randy = ThreadLocalRandom.current().nextInt(0, szerokosc);
		randx = ThreadLocalRandom.current().nextInt(0, wysokosc);
		if (plansza[randx][randy] == null)
		{
			if (i < 2)
				plansza[randx][randy] = DodajOrganizm(randx, randy, 'W');
			else if (i < 4)
				plansza[randx][randy] = DodajOrganizm(randx, randy, 'O');
			else if (i < 6)
				plansza[randx][randy] = DodajOrganizm(randx, randy, 'A');
			else if (i < 8)
				plansza[randx][randy] = DodajOrganizm(randx, randy, 'L');
			else if (i < 9)
				plansza[randx][randy] = DodajOrganizm(randx, randy, 'Z');
			else if (i < 10)
				plansza[randx][randy] = DodajOrganizm(randx, randy, 'T');
			else if (i < 11)
				plansza[randx][randy] = DodajOrganizm(randx, randy, 'M');
			else if (i < 12)
				plansza[randx][randy] = DodajOrganizm(randx, randy, 'J');
			else if (i < 13)
				plansza[randx][randy] = DodajOrganizm(randx, randy, 'B');
			else if (i < 14)
				plansza[randx][randy] = DodajOrganizm(randx, randy, 'C');
                        else if (i < 15)
				plansza[randx][randy] = DodajOrganizm(randx, randy, 'R');
			else
				plansza[randx][randy] = DodajOrganizm(randx, randy, 'G');
			i++;
		}
	}
		
}
public void Start()
{
	Generuj();
        //plansza[2][2] = DodajOrganizm(2, 2, 'C');
	//plansza[18][19] = DodajOrganizm(18, 19, 'O');
        //plansza[18][18] = DodajOrganizm(18, 18, 'O');
        menu();
        while (startgry == false)
        {
            try
            {
                Thread.sleep(1);
            }
            catch(InterruptedException ex)
            {
                Thread.currentThread().interrupt();
            }
        } 
        if(startgry)
        {
            RysujSwiat();
            while(true)
            {
		ZakonczTure();
                SetRuch(1);
                for (int j = 0; j < Gra.size(); j++)
		{
			if (Gra.get(j) != null && Gra.get(j).GetID() == 'C')
                            czlowiekzyje = true;		
		}
                WykonajTure();
		if (czlowiekzyje == false)
		{
			System.out.println("KONIEC");
			break;
		}
                czlowiekzyje = false;
            }
        }
        
}

private void RysujSwiat()
{
    Ekran c = new Ekran(this);
    JFrame f = new JFrame();
    c.setBackground(Color.white);
    c.setSize(1000, 1000);
    f.setSize(1000, 1000);
    f.setTitle("Farma");
    f.setVisible(true);
    c.setBackground(Color.white);
    f.add(c); 
    f.setLayout(new FlowLayout()); 
    f.setLocation(1000, 200);
    f.setLayout(new GridLayout(1,1,0,0));
    f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    f.setResizable(false);
}
private void menu()
{
    JFrame f=new JFrame("Farma");  
    JLabel l = new JLabel("PROJEKT PO2 COPYRIGHT ŁUKASZ NIEDŹWIADEK 180102");
    final JTextField tf=new JTextField();  
    tf.setBounds(210,100, 150,30);  
    JButton b2=new JButton("Wczytaj gre");
    JButton b1=new JButton("Nowa gra");  
    b2.setBounds(40,100,150,30);  
    b1.setBounds(40,150,320,30); 
    f.setVisible(true);
    b2.addActionListener(new ActionListener(){  
    public void actionPerformed(ActionEvent e){  
           wczytajnazwa = tf.getText();
           Wczytaj();
           if(jestplik)
           {
                startgry=true;
                f.setVisible(false);
                f.dispose();
           }
           else
           {
               JOptionPane.showMessageDialog(null, "NIE ZNALEZNIONO PLIKU","ERROR", JOptionPane.ERROR_MESSAGE);
               jestplik=true;
           }   
        }  
    });
    
    b1.addActionListener(new ActionListener(){  
    public void actionPerformed(ActionEvent e){  
           startgry=true;
           f.setVisible(false);
           f.dispose();
        }  
    });  
    l.setLocation(30,-110);
    l.setSize(400, 350);
    f.add(b2);
    f.add(b1);
    f.add(tf);  
    f.setSize(400,250);
    f.setLocation(1000, 200);
    f.add(l);
    f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    f.setResizable(false);
    f.setLayout(null);    
}
private void WykonajTure() {
	int x1,y1;
	for (int i = 0; i < Gra.size(); i++)
	{
		if (Gra.get(i) != null)
		{
			x1 = Gra.get(i).GetX();
			y1 = Gra.get(i).GetY();
			if (Gra.get(i).GetID() == 'Z')
			{
				int ruchzolwia = ThreadLocalRandom.current().nextInt(0, 4);
				if (ruchzolwia == 3)
				{
					Gra.get(i).Akcja(this);
					if (plansza[Gra.get(i).GetX()][Gra.get(i).GetY()] == null)
					{
						plansza[Gra.get(i).GetX()][Gra.get(i).GetY()] = Gra.get(i);
						plansza[x1][y1] = null;
					}
				}
				else
					System.out.println(Gra.get(i).GetImie()+" nie poruszyl sie ");
			}
			else
			{
				Gra.get(i).Akcja(this);
				if (Gra.get(i).GetID() == 'C' && wlacz == true)
				{
					licznik += 1;
				}
				if (plansza[Gra.get(i).GetX()][Gra.get(i).GetY()] == plansza[x1][y1])
					plansza[Gra.get(i).GetX()][Gra.get(i).GetY()] = Gra.get(i);
				else if (plansza[Gra.get(i).GetX()][Gra.get(i).GetY()] == null)
				{
					plansza[Gra.get(i).GetX()][Gra.get(i).GetY()] = Gra.get(i);
					plansza[x1][y1] = null;
				}
				else if(!(Gra.get(i) instanceof roslina))
				{
					boolean rozmnoz = false;
					boolean zolwodparlatak = false;
					organizm obronca = plansza[Gra.get(i).GetX()][Gra.get(i).GetY()];
					char atakujacy = Gra.get(i).GetID();
					plansza[Gra.get(i).GetX()][Gra.get(i).GetY()] = Gra.get(i).Kolizja(Gra.get(i), plansza[Gra.get(i).GetX()][Gra.get(i).GetY()], this);
					if (Gra.get(i).GetRozmnoz() == true && obronca.GetWiek() > 3)
					{
						rozmnoz = false;
					}
					else if (Gra.get(i).GetRozmnoz() == true && obronca.GetWiek() < 4)
					{
						rozmnoz = false;
					}
					else if (atakujacy == plansza[Gra.get(i).GetX()][Gra.get(i).GetY()].GetID())
					{
						for (int j = 0; j < Gra.size(); j++)
						{
							if (Gra.get(j) != null && obronca == Gra.get(j))
								Gra.remove(j);
						}
						//if (obronca->id != 'Z' && *zolwodparlatak == false)
							plansza[x1][y1] = null; //sprawdzić czy można to wywalić
					}	
					else
					{
						if (obronca.GetID() != 'Z' && zolwodparlatak == false)
						{
							Gra.remove(i);
							plansza[x1][y1] = null;
						}
						else
						{
							Gra.get(i).SetX(x1);
							Gra.get(i).SetY(y1);
						}
					}	
				}
			}
		}	
	}
}
private void Sortowanie()
{
	for (int i = 0; i < Gra.size()-1; i++)
	{
		for (int j = 0; j < Gra.size() - i - 1; j++)
		{
			if (Gra.get(j).GetInicjatywa() == Gra.get(j+1).GetInicjatywa())
			{
				if (Gra.get(j).GetWiek() > Gra.get(j+1).GetWiek())
				{
                                    Collections.swap(Gra, j, j+1);
				}
			}
			else if (Gra.get(j).GetInicjatywa() > Gra.get(j).GetInicjatywa())
			{
				Collections.swap(Gra, j, j+1);
			}
		}
	}
}

private void ZakonczTure()
{
	Gra.clear();
	for (int i = 0; i < wysokosc; i++)
	{
		for (int j = 0; j < szerokosc; j++)
		{
			if (plansza[i][j] instanceof organizm)
				Gra.add(plansza[i][j]);
		}
	}
	if(!Gra.isEmpty())
		Sortowanie();
	for (int i = 0; i < Gra.size(); i++)
	{
		Gra.get(i).SetWiek(Gra.get(i).GetWiek() + 1);
	}
}
}
