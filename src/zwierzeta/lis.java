/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zwierzeta;
import java.awt.Color;
import java.util.concurrent.ThreadLocalRandom;
import po_2.zwierze;
import po_2.organizm;
import po_2.swiat;
/**
 *
 * @author lukin
 */
public class lis extends zwierze{
public lis()
{
    SetSila(3);
    SetInicjatywa(7);
    SetID('L');
    SetWiek(0);
    SetImie("Lis");
}
private void Rozmnazanie(organizm rodzic, swiat planeta)
{
	boolean []brakruchu = new boolean[]{false,false,false,false};
        int kierunek;
	while (true)
	{
		if (brakruchu[0] && brakruchu[1] && brakruchu[2] && brakruchu[3])
			break;
		kierunek = ThreadLocalRandom.current().nextInt(0, 4);
		if (kierunek == 0)
		{
			if (rodzic.GetY() > 0)
			{
                                
				if (!(planeta.plansza[rodzic.GetX()][rodzic.GetY() - 1] instanceof organizm))
				{
					organizm dziecko = new lis();
					dziecko.SetX(rodzic.GetX());
					dziecko.SetY(rodzic.GetY() - 1);
					planeta.plansza[rodzic.GetX()][rodzic.GetY() - 1] = dziecko;
					System.out.println(dziecko.GetImie()+" rozmnozyla się na "+dziecko.GetX()+" "+dziecko.GetY());
					break;
				}
				else
					brakruchu[kierunek] = true;
			}
			else
			{
				brakruchu[kierunek] = true;
				kierunek = ThreadLocalRandom.current().nextInt(0, 4);
			}
		}
		else if (kierunek == 1)
		{
			if (rodzic.GetY() < planeta.szerokosc - 1)
			{
                           
				if ( !(planeta.plansza[rodzic.GetX()][rodzic.GetY() + 1] instanceof organizm))
				{
					organizm dziecko = new lis();
					dziecko.SetX(rodzic.GetX());
					dziecko.SetY(rodzic.GetY() + 1);
					planeta.plansza[rodzic.GetX()][rodzic.GetY() + 1] = dziecko;
					System.out.println(dziecko.GetImie()+" rozmnozyla się na "+dziecko.GetX()+" "+dziecko.GetY());
					break;
				}
				else
					brakruchu[kierunek] = true;
			}
			else
			{
				brakruchu[kierunek] = true;
				kierunek = ThreadLocalRandom.current().nextInt(0, 4);
			}
		}
		else if (kierunek == 2)
		{
			if (rodzic.GetX() < planeta.wysokosc - 1)
			{
				if (!(planeta.plansza[rodzic.GetX() + 1][rodzic.GetY()] instanceof organizm))
				{
					organizm dziecko = new lis();
					dziecko.SetX(rodzic.GetX() + 1);
					dziecko.SetY(rodzic.GetY());
					planeta.plansza[rodzic.GetX() + 1][rodzic.GetY()] = dziecko;
					System.out.println(dziecko.GetImie()+" rozmnozyla się na "+dziecko.GetX()+" "+dziecko.GetY());
					break;
				}
				else
					brakruchu[kierunek] = true;
			}
			else
			{
				brakruchu[kierunek] = true;
				kierunek = ThreadLocalRandom.current().nextInt(0, 4);
			}
		}
		else
		{
			if (rodzic.GetX() > 0)
			{
				if (!(planeta.plansza[rodzic.GetX() - 1][rodzic.GetY()] instanceof organizm))
				{
					organizm dziecko = new lis();
					dziecko.SetX(rodzic.GetX() - 1);
					dziecko.SetY(rodzic.GetY());
					planeta.plansza[rodzic.GetX() - 1][rodzic.GetY()] = dziecko;
					System.out.println(dziecko.GetImie()+" rozmnozyla się na "+dziecko.GetX()+" "+dziecko.GetY());
					break;
				}
				else
					brakruchu[kierunek] = true;
			}
			else
			{
				brakruchu[kierunek] = true;
				kierunek = ThreadLocalRandom.current().nextInt(0, 4);
			}
		}
	}
}
@Override
public void Akcja(swiat planeta)
{
	boolean []brakruchu = new boolean[]{false,false,false,false};
        int y = GetY();
        int x = GetX();
        int kierunek;
	while (true)
	{
		if (brakruchu[0] && brakruchu[1] && brakruchu[2] && brakruchu[3])
			break;
		kierunek = ThreadLocalRandom.current().nextInt(0, 4);
		if (kierunek == 0)
		{
			if (y > 0)
			{
				if (planeta.plansza[x][y-1] instanceof zwierze)
				{
					if (planeta.plansza[x][y - 1].GetSila() < this.GetSila())
					{
						SetY(y - 1);
						break;
					}
					else
						brakruchu[kierunek] = true;
				}
				else
				{
					SetY(y - 1);
					break;
				}
				
			}
			else
				kierunek = ThreadLocalRandom.current().nextInt(0, 4);
		}
		else if (kierunek == 1)
		{
			if (y < planeta.szerokosc - 1)
			{
				if (planeta.plansza[x][y+1] instanceof zwierze)
				{
					if (planeta.plansza[x][y + 1].GetSila() < this.GetSila())
					{
						SetY(y + 1);
						break;
					}
					else
						brakruchu[kierunek] = true;
				}
				else
				{
					SetY(y + 1);
					break;
				}
			}
			else
				kierunek = ThreadLocalRandom.current().nextInt(0, 4);

		}
		else if (kierunek == 2)
		{
			if (x < planeta.wysokosc - 1)
			{
				if (planeta.plansza[x+1][y] instanceof zwierze)
				{
					if (planeta.plansza[x + 1][y].GetSila() < this.GetSila())
					{
						SetX(x + 1);
						break;
					}
					else
						brakruchu[kierunek] = true;
				}
				else
				{
					SetX(x + 1);
					break;
				}
			}
			else
				kierunek = ThreadLocalRandom.current().nextInt(0, 4);
		}
		else
		{
			if (x > 0)
			{
				if (planeta.plansza[x-1][y] instanceof zwierze)
				{
					if (planeta.plansza[x - 1][y].GetSila() < this.GetSila())
					{
						SetX(x - 1);
						break;
					}
					else
						brakruchu[kierunek] = true;
				}
				else
				{
					SetX(x - 1);
					break;
				}
			}
			else
				kierunek = ThreadLocalRandom.current().nextInt(0, 4);
		}
	}
	System.out.println(GetImie()+" poruszył się na "+GetX()+" "+GetY());
}
@Override
public organizm Kolizja(organizm off, organizm def, swiat planeta)
{
	if (def.GetID() == off.GetID())
	{
		off.SetRozmnoz(true);
		Rozmnazanie(def, planeta);
		return def;
	}
	else if (def.GetID() == GetID()) //owca broni
	{
		if (def.GetSila() > off.GetSila())
		{
			System.out.println(def.GetImie()+" wygyrwa z "+off.GetImie());
			return def;
		}
		else
		{
			System.out.println(def.GetImie()+" przegrywa z "+off.GetImie());
			return off;
		}

	}
	else //owca atakuje
	{
		if (off.GetSila() > def.GetSila())
		{
			if (off == def.Kolizja(off, def, planeta)) //broniący sprawdza czy jego super skille go obroniły
			{
				System.out.println(off.GetImie()+" wygyrwa z "+def.GetImie());
				return off;
			}
			else
				return def;
		}
		else
		{
			System.out.println(off.GetImie()+" przegrywa z "+def.GetImie());
			return def;
		}
	}
}
@Override
public Color Kolor() {
      return Color.ORANGE;
}
}
