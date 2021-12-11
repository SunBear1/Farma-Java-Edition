/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zwierzeta;
import java.awt.Color;
import po_2.zwierze;
import po_2.organizm;
import po_2.swiat;
import java.util.concurrent.ThreadLocalRandom;
/**
 *
 * @author lukin
 */
public class zolw extends zwierze{
public zolw()
{
	SetSila(2);
	SetInicjatywa(1);
	SetID('Z');
	SetWiek(0);
	SetImie("Zolw");
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
					organizm dziecko = new zolw();
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
					organizm dziecko = new zolw();
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
					organizm dziecko = new zolw();
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
					organizm dziecko = new zolw();
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
public organizm Kolizja(organizm off, organizm def, swiat planeta)
{
	if (def.GetID() == off.GetID())
	{
		off.SetRozmnoz(true);
		Rozmnazanie(def, planeta);
		return def;
	}
	else if (def.GetID() == GetID()) //Zolw broni
	{
		if (off.GetSila() < 5) //odparcie ataku
		{
			System.out.println(def.GetImie()+" odpiera atak "+off.GetImie());
			planeta.zolwodparlatak = true;
			return def;
		}
		else
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
	}
	else //Zolw atakuje
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
      return new Color(20, 104, 22);
}
}
