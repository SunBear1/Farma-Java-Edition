/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package po_2;
import java.util.concurrent.ThreadLocalRandom;
import java.awt.*;

/**
 *
 * @author lukin
 */
public class zwierze extends organizm {
@Override
public void SetX(int x)
{
	this.x = x;
}
@Override
public void SetY(int y)
{
	this.y = y;
}
@Override
public int GetX()
{
	return x;
}
@Override
public int GetY()
{
	return y;
}
@Override
public int GetSila()
{
	return sila;
}
@Override
public char GetID()
{
	return id;
}
@Override
public String GetImie()
{
	return imie;
}
@Override
public void SetImie(String imie)
{
	this.imie = imie;
}
@Override
public void SetRozmnoz(boolean rozmnoz)
{
	this.rozmnoz = rozmnoz;
}
@Override
public boolean GetRozmnoz()
{
	return rozmnoz;
}
@Override
public void SetSila(int sila)
{
	this.sila = sila;
}
protected void Rozmnazanie(organizm rodzic, organizm plansza[][],boolean rozmnoz, boolean zolwodparlatak, int szerokosc, int wysokosc)
{

}
@Override
public int GetInicjatywa()
{
	return inicjatywa;
}
@Override
public void SetInicjatywa(int inicjatywa)
{
	this.inicjatywa = inicjatywa;
}
@Override
public int GetWiek()
{
	return wiek;
}
@Override
public void SetID(char id)
{
	this.id = id;
}
@Override
public void SetWiek(int wiek)
{
	this.wiek = wiek;
}
@Override
public void Akcja(swiat planeta)
{
    int y = GetY();
    int x = GetX();
    int kierunek;
	while (true)
	{
		kierunek = ThreadLocalRandom.current().nextInt(0, 4);
		if (kierunek == 0)
		{
			if (y > 0)
			{
				SetY(y - 1);
				break;
			}
			else
				kierunek = ThreadLocalRandom.current().nextInt(0, 4);
		}
		else if (kierunek == 1)
		{
			if (y < planeta.szerokosc - 1)
			{
				SetY(y + 1);
				break;
			}
			else
				kierunek = ThreadLocalRandom.current().nextInt(0, 4);

		}
		else if (kierunek == 2)
		{
			if (x < planeta.wysokosc - 1)
			{
				SetX(x + 1);
				break;
			}
			else
				kierunek = ThreadLocalRandom.current().nextInt(0, 4);
		}
		else
		{
			if (x > 0)
			{
				SetX(x - 1);
				break;
			}
			else
				kierunek = ThreadLocalRandom.current().nextInt(0, 4);
		}
	}
	System.out.println(GetImie()+" poruszył(a) się na "+GetX()+" "+GetY());
}
@Override
public organizm Kolizja(organizm off, organizm def,swiat planeta)
{
	return def;
}
@Override
public Color Kolor(){
     return Color.RED;
}
}
