/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rosliny;
import java.awt.Color;
import po_2.roslina;
import po_2.zwierze;
import po_2.organizm;
import java.util.concurrent.ThreadLocalRandom;
import po_2.swiat;
import zwierzeta.cyberowca;
/**
 *
 * @author lukin
 */
public class barszcz extends roslina{
public barszcz()
{
    SetSila(10);
    SetInicjatywa(0);
    SetID('B');
    SetWiek(0);
    SetImie("Barszcz Sosnowskiego");
}
private void Eksterminacja(swiat planeta)
{
	System.out.println("Barszcz przeprowadza eksterminacje sasiednich pol... ");
	if (GetX() > 0 && planeta.plansza[GetX() - 1][GetY()] instanceof zwierze &&  !(planeta.plansza[GetX() - 1][GetY()] instanceof cyberowca))
	{
		System.out.println(planeta.plansza[GetX() - 1][GetY()].GetImie()+" umiera w meczarniach przez Barszcz Sosnowskiego");
		planeta.plansza[GetX() - 1][GetY()] = null;
	}
        if (GetX() < planeta.wysokosc - 1 && planeta.plansza[GetX() + 1][GetY()] instanceof zwierze &&  !(planeta.plansza[GetX() + 1][GetY()] instanceof cyberowca))
	{
		System.out.println(planeta.plansza[GetX() + 1][GetY()].GetImie()+" umiera w meczarniach przez Barszcz Sosnowskiego");
		planeta.plansza[GetX() + 1][GetY()] = null;
	}
	if (GetY() > 0 && planeta.plansza[GetX()][GetY() - 1] instanceof zwierze &&  !(planeta.plansza[GetX()][GetY() - 1] instanceof cyberowca))
	{
		System.out.println(planeta.plansza[GetX()][GetY() - 1].GetImie()+" umiera w meczarniach przez Barszcz Sosnowskiego");
		planeta.plansza[GetX()][GetY() - 1] = null;
	}
	if (GetY() < planeta.szerokosc - 1 && planeta.plansza[GetX()][GetY() + 1] instanceof zwierze &&  !(planeta.plansza[GetX()][GetY() + 1] instanceof cyberowca))
	{
		System.out.println(planeta.plansza[GetX()][GetY() + 1].GetImie()+" umiera w meczarniach przez Barszcz Sosnowskiego");
		planeta.plansza[GetX()][GetY() + 1] = null;
	}
}
@Override
public void Akcja(swiat planeta)
{
        Eksterminacja(planeta);
	boolean []brakruchu = new boolean[]{false,false,false,false};
	int rozsiew = ThreadLocalRandom.current().nextInt(0, 100);
        int y = GetY();
        int x = GetX();
	if (rozsiew == 0)
	{
		while (true)
		{
			if (brakruchu[0] && brakruchu[1] && brakruchu[2] && brakruchu[3])
				break;
			int kierunek = ThreadLocalRandom.current().nextInt(0, 4);
			if (kierunek == 0)
			{
				if (y > 0)
				{
					if (!(planeta.plansza[x][y-1] instanceof organizm))
					{
						organizm New = new barszcz();
						New.SetX(x);
						New.SetY(y - 1);
						planeta.plansza[New.GetX()][New.GetY()] = New;
                                                System.out.println(New.GetImie()+" rozsiala sie na pole "+New.GetX()+" "+New.GetY());
						break;
					}
					else
						brakruchu[kierunek] = true;
				}
				else
				{
					brakruchu[kierunek] = true;
					ThreadLocalRandom.current().nextInt(0, 4);
				}
			}
			else if (kierunek == 1)
			{
				if (y < planeta.szerokosc - 1)
				{
					if (!(planeta.plansza[x][y+1] instanceof organizm))
					{
						organizm New = new barszcz();
						New.SetX(x);
						New.SetY(y + 1);
						planeta.plansza[New.GetX()][New.GetY()] = New;
						System.out.println(New.GetImie()+" rozsiala sie na pole "+New.GetX()+" "+New.GetY());
						break;
					}
					else
						brakruchu[kierunek] = true;
				}
				else
				{
					brakruchu[kierunek] = true;
					ThreadLocalRandom.current().nextInt(0, 4);
				}	
			}
			else if (kierunek == 2)
			{
				if (x < planeta.wysokosc - 1)
				{
					if (!(planeta.plansza[x+1][y] instanceof organizm))
					{
						organizm New = new barszcz();
						New.SetX(x + 1);
						New.SetY(y);
						planeta.plansza[New.GetX()][New.GetY()] = New;
						System.out.println(New.GetImie()+" rozsiala sie na pole "+New.GetX()+" "+New.GetY());
						break;
					}
					else
						brakruchu[kierunek] = true;
				}
				else
				{
					brakruchu[kierunek] = true;
					ThreadLocalRandom.current().nextInt(0, 4);
				}
			}
			else
			{
				if (x > 0)
				{
					if (!(planeta.plansza[x - 1][y] instanceof organizm))
					{
						organizm New = new barszcz();
						New.SetX(x - 1);
						New.SetY(y);
						planeta.plansza[New.GetX()][New.GetY()] = New;
						System.out.println(New.GetImie()+" rozsiala sie na pole "+New.GetX()+" "+New.GetY());
						break;
					}
					else
						brakruchu[kierunek] = true;
				}
				else
				{
					brakruchu[kierunek] = true;
					ThreadLocalRandom.current().nextInt(0, 4);
				}
			}
		}
	}
}
@Override
public organizm Kolizja(organizm off, organizm def, swiat planeta)
{
	return def;
}
@Override
public Color Kolor() {
     return new Color(102, 0, 51);
}
}
