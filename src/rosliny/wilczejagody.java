/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rosliny;
import java.awt.Color;
import po_2.roslina;
import po_2.organizm;
import po_2.swiat;
import java.util.concurrent.ThreadLocalRandom;
/**
 *
 * @author lukin
 */
public class wilczejagody extends roslina{
public wilczejagody()
{
    SetSila(99);
    SetInicjatywa(0);
    SetID('J');
    SetWiek(0);
    SetImie("Wilcze Jagody");
}
@Override
public void Akcja(swiat planeta)
{
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
						organizm New = new wilczejagody();
						New.SetX(x);
						New.SetY(y - 1);
						planeta.plansza[New.GetX()][New.GetY()] = New;
                                                System.out.print(New.GetImie()+" rozsiala sie na pole "+New.GetX()+" "+New.GetY()+"\n");
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
						organizm New = new wilczejagody();
						New.SetX(x);
						New.SetY(y + 1);
						planeta.plansza[New.GetX()][New.GetY()] = New;
						System.out.print(New.GetImie()+" rozsiala sie na pole "+New.GetX()+" "+New.GetY()+"\n");
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
						organizm New = new wilczejagody();
						New.SetX(x + 1);
						New.SetY(y);
						planeta.plansza[New.GetX()][New.GetY()] = New;
						System.out.print(New.GetImie()+" rozsiala sie na pole "+New.GetX()+" "+New.GetY()+"\n");
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
						organizm New = new wilczejagody();
						New.SetX(x - 1);
						New.SetY(y);
						planeta.plansza[New.GetX()][New.GetY()] = New;
						System.out.print(New.GetImie()+" rozsiala sie na pole "+New.GetX()+" "+New.GetY()+"\n");
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
	System.out.println(off.GetImie()+"wchodzi na "+def.GetImie()+" i umiera :< ");
	return def;
}
@Override
public Color Kolor() {
      return new Color(192, 23, 181);
}
}
